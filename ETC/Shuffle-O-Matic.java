import java.io.*;
import java.util.*;

class Solution {
    static List<Integer> cards;
    static int N, best;
    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());
            cards = new ArrayList<>(N);
            best = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                cards.add(Integer.parseInt(st.nextToken()));
            }
            if(isSorted(cards)){
                best = 0;
            }else {
                recur(0, cards);
                if (best > 5) best = -1;
            }
            sb.append("#").append(tc).append(" ").append(best).append("\n");
        }
        System.out.print(sb);
    }
    static void recur(int time, List<Integer> list) {
        if(time == 1) return;

        int len = N/2;
        List<Integer> tmp = new ArrayList<>(list);

        for(int i=1; i<N; i++){
            System.out.println(list);
            int count = 0;
            int move = i > len ? len : i;

            for(int j= len; j<len + move; j++){
                int num = tmp.get(j);
                tmp.remove(j);
                int idx = j - i + count;
                if(idx < 0){
                    idx = count;
                }
                count++;
                tmp.add(idx, num);
            }
            System.out.println(time+" "+i+" "+tmp.toString());
            if(isSorted(tmp)){
                best = best < time+1 ? best : time+1;
                System.out.print("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT"+(time+1));
                return;
            }
            recur(time+1, tmp);
        }
    }
    static boolean isSorted(List<Integer> list){
        boolean asc = true, desc = true;
        for(int i=0; i<list.size(); i++){
            if(list.get(i) != i+1){
                asc = false;
                break;
            }
        }
        for(int i=0; i<list.size(); i++){
            if(list.get(i) != list.size()-i){
                desc = false;
                break;
            }
        }
        return asc||desc;
    }
}

/*
1
4
4 2 3 1

 */