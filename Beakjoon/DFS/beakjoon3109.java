package beakjoon.d220217.q3109;
//https://www.acmicpc.net/problem/3109
//Solved : 22/02/17

import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] arr;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("res/beakjoon/q3109.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        arr = new boolean[R][C];

        for(int i=0; i<R; i++){
            String tmp = br.readLine();
            for(int j=0; j<C; j++){
                if(tmp.charAt(j)=='x') arr[i][j] = true;
            }
        }
        int rst = 0;
        for(int i=0; i<R; i++){
            if(pipe(R, C, i, 0)){
                rst++;
                //System.out.println(rst);
            }
        }
        bw.write(Integer.toString(rst));
        bw.close();
        br.close();
    }
    static boolean pipe(int r, int c, int nowR, int nowC) {
        if (nowC == c - 1) return true;

        boolean chk = false;
        for (int i = -1; i < 2; i++) {
            if (nowR + i < 0 || nowR + i >= r || nowC + 1 < 0 || nowC + 1 >= c||arr[nowR + i][nowC + 1]) continue;
            chk = pipe(r, c, nowR + i, nowC + 1);
            if (chk) break;
        }
        arr[nowR][nowC] = true;
        return chk;
    }
}


//import java.io.*;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    static int R, C, cnt; // 행,렬
//    static boolean root;
//    static char map[][]; // 입력받는 map
//    static int dy[] = { -1, 0, 1 }; // 우상, 우, 우하
//    static int dx[] = { 1, 1, 1 };
//
//    // 범위 체크
//    public static boolean isValid(int row, int col) {
//        if (row < 0 || row >= R || col < 0 || col >= C) {
//            return false;
//        }
//        return true;
//    }
//
//    private static void dfs(int row, int col) {
//
//        if (col == C - 1) {
//            root = true;
//            cnt++;
//            return;
//
//        }
//
//        // 3방 탐색
//        for (int k = 0; k < 3; k++) {
//            int nextRow = row + dy[k];
//            int nextCol = col + dx[k];
//
//            // 범위 && 파이프 자리 검사
//            if (isValid(nextRow, nextCol) && map[nextRow][nextCol] == '.') {
//                map[row][col] = 'x';
//                dfs(nextRow, nextCol);
//                if (root) {
//                    return;
//                }
//            }
//        }
//
//    }
//
//    public static void main(String[] args) throws IOException {
//        long before_time = System.currentTimeMillis();
//        System.setIn(new FileInputStream("res/beakjoon/q3109.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        // input
//        R = Integer.parseInt(st.nextToken());
//        C = Integer.parseInt(st.nextToken());
//        map = new char[R][C];
//
//        for (int i = 0; i < R; i++) {
//            map[i] = br.readLine().toCharArray();
//        }
//        // end of input;
//
//        for (int i = 0; i < R; i++) {
//            root = false;
//            dfs(i, 0);
//        }
//
//        // output
//        sb.append(cnt);
//        bw.write(sb + " ");
//        bw.flush();
//        long after_time = System.currentTimeMillis();
//        System.out.println("time : "+((after_time-before_time)));
//        bw.close();
//        br.close();
//
//    } // end of main
//
//}