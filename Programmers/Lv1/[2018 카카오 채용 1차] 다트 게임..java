package programmers.q17682;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

        System.out.println("tc");
        System.out.println(solution("1S2D*3T"));
        System.out.println(solution("1D2S#10S"));
        System.out.println(solution("1D2S0T"));
        System.out.println(solution("1S*2T*3S"));
        System.out.println(solution("1D#2S*3S"));
        System.out.println(solution("1T2D3D#"));
        System.out.println(solution("1D2S3T*"));
        System.out.println("추가 tc");
        System.out.println(solution("1D10S*1S"));
    }

    public static int solution(String dartResult) {
        int ans = 0;
        List<Character> list = new ArrayList<>();
        for (char i : dartResult.toCharArray()) {
            list.add(i);
        }
        int last_time = 0;
        for (int i = 0; i < 3; i++) {
            int len = 2;
            int grade = list.get(0) - '0';
            int tmp = 0;

            if(list.get(1)=='0'){
                len++;
                tmp++;
                grade*=10;
            }
            if (len < list.size()) {
                if (list.get(len) < '0' || list.get(len) > '9') {
                    len++;
                }
            }
            //System.out.println(grade + " " + list.get(0) + " " + len);
            if (list.get(1+tmp) == 'D') {
                grade *= grade;
            } else if (list.get(1+tmp) == 'T') {
                grade *= grade * grade;
            }
            if (len - tmp == 3) {
                if (list.get(2+tmp) == '*') {
                    grade *= 2;
                    ans += last_time;
                } else if(list.get(2+tmp)=='#'){
                    grade *= -1;
                }
            }
            ans += grade;
            last_time = grade;
            for (int j = 0; j < len; j++) {
                list.remove(0);
            }
            //System.out.println(ans+" "+grade+" "+list.size());
        }
        return ans;
    }
}
