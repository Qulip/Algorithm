public class Solution {
    public  static void main(String[] argc)
    {
        StringBuilder sb = new StringBuilder("2 ");
        for(int i=1; i<500000; i++)
        {
            boolean decimal = true;
            for(int j=3; j<= Math.sqrt(i*2+1); j++)
            {
                if((i*2+1)%j==0)
                {
                    decimal=false;
                    break;
                }
            }
            if(decimal)
            {
                sb.append(i*2+1);
                sb.append(" ");
            }
        }
        System.out.print(sb);
    }
}
