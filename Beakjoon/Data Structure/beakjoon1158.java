package beakjoon.d220210.q1158;
//https://www.acmicpc.net/problem/1158
//Solved : 22/02/10

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int r = K-1;
        int removed = 0;
        sb.append("<");
        boolean[] arr = new boolean[N];
        while(true){
            if(!arr[r]) {
                arr[r] = true;
                sb.append(r+1);
                removed++;
            }
            if(removed==N){
                break;
            }
            sb.append(", ");
            int temp = 1;
            while(temp<=K){
                if(r+1 >= N){
                    r = -1;
                }
                if(arr[r+1]){
                    r++;
                }else{
                    r++;
                    temp++;
                }
            }
        }
        sb.append(">");
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
