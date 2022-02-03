import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int tc = 1; tc<=T; tc++) {
            int[] x = new int[7];
            for(int i=0; i<7; i++) {
                x[i]=sc.nextInt();
            }
            Arrays.sort(x);
            int[] sums = new int[35];
            int nums = 0;
            for(int i = 6; i>1; i--) {
                for(int j=i-1; j>0; j--) {
                    for(int k=j-1; k>=0; k--) {
                        sums[nums] = x[i] + x[j] + x[k];
                        nums++;
                    }
                }
            }
            Arrays.sort(sums);
            int cnt = 0;
            int result=0;
            for(int i=nums-1; i>=0; i--) {
                if(sums[i]==sums[i-1]) {
                    continue;
                }
                else {
                    cnt++;
                    if(cnt==5) {
                        result = sums[i];
                        break;
                    }
                }
            }
            System.out.println("#"+tc+" "+result);
        }
    }
}