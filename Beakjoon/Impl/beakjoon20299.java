package beakjoon.d220214.q20299;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int rst = 0;	//총 가입 가능한 팀 수

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int x3 = Integer.parseInt(st.nextToken());
            if(x1+x2+x3>=S&&x1>=M&&x2>=M&&x3>=M) {		//총 합이 S이상이고 각각이 M보다 크다면
                rst++;									//결과값을 증가 시키고 스트링빌더에 값들 추가
                sb.append(x1).append(" ").append(x2).append(" ").append(x3).append(" ");
            }
        }
        bw.write(Integer.toString(rst));									//결과가 먼저나오므로 결과 먼저
        bw.write("\n");														//버퍼라이터에 쓰고, 줄바꿈문자쓴다
        bw.write(sb.toString());											//스트링빌더를 버퍼라이터에 쓰고 출력
        br.close();
        bw.close();
    }
}
