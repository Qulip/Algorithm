package beak1904;
//https://www.acmicpc.net/problem/1904

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n==1){
            System.out.println("1");
        }else if(n==2){
            System.out.println("2");
        }else{
            int[] rst = new int[n];
            rst[0] = 1;
            rst[1] = 2;
            for(int i=2; i<n; i++){
                rst[i]=(rst[i-1]+rst[i-2])%15746;
            }
            System.out.println(rst[n-1]);
        }
    }
}
