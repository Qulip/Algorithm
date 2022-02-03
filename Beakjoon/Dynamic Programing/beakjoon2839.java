package beak2839;
//https://www.acmicpc.net/problem/2839

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int hav = n/5;
        int left = n%5;
        int rst = 0;
        switch (left){
            case 0:
                if(hav>0) {
                    rst = hav;
                }
                else{
                    rst = -1;
                }
                break;
            case 1:
                if(hav>0){
                    rst = hav+1;
                }else{
                    rst = -1;
                }
                break;
            case 2:
                if(hav>1){
                    rst = hav+2;
                }else{
                    rst = -1;
                }
                break;
            case 3:
                rst = hav+1;
                break;
            case 4:
                if(hav>0){
                    rst = hav+2;
                }else{
                    rst = -1;
                }
                break;
        }
        System.out.println(rst);
    }
}
