package beak11653;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        if(num!=1){
            int div = 2;
            while(num>1){
                if(num%div==0){
                    num = num/div;
                    sb.append(div+"\n");
                }else{
                    div++;
                }
            }
        }
        System.out.println(sb);
    }
}
