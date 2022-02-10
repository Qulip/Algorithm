package swea.d220210.d4_1233;
//Solved : 22/02/10

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("res/swea/input_d4_1233.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        for(int tc=1; tc<=10; tc++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            int t = 0;
            boolean chk = true;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                t = Integer.parseInt(st.nextToken());
                char ch = st.nextToken().charAt(0);
                if(ch>='0'&&ch<='9'){
                    if(st.hasMoreTokens()){
                        chk = false;
                    }
                }else {
                    if(st.countTokens()!=2){
                        chk = false;
                    }
                }
            }
            sb.append("#").append(tc);
            if(chk) sb.append(" 1\n");
            else sb.append(" 0\n");
        }    bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
