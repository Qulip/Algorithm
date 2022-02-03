package beak10773;
//https://www.acmicpc.net/problem/10773

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int rst=0;
        Stack<Integer> nums = new Stack<>();
        for(int i=0; i<k; i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp==0){
                nums.pop();
            }else{
                nums.push(temp);
            }
        }
        while(!nums.isEmpty()){
            rst = rst+nums.pop();
        }
        System.out.println(rst);
    }
}
