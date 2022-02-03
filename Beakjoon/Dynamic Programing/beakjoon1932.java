package beak1932;
//https://www.acmicpc.net/problem/1932

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n==1){
            System.out.println(br.readLine());
        } else{
            int[][] triangle = new int[n][];
            triangle[0] = new int[1];
            triangle[0][0] = Integer.parseInt(br.readLine());
            for(int i = 1; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                triangle[i] = new int[i+1];
                for(int j=0; j<=i; j++){
                    triangle[i][j]=Integer.parseInt(st.nextToken());
                }
                for(int j=0; j<=i; j++){
                    if(j==0){
                        triangle[i][j] = triangle[i][j]+triangle[i-1][0];
                    }else if(j==i){
                        triangle[i][j] = triangle[i][j]+triangle[i-1][j-1];
                    } else{
                        triangle[i][j] = triangle[i][j]+(triangle[i-1][j-1]>triangle[i-1][j]? triangle[i-1][j-1]:triangle[i-1][j]);
                    }
                }
            }
            int rst = 0;
            for(int i=0; i<n; i++){
                if(rst<triangle[n-1][i]){
                    rst = triangle[n-1][i];
                }
            }
            System.out.println(rst);
        }
    }
}
