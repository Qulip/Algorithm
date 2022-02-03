import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] snacks = new int[n];
            for(int i=0; i<n; i++) {
                snacks[i] = sc.nextInt();
            }
            Arrays.sort(snacks);
            int result = -1;
            for(int i=n-1; i>0; i--) {
                int time=1;
                while(true) {
                    int temp = snacks[i]+snacks[i-time];
                    if(temp<=m) {
                        if(temp>result) {
                            result = temp;
                        }
                        break;
                    }
                    time++;
                    if(i-time<0) {
                        break;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#"+tc+" "+result);
            System.out.println(sb);
        }
    }
}
