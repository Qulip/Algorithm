package swea.d220226.d4_1251;
//Solved : 22/02/26

import java.util.*;
import java.io.*;

public class Solution {
    static long[][] island;
    static double E;
    static int N;
    static int[] parents;

    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("res/swea/input_d4_1251.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());
            island = new long[N][2];
            parents = new int[N];
            for(int i=0; i<2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    island[j][i] = Long.parseLong(st.nextToken());
                    parents[j] = j;
                }
            }
            E = Double.parseDouble(br.readLine());
            List<swea.d220226.d4_1251.Node> list = new ArrayList<>();
            for(int i=0; i<N; i++){
                for(int j=i+1; j<N; j++){
                    long dx = Math.abs(island[i][0]-island[j][0]);
                    long dy = Math.abs(island[i][1]-island[j][1]);
                    list.add(new swea.d220226.d4_1251.Node(i,j,dx*dx+dy*dy));
                }
            }
            Collections.sort(list);

            int cnt = 0;
            long rst = 0;
            for(swea.d220226.d4_1251.Node n : list){
                if(union(n.from,n.to)){
                    rst += n.dist;
                    if(++cnt == N-1) break;
                }
            }

            sb.append("#").append(tc).append(" ").append(Math.round(rst*E)).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        // 사이클이 형성되면
        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    static int find(int a){
        if(a==parents[a]) return a;
        return parents[a] = find(parents[a]);
    }
}

class Node implements Comparable<swea.d220226.d4_1251.Node>{
    int from, to;
    long dist;

    public Node(int from, int to, long dist) {
        this.from = from;
        this.to = to;
        this.dist = dist;
    }

    @Override
    public int compareTo(swea.d220226.d4_1251.Node o) {
        return Long.compare(this.dist, o.dist);
    }
}


//package swea1251;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class Solution {
//    public static void main(String[] args) throws IOException{
//        //File file = new File("/Volumes/Mac_HDD/IdeaProjects/11WeekStudy/src/input(swea1251).txt");
//        //BufferedReader br = new BufferedReader(new FileReader(file));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//        StringBuilder sb = new StringBuilder();
//        for(int tc = 1; tc<=T; tc++){
//            int n = Integer.parseInt(br.readLine());
//            StringTokenizer st1 = new StringTokenizer(br.readLine());
//            StringTokenizer st2 = new StringTokenizer(br.readLine());
//            ArrayList<int[]> island_done = new ArrayList<>();
//            ArrayList<int[]> island_yet = new ArrayList<>();
//            for(int i=0; i<n; i++){
//                int x = Integer.parseInt(st1.nextToken());
//                int y = Integer.parseInt(st2.nextToken());
//                int[] tmp = {x, y};
//                island_yet.add(tmp);
//            }
//            double e = Double.parseDouble(br.readLine());
//            double rst = 0;
//            island_done.add(island_yet.get(0));
//            island_yet.remove(0);
//            while(island_yet.size()>0){
//                int next_island = 0;
//                //int start_island = 0;
//                long distance = Long.MAX_VALUE;
//                for(int i=0; i<island_yet.size(); i++){
//                    for(int j=0; j<island_done.size(); j++){
//                        int[] yet = island_yet.get(i);
//                        int[] done = island_done.get(j);
//                        long dist_temp = (long) (done[0] - yet[0]) *(done[0]-yet[0])+(long)(done[1]-yet[1])*(done[1]-yet[1]);
//                        if(distance>dist_temp){
//                            distance = dist_temp;
//                            //start_island = i;
//                            next_island = i;
//                        }
//                    }
//                }
//                rst = rst + e * distance;
//                island_done.add(island_yet.get(next_island));
//                island_yet.remove(next_island);
//            }
//            sb.append("#"+tc+" "+Math.round(rst)+"\n");
//        }
//        System.out.println(sb);
//    }
//}
