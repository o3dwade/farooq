import java.util.*;


public class PradeepN{
	
	public static void main (String [] args){
		ArrayList<Integer> n = new ArrayList<Integer>();
		n.add(3);n.add(4);n.add(5);n.add(9);n.add(2);n.add(1);n.add(3);
		System.out.println(rem(n));
	}

	public static ArrayList<Integer> rem (ArrayList<Integer> n){
		ArrayList<Integer> r = new ArrayList<Integer>();
		int count = 0;
		for (int i =0; i < n.size(); i++){
			count = 0;
			for(int j =i+1; j<n.size();j++){
				if (n.get(i)<n.get(j))
					count++;
			}
			r.add(count);
		}
		return r;
	}


	public static int binarySearch(ArrayList<Integer> n, int l, int r, int v){
		int mid = (l+r)/2;

		if (r<l || r<0 || l<0)
			return -1;
		if (n.get(mid) == v)
			return mid;
		else if(n.get(mid)>v)
			return binarySearch(n,0,mid,v);
		else if(n.get(mid)<v)
			return binarySearch(n,mid+1,r, v);
		else
			return -1;

	}




}
