package beak1753;       //나중에 다시 풀어보기
//https://www.acmicpc.net/problem/1753

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int v,e,k;
    static ArrayList<beak1753.Node>[] list;
    static int[] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        list = new ArrayList[v + 1];
        dist = new int[v + 1];

        Arrays.fill(dist, 3000000);     //MAX_VALUE 사용시 오버플로우

        for(int i = 1; i <= v; i++){
            list[i] = new ArrayList<>();    //그래프 정보 초기화
        }

        for(int i = 0 ; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new beak1753.Node(end, weight));
        }

        dijkstra(k);

        for(int i = 1; i <= v; i++){
            if(dist[i] == 3000000) sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }

        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        PriorityQueue<beak1753.Node> queue = new PriorityQueue<>();
        boolean[] check = new boolean[v + 1];
        queue.add(new beak1753.Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            beak1753.Node curNode = queue.poll();
            int cur = curNode.end;

            if (check[cur]) {
                continue;
            }
            check[cur] = true;

            for (beak1753.Node node : list[cur]) {
                if (dist[node.end] > dist[cur] + node.weight) {
                    dist[node.end] = dist[cur] + node.weight;
                    queue.add(new beak1753.Node(node.end, dist[node.end]));
                }
            }
        }
    }
}

class Node implements Comparable<beak1753.Node>{

    int end, weight;

    Node(int x, int y){
        end = x;
        weight = y;
    }

    @Override
    public int compareTo(beak1753.Node o) {
        return this.weight - o.weight;
    }
}

/*
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        int[][] ways = new int[v+1][v+1];
        for(int i=1; i<=v; i++) {
            Arrays.fill(ways[i], 3000000);
            ways[i][i] = 0;
        }
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int finish = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if(ways[start][finish]>dist){
                ways[start][finish]=dist;
            }
        }
        int num = 1;
        int next_point = 0;
        boolean[] chk = new boolean[v+1];
        chk[k] = true;
        while(num<v){
            int dist= Integer.MAX_VALUE;
            for(int i=1; i<=v; i++){
                if(dist>ways[k][i]&&!chk[i]){
                    next_point = i;
                    dist = ways[k][i];
                }
            }
            chk[next_point]=true;
            for(int i=1; i<=v; i++){
                if(!chk[i]&&dist+ways[next_point][i]<ways[k][i]){
                    ways[k][i] = dist+ways[next_point][i];
                }
            }
            num++;
        }
        for(int i=1; i<=v;i++){
            if(ways[k][i]==3000000){
                sb.append("INF\n");
            }else{
                sb.append(ways[k][i]+"\n");
            }
        }
        System.out.println(sb);
    }
}
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6

 */
