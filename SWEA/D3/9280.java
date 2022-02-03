package swea9280;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int[] parkinglot;
    static int[] bill;
    static int[] weight;
    static ArrayList<Integer> waiting = new ArrayList<>();
    static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(input.readLine());
        for(int tc=1; tc<=T; tc++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            parkinglot = new int[n];
            bill = new int[n];
            weight = new int[m];
            result = 0;
            for(int i=0; i<n; i++){
                bill[i] = Integer.parseInt(input.readLine());
            }
            for(int i=0; i<m; i++){
                weight[i] = Integer.parseInt(input.readLine());
            }
            for(int i=0; i<2*m; i++){
                int temp = Integer.parseInt(input.readLine());
                if(temp>0){
                    parkin(temp);
                }else{
                    temp = -1*temp;
                    parkout(temp);
                }
            }
            sb.append("#"+tc+" "+result+"\n");
        }
        System.out.println(sb);
    }
    static void parkin(int x){
        for(int i=0; i<parkinglot.length; i++){
            if(parkinglot[i]==0){
                parkinglot[i]=x;
                break;
            }
            if(i==parkinglot.length-1){
                waiting.add(x);
            }
        }
    }
    static void parkout(int x){
        for(int i=0; i<parkinglot.length; i++){
            if(parkinglot[i]==x){
                parkinglot[i]=0;
                result = result+weight[x-1]*bill[i];
            }
        }
        if(waiting.size()>=1){
            parkin(waiting.get(0));
            waiting.remove(0);
        }
    }
}
