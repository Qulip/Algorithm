import java.math.BigDecimal;
import java.util.Scanner;

public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc<=T; tc++){
            String x = sc.next();
            String y = sc.next();
            BigDecimal bigx = new BigDecimal(x);
            BigDecimal bigy = new BigDecimal(y);
            sb.append("#"+tc+" "+bigx.add(bigy)+"\n");
        }
        System.out.print(sb);
    }
}
