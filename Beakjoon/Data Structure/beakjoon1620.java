//https://www.acmicpc.net/problem/1620
//Solved : 22/03/01

import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> p1 = new HashMap<>();
        Map<String, Integer> p2 = new HashMap<>();
        for(int i=1; i<=N; i++){
            String t = br.readLine();
            p1.put(i, t);
            p2.put(t,i);
        }
        loop:for(int i=0; i<M; i++){
            String q = br.readLine();
            if(q.charAt(0)>='0'&&q.charAt(0)<='9'){
                int tmp = Integer.parseInt(q);
                sb.append(p1.get(tmp)).append("\n");
            }else{
                sb.append(p2.get(q)).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}