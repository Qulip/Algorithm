import java.util.Scanner;

public class Solution {
    public  static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int tc=1; tc<=T; tc++)
        {
            int x = sc.nextInt();
            int[] Hays = new int[x];
            int sum = 0;
            int result = 0;
            for(int i=0; i<x; i++)
            {
                Hays[i] = sc.nextInt();
                sum = sum+Hays[i];
            }
            sum = sum/x;
            for(int i=0; i<x;i++)
            {
                if(Hays[i]>sum)
                {
                    result = result+Hays[i]-sum;
                }
            }
            System.out.println("#"+tc+" "+result);
        }
    }
}
