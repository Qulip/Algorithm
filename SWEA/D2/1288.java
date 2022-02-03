import java.util.Scanner;

public class Solution {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int[] Numbers = new int[T];
        int[] Results = new int[10];

        for(int test_case = 1; test_case <= T; test_case++)
        {
            Numbers[test_case-1] = sc.nextInt();
        }

        int left, number, a, Time;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            number = Numbers[test_case-1];
            Time = 1;
            while(true)
            {
                while(true)
                {
                    left = number % 10;
                    number = number-left;
                    Results[left] = 1;
                    if (number == 0)
                    {
                        break;
                    }
                    number = number/10;
                }
                if(Results[0]==1 && Results[1]==1 && Results[2]==1 && Results[3]==1&&Results[4]==1&&Results[5]==1&&Results[6]==1&&Results[7]==1&&Results[8]==1&&Results[9]==1)
                {
                    number = Numbers[test_case-1]*Time;
                    break;
                }
                Time++;
                number = Numbers[test_case-1]*Time;
            }
            System.out.println("#" + test_case+" "+number);
            for(int i = 0; i<10;i++)
            {
                Results[i] = 0;
            }
        }
    }
}
