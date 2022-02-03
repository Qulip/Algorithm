package beak2156;
//https://www.acmicpc.net/problem/2156

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n];
        int[] dp = new int[n];
        for(int i = 0; i<n; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = wine[0];
        if(n>1){
            dp[1] = wine[1]+wine[0];
        }
        if(n>2){
            dp[2] = wine[0]+wine[1]>wine[1]+wine[2] ? wine[0]+wine[1]:wine[1]+wine[2];
            dp[2] = dp[2]>wine[0]+wine[2]? dp[2]:wine[0]+wine[2];
        }
        for(int i=3; i<n; i++){
            dp[i] = dp[i-2]+wine[i]>dp[i-3]+wine[i-1]+wine[i] ? dp[i-2]+wine[i]:dp[i-3]+wine[i-1]+wine[i];
            dp[i] = dp[i]>dp[i-1] ? dp[i]:dp[i-1];
        }
        System.out.println(dp[n-1]);
    }
}