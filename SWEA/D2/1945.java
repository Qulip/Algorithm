package com.company;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int[] numbers = new int[T];
        for(int test_case = 1; test_case <= T; test_case++) {
            numbers[test_case-1] = sc.nextInt();
        }

        for(int test_case = 1; test_case <= T; test_case++) {
            int numleft,left;
            int[] result = {0,0,0,0,0};
            left = 0;
            numleft = numbers[test_case-1];
            while(true) {
                left = numleft%2;
                if(left == 0) {
                    numleft = numleft/2;
                    result[0]++;
                } else {
                    break;
                }
            }
            left = 0;
            numleft = numbers[test_case-1];
            while(true) {
                left = numleft%3;
                if(left == 0) {
                    numleft = numleft/3;
                    result[1]++;
                } else {
                    break;
                }
            }
            left = 0;
            numleft = numbers[test_case-1];
            while(true) {
                left = numleft%5;
                if(left == 0) {
                    numleft = numleft/5;
                    result[2]++;
                } else {
                    break;
                }
            }
            left = 0;
            numleft = numbers[test_case-1];
            while(true) {
                left = numleft%7;
                if(left == 0) {
                    numleft = numleft/7;
                    result[3]++;
                } else {
                    break;
                }
            }
            left = 0;
            numleft = numbers[test_case-1];
            while(true) {
                left = numleft%11;
                if(left == 0) {
                    numleft = numleft/11;
                    result[4]++;
                } else {
                    break;
                }
            }
            System.out.println("#"+test_case+" "+result[0]+" "+result[1]+" "+result[2]+" "+result[3]+" "+result[4]);
        }
    }
}
