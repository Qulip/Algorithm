package swea4789;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        char[] people;
        for(int tc = 1; tc <= T; tc++){
            people = br.readLine().toCharArray();
            int num = 0;
            int rst = 0;
            for(int i=0; i<people.length; i++){
                if(people[i]-'0'>0){
                    num = num+people[i]-'0';
                }else{
                    if(num<i+1){
                        System.out.println(i);
                        rst++;
                        num++;
                    }
                }
                //System.out.println(num);
            }
            sb.append("#"+tc+" "+rst+"\n");
            System.out.println();
        }
        System.out.print(sb);
    }
}
