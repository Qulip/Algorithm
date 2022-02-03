package beak1446;
//https://www.acmicpc.net/problem/1446

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());
        ArrayList<beak1446.Short_cut> ways = new ArrayList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            if(y>distance||y-x<=z) {                    //도착점이 거리보다 멀거나, 숏컷의 역할을 못하면 넘김
                continue;
            }
            ways.add(new beak1446.Short_cut(x,y,z));
        }
        Collections.sort(ways);                         //시작점을 오름차순으로 정렬

        int[] dp = new int[distance+1];
        int now_point = 0;
        Arrays.fill(dp, Integer.MAX_VALUE);             //비교할 값들 입력
        dp[0] = 0;
        int i = 0;

        while(now_point<distance){
            if(i<ways.size()){                          //아직 모든 지름길을 안봤을경우
                beak1446.Short_cut temp = ways.get(i);
                if(now_point == temp.start){            //지름길의 시작점과 현재 위치가 같을경우
                    dp[temp.finish] = Math.min(dp[now_point]+temp.distance, dp[temp.finish]);
                    i++;                                    //지름길 사용과 아닌것과 비교
                }else{
                    dp[now_point+1] = Math.min(dp[now_point+1], dp[now_point]+1);
                    now_point++;                        //아니면 그냥 전값에 1더하기
                }
            }else{
                dp[now_point+1] = Math.min(dp[now_point+1], dp[now_point]+1);
                now_point++;                            //위와 동일
            }
        }
        System.out.println(dp[distance]);
    }
}

class Short_cut implements Comparable<beak1446.Short_cut>{
    int start;
    int finish;
    int distance;
    Short_cut(int x, int y, int z){
        start = x;
        finish = y;
        distance = z;
    }
    @Override
    public int compareTo(beak1446.Short_cut o){
        if(this.start != o.start){
            return this.start - o.start;
        }else{
            return this.finish - o.finish;
        }
    }
}
/*
5 150
0 50 10
0 50 20
50 100 10
100 151 10
110 140 90

 */