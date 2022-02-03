import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int n,k,m,f,h;
        int[] grade;
        for(int tc=1; tc<=T; tc++) {
            n = sc.nextInt();
            k = sc.nextInt();
            grade = new int[n];
            for(int i=0; i<n; i++){
                m = sc.nextInt();
                f = sc.nextInt();
                h = sc.nextInt();
                grade[i] = m*35+f*45+h*20;
            }
            int checkgrade = grade[k-1];
            //System.out.print(checkgrade+" ");
            Arrays.sort(grade);
            for(int i=0; i<grade.length; i++){
                if(grade[i]==checkgrade){
                    checkgrade = i+1;
                    break;
                }
            }
            //System.out.println(checkgrade);
            checkgrade = ((n-checkgrade+1)*100)/n;
            checkgrade = (checkgrade-1)/10;
            switch (checkgrade){
                case 0:
                    sb.append("#"+tc+" A+\n");
                    break;
                case 1:
                    sb.append("#"+tc+" A0\n");
                    break;
                case 2:
                    sb.append("#"+tc+" A-\n");
                    break;
                case 3:
                    sb.append("#"+tc+" B+\n");
                    break;
                case 4:
                    sb.append("#"+tc+" B0\n");
                    break;
                case 5:
                    sb.append("#"+tc+" B-\n");
                    break;
                case 6:
                    sb.append("#"+tc+" C+\n");
                    break;
                case 7:
                    sb.append("#"+tc+" C0\n");
                    break;
                case 8:
                    sb.append("#"+tc+" C-\n");
                    break;
                default:
                    sb.append("#"+tc+" D0\n");
                    break;
            }
            //System.out.println(checkgrade);
        }
        System.out.print(sb);
    }
}
