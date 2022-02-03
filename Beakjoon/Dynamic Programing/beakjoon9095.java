package beakjoon.q9095;
//https://www.acmicpc.net/problem/9095

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] rst = new int[10];
        rst[0] = 1;
        rst[1] = 2;
        rst[2] = 4;
        int dp = 3;
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            if(rst[n-1]==0){
                for(int i=dp; i<n; i++){
                    rst[i] = rst[i-1] + rst[i-2] + rst[i-3];
                }
            }
            bw.write(Integer.toString(rst[n-1]));
            bw.write("\n");
        }
        bw.close();
    }
}
