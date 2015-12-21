import java.util.*;


public class What{
	public static void main(String [] args){
		System.out.println(num(3));
	}

	public static int num(int w){
		int n;
		if (w>0){
			n=w+1;
			return 0;
		}
		return num(n--);
	}

}
