import java.util.Scanner;

public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int tc=1; tc<=T;tc++)
        {
            int x=sc.nextInt();
            int y=sc.nextInt();
            if(x%y==0) {
                System.out.println("#" + tc + " 0");
            }
            else
            {
                System.out.println("#" + tc + " 1");
            }
        }
    }
}
