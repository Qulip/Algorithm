package beak15649;
//https://www.acmicpc.net/problem/15649

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] chk;
    static int[] rst;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        chk = new boolean[n];
        rst = new int[m];
        dfs(n,m,0);
        System.out.println(sb);
    }
    static void dfs(int n, int m, int time){
        if(time ==m){
            for(int i=0; i<rst.length; i++){
                sb.append(rst[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<n; i++){
            if(!chk[i]){
                chk[i]=true;
                rst[time] = i+1;
                dfs(n,m,time+1);
                chk[i]=false;
            }
        }
    }
}
