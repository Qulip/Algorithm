//https://www.acmicpc.net/problem/17135
//Solved : 22/04/07

import java.util.*;
import java.io.*;

class Main{
    static int N, M, D, rst = 0, enemys;
    static int[][] map;
    static boolean[] archer;
    static int[] dr = {0,-1, 0}, dc = {-1, 0, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        archer = new boolean[M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) enemys++;
            }
        }
        if(enemys!=0) com(0, 0);

        bw.write(Integer.toString(rst));
        bw.close();
        br.close();
    }
    static void com(int idx, int time){
        if(time==3){
            int[][] copy = new int[N][M];
            for(int i=0; i<N; i++) copy[i] = map[i].clone();
            game();
            for(int i=0; i<N; i++) map[i] = copy[i].clone();
            return;
        }
        if(idx>=M) return;
        archer[idx] = true;
        com(idx+1, time+1);
        archer[idx] = false;
        com(idx+1, time);
    }

    static void game(){
        List<int[]> list = new ArrayList<>();
        int kill = 0;
        int remove = 0;
        while (true){
            list.clear();

            for(int arc=0; arc<M; arc++){
                if(archer[arc]){
                    if(map[N-1][arc]!=1) {
                        list.add(find(N - 1, arc));
                    }else{
                        list.add(new int[]{N-1, arc});
                    }
                }
            }

            for (int[] now : list) {
                if (now[0] != -1 && map[now[0]][now[1]] != 0) {
                    map[now[0]][now[1]] = 0;
                    kill++;
                }
            }

            for(int i=0; i<M; i++){
                if(map[N-1][i]==1){
                    remove++;
                }
            }
            if(enemys==kill+remove) break;
            move();
        }
        rst = rst > kill ? rst : kill;
    }

    static int[] find(int r, int c){
        Queue<int[]> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        que.add(new int[]{r,c, 1});
        visited[r][c] = true;
        while (!que.isEmpty()){
            int[] now = que.poll();
            for(int i=0; i<3; i++){
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if(nr<0||nc<0||nc>=M||visited[nr][nc]) continue;
                if(now[2]+1<=D && map[nr][nc] == 1) return new int[]{nr, nc};
                visited[nr][nc] = true;
                if(now[2]+1<D) que.add(new int[]{nr, nc, now[2]+1});
            }
        }
        return new int[]{-1, -1};
    }
    static void move(){
        for(int i=N-1; i>0; i--){
            for(int j=0; j<M; j++){
                map[i][j] = map[i-1][j];
            }
        }
        for(int j=0; j<M; j++){
            map[0][j] = 0;
        }
    }
}
/*

15 3 10
0 0 0
0 0 0
1 1 1
0 0 0
1 1 1
0 0 0
0 0 0
0 0 0
1 1 1
0 0 0
1 1 1
0 0 0
0 0 0
0 0 0
1 1 1
0 0 0
1 1 1
0 0 0
0 0 0
0 0 0
1 1 1
0 0 0
1 1 1
0 0 0
0 0 0
0 0 0
 */