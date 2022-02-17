package beakjoon.d220214.q20361;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");	//입력을 공백으로 나누기 위하여
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i=0; i<K; i++) {										//매번 바뀔때마다 간식이 바뀌는 경우만 간식위치 변경
            st = new StringTokenizer(br.readLine());
            int change1 = Integer.parseInt(st.nextToken());
            int change2 = Integer.parseInt(st.nextToken());
            if(X == change1) {
                X = change2;
            }else if(X == change2) {
                X = change1;
            }
        }
        bw.write(Integer.toString(X));											//스트링빌더를 버퍼라이터에 쓰고 출력
        br.close();
        bw.close();
    }
}