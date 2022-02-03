package beak5585;
//https://www.acmicpc.net/problem/5585

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int price = Integer.parseInt(br.readLine());
        int left = 1000 - price;
        int rst = 0;
        while(left>0){
            if(left>=500){
                left = left-500;
            }else if(left>=100){
                left = left-100;
            }else if(left>=50){
                left = left-50;
            }else if(left>=10){
                left = left-10;
            }else if(left>=5){
                left = left-5;
            }else {
                left--;
            }
            rst++;
        }
        System.out.println(rst);
    }
}
