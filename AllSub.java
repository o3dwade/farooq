import java.util.*;


public class AllSub{
    static int count=0;
    static String str="";
    public static void main(String [] args){

        int [] num = {1, 2, 3};
        int n= num.length;
        sub(num,n);
        System.out.println(str);

    }




    public static int [] sub(int [] vals, int n){

        if (n<0)
            return null;
        if (n==0){
            int [] tmp = new int[n+1];
            tmp[n]=vals[n];
            count++;
            return tmp;
        }
        else{
            int [] tmp = new int[n];
            for(int k=0;k<n; k++)
                tmp[k]=vals[k];
            str+=Arrays.toString(tmp);
            return sub(vals, n-1);


        }
        //sub(vals-1)


    }

















}
