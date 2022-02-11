package beakjoon.d220211.q2468;
//https://www.acmicpc.net/problem/2468
//Solved : 22/02/11

import java.util.*;
import java.io.*;

public class Main {

    static int Max = 1, maxH = Integer.MIN_VALUE, minH = Integer.MAX_VALUE;
    static int[][] height;
    static boolean[][] chk;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        height = new int[N][N];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                height[i][j] = Integer.parseInt(st.nextToken());
                maxH = maxH > height[i][j] ? maxH : height[i][j];
                minH = minH < height[i][j] ? minH : height[i][j];
            }
        }

        for(int h=minH; h<maxH; h++){
            chk = new boolean[N][N];
            int rst = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    chk[i][j] = height[i][j]<=h;
                }
            }
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!chk[i][j]){
                        rst++;
                        dfs(i,j);
                    }
                }
            }
            Max = Max > rst ? Max : rst;
        }
        bw.write(Integer.toString(Max));
        bw.close();
        br.close();
    }

    static void dfs(int r, int c){
        chk[r][c] = true;
        if(r>0){
            if(!chk[r-1][c]){
                dfs(r-1,c);
            }
        }
        if(r<chk.length-1){
            if(!chk[r+1][c]){
                dfs(r+1,c);
            }
        }
        if(c>0){
            if(!chk[r][c-1]){
                dfs(r,c-1);
            }
        }
        if(c<chk.length-1){
            if(!chk[r][c+1]){
                dfs(r,c+1);
            }
        }

    }
}
