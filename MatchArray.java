import java.util.*;
//

public class MatchArray{
	
	private static int max=0;
	public static void main(String [] args){
	
		String [] arr = {"ABCW","BAZ","FOO","BAR","XTFN","ABCDEF"};
		matchArray(0,arr.length-1, arr);
		System.out.println(max);
	}


	public static int matchArray(int i, int j, String [] arr){

		//base
		if (i>arr.length || j<0)
			return max;
		boolean same=false;
		char [] arrI = arr[i].toCharArray();
		char [] arrJ = arr[j].toCharArray();			
		for(Object l1: arrI){
			for(Object l2: arrJ){
				if(l1.equals(l2))
					same=true;
			}
		}
		if(same==false){
			if(arr[i].length()*arr[j].length()>max)
				max=arr[i].length()*arr[j].length();
		}
		return matchArray(i+1, j-1, arr);	
	}




}

