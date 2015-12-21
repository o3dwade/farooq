import java.util.*;
public class Value2{

	public static void main(String [] args){
		int [] xs={1,2,3,4,5};
		int [] xy={4,3,2,2,2,3,4,4,3,3,2,3,4};
		System.out.println(max2(xs));
	}


	public static int max2(int [] arr){
		int min=5000;
		int min2=30000;
		for (int i=0; i < arr.length; i ++){
			if(arr[i] < min){
				min2=min;
				min=arr[i];
			}
		}	
		for (int i=0; i <arr.length; i++){
			if(arr[i]<=min2 && arr[i] > min )
				min2=arr[i];

		}
		return min2;
	}
}

