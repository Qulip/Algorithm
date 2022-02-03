package swea3233;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long result = 0;
            //BigInteger result = new BigInteger("0");
            long left = a/b;
            while(left>0){
                result = result+(left*2-1);
                //result = result.add(new BigInteger(Integer.toString(left*2-1)));
                left--;
            }
            sb.append("#"+tc+" "+result+"\n");
            //sb.append("#"+tc+" "+result.toString()+"\n");
        }
        System.out.print(sb);
    }
}
