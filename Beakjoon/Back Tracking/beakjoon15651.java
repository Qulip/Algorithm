package beak15651;
//https://www.acmicpc.net/problem/15651

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
        dfs(n,m,0);
        System.out.print(sb);
    }
    static void dfs(int n, int m, int time){
        if(time==m){
            for(int i=0; i<rst.length; i++){
                sb.append(rst[i]+" ");
            }
            sb.append("\n");
        }else{
            for(int i=1; i<=n; i++){
                rst[time] = i;
                dfs(n,m, time+1);
            }
        }
    }
}
