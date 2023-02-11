//https://www.acmicpc.net/problem/2001
//solved : 23/02/11

import java.util.*;
import java.io.*;

class Main1{
    public static int rst;
    public static boolean[][][] canMove;
    public static boolean[][] state;

    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("./res/input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        rst = 0;

        int[] jewel = new int[k];
        int[][] bridge = new int[n][n];
        canMove = new boolean[n][n][k+1];
        state = new boolean[n][1<<k];

        for(int i=0; i<k; i++) {
            jewel[i] = Integer.parseInt(br.readLine())-1;
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int l1 = Integer.parseInt(st.nextToken()) -1;
            int l2 = Integer.parseInt(st.nextToken()) -1;
            int weight = Integer.parseInt(st.nextToken());
            bridge[l1][l2] = weight;
            bridge[l2][l1] = weight;
        }

        recur(jewel, bridge, 0, 0, 0);

        bw.write(Integer.toString(rst));
        br.close();
        bw.close();
    }

    public static void recur(int[] jewel, int[][] bridge, int cnt, int from, int bit) {
        if(cnt == jewel.length) {
            if(BFS(bridge, cnt, from, 0)) {
                rst = cnt;
            }
        }
        if(state[from][bit]) {
            return;
        }
        for(int i=0; i<jewel.length; i++) {
            if(jewel[i] <= -1) {
                continue;
            }
            if(BFS(bridge, cnt, from, jewel[i])) {
                int next = jewel[i];
                jewel[i] = -1;
                int nBit = bit | 1 << i;
                recur(jewel, bridge, cnt+1, next, nBit);
                jewel[i] = next;
            }
        }
        if(BFS(bridge, cnt, from, 0)) {
            rst = rst < cnt ? cnt : rst;
        }
        state[from][bit] = true;
    }

    public static boolean BFS(int[][] bridge, int cnt, int from, int to) {
        if(from == to || canMove[from][to][cnt]){
            return true;
        }
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[bridge.length];
        que.add(from);
        visited[from] = true;

        while(!que.isEmpty()) {
            int now = que.poll();
            for(int i = 0; i< bridge[now].length; i++) {
                if(bridge[now][i] >= cnt && !visited[i]) {
                    if(i == to) {
                        canMove[from][to][cnt] = true;
                        canMove[to][from][cnt] = true;
                        return true;
                    }
                    que.add(i);
                    visited[i] = true;
                }
            }
        }
        return false;
    }
}