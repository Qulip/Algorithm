package beakjoon.q14888;
//https://www.acmicpc.net/problem/14888
//Solved : 22/02/08

import java.util.*;
import java.io.*;

public class Main {
    static int[] test;
    static int[] Oper = new int[4];
    static long Max = Long.MIN_VALUE;
    static long Min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        test = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<num; i++){
            test[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            Oper[i] = Integer.parseInt(st.nextToken());
        }
        mk_num(0, test[0]);
        sb.append(Max).append("\n").append(Min);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void mk_num(int time, long rst){
        //System.out.print("mk_num : " + time + " " + rst);
        //System.out.println(" Oper : "+Arrays.toString(Oper));
        if(time==test.length-1){
            Max = Max > rst ? Max : rst;
            Min = Min < rst ? Min : rst;
            return;
        }
        if(Oper[0]>0){
            Oper[0]--;
            //System.out.println("+ "+time+" "+rst);
            mk_num(time+1, rst+test[time+1]);
            Oper[0]++;
        }
        if(Oper[1]>0){
            Oper[1]--;
            //System.out.println("- "+time+" "+rst);
            mk_num(time+1, rst-test[time+1]);
            Oper[1]++;
        }
        if(Oper[2]>0){
            Oper[2]--;
            //System.out.println("* "+time+" "+rst);
            mk_num(time+1, rst*test[time+1]);
            Oper[2]++;
        }
        if(Oper[3]>0){
            Oper[3]--;
            //System.out.println("/ "+time+" "+rst);
            mk_num(time+1, rst/test[time+1]);
            Oper[3]++;
        }
    }
}

/*

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static int MAX = Integer.MIN_VALUE;	// ?????????
    public static int MIN = Integer.MAX_VALUE;	// ?????????
    public static int[] operator = new int[4];	// ????????? ??????
    public static int[] number;					// ??????
    public static int N;						// ?????? ??????

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        number = new int[N];

        // ?????? ??????
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        // ????????? ??????
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(number[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);

    }

    public static void dfs(int num, int idx) {
        if (idx == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            // ????????? ????????? 1??? ????????? ??????
            if (operator[i] > 0) {

                // ?????? ???????????? 1 ???????????????.
                operator[i]--;

                switch (i) {

                    case 0:	dfs(num + number[idx], idx + 1);	break;
                    case 1:	dfs(num - number[idx], idx + 1);	break;
                    case 2:	dfs(num * number[idx], idx + 1);	break;
                    case 3:	dfs(num / number[idx], idx + 1);	break;

                }
                // ??????????????? ???????????? ?????? ?????? ????????? ????????? ????????????.
                operator[i]++;
            }
        }
    }

}

 */