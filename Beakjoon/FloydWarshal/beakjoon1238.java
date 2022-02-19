package beakjoon.d220219.q1238;
//https://www.acmicpc.net/problem/1238
//Solved : 22/02/19

import java.util.*;
import java.io.*;

public class Main {
    static int[][] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        dist = new int[N][N];
        for(int i=0; i<N; i++){
            Arrays.fill(dist[i], 100000);
            dist[i][i] = 0;
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            dist[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken());
        }

        floydWarshal();

        for(int[] i : dist){
            System.out.println(Arrays.toString(i));
        }

        int rst = 0;
        for(int i=0; i<N; i++){
            if(i==X-1) continue;
            rst = rst > dist[i][X-1]+dist[X-1][i] ? rst : dist[i][X-1]+dist[X-1][i];
        }
        bw.write(Integer.toString(rst));
        bw.close();
        br.close();
    }

    static void floydWarshal(){
        for(int i=0; i< dist.length; i++){
            for(int j=0; j<dist.length; j++){
                if(j==i) continue;
                for(int k=0; k<dist.length; k++){
                    if(i==k||k==j) continue;
                    dist[j][k] = dist[j][k] < dist[j][i] + dist[i][k] ? dist[j][k] : dist[j][i] + dist[i][k];
                }
            }
        }
    }
}
/*
//분석해봅시다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(input.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        List<int[]>[] tRoads = new List[N+1];
        List<int[]>[] fRoads = new List[N+1];
        for(int i = 1; i <= N; i++){
            tRoads[i] = new ArrayList<>();
            fRoads[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(input.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            fRoads[from].add(new int[]{to, time});
            tRoads[to].add(new int[]{from, time});
        }
        int go[] = dijkstra(tRoads, X);
        int back[] = dijkstra(fRoads, X);
        int max = 0;
        for(int i = 1; i <= N; i++){
            if(i == X){
                continue;
            }

            int cost = go[i] + back[i];

            if(cost > max){
                max = cost;
            }
        }
        System.out.println(max);
    }

    static final int INF = Integer.MAX_VALUE;
    static int N, M, X;
    static int[] dijkstra(List<int[]> roads[], int to){
        int ans = 0;
        boolean[] isVisited = new boolean[N+1];
        int[] dp = new int[N+1];
        Arrays.fill(dp, INF);
        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        pq.add(new int[]{to, 0});
        dp[to] = 0;
        while(!pq.isEmpty()){
            int[] loc = pq.poll();
            if(isVisited[loc[0]]){
                continue;
            }
            isVisited[loc[0]] = true;
            for(int[] next: roads[loc[0]]){
                if(isVisited[next[0]]){
                    continue;
                }
                if(loc[1] + next[1] < dp[next[0]]) {
                    dp[next[0]] = loc[1] + next[1];
                    pq.add(new int[]{next[0], dp[next[0]]});
                }
            }
        }
        return dp;
    }
}


 */