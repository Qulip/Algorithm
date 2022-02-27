package beakjoon.d220225.q1629;
//https://www.acmicpc.net/problem/1629
//Solved : 22/02/26

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        bw.write(Long.toString(power(a%c,b,c)));
        bw.close();
        br.close();
    }

    static long power(long a, long b, long c){
        if(b==1) return a;

        long tmp = power(a,b/2,c)%c;

        if(b % 2 == 0) {
            return (tmp*tmp)%c;
        } else {
            return (((tmp*tmp)%c)*a)%c;
        }
    }
}
