package jungol.d220215.q1828;
//http://www.jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1101&sca=99&sfl=wr_hit&stx=1828
//Solved :

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Ref> arrayList = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int low = Integer.parseInt(st.nextToken());
            int high = Integer.parseInt(st.nextToken());
            arrayList.add(new Ref(low, high));
        }
        Collections.sort(arrayList);
        int max = arrayList.get(0).high;
        int num = 1;
        for(int i=1; i<N; i++){
            if(max < arrayList.get(i).low){
                max = arrayList.get(i).high;
                num++;
            }
        }

        bw.write(Integer.toString(num));
        bw.close();
        br.close();
    }
}

class Ref implements Comparable<Ref>{
    int low;
    int high;

    Ref(int low, int high){
        this.low = low;
        this.high = high;
    }

    @Override
    public int compareTo(Ref o) {
        if(this.high != o.high) return this.high - o.high;
        else return o.low - this.low;
    }
}
