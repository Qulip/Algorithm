import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=T; tc++){
            int x = sc.nextInt();
            int[][] triangle= new int[x][];
            for(int i=0; i<x; i++){
                triangle[i] = new int[i+1];
                if(i==0){
                    triangle[0][0]=1;
                } else{
                    triangle[i][0]=1;
                    triangle[i][i]=1;
                }
            }
            if(x>2){
                for(int i=2; i<x;i++){
                    for(int j=1; j<i; j++){
                        triangle[i][j]= triangle[i-1][j-1]+triangle[i-1][j];
                    }
                }
            }
            sb.append("#"+tc+"\n");
            for(int i=0; i<triangle.length; i++){
                for(int j =0; j<triangle[i].length; j++){
                    sb.append(triangle[i][j]+" ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}