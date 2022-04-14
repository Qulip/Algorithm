//Solved : 22/03/28

import java.io.*;
import java.util.*;

class Solution{
    static int[][] mag = new int[4][8];
    static int[] dirs; // 자석의 회전하는 방향

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            int K = Integer.parseInt(br.readLine());
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    mag[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                dirs = new int[4];

                check(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()));
                rotate();
            }

            int rst = 0;
            for (int i = 0; i < 4; i++) {
                if (mag[i][0] == 1) rst += Math.pow(2, i);
            }
            sb.append("#").append(tc).append(" ").append(rst).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void check(int wheelNum, int dir) {
        dirs[wheelNum] = dir;

        int prev = wheelNum - 1;
        int next = wheelNum + 1;

        if (prev >= 0 && dirs[prev] == 0) {
            // 왼쪽 검사
            if (mag[prev][2] != mag[wheelNum][6]) {
                check(prev, dir * -1);
            }
        }

        if (next <= 3 && dirs[next] == 0) {
            //오른쪽 검사
            if (mag[next][6] != mag[wheelNum][2]) {
                check(next, dir * -1);
            }
        }
    }

    static void rotate() {
        for (int i = 0; i < 4; i++) {
            if (dirs[i] != 0) {
                int[] tmp = new int[8];

                int idx;
                for (int j = 0; j < 8; j++) {
                    idx = j + dirs[i];

                    if (idx == -1) idx = 7;
                    else if (idx == 8) idx = 0;

                    tmp[idx] = mag[i][j];
                }
                mag[i] = tmp;
            }
        }
    }
}