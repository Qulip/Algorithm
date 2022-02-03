package beak18352;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList[] ways;
    static int[] nodes;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        nodes = new int[n+1];
        Arrays.fill(nodes,Integer.MAX_VALUE);
        nodes[x] = 0;
        ways = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            ways[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            ways[start].add(end);
        }
        dijikstra(x, k);
        boolean chk = true;/*
        for(int i=1; i<nodes.length; i++){
            if(nodes[i]==k){
                sb.append(i+"\n");
            }
        }
        if(chk) {
            System.out.println(sb);
        } else {
            System.out.println("-1");
        }*/
        System.out.println(sb);
    }
    public static void dijikstra(int start, int finish){//비교하고 값을 추가하기
        int now_length = 1;
        Queue<Integer> next = new LinkedList<>();
        next.add(start);
        while(true){
            int node_sizes = next.size();
            for(int i=0; i<node_sizes; i++) {
                int next_node = next.poll();
                for (int j = 0; j < ways[next_node].size(); j++) {
                    int k = (int) ways[next_node].get(j);
                    if(nodes[k]>now_length) {
                        next.add(k);
                        nodes[j] = now_length;
                    }
                }
            }
            if(finish==now_length){
                if(next.size()==0){
                    sb.append("-1");
                }else{
                    while(next.size()!=0){
                        int next_node = next.poll();
                        sb.append(next_node+"\n");
                    }
                }
                break;
            }
            now_length++;
        }
    }
}

/*
ex1
4 4 2 1
1 2
1 3
2 3
2 4

out  now
4    4
     3
ex2
4 3 2 1
1 2
1 3
1 4

out
-1

ex3
4 4 1 1
1 2
1 3
2 3
2 4

out
2
3
 */