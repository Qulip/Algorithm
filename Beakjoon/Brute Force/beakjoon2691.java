package beakjoon.d220214.q2691;
//https://www.acmicpc.net/problem/
//Solved :

import java.util.*;
import java.io.*;

public class Main {
    static int rst;
    static int[][] taste;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        rst = Integer.MAX_VALUE;
        int N = Integer.parseInt(br.readLine());
        taste = new int[N][2];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            taste[i][0] = Integer.parseInt(st.nextToken());
            taste[i][1] = Integer.parseInt(st.nextToken());
        }
        com(0,1,0, 0);
        bw.write(Integer.toString(rst));
        bw.close();
        br.close();
    }
    static void com(int chk, int sour, int bitter, int time){
        if(chk == taste.length&&time>0){
            rst = rst < Math.abs(sour - bitter) ? rst : Math.abs(sour - bitter);
            return;
        }else if(chk == taste.length) return;
        com(chk+1, sour*taste[chk][0], bitter+taste[chk][1], time+1);
        com(chk+1, sour, bitter,time);
    }
}
