import java.util.*;
import java.lang.*;
public class SquareSupplies{
	
	public static void main(String [] args){
		int c = Integer.parseInt(args[0]);
		//answer(c);
		//System.out.println((int)Math.sqrt(c));
		System.out.println(answer(c));
	}

	public static int answer(int c){
		int v = (int)Math.sqrt(c);
		if (v<=0)
			return 0;
		return 1+answer(c-(v*v));
	}
}
