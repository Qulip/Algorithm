package swea.d2_2001;

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T;
        T = Integer.parseInt(br.readLine());
        int[][] Array;

        for(int test_case = 1; test_case<=T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Array = new int[x][x];
            int rst = 0;
            for(int i=0; i<x; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<x; j++) {
                    Array[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0; i<=x-y; i++) {
                for(int j=0; j<=x-y; j++) {
                    int temp = 0;
                    for(int k=i; k<i+y;k++) {
                        for(int l = j; l<j+y;l++) {
                            temp=temp+Array[k][l];
                        }
                    }
                    if(rst<temp) {
                        rst = temp;
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append(rst).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}