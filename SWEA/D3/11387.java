package swea11387;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int d, l, n;
        long rst;
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            rst = 0;
            d = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            for(int i = 0; i<n; i++){
                rst = rst + d + (d/100*i*l);
            }
            sb.append("#"+tc+" "+rst+"\n");
        }
        System.out.println(sb);
    }
}
