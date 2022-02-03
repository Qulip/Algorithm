package beak1002;
//https://www.acmicpc.net/problem/1002

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            int x1, y1, r1, x2, y2, r2;
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            double d = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));      //점사이 거리
            double r_m = Math.abs(r2-r1);                                             //r뺀거
            double r_p = r2+r1;                                             //r더한거
            if(d==0){
                if(r1 == r2){
                    sb.append("-1\n");
                }else{
                    sb.append("0\n");
                }
            }else{
                if(r_m < d && d < r_p){
                    sb.append("2\n");
                } else if(r_m == d || r_p == d){
                    sb.append("1\n");
                }else {
                    sb.append("0\n");
                }
            }
        }
        System.out.println(sb);
    }
}
