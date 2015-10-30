public class SaveBetaRabit{
    public static int [][] myGrid;

	public static void main(String [] args){
		System.out.println("Hello");
		int [][] arr = {{0,2,3},{3,4,5},{6,3,1}};
		answer(4,arr);
		work(2,2,2);


	}   
 
    public static int work(int n, int locr, int locc ){
        if (locr == myGrid[0].length && locc == myGrid.length) 
		return -1;
	else
		return 0;        
        
    }
    
    public static int answer(int food, int[][] grid) { 
        myGrid=grid;
        // Your code goes here.
	return 4;
    } 	
}
