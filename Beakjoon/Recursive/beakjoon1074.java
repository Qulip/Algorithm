package beakjoon.d220215.q1074;
//https://www.acmicpc.net/problem/1074
//Solved : 22/02/18

import java.util.*;
import java.io.*;

public class Main {
    //static int[][] arr;
    static int next=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        N = (int)Math.pow(2,N);
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        chk_place(R, C, 0,0, N, 0);

        //arr = new int[N][N];
        //move(0,0,N);
        //bw.write(Integer.toString(arr[r][c]));
        bw.write(Integer.toString(next));
        bw.close();
        br.close();
    }

    static void chk_place(int R, int C, int now_r, int now_c, int size, int score){
        //System.out.println(now_r+" "+now_c+" "+size+" "+score);
        if(size==2){
            if(now_c==C&&now_r==R) next = score;
            else if(now_c+1==C&&now_r==R) next = score+1;
            else if(now_r+1==R&&now_c==C) next = score+2;
            else next = score+3;
            return;
        }
        int next_r = now_r+size/2 <= R ? now_r+size/2 : now_r;
        int next_c = now_c+size/2 <= C ? now_c+size/2 : now_c;
        int next_score = score + (int)Math.pow(size,2)/4 * ((next_r/(now_r+size/2)*2)+next_c/(now_c+size/2));
        chk_place(R, C, next_r, next_c, size/2,next_score);
    }

//    static void move(int r, int c, int size){       //시간초과
//        if(size==2){
//            arr[r][c] = next++;
//            arr[r][c+1] = next++;
//            arr[r+1][c] = next++;
//            arr[r+1][c+1] = next++;
//            return;
//        }
//        move(r,c,size/2);
//        move(r,c+size/2,size/2);
//        move(r+size/2,c,size/2);
//        move(r+size/2,c+size/2, size/2);
//    }

}
