package swea.d220214.d3_6808;
//Solved : 22/02/14

import java.util.*;
import java.io.*;

public class Solution {
    static int[] kyu_card;
    static boolean[] cards;
    static int win;
    static int lose;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++){
            kyu_card = new int[9];
            cards = new boolean[18];
            win = 0;
            lose = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<9; i++){
                kyu_card[i] = Integer.parseInt(st.nextToken());
                cards[kyu_card[i]-1] = true;
            }
            perm(0,0,0);
            sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void perm(int now, int kyu_score, int in_score){
        if(now==9){
            if(kyu_score>in_score) win++;
            else lose++;
            return;
        }
        for(int i=0; i<18; i++){
            if(!cards[i]){
                cards[i] = true;
                if(kyu_card[now]>i+1){
                    perm(now+1, kyu_score+i+1+kyu_card[now], in_score);
                }else{
                    perm(now+1, kyu_score, in_score+i+1+kyu_card[now]);
                }
                cards[i] = false;
            }
        }
    }
}

/*

4
1 3 5 7 9 11 13 15 17
18 16 14 12 10 8 6 4 2
13 17 9 5 18 7 11 1 15
1 6 7 9 12 13 15 17 18

 */