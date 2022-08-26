//https://www.acmicpc.net/problem/1253
//Solved : 22/07//13

import java.io.*;
import java.util.*;

class Main {
    static int[] arr;
    static int N, rst = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            binarySearch(i);

        }

        bw.write(Integer.toString(rst));
        bw.close();
        br.close();
    }

    static void binarySearch(int idx) {
        int min = 0;
        int max = N - 1;

        while (min < max) {
            if (min == idx)
                min++;
            else if (max == idx)
                max--;

            else {
                int sum = arr[max] + arr[min];
                if (sum < arr[idx])
                    min++;
                else if (sum == arr[idx]) {
                    rst++;
                    return;
                } else
                    max--;
            }
        }
    }
}
