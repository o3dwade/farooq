import java.util.*;
public class RegexExample{
  public static void main (String[] args) {
    Scanner sc  = new Scanner(System.in);
    String str = "";
    String regex = "[a-z]+";
    System.out.println("\nPattern: "+regex+"\n");
    while (!str.equals("quit")) {
      System.out.println("next input please: ");
      str = sc.nextLine();
      System.out.println("\n\nstring: \""+str+"\"\nPattern: "   +regex+"\nmatches: "+str.matches(regex)+"\n");   
    }
  }
}