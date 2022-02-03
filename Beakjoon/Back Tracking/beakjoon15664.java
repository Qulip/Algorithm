package beak15664;
//https://www.acmicpc.net/problem/15664

import java.io.*;
import java.util.*;

public class Main {
    static int[] rst;
    static int[] nums;
    static Set<String> set = new LinkedHashSet<>();
    static boolean[] chk;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        rst = new int[m];
        nums = new int[n];
        chk = new boolean[n];
        st = new StringTokenizer(input.readLine());
        for(int i=0; i<n; i++){
            nums[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        dfs(n,m,1,0);
        for (String s : set) {
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
                rst[time] = nums[i - 1];
                dfs(n, m, i + 1, time + 1);
            }
        }
    }
}
