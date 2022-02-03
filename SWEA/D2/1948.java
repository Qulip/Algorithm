import java.util.ArrayList;
import java.util.Scanner;
public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        int[] Result = new int[T];
        ArrayList<Integer> aDate = new ArrayList<Integer>();
        ArrayList<Integer> bDate = new ArrayList<Integer>();
        for(int test_case = 1; test_case<=T;test_case++)
        {
            Result[test_case-1] = 0;
            aDate.add(sc.nextInt());
            aDate.add(sc.nextInt());
            bDate.add(sc.nextInt());
            bDate.add(sc.nextInt());
            for(int i = aDate.get(0); i<bDate.get(0);i++)
            {
                switch (i) {
                    case 1:
                        Result[test_case-1]=Result[test_case-1]+31;
                        break;
                    case 2:
                        Result[test_case-1]=Result[test_case-1]+28;
                        break;
                    case 3:
                        Result[test_case-1]=Result[test_case-1]+31;
                        break;
                    case 4:
                        Result[test_case-1]=Result[test_case-1]+30;
                        break;
                    case 5:
                        Result[test_case-1]=Result[test_case-1]+31;
                        break;
                    case 6:
                        Result[test_case-1]=Result[test_case-1]+30;
                        break;
                    case 7:
                        Result[test_case-1]=Result[test_case-1]+31;
                        break;
                    case 8:
                        Result[test_case-1]=Result[test_case-1]+31;
                        break;
                    case 9:
                        Result[test_case-1]=Result[test_case-1]+30;
                        break;
                    case 10:
                        Result[test_case-1]=Result[test_case-1]+31;
                        break;
                    case 11:
                        Result[test_case-1]=Result[test_case-1]+30;
                        break;
                    case 12:
                        Result[test_case-1]=Result[test_case-1]+31;
                        break;
                }
            }
            Result[test_case-1] = Result[test_case-1]+(bDate.get(1)-aDate.get(1))+1;
            aDate.clear();
            bDate.clear();
        }
        for(int test_case = 1; test_case<=T;test_case++)
        {
            System.out.println("#"+test_case+" "+Result[test_case-1]);
        }
    }
}
