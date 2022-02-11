package beakjoon.d220211.q2491;
//https://www.acmicpc.net/problem/2491
//Solved : 22/02/11

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int rst = 1;

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[][] dp = new int[n][2];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = 1;       //큼
        dp[0][1] = 1;       //작음
        for(int i=1; i<n; i++){
            if(arr[i]>arr[i-1]){
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1]=1;
            }else if(arr[i]==arr[i-1]){
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1]= dp[i-1][1] + 1;
            }else{
                dp[i][0] = 1;
                dp[i][1] = dp[i-1][1] + 1;
            }
        }
        for(int i=0; i<n; i++){
            rst = rst > dp[i][0] ? rst : dp[i][0];
            rst = rst > dp[i][1] ? rst : dp[i][1];
        }
        bw.write(Integer.toString(rst));
        bw.close();
        br.close();
    }
}


/*
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int rst = 1;

        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[a];

        for(int i=0; i<a; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int pos = 0;
        while(pos<a-2){
            boolean big = arr[pos+1] - arr[pos] > 0;
            boolean small = arr[pos+1] - arr[pos] < 0;
            int score = 2;
            if(pos>0){
                if(arr[pos-1]==arr[pos]){
                    score++;
                }
            }
            for(int j=pos+1; j<a-1; j++){
                System.out.println("pos, score : " +pos+" "
                        +score+" j+1 : "+(j+1)+" arr[j+1] : "
                        +arr[j+1]+" j : "+j+" arr[j] : "+arr[j]+" big : "
                        +big+" small : "+small);
                int tmp = arr[j+1]-arr[j];
                if(!big&&!small){
                    big = arr[j+1] - arr[j] > 0;
                    small = arr[j+1] - arr[j] < 0;
                    //System.out.println(big+" "+small+" "+chk);
                }
                if(tmp==0){
                    score++;
                }else if(tmp>=0&&big){
                    score++;
                }else if(tmp<=0&&small){
                    score++;
                }else break;
            }
            pos += score-1;
            System.out.println(pos);
            //System.out.println(score);
            rst = rst > score ? rst : score;
        }
        bw.write(Integer.toString(rst));
        bw.close();
        br.close();
    }
}
*/