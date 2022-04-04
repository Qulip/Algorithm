//Solved : 22/04/04

import java.util.*;
import java.io.*;

class Solution{
    static int N;
    static boolean[][] chk;
    static char[][] map;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}, dc = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream(new File("res/input.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());
            chk = new boolean[N][N];
            map = new char[N][N];
            for(int i=0; i<N; i++){
                map[i] = br.readLine().toCharArray();
                for(int j=0; j<N; j++){
                    chk[i][j] = map[i][j] == '*';
                }
            }

            sb.append("#").append(tc).append(" ").append(find()).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    static int find(){
        int rst = 0;
        Queue<int[]> que = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                boolean flag = true;
                for(int k=0; k<8; k++){
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if(nr<0||nr>=N||nc<0||nc>=N) continue;
                    if(map[nr][nc]=='*'){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    que.add(new int[]{i,j});
                }
            }
        }
        while (!que.isEmpty()){
            int[] now = que.poll();
            if(chk[now[0]][now[1]]) continue;
            rst++;
            click(now[0], now[1]);
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!chk[i][j]) rst++;
            }
        }
        return rst;
    }
    static void click(int r, int c){
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{r,c});
        while (!que.isEmpty()){
            int[] now = que.poll();
            if(chk[now[0]][now[1]]) continue;
            boolean flag = true;
            for(int i=0; i<8; i++){
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if(nr<0||nr>=N||nc<0||nc>=N) continue;
                if(map[nr][nc]=='*'){
                    flag = false;
                    break;
                }
            }
            if(flag){
                for(int i=0; i<8; i++){
                    int nr = now[0] + dr[i];
                    int nc = now[1] + dc[i];
                    if(nr<0||nr>=N||nc<0||nc>=N) continue;
                    que.add(new int[]{nr, nc});
                }
            }
            chk[now[0]][now[1]] = true;
        }
    }
}
