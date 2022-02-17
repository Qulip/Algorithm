package swea.d220216.d4_3234;
//Solved : 22/02.16

import java.util.*;
import java.io.*;

public class Solution {
    static int rst;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("res/swea/input_d4_3234.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int tc=1; tc<=T; tc++){
            int N = Integer.parseInt(br.readLine());
            int[] weight = new int[N];
            boolean[] used = new boolean[N];
            rst = 0;
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                weight[i] = Integer.parseInt(st.nextToken());
            }
            com(weight, used,0, 0,0);
            sb.append("#").append(tc).append(" ").append(rst).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    static void com(int[] weight, boolean[] used,int idx, int lWeight, int rWeight){
        if(idx==weight.length){
            rst++;
            return;
        }
        for(int i=0; i<weight.length; i++){
            if(!used[i]) {
                used[i] = true;
                com(weight, used,idx+1, lWeight+weight[i], rWeight);
                if(lWeight>=rWeight+weight[i]) com(weight, used, idx+1, lWeight, rWeight+weight[i]);
                used[i] = false;
            }
        }
    }
}
