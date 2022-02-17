package swea.d220217.d5_1247;
//https://www.acmicpc.net/problem/1247
//Solved : 22/02/17

import java.util.*;
import java.io.*;

public class Solution {
    static int rst;
    static boolean[] visit;
    static Point[] cus;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("res/swea/input_d5_1247.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            rst = Integer.MAX_VALUE;
            int N = Integer.parseInt(br.readLine());
            visit = new boolean[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point now = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Point home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            cus = new Point[N];
            for(int i=0; i<N; i++){
                cus[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            perm(0, 0, now, home);
            sb.append("#").append(tc).append(" ").append(rst).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void perm(int idx, int score, Point before, Point home){
        if(idx == visit.length){
            score += home.dist(before);
            rst = rst < score ? rst : score;
            return;
        }
        for(int i=0; i<visit.length; i++){
            if(visit[i]) continue;
            visit[i] = true;
            perm(idx+1, score+ before.dist(cus[i]), cus[i], home);
            visit[i] = false;
        }
    }
}

class Point {
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    int dist(Point o){
        return Math.abs(this.x-o.x) + Math.abs(this.y-o.y);
    }
}