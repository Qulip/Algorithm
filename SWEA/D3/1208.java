package swea.d3_1208;

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for(int tc=1; tc<=10; tc++){
            int time = Integer.parseInt(br.readLine());
            int[] box = new int[100];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<100; i++){
                box[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(box);
            int min, max;
            while(time>0){
                min = 1;
                max = 1;
                while(true){
                    if(box[0]==box[min]){
                        min++;
                    }else break;
                }
                while(true){
                    if(box[99]==box[99-max]){
                        max++;
                    }else break;
                }

                int t = min > max ? max : min;
                if(time<t){
                    break;
                }
                for(int i=0; i<t; i++){
                    box[min-1-i]++;
                    box[99-max+1+i]--;
                }
                time -= t;
            }
            int rst = box[99] - box[0];
            sb.append("#").append(tc).append(" ").append(rst).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
