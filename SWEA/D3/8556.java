import java.util.Scanner;

public class Solution {
    public static void main(String[] argc){
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int tc=1; tc<=T; tc++){
            String tmp = sc.next();
            char[] words = tmp.toCharArray();
            int[] dir = new int[20];
            int[] result = new int[2];
            int x = 0;
            for(int i=words.length-1; i>=0;i--){
                if(words[i]=='n'){
                    dir[x]=-1;
                    x++;
                } else if(words[i]=='w'){
                    dir[x]=1;
                    x++;
                }
            }
            x=1;
            if(dir[0]==-1){
                result[0]=0;
            }else {
                result[0] = 90;
            }
            result[1]=1;
            while(dir[x]!=0){
                result[0] = ((result[0]*(int)Math.pow(2,x))/result[1])+(dir[x]*90);
                result[1] = (int)Math.pow(2,x);
                //System.out.println(x+" "+result[0]+" "+result[1]+" "+Math.pow(2,x));
                while(result[0]%2==0&&result[1]%2==0){
                    result[0] = result[0]/2;
                    result[1] = result[1]/2;
                }
                //System.out.println(x+" "+result[0]+" "+result[1]+" "+Math.pow(2,x));
                x++;
            }
            if(result[0]<0){
                result[0]=result[0]*(-1);
            }
            if(result[1]==1){
                sb.append("#"+tc+" "+result[0]+"\n");
            }else{
                sb.append("#"+tc+" "+result[0]+"/"+result[1]+"\n");
            }
        }
        System.out.println(sb);
    }
}
//  36개중 30개 통과