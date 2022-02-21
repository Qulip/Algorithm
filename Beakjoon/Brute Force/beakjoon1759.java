package beakjoon.d220221.q1759;
//https://www.acmicpc.net/problem/1759
//Solved : 22/02/21

import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int hasvowel;
    static int hascom;
    static boolean[] chk;
    static List<Character> alphabet;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        alphabet = new ArrayList<>();
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++) {
            alphabet.add(st.nextToken().charAt(0));
        }
        Collections.sort(alphabet);
        hasvowel = 0;
        hascom = 0;
        chk = new boolean[alphabet.size()];

        dfs(L,C,0,0);

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void dfs(int L, int C, int idx, int used){
        if(used == L){
            if(hasvowel>0&&hascom>1){
                for(int i=0; i<chk.length; i++){
                    if(chk[i]){
                        sb.append(alphabet.get(i));
                    }
                }
                sb.append("\n");
            }
            return;
        }
        //if(idx==C) return;
        if(L-used>C-idx) return;
        char now = alphabet.get(idx);
        chk[idx] = true;
        if(now=='a'||now=='e'||now=='i'||now=='o'||now=='u') hasvowel++;
        else hascom++;
        dfs(L, C, idx+1, used+1);
        chk[idx] = false;
        if(now=='a'||now=='e'||now=='i'||now=='o'||now=='u') hasvowel--;
        else hascom--;
        dfs(L, C, idx+1, used);
    }
}
