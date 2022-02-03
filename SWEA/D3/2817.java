package swea2817;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static int rst;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(input.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            rst = 0;
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            nums = new int[n];
            st = new StringTokenizer(input.readLine());
            for(int i=0; i<n; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }
            dfs(k,0,1,0);
            sb.append("#"+tc+" "+rst+"\n");
        }
        System.out.print(sb);
    }
    public static void dfs(int k, int sum, int at, int depth){
        if(depth==nums.length){
            return;
        }
        int temp;
        for(int i=at; i<=nums.length; i++){
            temp = sum+nums[i-1];
            at++;
            //System.out.println("all "+nums[i-1]+" "+temp+" "+sum+" "+at+" "+depth);
            if(temp>=k){
                if(temp==k) {
                    rst++;
                    //System.out.println("Same");
                }
                continue;
            }
            dfs(k,temp,at,depth+1);
        }
    }
}
