package cramgame;

import java.util.HashSet;
import java.util.Set;

public class cram {
	
	public static  int calculateGrundy (int n)
	{
		//stop condition 
		if (n==0|| n==1) return 0;
		
		//A set to calculate the mex of grundy numbers .
		Set<Integer> Set = new HashSet<Integer>();  
		
			for (int i=0 ; i<n/2 ;i++)
				//the first player choose a square.
				Set.add((calculateGrundy (n-i-2))^(calculateGrundy (i)));

		//return the mex of grundy numbers.
		return (calculateMex(Set));
		}
	
	public static int calculateMex(Set<Integer> Set)
	{
	    int Mex = 0;
	    while (Set.contains(Mex))
	        Mex++;
	    return Mex;
	}
	   
 public static void main(String[] args)
 {
	 System.out.println(calculateGrundy(6));
 }
}

