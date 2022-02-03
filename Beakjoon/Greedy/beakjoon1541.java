package beak1541;
//https://www.acmicpc.net/problem/1541

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(),"-");
        int rst=0;
        boolean chk = true;
        while(st.hasMoreTokens()){
            int temp = 0;
            StringTokenizer plus_elements = new StringTokenizer(st.nextToken(),"+");
            while (plus_elements.hasMoreTokens()){
                temp = temp + Integer.parseInt(plus_elements.nextToken());
            }
            if(chk){
                rst = rst+temp;
                chk = false;
            }else{
                rst = rst-temp;
            }
        }
        System.out.println(rst);
    }
}
