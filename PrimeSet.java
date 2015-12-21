import java.util.*;

public class PrimeSet{
	public static void main(String [] args){
		int [] a = {2, 3, 4};
		int r =2;
		allSub(a, 0, a.length-1 , r-1);	
	}

	public static void allSub(int [] a, int s, int n, int r){
			
		if (n-s == r){
			for (int i =s; i < n; i++){
				System.out.print(a[i]);
			System.out.println();
			}
		}
				
		else{
			allSub(a,s, n--, r); 
			allSub(a,s++, n, r); 


		}



	}

/*
	if i == n
		for (int i =0; i < n; i++)
			sop a[i]
	else
	   i--  
	
*/

}
