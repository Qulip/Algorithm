package swea.d220209.d4_1223;
//Solved : 22/02/09

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int tc=1; tc<=10; tc++){
            int num = Integer.parseInt(br.readLine());
            int rst = 0;
            st = new StringTokenizer(br.readLine(),"+");
            StringTokenizer st2;
            while (st.hasMoreTokens()){
                String str = st.nextToken();
                if(str.length()>1){
                    st2 = new StringTokenizer(str,"*");
                    int tmp = Integer.parseInt(st2.nextToken());
                    while(st2.hasMoreTokens()) {
                        tmp *= Integer.parseInt(st2.nextToken());
                    }
                    rst += tmp;
                }else{
                    rst += Integer.parseInt(str);
                }
            }
            sb.append("#").append(tc).append(" ").append(rst).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
