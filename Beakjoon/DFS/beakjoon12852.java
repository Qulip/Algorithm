//https://www.acmicpc.net/problem/12852
//solved : 22/12/15

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {

    static class Result {
        int count;
        List<Integer> results;

        public Result() {
            count = 0;
            results = new ArrayList<>();
        }

        public Result(Result result) {
            this.count = result.count;
            this.results = new ArrayList<>(result.results);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(count).append("\n");
            for (Integer result : results) {
                sb.append(result).append(" ");
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Result recur = recur(N, new Result());
        System.out.println(recur);
    }

    static Result recur(int N, Result result) {
        // N이 2 미만인 경우 누적된 count값을 반환
        if (N < 2) {
            result.results.add(1);
            return result;
        }
        Result tmp2 = new Result(result);
        Result tmp3 = new Result(result);
        tmp2.count = tmp2.count + 1 + (N % 2);
        tmp3.count = tmp3.count + 1 + (N % 3);
        for (int i=0; i<=(N%2); i++) {
            tmp2.results.add(N-i);
        }
        for (int i=0; i<=(N%3); i++) {
            tmp3.results.add(N-i);
        }
        Result div2 = recur(N / 2, tmp2);
        Result div3 = recur(N / 3, tmp3);
        return div2.count > div3.count ? div3 : div2;

    }
}