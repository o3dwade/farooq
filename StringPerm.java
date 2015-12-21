import java.util.*;

public class StringPerm{

	public static void main(String [] args){

		String s = args[0];
		int n = s.length();
		char [] str = s.toCharArray();
		perm(str, 0, n-1, n);	
	}

	public static void  perm(char [] str, int i, int j,int n){
		if(i==j || j<=1 || i>n){
			for (int k=i; k<j ; k++)
				System.out.print(str[k]);
			System.out.println();		
			return;
		}
		perm(str, i+1, j,n);
		perm(str, i,j-1,n);
	}




}
