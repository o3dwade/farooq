import java.util.*;

public class InsertionSort{
	
	public static void main (String [] args){
		int [] a = {3,2,4,88,2,5,2,17};
		for (int i=0; i<a.length; i++)
			System.out.print(a[i]+",");
		System.out.println();
		insertionSort(a);
	}
	public static void insertionSort(int [] a){
	int k;
	int j;
	for (int i =1; i < a.length; i ++){
		k = a[i];
		j = i-1;
		while (j>=0 && k<a[j]){
			a[j+1] = a[j];
			j--;
		}
		a[j+1] = k;
	}
	for (int i = 0 ; i <a.length; i++){
		System.out.print(a[i]+",");
	}
	System.out.println();


	}







}
