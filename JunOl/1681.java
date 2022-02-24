package jungol.d220224.q1681;
//Solved : 22/02/24

import java.util.*;
import java.io.*;

public class Main {
    static int[][] dist;
    static boolean[] chk;
    static int N, rst = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        //System.setIn(new FileInputStream("res/jungol/input_q1681.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dist = new int[N][N];
        chk = new boolean[N];
        chk[0] = true;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);

        bw.write(Integer.toString(rst));
        bw.close();
        br.close();
    }

    static void dfs(int visited, int now, int way){
        //System.out.println(visited+" "+now+" "+way+" "+rst);
        if(way > rst) return;
        if(visited == N-1){
            if(dist[now][0]==0) return;
            way += dist[now][0];
            rst = rst < way ? rst : way;
            return;
        }
        for(int i=1; i<N; i++){
            if(i==now||chk[i]||dist[now][i]==0) continue;
            chk[i] = true;
            dfs(visited+1, i, way+dist[now][i]);
            chk[i] = false;
        }
    }
}
