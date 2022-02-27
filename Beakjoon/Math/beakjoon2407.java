package beakjoon.d220225.q2407;
//https://www.acmicpc.net/problem/2407
//Solved : 22/02/26

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    static BigInteger rst;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        rst = fac(N).divide(fac(N-M).multiply(fac(M)));

        bw.write(rst.toString());

        bw.close();
        br.close();
    }

    static BigInteger fac(int n){
        if(n<=1) return BigInteger.valueOf(1);
        return fac(n-1).multiply(BigInteger.valueOf(n));
    }
}
