package beak2579;
//https://www.acmicpc.net/problem/2579

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] stairs = new int[T];
        for(int i = 0; i<T; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }
        int[] rst = new int[T];
        rst[0] = stairs[0];
        if(T>1) {
            rst[1] = stairs[0] + stairs[1];
        }
        if(T>2) {
            rst[2] = stairs[0] + stairs[2] > stairs[1] + stairs[2] ? stairs[0] + stairs[2] : stairs[1] + stairs[2];
        }
        for(int i=3; i<T; i++){
            rst[i] = rst[i-2]+stairs[i]>rst[i-3]+stairs[i-1]+stairs[i] ? rst[i-2]+stairs[i]:rst[i-3]+stairs[i-1]+stairs[i];
        }

        System.out.println(rst[T-1]);
    }
}
