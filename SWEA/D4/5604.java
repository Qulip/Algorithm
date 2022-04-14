import java.io.*;
import java.util.*;

class Solution{
    static HashMap<Long, Long> f;
    static long start, end, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        f = new HashMap<Long, Long>();

        long sum = 0;
        for(long i=0; i<10; i++) {
            sum += i;
            f.put(i, sum);
        }

        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            start = Long.parseLong(st.nextToken());
            end = Long.parseLong(st.nextToken());

            if(start > 0)
                ans = F(end) - F(start-1);
            else
                ans = F(end) - F(start);

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static long F(long i) {
        if(f.containsKey(i)) return f.get(i);
        if(i<10) return f.get(i);

        long v = V(i);
        long F = F(i-1-i%v);
        long G = (i/v)*(i%v+1)+ F(i%v);
        long num = F+G;

        f.put(i, num);

        return num;
    }

    static long V(long i) {
        long v = 1;
        while(i>=10) {
            v = v*10;
            i = i/10;
        }
        return v;
    }
}