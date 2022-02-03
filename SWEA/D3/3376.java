package swea3376;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            int time = Integer.parseInt(br.readLine());
            if(time<=3) {
                sb.append("#"+tc+" 1\n");
            }else if(time<=5){
                sb.append("#"+tc+" 2\n");
            }else{
                ArrayList<Long> nums = new ArrayList<>();
                nums.add(1L);
                nums.add(1L);
                nums.add(1L);
                nums.add(2L);
                nums.add(2L);
                while(nums.size()<time){
                    nums.add(nums.get(nums.size()-1)+nums.get(nums.size()-5));
                }
                sb.append("#"+tc+" "+nums.get(nums.size()-1)+"\n");
            }
        }
        System.out.println(sb);
    }
}