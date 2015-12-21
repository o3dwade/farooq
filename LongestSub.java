import java.util.*;

public class LongestSub{
	public static int [] a = {1,2,3,4,3,4,5,6,7,26,5};
	public static int [] tmp = new int[a.length];
	public static void main(String [] args){
		for (int i =0; i < a.length; i++)
			tmp[i] =0;
		System.out.println(longS(0, a.length));
	}
	
	public static int longS(int idx, int n){
		int count =0;
		int max = 0;
		int refi=0;
		if (idx<(n-1)){
			for (int i =1; i < a.length; i++){
				if (a[i] == (a[i-1]+1)){
					count++;		
				}
				if (count> max){
					max = count;
					count = 0;
					refi= i;
				}
			}
		}
		System.out.println(refi-max+"-"+refi);
		return max;
	}
}
