package beakjoon.d220225.q11723;
//https://www.acmicpc.net/problem/11723
//Solved : 22/02/26

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String com = st.nextToken();
            if(com.equals("add")){
                set.add(Integer.parseInt(st.nextToken()));
            }else if(com.equals("remove")){
                set.remove(Integer.parseInt(st.nextToken()));
            }else if(com.equals("check")){
                if(set.contains(Integer.parseInt(st.nextToken()))) sb.append(1);
                else sb.append(0);
                sb.append("\n");
            }else if(com.equals("toggle")){
                int num = Integer.parseInt(st.nextToken());
                if(set.contains(num)) set.remove(num);
                else set.add(num);
            }else if(com.equals("all")){
                for(int j=1; j<=20; j++) set.add(j);
            }else{
                set.clear();
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
