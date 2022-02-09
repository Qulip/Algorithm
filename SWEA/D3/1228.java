package swea.d3_1228;
//Solved : 22/02/08

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for(int TC=1; TC<=10; TC++) {
            List<Integer> list = new LinkedList<>();
            int num_l = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < num_l; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            int num_c = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(),"I");
            //System.out.println(st.countTokens()+" "+num_c);
            for(int i=0; i<num_c; i++){
                StringTokenizer st1 = new StringTokenizer(st.nextToken());
                int num = Integer.parseInt(st1.nextToken());
                int time = Integer.parseInt(st1.nextToken());
                //System.out.println(num+" "+time);
                for(int j=0; j<time; j++){
                    list.add(num+j, Integer.parseInt(st1.nextToken()));
                }
            }
            sb.append("#").append(TC).append(" ");
            for(int i=0; i<10; i++){
                sb.append(list.get(0)).append(" ");
                list.remove(0);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
