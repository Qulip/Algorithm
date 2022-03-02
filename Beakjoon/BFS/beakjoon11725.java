//https://www.acmicpc.net/problem/
//Solved :

import java.util.*;
import java.io.*;

class Main{
    static int N;
    static int[] parent;
    static List<List<Integer>> nodes;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        parent[1] = 1;
        nodes = new ArrayList<>(N+1);

        for(int i=0; i<=N; i++) nodes.add(new ArrayList<>());

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            nodes.get(n1).add(n2);
            nodes.get(n2).add(n1);
        }

        BFS();
        for(int i=2; i<=N; i++) sb.append(parent[i]).append("\n");

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void BFS(){
        Queue<Integer> que = new ArrayDeque<>();
        que.add(1);
        while (!que.isEmpty()){
            int p = que.poll();
            for(int i=nodes.get(p).size()-1; i>=0; i--){
                int n = nodes.get(p).get(i);
                if(parent[n]==0){
                    parent[n] = p;
                    que.add(n);
                }
                nodes.get(p).remove(i);
            }
        }
    }
}