package swea6019;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        double d,a,b,f,rst;
        for(int tc =1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            d = Double.parseDouble(st.nextToken());
            a = Double.parseDouble(st.nextToken());
            b = Double.parseDouble(st.nextToken());
            f = Double.parseDouble(st.nextToken());
            rst = f*(d/(a+b));
            sb.append("#"+tc+" "+String.format("%.6f", rst)+"\n");
        }
        System.out.print(sb);
    }
}
//f*(d/(a+b))
//String.format