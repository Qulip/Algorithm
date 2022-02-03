import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        int a,b;
        ArrayList<Integer> aList = new ArrayList<Integer>();
        ArrayList<Integer> bList = new ArrayList<Integer>();
        int[] Result = new int[T];
        int left;
        for(int test_case = 1; test_case<=T; test_case++)
        {
            a = sc.nextInt();
            b = sc.nextInt();
            Result[test_case-1] = 0;
            for(int i = 0; i<a; i++)
            {
                int x;
                x = sc.nextInt();
                aList.add(x);
            }
            for(int i = 0; i<b; i++)
            {
                int x;
                x = sc.nextInt();
                bList.add(x);
            }
            if(a<b)
            {
                for (int i = 0; i <= bList.size() - aList.size(); i++) {
                    left = 0;
                    for (int j = 0; j < aList.size(); j++) {
                        if (i == 0) {
                            Result[test_case - 1] = Result[test_case - 1] + aList.get(j) * bList.get(i + j);
                        } else {
                            left = left + aList.get(j) * bList.get(i + j);
                        }
                    }
                    if (Result[test_case - 1] < left) {
                        Result[test_case - 1] = left;
                    }
                }
            }
            else
            {
                for (int i = 0; i <= aList.size() - bList.size(); i++) {
                    left = 0;
                    for (int j = 0; j < bList.size(); j++) {
                        if (i == 0) {
                            Result[test_case - 1] = Result[test_case - 1] + bList.get(j) * aList.get(i + j);
                        } else {
                            left = left + bList.get(j) * aList.get(i + j);
                        }
                    }
                    if (Result[test_case - 1] < left) {
                        Result[test_case - 1] = left;
                    }
                }
            }
            aList.clear();
            bList.clear();
        }
        for(int test_case=1; test_case<=T; test_case++)
        {
            System.out.println("#"+test_case+" "+Result[test_case-1]);
        }
    }
}
