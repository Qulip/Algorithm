package beakjoon.q9020;
//https://www.acmicpc.net/problem/9020
//22/02/04

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int tc=0; tc<t; tc++){
            int num = Integer.parseInt(br.readLine());
            for(int i=num/2; i>0; i--){
                if(isPrime(i)&&isPrime(num-i)){
                    sb.append(i).append(" ").append(num-i).append("\n");
                    break;
                }
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
    public static boolean isPrime(int n){
        for(int i=2; i*i<=n; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
