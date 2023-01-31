//https://softeer.ai/practice/info.do?idx=1&eid=1309
//solved : 23/01/31

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("./res/input.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] totalScore = new int[n];

        for (int tc = 0; tc < 3; tc++) {
            int[] score = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                score[i] = Integer.parseInt(st.nextToken());
                totalScore[i] += score[i];
            }
            sb.append(toRankString(score));
        }

        sb.append(toRankString(totalScore));

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    public static String toRankString(int[] score) {
        StringBuilder sb = new StringBuilder();
        Integer[] sort = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(sort, Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<sort.length; i++) {
            if(!map.containsKey(sort[i])) {
                map.put(sort[i], i+1);
            }
        }

        for (int i : score) {
            sb.append(map.get(i)).append(" ");
        }
        return sb.append("\n").toString();
    }
}