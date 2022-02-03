package swea3809;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(input.readLine());
        for(int tc=1; tc<=T; tc++){
            int n = Integer.parseInt(input.readLine());
            int[] nums = new int[n];
            int temp=0;
            StringTokenizer st;
            while(temp<n){
                st = new StringTokenizer(input.readLine());
                while(st.hasMoreTokens()){
                    nums[temp] = Integer.parseInt(st.nextToken());
                    temp++;
                }
            }
            boolean chk = true;
            temp = -1;
            while(chk){
                temp++;
                int time = (int)Math.log10(temp);
                if(temp==0){
                    time=0;
                }
                int left = temp%10;
                for(int i=0; i<n; i++){
                    if(nums[i]==left&&i>=time){
                        int tmp=0;
                        for(int j=i-time; j<=i; j++){
                            tmp = tmp+nums[j]*(int)Math.pow(10, i-j);
                        }
                        if(temp == tmp){
                            break;
                        }
                    }
                    if(i==n-1){
                        chk=false;
                    }
                }
            }
            sb.append("#"+tc+" "+temp+"\n");
        }
        System.out.println(sb);
    }
}
