package beak15666;
//https://www.acmicpc.net/problem/15666

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static Set<String> set = new LinkedHashSet<>();
    static int[] rst;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        rst = new int[m];
        st = new StringTokenizer(input.readLine());
        nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        dfs(n,m,1,0);
        for(String s : set){
            sb.append(s);
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static void dfs(int n, int m, int at, int time){
        if(time==m){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<rst.length; i++){
                sb.append(rst[i]+" ");
            }
            set.add(sb.toString());
        }else{
            for(int i=at; i<=n; i++){
                rst[time] = nums[i-1];
                dfs(n,m, at, time+1);
                at++;
            }
        }
    }
}