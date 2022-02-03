package beak1149;
//https://www.acmicpc.net/problem/1149

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] bill = new int[3];
        int[][] cost = new int[n][3];
        int rst = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bill[0] = Integer.parseInt(st.nextToken());
            bill[1] = Integer.parseInt(st.nextToken());
            bill[2] = Integer.parseInt(st.nextToken());
            if(i==0){
                cost[i][0] = bill[0];
                cost[i][1] = bill[1];
                cost[i][2] = bill[2];
            } else{
                cost[i][0] = bill[0] + (cost[i-1][1]>cost[i-1][2]? cost[i-1][2]:cost[i-1][1]);
                cost[i][1] = bill[1] + (cost[i-1][0]>cost[i-1][2]? cost[i-1][2]:cost[i-1][0]);
                cost[i][2] = bill[2] + (cost[i-1][0]>cost[i-1][1]? cost[i-1][1]:cost[i-1][0]);
            }
            //System.out.println(cost[i][0]+" "+cost[i][1]+" "+cost[i][2]);
        }
        System.out.println(cost[n-1][0]>cost[n-1][1] ? cost[n-1][1]>cost[n-1][2]? cost[n-1][2]:cost[n-1][1] : cost[n-1][0]>cost[n-1][2]? cost[n-1][2]:cost[n-1][0]);
    }
}