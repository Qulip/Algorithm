package beak9461;
//https://www.acmicpc.net/problem/9461

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            if(n<4){
                sb.append("1\n");
            }else{
                long[] nums = new long[n];
                nums[0] = 1;
                nums[1] = 1;
                nums[2] = 1;
                for(int j = 3; j<n; j++){
                    nums[j]=nums[j-2]+nums[j-3];
                }
                sb.append(nums[n-1]+"\n");
            }
        }
        System.out.print(sb);
    }
}
