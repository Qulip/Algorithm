
import java.util.Scanner;

public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int[][] Results = new int[T][2];
        for(int test_case = 1; test_case<=T;test_case++)
        {
            int Size = sc.nextInt();
            for(int i = 0; i<Size;i++)
            {
                int x = sc.nextInt();
                if(x<0)
                {
                    x = x*(-1);
                }
                if(i==0)
                {
                    Results[test_case-1][0] = x;
                    Results[test_case-1][1] = 1;
                }
                else
                {
                    if(Results[test_case-1][0]>x)
                    {
                        Results[test_case-1][0] = x;
                        Results[test_case-1][1] = 1;
                    }
                    else if(Results[test_case-1][0] == x)
                    {
                        Results[test_case-1][1]++;
                    }
                }
            }
        }
        for(int test_case = 1; test_case<=T;test_case++)
        {
            System.out.println("#"+test_case+" "+Results[test_case-1][0]+" "+Results[test_case-1][1]);
        }
    }
}

