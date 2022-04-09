//Solved :

import java.util.*;
import java.io.*;

class Solution{
    static int[][] map;
    static int N;
    static int[] dr = {-1,0,1,0}, dc = {0,1,0,-1};
    static int[][] visited;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str;
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new int[N][N];
            for(int i=0; i<N; i++){
                str = br.readLine();
                Arrays.fill(visited[i], Integer.MAX_VALUE);
                for(int j=0; j<N; j++){
                    map[i][j] = str.charAt(j)-'0';
                }
            }
            int rst = BFS();
            sb.append("#").append(tc).append(" ").append(rst).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    static int BFS(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> x[2] == y[2] ? x[1] == y[1] ? x[0] - y[0] : x[1] - y[1] : x[2] - y[2]);
        pq.add(new int[]{0,0,0});
        while (!pq.isEmpty()){
            int[] now = pq.poll();
            for(int i=0; i<4; i++){
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if(nr==N-1&&nc==N-1) return now[2];
                if(nr<0||nr>=N||nc<0||nc>=N||visited[nr][nc]<=now[2]+map[nr][nc]) continue;
                pq.add(new int[]{nr,nc,now[2]+map[nr][nc]});
                visited[nr][nc] = now[2]+map[nr][nc];
            }
        }
        return 0;
    }

}