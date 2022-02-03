package beak1065;
//https://www.acmicpc.net/problem/1065

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        if(n<100){
            sb. append(n);
        }else if(n<111){
            sb.append("99");
        }else{
            int result = 99;
            int[] nums = new int[3];
            int i = 111;
            while(true){
                nums[0] = i/100;
                nums[1] = (i%100)/10;
                nums[2] = i%10;
                int temp = nums[0] - nums[1];
                if(nums[1]-temp>=10||nums[1]-temp<0){
                    i = nums[0]*100+(nums[1]+1)*10;
                } else if(temp == nums[1] - nums[2]){
                    result++;
                    i++;
                } else {
                    i++;
                }
                if(i>n){
                    break;
                }
            }
            sb.append(result);
        }
        System.out.print(sb);
    }
}
