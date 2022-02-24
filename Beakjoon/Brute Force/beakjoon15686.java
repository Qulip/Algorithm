package beakjoon.d220223.q15686;
//https://www.acmicpc.net/problem/15686
//Solved : 22/02/23

import java.util.*;
import java.io.*;

public class Main {
    static int[][] dist;
    static boolean[] open;
    static int rst = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<int[]> home = new ArrayList<>();
        List<int[]> chicken = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int t = Integer.parseInt(st.nextToken());
                if(t==1)home.add(new int[]{i,j});
                else if(t==2)chicken.add(new int[]{i,j});
            }
        }

        dist = new int[home.size()][chicken.size()];
        open = new boolean[chicken.size()];

        for(int i=0; i < home.size(); i++){
            int[] nowH = home.get(i);
            for(int j=0;  j < chicken.size(); j++){
                int[] nowC = chicken.get(j);
                dist[i][j] = Math.abs(nowC[0] - nowH[0]) + Math.abs(nowC[1] - nowH[1]);
            }
        }

        com(M, home.size(), chicken.size(), 0, 0);

        bw.write(Integer.toString(rst));
        bw.close();
        br.close();
    }
    static void com(int M, int home, int chicken, int idx, int used){
        if(M==used){
            int nowD=0;
            for(int i=0; i< home; i++){
                int d = Integer.MAX_VALUE;
                for(int j=0; j<chicken; j++){
                    if(open[j]) d = d < dist[i][j] ? d : dist[i][j];
                }
                nowD += d;
            }
            rst = rst < nowD ? rst : nowD;
            return;
        }
        if(idx==chicken||M-used>chicken-idx) return;
        open[idx] = true;
        com(M, home, chicken, idx+1, used+1);
        open[idx] = false;
        com(M, home, chicken, idx+1, used);
    }
}
