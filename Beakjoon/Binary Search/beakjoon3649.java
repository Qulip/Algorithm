//https://www.acmicpc.net/problem/3649
//Solved :22/12/14

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str;
        int x, n;
        int[] arr;

        while ((str = br.readLine()) != null) {

            x = Integer.parseInt(str) * 10000000;
            n = Integer.parseInt(br.readLine());
            arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);

            int min = 0;
            int max = n - 1;
            boolean flag = false;

            while (min < max) {
                int sum = arr[min] + arr[max];
                if (sum == x) {
                    flag = true;
                    sb.append("yes ").append(arr[min]).append(" ").append(arr[max]).append("\n");
                    break;
                }
                if (sum < x) {
                    min++;
                } else {
                    max--;
                }
            }

            if (!flag) {
                sb.append("danger\n");
            }
            str = null;
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}