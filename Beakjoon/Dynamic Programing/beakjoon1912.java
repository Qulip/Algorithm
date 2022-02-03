package beak1912;
//https://www.acmicpc.net/problem/1912

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        int rst=arr[0];
        dp[0] = arr[0];
        for(int i=1; i<n; i++){
            dp[i] = dp[i-1]+arr[i]>arr[i]? dp[i-1]+arr[i]:arr[i];
            rst = rst>dp[i]?rst:dp[i];
        }
        System.out.println(rst);
    }
}
