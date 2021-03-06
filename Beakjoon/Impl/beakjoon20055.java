//https://www.acmicpc.net/problem/20055
//Solved : 22/04/05

import java.util.*;
import java.io.*;

class Main{
    static int N,K;
    static int[] belt;
    static boolean[] robot;
    static int rst, zero;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new int[N*2];
        rst = 0;
        robot = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N *2 ; i++)
            belt[i] = Integer.parseInt(st.nextToken());

        while(true) {
            rst++;
            rotate();
            move();
            put();
            if(zero >= K)
                break;
        }
        bw.write(Integer.toString(rst));
        bw.close();
        br.close();
    }

    static void rotate() {
        int pre = belt[N*2-1];
        for(int i = 0 ; i < N*2 ; i++) {
            int now = belt[i];
            belt[i] = pre;
            pre = now;
        }
        for(int i = N-2 ; i >= 0 ; i--)
            robot[i+1] = robot[i];
        robot[0] = false;
        robot[N-1] = false;
    }
    static void move() {
        for(int i = N-1 ; i >= 0 ; i-- ) {
            if(robot[i] && !robot[i+1] && belt[i+1] >= 0) {
                robot[i] = false;
                robot[i+1] = true;
                belt[i+1] -=1;
                if(belt[i+1] == 0)
                    zero++;
            }
        }
        robot[N-1] = false;
    }
    static void put() {
        if(belt[0] != 0) {
            robot[0] = true;
            belt[0]--;
            if(belt[0] == 0)
                zero++;
        }
    }
}