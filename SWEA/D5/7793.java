//Solved : 22/04/05

import java.util.*;
import java.io.*;

class Solution {
    static char[][] map;
    static boolean[][] visited;
    static int N, M;
    static Queue<int[]> demon;
    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        String str;
        StringTokenizer st;
        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            visited = new boolean[N][M];
            demon = new ArrayDeque<>();
            int[] now = new int[2];
            for(int i=0; i<N; i++) {
                str = br.readLine();
                map[i] = str.toCharArray();
                for(int j=0; j<M; j++){
                    if(map[i][j]=='S'){
                        now[0] = i;
                        now[1] = j;
                    }else if(map[i][j]=='*'){
                        demon.add(new int[]{i, j});
                    }
                }
            }
            int rst = bfs(now[0], now[1]);
            sb.append("#").append(tc).append(" ").append(rst!=-1 ? rst:"GAME OVER").append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static int bfs(int r, int c){
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{r,c});
        int time = 1;
        int size = que.size();
        visited[r][c] = true;
        while (!que.isEmpty()){
            int[] now = que.poll();
            size--;
            if(map[now[0]][now[1]]!='*') {
                for (int i = 0; i < 4; i++) {
                    int nr = now[0] + dr[i];
                    int nc = now[1] + dc[i];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 'X' || map[nr][nc] == '*' || visited[nr][nc])
                        continue;
                    else if (map[nr][nc] == 'D') return time;
                    que.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
            if(size==0){
                time++;
                size = que.size();
                spread();
            }
        }
        return -1;
    }

    static void spread(){
        int size = demon.size();
        while (size>0){
            int[] now = demon.poll();
            size--;
            for(int i=0; i<4; i++){
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if(nr<0||nr>=N||nc<0||nc>=M||map[nr][nc]!='.') continue;
                map[nr][nc] = '*';
                demon.add(new int[]{nr, nc});
            }
        }
    }
}
/*

10 15
........X......
..XXXXX.X.*....
X.....X.X..*...
.X.S..X.X......
D.X...X.XXXXXXX
.X....X........
.X....X.XXXXXXX
.XXXXXX.X......
........X......
XXXXXXXXX...*..

 */