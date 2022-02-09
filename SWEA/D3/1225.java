package swea.d3_1225;
//Solved : 22/02/08

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for(int T=1; T<=10; T++) {
            int tc = Integer.parseInt(br.readLine());
            Queue<Integer> arr = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<8; i++){
                arr.add(Integer.parseInt(st.nextToken()));
            }
            int time = 1;
            while(true){
                int tmp = arr.poll() - time;
                if(tmp<=0) {
                    arr.add(0);
                    break;
                }else{
                    arr.add(tmp);
                }
                time++;
                if(time==6){
                    time=1;
                }
                //System.out.println(arr.toString()+" "+time);
            }
            sb.append("#").append(T).append(" ");
            for(int i=0; i<8; i++){
                sb.append(arr.poll()).append(" ");
            }
            sb.append("\n");
            //System.out.println();
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
