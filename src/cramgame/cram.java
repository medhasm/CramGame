package cramgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class cram {
	
	static	ArrayList<Integer> A =new ArrayList<Integer>();
	static	ArrayList<Integer> B =new ArrayList<Integer>();
	static	ArrayList<Integer> C =new ArrayList<Integer>();
	static	ArrayList<Integer> D =new ArrayList<Integer>();
	static Map map=new HashMap<Character,Map<Integer,Map<Integer,ArrayList<Integer>>>>();
	static Map mapA=new HashMap<Integer,ArrayList<Integer>>();
	static Map mapB=new HashMap<Integer,ArrayList<Integer>>();
	static Map mapC=new HashMap<Integer,ArrayList<Integer>>();
	static Map mapD=new HashMap<Integer,ArrayList<Integer>>();
	

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
		ArrayList<Integer> arr;
		Map<Integer,Map<Integer,ArrayList<Integer>>> mp=
				new HashMap<Integer,Map<Integer,ArrayList<Integer>>>();
		for(int j=0 ;j<=i-2;j++)
		{
			
			Set.add(A.get(j)^B.get(k));//L
			arr=new ArrayList<Integer>();
			arr.add(2*j+1);
			arr.add(2*j+2);
			arr.add(2*j+3);
			
			
			mapA.put(A.get(j)^B.get(k), arr);
			
			k--;
		}
		
		mp.put(i, mapA);
		map.put('A', mp);
		mapA=new HashMap<Integer,ArrayList<Integer>>();
		A.add(calculateMex(Set));
//		System.out.println("A--->" +calculateMex(Set));
	}
	public static void calculateB(int i) {
		Set<Integer> Set = new HashSet<Integer>();
		Map<Integer,Map<Integer,ArrayList<Integer>>> mp=
				new HashMap<Integer,Map<Integer,ArrayList<Integer>>>();
		ArrayList<Integer> arr=new ArrayList<Integer>();
		Set.add(A.get(i-1));
		arr.add(2*(i-1) + 1);
		arr.add(2*(i-1) + 2);
		arr.add(2*(i-1) + 4);
		int k=i-2;
		for(int j=0 ;j<=i-2;j++)
		{
			Set.add(B.get(j)^B.get(k)); //rotate L 90
			arr=new ArrayList<Integer>();
			arr.add(2*j+2);
			arr.add(2*j+3);
			arr.add(2*j+4);
			mapB.put(B.get(j)^B.get(k), arr);
			
			Set.add(A.get(j)^C.get(k)); //  rotate L 280 left 
			arr=new ArrayList<Integer>();
			arr.add(2*j + 1);
			arr.add(2*j + 2);
			arr.add(2*j + 3);
			mapB.put(A.get(j)^C.get(k), arr);
			
			Set.add(A.get(j)^D.get(k)); // L
			arr=new ArrayList<Integer>();
			arr.add(2*j + 1);
			arr.add(2*j + 2);
			arr.add(2*j + 4);

			mapB.put(A.get(j)^D.get(k), arr);
			k--;
		}
		
		B.add(calculateMex(Set));
//		System.out.println("B--->" +calculateMex(Set));
			
			mp.put(i, mapB);
			map.put('B', mp);
			mapB=new HashMap<Integer,ArrayList<Integer>>();
		
	}
	public static void calculateB2(int i) {
		Set<Integer> Set = new HashSet<Integer>();
		Map<Integer,Map<Integer,ArrayList<Integer>>> mp=
				new HashMap<Integer,Map<Integer,ArrayList<Integer>>>();
		ArrayList<Integer> arr=new ArrayList<Integer>();
		Set.add(A.get(i-1));
		arr.add(1);
		arr.add(3);
		arr.add(4);
		int k=i-2;
		for(int j=0 ;j<=i-2;j++)
		{
			Set.add(B.get(j)^B.get(k)); //rotate L 90
			arr=new ArrayList<Integer>();
			arr.add(2*j+5);
			arr.add(2*j+3);
			arr.add(2*j+4);
			mapB.put(B.get(j)^B.get(k), arr);
			
			Set.add(A.get(j)^C.get(k)); //  rotate L 280 left 
			arr=new ArrayList<Integer>();
			arr.add(2*j + 4);
			arr.add(2*j + 5);
			arr.add(2*j + 6);
			mapB.put(A.get(j)^C.get(k), arr);
			
			Set.add(A.get(j)^D.get(k)); // L
			arr=new ArrayList<Integer>();
			arr.add(2*j + 3);
			arr.add(2*j + 5);
			arr.add(2*j + 6);

			mapB.put(A.get(j)^D.get(k), arr);
			k--;
		}
		
		B.add(calculateMex(Set));
//		System.out.println("B--->" +calculateMex(Set));
			
			mp.put(i, mapB);
			map.put('B', mp);
			mapB=new HashMap<Integer,ArrayList<Integer>>();
		
	}
	public static void calculateB3(int i) {
		Set<Integer> Set = new HashSet<Integer>();
		Map<Integer,Map<Integer,ArrayList<Integer>>> mp=
				new HashMap<Integer,Map<Integer,ArrayList<Integer>>>();
		ArrayList<Integer> arr=new ArrayList<Integer>();
		Set.add(A.get(i-1));
		arr.add(2);
		arr.add(3);
		arr.add( 4);
		int k=i-2;
		for(int j=0 ;j<=i-2;j++)
		{
			Set.add(B.get(j)^B.get(k)); //rotate L 90
			arr=new ArrayList<Integer>();
			arr.add(2*j+5);
			arr.add(2*j+3);
			arr.add(2*j+4);
			mapB.put(B.get(j)^B.get(k), arr);
			
			Set.add(A.get(j)^C.get(k)); //  rotate L 280 left 
			arr=new ArrayList<Integer>();
			arr.add(2*(k+1) - 1);
			arr.add(2*(k+1) + 1);
			arr.add(2*(k+1) + 2);
			
			mapB.put(A.get(j)^C.get(k), arr);
			
			Set.add(A.get(j)^D.get(k)); // L
			arr=new ArrayList<Integer>();
			arr.add(2*(k+1));
			arr.add(2*(k+1) + 1);
			arr.add(2*(k+1) + 2);
			mapB.put(A.get(j)^D.get(k), arr);
			k--;
		}
		
		B.add(calculateMex(Set));
//		System.out.println("B--->" +calculateMex(Set));
			
			mp.put(i, mapB);
			map.put('B', mp);
			mapB=new HashMap<Integer,ArrayList<Integer>>();
		
	}
	public static void calculateB4(int i) {
		Set<Integer> Set = new HashSet<Integer>();
		Map<Integer,Map<Integer,ArrayList<Integer>>> mp=
				new HashMap<Integer,Map<Integer,ArrayList<Integer>>>();
		ArrayList<Integer> arr=new ArrayList<Integer>();
		int k=i-2;
		Set.add(A.get(i-1));
		arr.add(2*(k+1)+1);
		arr.add(2*(k+1)+2);
		arr.add(2*(k+1)+3);
		
		for(int j=0 ;j<=i-2;j++)
		{
			Set.add(B.get(j)^B.get(k)); //rotate L 90
			arr=new ArrayList<Integer>();
			arr.add(2*(k+1));
			arr.add(2*(k+1)+1);
			arr.add(2*(k+1)+2);
			mapB.put(B.get(j)^B.get(k), arr);
			
			Set.add(A.get(j)^C.get(k)); //  rotate L 280 left 
			arr=new ArrayList<Integer>();
			arr.add(2*(j) + 1);
			arr.add(2*(j) + 2);
			arr.add(2*(j) + 4);
			
			mapB.put(A.get(j)^C.get(k), arr);
			
			Set.add(A.get(j)^D.get(k)); // L
			arr=new ArrayList<Integer>();
			arr.add(2*(j) + 1);
			arr.add(2*(j) + 2);
			arr.add(2*(j) + 3);
			mapB.put(A.get(j)^D.get(k), arr);
			k--;
		}
		
		B.add(calculateMex(Set));
//		System.out.println("B--->" +calculateMex(Set));
			
			mp.put(i, mapB);
			map.put('B', mp);
			mapB=new HashMap<Integer,ArrayList<Integer>>();
		
	}
	public static void calculateC(int i) {
		Set<Integer> Set = new HashSet<Integer>();
		ArrayList<Integer> arr=new ArrayList<Integer>();
		Map<Integer,Map<Integer,ArrayList<Integer>>> mp=
				new HashMap<Integer,Map<Integer,ArrayList<Integer>>>();
		Set.add(B.get(i-1));
		arr.add(2);
		arr.add(3);
		arr.add(4);
		
		int k=i-2;
		
		for(int j=0 ;j<=i-2;j++)
		{
			Set.add(B.get(j)^D.get(k));
			arr=new ArrayList<Integer>();
			arr.add(2*j + 3);
			arr.add(2*j + 4);
			arr.add(2*j + 6);
			mapC.put(B.get(j)^D.get(k),arr);
			Set.add(B.get(j)^C.get(k));
			arr=new ArrayList<Integer>();
			arr.add(2*j + 3);
			arr.add(2*j + 4);
			arr.add(2*j + 5);
			mapC.put(B.get(j)^C.get(k),arr);
			k--;
		}
		mp.put(i, mapC);
		map.put('C', mp);
		mapB=new HashMap<Integer,ArrayList<Integer>>();
		C.add(calculateMex(Set));
		
//		System.out.println("C--->" +calculateMex(Set));

	}
	public static void calculateD(int i) {
		Set<Integer> Set = new HashSet<Integer>();
		ArrayList<Integer> arr=new ArrayList<Integer>();
		Map<Integer,Map<Integer,ArrayList<Integer>>> mp=
				new HashMap<Integer,Map<Integer,ArrayList<Integer>>>();
		Set.add(B.get(i-1));
		arr.add(1);
		arr.add(3);
		arr.add(4);
		mapD.put(B.get(i-1), arr);
		int k=i-2;
		for(int j=0 ;j<=i-2;j++)
		{
			arr=new ArrayList<Integer>();
			
			Set.add(B.get(j)^C.get(k));
			arr.add(2*j + 3);
			arr.add(2*j + 4);
			arr.add(2*j + 5);
			mapD.put(B.get(j)^C.get(k), arr);
			Set.add(D.get(j)^B.get(k));
			arr=new ArrayList<Integer>();
			arr.add(2*j + 3);
			arr.add(2*j + 5);
			arr.add(2*j + 6);
			mapD.put(D.get(j)^B.get(k), arr);
			k--;
		}
		mp.put(i, mapD);
		map.put('D', mp);
		mapD=new HashMap<Integer,ArrayList<Integer>>();
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
	 cram cram=new cram();
	 
	 cram.calculate(12);
	 System.out.println(cram.A.get(3)^cram.B.get(2)^cram.C.get(1));
 }
}