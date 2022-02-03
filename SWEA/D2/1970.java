import java.util.Scanner;

public class Solution {
    static int[] r = new int[8];
    static int money;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc<=T; tc++){
            money = sc.nextInt();
            r[0] = makechange(50000);
            r[1] = makechange(10000);
            r[2] = makechange(5000);
            r[3] = makechange(1000);
            r[4] = makechange(500);
            r[5] = makechange(100);
            r[6] = makechange(50);
            r[7] = makechange(10);
            sb.append("#"+tc+"\n"+r[0]+" "+r[1]+" "+r[2]+" "+r[3]+" "+r[4]+" "+r[5]+" "+r[6]+" "+r[7]+"\n");
        }
        System.out.print(sb);
    }
    static int makechange(int change){
        int temp = money;
        money = money%change;
        return temp/change;
    }
}
