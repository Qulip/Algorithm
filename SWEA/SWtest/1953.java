//Solved :

import java.util.*;
import java.io.*;

class Solution{
    static int N, M, R, C, L, rst;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1,0,1,0}, dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];
            rst = 0;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            if(L==1) rst = 1;
            else BFS();
            sb.append("#").append(tc).append(" ").append(rst).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void BFS(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> y[2] - x[2]);
        pq.add(new int[]{R, C, L-1});
        visited[R][C] = true;
        rst++;
        while (!pq.isEmpty()){
            int[] now = pq.poll();
            int nowT = map[now[0]][now[1]];
            for(int i=0; i<4; i++){

                if(!canGo(i, nowT)) continue;

                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if(nr<0||nr>=N||nc<0||nc>=M||visited[nr][nc]||map[nr][nc]==0) continue;

                if(!canCome(i, map[nr][nc])) continue;

                visited[nr][nc] = true;
                rst++;
                if(now[2]>1) pq.add(new int[]{nr, nc, now[2]-1});
            }
        }
    }
    static boolean canGo(int i, int nowT){
        if(i==0&&(nowT==3||nowT==5||nowT==6)) return false;
        else if(i==1&&(nowT==2||nowT==6||nowT==7)) return false;
        else if(i==2&&(nowT==3||nowT==4||nowT==7)) return false;
        else if(i==3&&(nowT==2||nowT==4||nowT==5)) return false;
        return true;
    }
    static boolean canCome(int i, int nextT){
        if(i==0&&(nextT==3||nextT==4||nextT==7)) return false;
        else if(i==1&&(nextT==2||nextT==4||nextT==5)) return false;
        else if(i==2&&(nextT==3||nextT==5||nextT==6)) return false;
        else if(i==3&&(nextT==2||nextT==6||nextT==7)) return false;
        return true;
    }
}