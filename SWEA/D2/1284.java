import java.util.Scanner;

public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        int[][] Numbers = new int[T][5];
        for(int test_case=1; test_case<=T; test_case++)
        {
            for(int i=0; i<5;i++)
            {
                Numbers[test_case-1][i]= sc.nextInt();
            }
        }
        int a,b;
        for(int test_case=1; test_case<=T; test_case++)
        {
            a = Numbers[test_case-1][0]*Numbers[test_case-1][4];
            if(Numbers[test_case-1][2]>=Numbers[test_case-1][4])
            {
                b = Numbers[test_case-1][1];
            }
            else
            {
                b = Numbers[test_case-1][1]+Numbers[test_case-1][3]*(Numbers[test_case-1][4]-Numbers[test_case-1][2]);
            }
            if(a<=b)
            {
                System.out.println("#"+test_case+" "+a);
            }
            else
            {
                System.out.println("#"+test_case+" "+b);
            }
        }
    }
}
