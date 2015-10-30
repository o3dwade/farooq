import java.util.*;



public class DPSub{

	public static int [] retVal;
	public static int k=-1;
	public static void main(String [] args){

		int [] n = new int[10];
		DPSub(n, 1, 3);
		System.out.println(n[0]);


	}



	public static int [] DPSub(int [] num, int i, int j){
		int sum=0;
		retVal=new int [num.length] ;
		if (num.length==0)
			return retVal;
		for (int w =0; w < num.length; w++)
			sum+=num[w];
		if ( sum>i && sum <j){
		   for(int l=0; l<num.length; l++)
			retVal[k++]=num[l];	
		}
		else{
			num[num.length-1];
			return DPSub(num, i, j);
		}
		return retVal;
	}






}
