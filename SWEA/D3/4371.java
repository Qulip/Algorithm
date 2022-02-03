package swea4371;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int time;
        for(int tc = 1; tc<= T; tc++){
            time = Integer.parseInt(br.readLine());
            int[] days = new int[time-1];
            int first = Integer.parseInt(br.readLine());
            int temp;
            int rst = 0;
            for(int i=0; i<time-1; i++){
                temp = Integer.parseInt(br.readLine());
                days[i] = temp-first;
            }
            for(int i = 0; i<days.length; i++){
                if(days[i] == 0){
                    continue;
                }
                temp = days[i];
                for(int j = i; j<days.length; j++){
                    if(days[j] % temp == 0){
                        days[j] = 0;
                    }
                }
                rst++;
            }
            sb.append("#" + tc + " "+ rst + "\n");
        }
        System.out.println(sb);
    }
}

