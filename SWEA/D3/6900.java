import java.util.Scanner;

public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=T; tc++) {
            int win_num = sc.nextInt();
            int lot_num = sc.nextInt();
            char[][] win_code = new char[win_num][];
            int[] win_bill = new int[win_num];
            char[][] lot_code = new char[lot_num][];
            int result = 0;
            for (int i = 0; i < win_num; i++) {
                String temp = sc.next();
                win_code[i] = temp.toCharArray();
                win_bill[i] = sc.nextInt();
            }
            for (int i = 0; i < lot_num; i++) {
                String temp = sc.next();
                lot_code[i] = temp.toCharArray();
            }
            for(int i=0; i<win_num; i++){
                for(int j=0; j<lot_num; j++){
                    boolean check = true;
                    for(int k=0; k<8; k++){
                        if(win_code[i][k]=='*'){
                            continue;
                        }
                        if(win_code[i][k]!=lot_code[j][k]){
                            check = false;
                        }
                    }
                    if(check){
                        result = result+win_bill[i];
                    }
                }
            }
            sb.append("#"+tc+" "+result+"\n");
        }
        System.out.println(sb);
    }
}
