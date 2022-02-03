package beak1916;
//https://www.acmicpc.net/problem/1916

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static ArrayList<Node>[] list;
    static int rst;
    static int[] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, 300000000);
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<beak1916.Node>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }
        st = new StringTokenizer(br.readLine());
        int start_node = Integer.parseInt(st.nextToken());
        int end_node = Integer.parseInt(st.nextToken());
        dijkstra(start_node);
        System.out.println(dist[end_node]);
    }
    static public void dijkstra(int start_node){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] chk = new boolean[n+1];
        queue.add(new Node(start_node,0));
        dist[start_node] = 0;
        while (!queue.isEmpty()){
            Node cur_node = queue.poll();
            int next = cur_node.end;
            if(chk[next]){
                continue;
            }
            chk[next] = true;

            for(Node node : list[next]){
                if (dist[node.end] > dist[next] + node.weight) {
                    dist[node.end] = dist[next] + node.weight;
                    queue.add(new beak1916.Node(node.end, dist[node.end]));
                }
            }
        }
    }
}

class Node implements Comparable<Node>{

    int end, weight;

    Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o){
        return this.weight - o.weight;
    }

}

/*
5
8
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
1 5

 */
