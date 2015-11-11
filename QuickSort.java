import java.util.*;

public class QuickSort{
	public static int [] a = {2,1,4,9,5,3};
	public static void main(String [] args){
		sort(0, a.length-1);
		for(int i =0; i < a.length; i++)
			System.out.println(a[i]); 	
	
	}
	public static void sort(int l, int h){
		if (l<h){
			int p = quickSort(l, h);
			sort(l, p-1);
			sort(p+1, h);
		}

	}
	public static int quickSort(int l, int h){
		int i = l-1;
		int piv = a[h];
		for (int j = 1; j<= h-1; j++){
			if (a[j] <= piv){
				i++;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		int temp2 = a[i+1];
		a[i+1] = a[h];
		a[h] = a[i+1];
		return (i+1);
	}
}
