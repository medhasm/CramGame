package cramgame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class cram {
	
	static	ArrayList<Integer> A =new ArrayList<Integer>();
	static	ArrayList<Integer> B =new ArrayList<Integer>();
	static	ArrayList<Integer> C =new ArrayList<Integer>();
	static	ArrayList<Integer> D =new ArrayList<Integer>();

	public static int calculate(int n) {
	if (n==0|| n==1) return 0;
		A.add(0);	A.add(0);	
		B.add(0);   B.add(1);
		C.add(0);	C.add(1);
		D.add(0);	D.add(1);
		

		for(int i=2;i <= n;i++) {
			calculateA(i);
			calculateB(i);
			calculateC(i);
			calculateD(i);
		}
	
		return A.get(n);
		
		
	}
	public static void calculateA(int i) {
		Set<Integer> Set = new HashSet<Integer>();  
		int k=i-2;
		for(int j=0 ;j<=i-2;j++)
		{
			Set.add(A.get(j)^B.get(k));//L
			k--;
		}
		A.add(calculateMex(Set));
//		System.out.println("A--->" +calculateMex(Set));
	}
	public static void calculateB(int i) {
		Set<Integer> Set = new HashSet<Integer>();
		Set.add(A.get(i-1));
		int k=i-2;
		for(int j=0 ;j<=i-2;j++)
		{
			Set.add(B.get(j)^B.get(k)); //rotate L 90
			Set.add(A.get(j)^C.get(k)); //  rotate L 280 left 
			Set.add(A.get(j)^D.get(k)); // L
		}
		B.add(calculateMex(Set));
//		System.out.println("B--->" +calculateMex(Set));

		
	}
	public static void calculateC(int i) {
		Set<Integer> Set = new HashSet<Integer>();
		Set.add(B.get(i-1));
		int k=i-2;
		for(int j=0 ;j<=i-2;j++)
		{
			Set.add(B.get(j)^D.get(k));
			//k--;
		}
		C.add(calculateMex(Set));
//		System.out.println("C--->" +calculateMex(Set));

	}
	public static void calculateD(int i) {
		Set<Integer> Set = new HashSet<Integer>();
		Set.add(B.get(i-1));
		int k=i-2;
		for(int j=0 ;j<=i-2;j++)
		{
			Set.add(B.get(j)^C.get(k));
			Set.add(D.get(j)^B.get(k));
			//k--;
		}
		D.add(calculateMex(Set));
//		System.out.println("D--->" +calculateMex(Set));

	}
	public static void print(ArrayList<Integer> set) {
		for(int i=0 ;i< set.size();i++)
			System.out.print(set.get(i));
		System.out.println('\n');
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
	 //
	 //System.out.println(calculate(50));
	 //print(A);
	 //print(B);
	 //print(C);
	// print(D);
 }
}