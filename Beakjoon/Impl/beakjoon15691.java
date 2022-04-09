//https://www.acmicpc.net/problem/15691
//Solved : 22/04/05

import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int rst = 0;
        for(int i=0; i<N; i++) arr[i] = Integer.parseInt(br.readLine());

        /*  완전탐색 시간 초과
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<N; i++){
            set.clear();
            set.add(C);
            for(int j=0; j<K; j++){
                int ni = i+j;
                if(ni>=N) ni-=N;
                set.add(arr[ni]);
            }
            rst = rst > set.size() ? rst : set.size();
        }
        */
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<K; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }
        if(map.containsKey(C)){
            map.put(C, map.get(C)+1);
        }else{
            map.put(C, 1);
        }
        rst = map.size();
        for(int i=0; i<N-1; i++){
            if(map.get(arr[i])>1){
                map.put(arr[i], map.get(arr[i])-1);
            }else{
                map.remove(arr[i]);
            }
            int ni = i+K;
            if(ni>=N) ni-=N;
            if(map.containsKey(arr[ni])){
                map.put(arr[ni], map.get(arr[ni])+1);
            }else{
                map.put(arr[ni], 1);
            }
            rst = rst > map.size() ? rst : map.size();
        }
        bw.write(Integer.toString(rst));
        bw.close();
        br.close();
    }
}