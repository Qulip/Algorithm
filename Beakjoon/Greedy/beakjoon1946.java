package beak1946;
//https://www.acmicpc.net/problem/1946

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            Grades[] peoples = new Grades[n];
            int rst=1;
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                peoples[i] = new Grades(x, y);
            }
            Arrays.sort(peoples);
            int low_interview = peoples[0].interview;
            for(int i=1; i<n; i++){
                if(low_interview>peoples[i].interview){
                    rst++;
                    low_interview=peoples[i].interview;
                }
            }/*
            for(int i=0; i<n; i++){
                System.out.println(peoples[i].paper+" "+peoples[i].interview);
            }
            System.out.println();*/
            sb.append(rst+"\n");
        }
        System.out.println(sb);
    }
}
class Grades implements Comparable<Grades>{
    int paper;
    int interview;
    Grades(int x, int y){
        paper=x;
        interview=y;
    }

    @Override
    public int compareTo(Grades o) {
            return this.paper - o.paper;
    }
}
/*
2
5
3 2
1 4
4 1
2 3
5 5
7
3 6
7 3
4 2
1 4
5 7
2 5
6 1

 */