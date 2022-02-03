import java.util.Scanner;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        LinkedList<String> List = new LinkedList<>();

        for(int tc = 1; tc<=T; tc++) {
            int x = sc.nextInt();
            for (int i = 0; i < x; i++) {
                List.add(sc.next());
            }
            if(x%2==0){
                for(int i=0;i<x/2;i++){
                    String temp = List.get(x/2+i);
                    List.remove(x/2+i);
                    List.add((i*2)+1, temp);
                }
            }
            else{
                for(int i=0;i<x/2;i++){
                    String temp = List.get(x/2+i+1);
                    List.remove(x/2+i+1);
                    List.add((i*2)+1, temp);
                }
            }
            System.out.print("#"+tc+" ");
            for(int i=0; i<x; i++) {
                System.out.print(List.get(i)+" ");
            }
            System.out.println();
            List.clear();
        }
    }
}
