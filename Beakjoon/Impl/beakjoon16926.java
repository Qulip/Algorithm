package beakjoon.q16926;

import java.util.*;
import java.io.*;

public class Main {
    static int[] mr = {0, 1, 0, -1};
    static int[] mc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = Math.min(N, M) / 2;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < time; j++) {
                int row = j, col = j;
                int value = arr[row][col];
                int idx = 0;

                while (idx < 4) {
                    int nextR = row + mr[idx];
                    int nextC = col + mc[idx];

                    if (nextR >= j && nextC >= j && nextR < N - j && nextC < M - j) {
                        arr[row][col] = arr[nextR][nextC];
                        row = nextR;
                        col = nextC;
                    } else idx++;
                }
                arr[j + 1][j] = value;
            }
        }

        for(int[] i: arr){
            for(int j : i){
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}

