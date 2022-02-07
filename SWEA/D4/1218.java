package swea.d4_1218;
//Solved : 22/02/07

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        for(int T = 1; T<=10; T++){
            sb.append("#").append(T).append(" ");
            int n = Integer.parseInt(br.readLine());
            int[] chk = new int[4];
            char[] arr = br.readLine().toCharArray();
            for(int i =0; i<arr.length; i++){
                if(arr[i]=='['){
                    chk[0]++;
                }else if(arr[i]=='{'){
                    chk[1]++;
                }else if(arr[i]=='('){
                    chk[2]++;
                }else if(arr[i]=='<'){
                    chk[3]++;
                }else if(arr[i]==']'){
                    chk[0]--;
                }else if(arr[i]=='}'){
                    chk[1]--;
                }else if(arr[i]==')'){
                    chk[2]--;
                }else{
                    chk[3]--;
                }
                if(chk[0]<0||chk[1]<0||chk[2]<0){
                    break;
                }
                //System.out.println(Arrays.toString(chk));
            }
            if(chk[0]!=0||chk[1]!=0||chk[2]!=0||chk[3]!=0){
                sb.append("0\n");
            }else{
                sb.append("1\n");
            }
            //System.out.println();
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
