//Solved : 22/03/30

import java.util.*;
import java.io.*;

class Solution{
    static class Node{
        int from, to, dist;

        public Node(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }
    static int[] parents;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            int nodes = Integer.parseInt(st.nextToken());
            long rst = 0;
            parents = new int[nodes+1];
            int lines = Integer.parseInt(st.nextToken());
            PriorityQueue<Node> que = new PriorityQueue<>((x,y) -> x.dist - y.dist);
            for(int i=1; i<=nodes; i++){
                parents[i] = i;
            }
            for(int i=0; i<lines; i++){
                st = new StringTokenizer(br.readLine());
                que.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            while(!que.isEmpty()){
                Node node = que.poll();
                if(find(node.from) != find(node.to)){
                    union(node.from, node.to);
                    rst += node.dist;
                }
            }
            sb.append("#").append(tc).append(" ").append(rst).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x>y) parents[x] = y;
        else parents[y] = x;
    }
    static int find(int num){
        if(parents[num] != num) return find(parents[num]);
        return num;
    }
}