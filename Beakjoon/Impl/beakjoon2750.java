package baek2750;
//https://www.acmicpc.net/problem/2750

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int tc = sc.nextInt();
        int[] nums = new int[tc];
        for(int i=0; i<tc; i++) {
            nums[i]=sc.nextInt();
        }
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            sb.append(nums[i]+"\n");
        }
        System.out.print(sb);
    }
}