package beak10162;
//https://www.acmicpc.net/problem/10162

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] times = new int[3];
        if(n%10>0){
            System.out.println(-1);
        }else {
            int time = n/10;
            while(time>0){
                if(time>=30){
                    time = time-30;
                    times[0]++;
                }else if(time>=6){
                    time = time-6;
                    times[1]++;
                }else{
                    time--;
                    times[2]++;
                }
            }
            System.out.println(times[0]+" "+times[1]+" "+times[2]);
        }
    }
}
