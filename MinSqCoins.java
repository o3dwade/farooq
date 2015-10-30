public class MinSqCoins{
        public static int counts=0;
        public static void main(String [] args){
        
            System.out.println(coins(24,24));
        }

            
        public static int coins(int n, int i){
            int num=i*i;
            if (n==0 )
                return 0;
            if (n<0 || i<0)
                return -1;
            if (num<n)
                return coins(n-num, i-1);
            if (num>n)
                return coins(n, i-1);
            return max(coins(n, i-1), coins(n,i));
        }


        public static int max(int a, int b){
            return (a>b? a: b);
        }






}
