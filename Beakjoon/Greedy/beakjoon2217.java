package beak2217;
//https://www.acmicpc.net/problem/2217

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());        //1<=n<=100000
        int[] ropes = new int[n];
        for(int i=0; i<n; i++){
            ropes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ropes);
        int best = ropes[n-1];
        for(int i=0; i<n; i++){
            if(ropes[i]*(n-i)>=best){
                best = ropes[i]*(n-i);
            }
        }
        System.out.println(best);
    }
}
