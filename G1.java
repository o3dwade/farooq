public class G1{


	public static void main(String [] args){
		String [] arr = {"bana", "apple", "banaba", "bonanza", "banamf"};
		String s  = "banana";
		System.out.println(NumOff(arr,s));
	}

	public static boolean NumOff(String [] arr, String s){
		boolean output= false;
		
		for (String word: arr){
			for(int i=0; i < word.length(); i++){
				//if ( i>s.length()-1)
				//	return false;
				//int v1= (int)word.charAt(i);
				//int v2=v1;
				//v1++;
				//v2--;
				//int snum=(int)(s.charAt(i));
				//if (snum==v1 || snum==v2)
				//	output=true;
				StringBuilder s1=new StringBuilder(s);
				s1.delete(i, i+1);
				StringBuilder w1=new StringBuilder(word);
				w1.delete(i, i+1);
				if (s1.toString().equals(w1.toString()))
					output=true;
			}
		}	
		return output;
	}
}
