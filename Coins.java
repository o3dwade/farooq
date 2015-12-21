import java.util.*;

public class Coins{
	public static void main(String [] args){
		System.out.println(coins(37));
	}

	public static int coins(int n){
		if (n==0)
			return 0;
		if (n<0)
			return 9000;
		else
			return 1+ min ( coins(n-1), coins(n-5), coins(n-10),coins(n-25));

	}

	public static int min(int a,int b,int c, int d){
		int x = (a<b? a: b);
		int y = (x<c? x: c);
		int z = (y<d? y: d);
		return z;
	}

}
