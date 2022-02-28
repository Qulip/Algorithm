package beakjoon.d220227.q16953;
//https://www.acmicpc.net/problem/16953
//Solved :

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rst = 1;
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        while(true){
            if(B < A){
                rst = -1;
                break;
            }
            if(B==A){
                break;
            }
            if(B%2==1 && B%10!=1){
                rst = -1;
                break;
            }
            if(B%2==0) B/=2;
            else B /= 10;
            rst++;
        }

        bw.write(Integer.toString(rst));
        bw.close();
        br.close();
    }
}
