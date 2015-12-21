import java.util.*;


public class RepTwice{
	public static void main(String [] args){
		String str = "aaabc";
		System.out.println(repTwice(str));
	}


	public static String repTwice(String s){
		String str=s;
		StringBuilder sb = new StringBuilder(s);
		for (int i =0; i <s.length(); i++){
			for (int j = 0; j<s.length(); j++){
				if (i!=j && s.charAt(i)==(s.charAt(j)))
					sb.delete();		
		
			}

		}
		return sb.toString();
	}




}
