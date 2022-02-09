package swea.d220209.d3_3499;
//Solved : 22/02/09

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        String[][] arr = new String[2][];
        for(int tc=1; tc<=T; tc++){
            sb.append("#").append(tc).append(" ");
            int num = Integer.parseInt(br.readLine());
            arr[0] = new String[num/2+num%2];
            arr[1] = new String[num/2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<num; i++){
                arr[i/(num/2+num%2)][i%(num/2+num%2)] = st.nextToken();
            }
            for(int i=0; i<num/2+num%2; i++){
                if(i==arr[1].length) sb.append(arr[0][i]);
                else sb.append(arr[0][i]).append(" ").append(arr[1][i]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}

/*
import java.util.Scanner;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        LinkedList<String> List = new LinkedList<>();

        for(int tc = 1; tc<=T; tc++) {
            int x = sc.nextInt();
            for (int i = 0; i < x; i++) {
                List.add(sc.next());
            }
            if(x%2==0){
                for(int i=0;i<x/2;i++){
                    String temp = List.get(x/2+i);
                    List.remove(x/2+i);
                    List.add((i*2)+1, temp);
                }
            }
            else{
                for(int i=0;i<x/2;i++){
                    String temp = List.get(x/2+i+1);
                    List.remove(x/2+i+1);
                    List.add((i*2)+1, temp);
                }
            }
            System.out.print("#"+tc+" ");
            for(int i=0; i<x; i++) {
                System.out.print(List.get(i)+" ");
            }
            System.out.println();
            List.clear();
        }
    }
}
*/