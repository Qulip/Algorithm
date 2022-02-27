package beakjoon.d220225.q1197;
//https://www.acmicpc.net/problem/1197
//Solved : 22/02/26

import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node>{
        int to, dist;

        public Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<Node>[] list = new List[V];
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++) list[i] = new ArrayList<>();

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            int dist = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to,dist));
            list[to].add(new Node(from, dist));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0));
        int rst = 0, cnt=0;

        while(!pq.isEmpty()){
            Node n = pq.poll();
            if(visited[n.to]) continue;

            visited[n.to] = true;

            rst += n.dist;

            for(Node next : list[n.to]){
                if(!visited[next.to]){
                    pq.add(next);
                }
            }
            if(++cnt == V) break;
        }

        bw.write(Integer.toString(rst));
        bw.close();
        br.close();
    }
}



/*
public class Main {         //Kruskal
    static int[] parents;
    static int V;

    static class Node implements Comparable<Node>{
        int from, to, dist;

        public Node(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rst = 0;

        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        List<Node> list = new ArrayList<>();
        parents = new int[V];
        for(int i=0; i<V; i++) parents[i] = i;      //부모 초기화

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        int cnt=0;
        for(Node n : list){
            if(union(n.from-1, n.to-1)){
                rst+=n.dist;
                if(++cnt == V-1) break;
            }
        }

        bw.write(Integer.toString(rst));
        bw.close();
        br.close();
    }
    static boolean union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB) return false;        //사이클 되면 아웃!
        parents[rootB] = rootA;                 //아니면 모으기
        return true;
    }

    static int find(int a){
        if(a==parents[a]) return a;
        return find(parents[a]);
    }
}
*/