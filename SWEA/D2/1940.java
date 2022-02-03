import java.util.Scanner;

public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        int[] Result = new int[T];
        for(int test_case=1; test_case<=T; test_case++)
        {
            int Times = sc.nextInt();
            int speed = 0;
            for(int i=1; i<=Times; i++)
            {
                int y;
                int x = sc.nextInt();
                if(x!=0)
                {
                    y = sc.nextInt();
                    if(x==1)
                    {
                        speed = speed+y;
                    }
                    else
                    {
                        speed = speed-y;
                        if(speed<0)
                        {
                            speed =0;
                        }
                    }
                }
                Result[test_case-1]=Result[test_case-1]+speed;
            }
        }
        for(int test_case=1; test_case<=T;test_case++)
        {
            System.out.println("#"+test_case+" "+Result[test_case-1]);
        }
    }
}
