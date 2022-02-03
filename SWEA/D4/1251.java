package swea1251;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        //File file = new File("/Volumes/Mac_HDD/IdeaProjects/11WeekStudy/src/input(swea1251).txt");
        //BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc<=T; tc++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            ArrayList<int[]> island_done = new ArrayList<>();
            ArrayList<int[]> island_yet = new ArrayList<>();
            for(int i=0; i<n; i++){
                int x = Integer.parseInt(st1.nextToken());
                int y = Integer.parseInt(st2.nextToken());
                int[] tmp = {x, y};
                island_yet.add(tmp);
            }
            double e = Double.parseDouble(br.readLine());
            double rst = 0;
            island_done.add(island_yet.get(0));
            island_yet.remove(0);
            while(island_yet.size()>0){
                int next_island = 0;
                //int start_island = 0;
                long distance = Long.MAX_VALUE;
                for(int i=0; i<island_yet.size(); i++){
                    for(int j=0; j<island_done.size(); j++){
                        int[] yet = island_yet.get(i);
                        int[] done = island_done.get(j);
                        long dist_temp = (long) (done[0] - yet[0]) *(done[0]-yet[0])+(long)(done[1]-yet[1])*(done[1]-yet[1]);
                        if(distance>dist_temp){
                            distance = dist_temp;
                            //start_island = i;
                            next_island = i;
                        }
                    }
                }
                rst = rst + e * distance;
                island_done.add(island_yet.get(next_island));
                island_yet.remove(next_island);
            }
            sb.append("#"+tc+" "+Math.round(rst)+"\n");
        }
        System.out.println(sb);
    }
}
