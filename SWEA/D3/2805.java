package swea.d3_2805;

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        //BufferedReader br = new BufferedReader(new FileReader("res/swea/input_d3_2805.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            //int[][] tttt = new int[N][N];
            char[] tmp;
            int rst = 0;
            for(int i=0; i<N; i++){
                tmp = br.readLine().toCharArray();
                for(int j=0; j<N; j++){
                    arr[i][j] = tmp[j]-'0';
                }
            }
            for(int i=0; i<N; i++){
                if(i<=N/2) {
                    for (int j = N/2 - i; j < N- N/2 + i; j++) {
                        rst += arr[i][j];
                        //tttt[i][j] = 1;
                    }
                }else{
                    for (int j = i - N/2; j < N - i + N/2; j++) {
                        rst += arr[i][j];
                        //tttt[i][j] = 1;
                    }
                }
            }
            /*for(int[] i : tttt){
                for(int j : i){
                    System.out.print(j+" ");
                }
                System.out.println();
            }*/
            sb.append("#").append(tc).append(" ").append(rst).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
