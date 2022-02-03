package beak15652;
//https://www.acmicpc.net/problem/15652

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] rst;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        rst = new int[m];
        dfs(n,m,1,0);
        System.out.print(sb);
    }
    static void dfs(int n, int m, int at, int time){
        if(time==m){
            for(int i=0; i<rst.length; i++){
                sb.append(rst[i]+" ");
            }
            sb.append("\n");
        }else{
            for(int i=at; i<=n; i++){
                rst[time] = i;
                dfs(n,m, at, time+1);
                at++;
            }
        }
    }
}
