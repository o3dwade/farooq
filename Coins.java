import java.util.*;

public class Coins{
	static int [] x = {1,5,10,25};
	static int min=9000;
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


	public static int coins(int n){
		int k=0;
		if (n==0)
			return 0;
		if (n<0)
			return 9000;
		else{
			k++;
			for(int i=0; i<x.length;i++){
				min=Math.min(min,coins(n-x[i]));
			}
			return k+min;
		}
	}


	public static int min(int a,int b,int c, int d){
		int x = (a<b? a: b);
		int y = (x<c? x: c);
		int z = (y<d? y: d);
		return z;
	}

}
