import java.util.*;


public class Compress{

        public static void main(String [] args){
            String s = args[0];
            String str = "";
            char [] msg = s.toCharArray();
            for (int i=0; i<s.length(); i++){
                int count =1;
                int j =i+1;
                while (j<s.length() && msg[i] == msg[j]){
                    count++;
                    i++;
                    j++;
                }
                if (count!=1)
                    str = str+ msg[i]+""+count;
                else
                     str = str+ msg[i];
            }
            System.out.println(str);

        }

}
