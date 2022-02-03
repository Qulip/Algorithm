import java.util.Scanner;

public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=T; tc++){
            boolean[][] chk = new boolean[4][13];
            String text = sc.next();
            boolean error = true;
            int[] result = new int[4];
            for(int i=0; i<text.length(); i=i+3) {
                String tmp = text.substring(i);
                char pattern = tmp.charAt(0);
                tmp = text.substring(i+1,i+3);
                int num = Integer.parseInt(tmp);
                //System.out.println(pattern+" "+num);
                switch (pattern){
                    case 'S':
                        if(chk[0][num-1]){
                            error = false;
                            break;
                        }
                        chk[0][num-1]= true;
                        break;
                    case 'D':
                        if(chk[1][num-1]){
                            error = false;
                            break;
                        }
                        chk[1][num-1]= true;
                        break;
                    case 'H':
                        if(chk[2][num-1]){
                            error = false;
                            break;
                        }
                        chk[2][num-1]= true;
                        break;
                    case 'C':
                        if(chk[3][num-1]){
                            error = false;
                            break;
                        }
                        chk[3][num-1]= true;
                        break;
                }
            }
            if(!error){
                sb.append("#"+tc+" ERROR\n");
            }
            else{
                for(int i=0; i<4; i++){
                    for(int j=0; j<13; j++){
                        if(!chk[i][j]){
                            result[i]++;
                        }
                    }
                }
                sb.append("#"+tc+" "+result[0]+" "+result[1]+" "+result[2]+" "+result[3]+"\n");
            }
        }
        System.out.print(sb);
    }
}
