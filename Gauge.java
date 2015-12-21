import java.util.*;


public class Gauge{
	public static void main(String [] args){
		System.out.println(wk(9));
	
	}

	public static int wk(int n){
		if (n <=0)
			return 0;
		else{
			for (int i=n; i >0; i--){
				if(i*i<=n)
					return 1+wk(n-i*i);
			}


		}

		return -1;


	}





}
