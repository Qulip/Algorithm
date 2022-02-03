import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T =  sc.nextInt();
        for(int tc = 1; tc<=T; tc++)
        {
            String a = sc.next();
            char[] Letters = a.toCharArray();
            ArrayList<Character> last = new ArrayList<>();
            Arrays.sort(Letters);
            for(int x=0; x<Letters.length; x++)
            {
                if(x== Letters.length-1){
                    last.add(Letters[x]);
                    break;
                }
                if(Letters[x]==Letters[x+1])
                {
                    x++;
                }
                else
                {
                    last.add(Letters[x]);
                }
            }
            System.out.print("#"+tc+" ");
            if(last.size()==0)
            {
                System.out.println("Good");
            }
            else {
                for (int i = 0; i < last.size(); i++) {
                    System.out.print(last.get(i));
                }
                System.out.println();
            }
            last.clear();
        }
    }
}
