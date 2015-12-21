import java.util.*;



public class ArrR{

	public static ArrayList<ArrayList<Integer>> cpy;
	public static void main(String [] args){


		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> s1 = new ArrayList<Integer>();
		ArrayList<Integer> s2 = new ArrayList<Integer>();
		ArrayList<Integer> s3 = new ArrayList<Integer>();
		ArrayList<Integer> s4 = new ArrayList<Integer>();
		s1.add(2);		s1.add(6);
		arr.add(s1);
		s2.add(3);s2.add(5);
		arr.add(s2);
		s3.add(7);s3.add(21);
		arr.add(s3);
		s4.add(20);s4.add(21);
		arr.add(s4);
		cpy=arr;
		System.out.println(arrR(arr, arr.size()-1));		
	}


	public static ArrayList<ArrayList<Integer>> arrR(ArrayList<ArrayList<Integer>> arr, int n){
		if (n<0)
			return cpy;
		else{
		int num=0;
		int fV=arr.get(n).get(1);
		int sV=arr.get(n).get(0);
		for (int i =0; i < arr.size(); i++){
			int ffV=arr.get(i).get(1);
			int ssV=arr.get(i).get(0);
			if (fV==ffV && sV==ssV)
				num++;	
			else if (fV>= ffV && sV <= ssV)
				cpy.remove(arr.get(i));
		}
		return arrR(arr,n-1);
		}
	}




}
