import java.util.Scanner;
 
public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
 
        for(int tc=1; tc<=T; tc++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int temp=0;
            int[] xPoint = new int[2];
            int[] yPoint = new int[2];
            for(int i=1; i<317; i++) {
                temp = temp + i;
                if (temp >= x) {
                    xPoint[1] = temp-x+1;
                    xPoint[0] = i-(temp-x);
                    break;
                }
                if (temp >= y) {
                    yPoint[1] = temp-y+1;
                    yPoint[0] = i-(temp-y);
                }
            }
            temp = 0;
            for(int i=1; i<317; i++) {
                temp = temp + i;
                if (temp >= y) {
                    yPoint[1] = temp-y+1;
                    yPoint[0] = i-(temp-y);
                    break;
                }
            }
            xPoint[0]=xPoint[0]+yPoint[0];
            xPoint[1]=xPoint[1]+yPoint[1];
            temp = ((xPoint[0]+xPoint[1]-1)*(xPoint[0]+xPoint[1]))/2-xPoint[1]+1;
            System.out.println("#"+tc+" "+temp);
        }
    }
}