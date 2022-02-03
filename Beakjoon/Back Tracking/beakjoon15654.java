package beak15654;
//https://www.acmicpc.net/problem/15652

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] chk;
    static int[] rst;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        chk = new boolean[n];
        rst = new int[m];
        nums = new int[n];
        st = new StringTokenizer(input.readLine());
        for(int i=0; i<n; i++){
            nums[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
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
                rst[time] = nums[i];
                dfs(n,m,time+1);
                chk[i]=false;
            }
        }
    }
}