package beak2667;
//https://www.acmicpc.net/problem/2667

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        }

        ArrayList<Integer> rst = new ArrayList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]==1&&!visited[i][j]){
                    int temp = bfs(i, j);
                    rst.add(temp);
                }
            }
        }
        Collections.sort(rst);
        StringBuilder sb = new StringBuilder();
        sb.append(rst.size() + "\n");
        for(int i=0; i<rst.size(); i++){
            sb.append(rst.get(i));
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static int bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        int rst = 1;
        visited[x][y] = true;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];
            for(int i=0; i<4; i++){
                int nextX = nowX + dr[i];
                int nextY = nowY + dc[i];
                if(nextX>=0 && nextY>=0 && nextX<n && nextY<n){
                    if(!visited[nextX][nextY] && map[nextX][nextY]==1) {
                        q.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                        rst++;
                    }
                    //System.out.println(nowX+" "+nowY+" "+nextX+" "+nextY+" "+rst+" "+q.size());
                }
                //System.out.println(rst);
            }
        }
        return rst;
    }
}
/*
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

 */