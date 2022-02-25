package beakjoon.d220225.q17144;
//https://www.acmicpc.net/problem/
//solved : 22/02/25
import java.util.*;
import java.io.*;

public class Main{
    static int[][] map;
    static int R,C,T;
    static int[] cleaner;
    static int[] dr = new int[]{-1,0,1,0};
    static int[] dc = new int[]{0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        cleaner = new int[4];


        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==-1){
                    if(cleaner[0]==0){
                        cleaner[0]=i;
                        cleaner[1]=j;
                    }else{
                        cleaner[2]=i;
                        cleaner[3]=j;
                    }
                }
            }
        }

        for(int i=0; i<T; i++){
            spread();
            blow();
        }

        int rst = 0;    //출력
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]!=-1) rst +=map[i][j];
            }
        }
        bw.write(Integer.toString(rst));
        br.close();
        bw.close();
    }

    static void spread(){
        //Map<int[], Integer> spreads = new HashMap<>();
        int[][] spreads = new int[R][C];
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]>0){
                    int dist = 0;
                    int s = map[i][j]/5;
                    for(int k=0; k<4; k++){
                        if(i+dr[k]<0||i+dr[k]>=R||j+dc[k]<0||j+dc[k]>=C||map[i+dr[k]][j+dc[k]]==-1) continue;
                        dist++;
                        spreads[i+dr[k]][j+dc[k]] += s;
                        /*if(spreads.containsKey(new int[]{i,j})){
                            spreads.put(new int[]{i,j}, spreads.get(new int[]{i,j})+s);
                        }else{
                            spreads.put(new int[]{i,j}, s);
                        }*/
                    }
                    map[i][j] = map[i][j]-(s)*dist;
                }
            }
        }
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                map[i][j] += spreads[i][j];
            }
        }
        /*Iterator<int[]> iter = spreads.keySet().iterator();
        while(iter.hasNext()){
            int[] point = iter.next();
        }*/
    }

    static void blow(){
        int n=0;
        int r = cleaner[0]+dr[0];
        int c = cleaner[1]+dc[0];
        while(true){
            if(r+dr[n]<0||r+dr[n]>cleaner[0]||c+dc[n]<0||c+dc[n]>=C){
                n++;
            }
            int nextR = r+dr[n], nextC = c+dc[n];
            //System.out.println(nextR+" "+nextC);
            if(map[nextR][nextC] == -1){
                map[r][c] = 0;
                break;
            }
            map[r][c] = map[nextR][nextC];
            r = nextR;
            c = nextC;
        }
        n = 0;
        r = cleaner[2]-dr[0];
        c = cleaner[3]+dc[0];
        while(true){
            if(r-dr[n]<cleaner[2]||r-dr[n]>=R||c+dc[n]<0||c+dc[n]>=C){
                n++;
            }
            int nextR = r-dr[n], nextC = c+dc[n];
            if(map[nextR][nextC] == -1){
                map[r][c] = 0;
                break;
            }
            map[r][c] = map[nextR][nextC];
            r = nextR;
            c = nextC;
        }
    }
}