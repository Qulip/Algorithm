package swea1289;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        //BufferedReader br = new BufferedReader(new FileReader("res/input_d3_1289.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1; t<=tc; t++) {
            char[] mem = br.readLine().toCharArray();
            int time = 0;
            char now = '0';
            for(int i=0; i<mem.length; i++) {
                if(mem[i]!=now) {
                    time++;
                    now = mem[i];
                }
            }
            bw.write("#");
            bw.write(Integer.toString(t));
            bw.write(" ");
            bw.write(Integer.toString(time));
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
}

