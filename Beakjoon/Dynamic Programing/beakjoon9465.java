package beakjoon.q9465;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            int num = Integer.parseInt(br.readLine());
            int[][] cost = new int[2][num];
            int[][] best = new int[2][num];
            StringTokenizer st;
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < num; j++) {
                    cost[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            best[0][0] = cost[0][0];
            best[1][0] = cost[1][0];
            if (num > 1) {
                best[0][1] = cost[0][1] + cost[1][0];
                best[1][1] = cost[1][1] + cost[0][0];
                if (num > 2)
                    for (int i = 2; i < best[0].length; i++) {
                        best[0][i] = Math.max(best[1][i - 1], best[1][i - 2]) + cost[0][i];
                        best[1][i] = Math.max(best[0][i - 1], best[0][i - 2]) + cost[1][i];
                    }

            }
            bw.write(Integer.toString(Math.max(best[0][num - 1], best[1][num - 1])));
            bw.write("\n");
        }
        bw.close();
    }
}

/*
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int best;
    static int[][] stk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            best = 0;
            int num = Integer.parseInt(br.readLine());
            stk = new int[2][num];
            StringTokenizer st;
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < num; j++) {
                    stk[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp(0, 0, best, new boolean[2][num]);
            bw.write(Integer.toString(best));
            bw.write("\n");
        }
        bw.close();
    }

    public static void dp(int row, int col, int score, boolean[][] chk) {
        if (!chkNext(row, col, chk)) {
            best = Math.max(best, score);
            return;
        }
        if (!chk[row][col]) {
            int nextR, nextC;
            if (col == stk[0].length - 1) {
                if (row == 1) {
                    nextC = col;
                    nextR = row;
                    best = Math.max(best, score+stk[row][col]);
                    return;
                } else {
                    nextC = 0;
                    nextR = 1;
                }
            } else {
                nextC = col + 1;
                nextR = row;
            }
            dp(nextR, nextC, score + stk[row][col], use(row, col, chk));
            dp(nextR, nextC, score, chk);
        }else{
            int nextR, nextC;
            if (col == stk[0].length - 1) {
                if (row == 1) {
                    nextC = col;
                    nextR = row;
                } else {
                    nextC = 0;
                    nextR = 1;
                }
            } else {
                nextC = col + 1;
                nextR = row;
            }
            dp(nextR, nextC, score, chk);
        }
    }

    public static boolean chkNext(int row, int col, boolean[][] chk) {
        if (row == 0) {
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    for (int j = col; j < chk[0].length; j++){
                        if (!chk[i][j]) {
                            return true;
                        }
                    }
                } else {
                    for (int j = 0; j < chk[0].length; j++) {
                        if (!chk[i][j]) {
                            return true;
                        }
                    }
                }
            }
        }else{
            for (int j = col; j < chk[0].length; j++){
                if (!chk[row][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean[][] use(int row, int col, boolean[][] arr) {
        boolean[][] chk = new boolean[2][arr[0].length];
        for(int i=0; i<2; i++){
            System.arraycopy(arr[i],0,chk[i],0,arr[0].length);
        }
        chk[row][col] = true;
        if (row == 0) {
            chk[1][col] = true;
        } else {
            chk[0][col] = true;
        }
        if (!(col == 0)) {
            chk[row][col - 1] = true;
        }
        if (!(col == chk[0].length - 1)) {
            chk[row][col + 1] = true;
        }
        return chk;
    }
}
*/
