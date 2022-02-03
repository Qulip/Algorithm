package beak10989;
//https://www.acmicpc.net/problem/10989

import java.io.*;

public class Main {     //no sorting
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[10000];
        int tmp;
        for(int i=0; i<tc; i++) {
            tmp=Integer.parseInt(input.readLine());
            nums[tmp-1]++;
        }
        for(int i=0; i<10000; i++){
            if(nums[i]>0){
                for(int j=0; j<nums[i]; j++){
                    sb.append(i+1+"\n");
                }
            }
        }
        System.out.print(sb);
    }
}
/* sorting
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[tc];
        for(int i=0; i<tc; i++) {
            nums[i]=Integer.parseInt(input.readLine());
        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            sb.append(nums[i]+"\n");
        }
        System.out.print(sb);
    }
}

 */