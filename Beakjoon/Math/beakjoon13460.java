//https://www.acmicpc.net/problem/13460
//Solved : 22/03/01

import java.math.BigInteger;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        BigInteger num = BigInteger.valueOf(1);
        for(int i=2; i<=N; i++){
            num = num.multiply(BigInteger.valueOf(i));
        }
        int rst=0;
        while(true){
            BigInteger aa = num.mod(BigInteger.TEN);
            if(!aa.equals(BigInteger.ZERO)) break;
            num = num.divide(BigInteger.TEN);
            rst++;
        }
        bw.write(Integer.toString(rst));
        bw.close();
        br.close();
    }
}