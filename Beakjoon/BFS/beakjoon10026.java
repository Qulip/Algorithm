package beakjoon.d220223.q10026;
//https://www.acmicpc.net/problem/10026
//Solved : 22/02/23

import java.util.*;
import java.io.*;

public class Main {
    static int RGB=0, RB=0, N;
    static char[][] map;
    static boolean[][] chk;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        chk = new boolean[N][N];

        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!chk[i][j]){
                    bfsRGB(i,j,map[i][j]);
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(chk[i][j]){
                    bfsRB(i,j,map[i][j]);
                }
            }
        }

        sb.append(RGB).append(" ").append(RB);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    static void bfsRGB(int r, int c, char color){
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{r,c});
        RGB++;
        while(!que.isEmpty()){
            int[] now = que.poll();
            if(chk[now[0]][now[1]] || map[now[0]][now[1]]!=color) continue;
            chk[now[0]][now[1]] = true;
            for(int i=0; i<4; i++){
                if(now[0]+dx[i]<0||now[1]+dy[i]<0||now[0]+dx[i]>=N||now[1]+dy[i]>=N) continue;
                que.add(new int[]{now[0]+dx[i], now[1]+dy[i]});
            }
        }
    }

    static void bfsRB(int r, int c, char color){
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{r,c});
        RB++;
        while(!que.isEmpty()){
            int[] now = que.poll();
            if(!chk[now[0]][now[1]]) continue;
            if(color=='R'||color=='G'){
                if(map[now[0]][now[1]]!='R'&&map[now[0]][now[1]]!='G') continue;
            }else{
                if(map[now[0]][now[1]]!=color) continue;
            }
            chk[now[0]][now[1]] = false;
            for(int i=0; i<4; i++){
                if(now[0]+dx[i]<0||now[1]+dy[i]<0||now[0]+dx[i]>=N||now[1]+dy[i]>=N) continue;
                que.add(new int[]{now[0]+dx[i], now[1]+dy[i]});
            }
        }
    }
}
