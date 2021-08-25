package cramgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class cram {
	
	static	ArrayList<Integer> A =new ArrayList<Integer>();
	static	ArrayList<Integer> B =new ArrayList<Integer>();
	static	ArrayList<Integer> C =new ArrayList<Integer>();
	static	ArrayList<Integer> D =new ArrayList<Integer>();
	static Map<String,Map<Integer,Map<Integer,ArrayList<Integer>>>> map=new HashMap<String,Map<Integer,Map<Integer,ArrayList<Integer>>>>();
	static Map mapA=new HashMap<Integer,ArrayList<Integer>>();
	static Map mapB=new HashMap<Integer,ArrayList<Integer>>();
	static Map mapC=new HashMap<Integer,ArrayList<Integer>>();
	static Map mapD=new HashMap<Integer,ArrayList<Integer>>();
	
	public cram(int row) {
	
		this.calculate(row);
		
	}
	
   public Map<String,Map<Integer,Map<Integer,ArrayList<Integer>>>> getMap(){
	    
	   return this.map;
   }
	public static int calculate(int n) {
	if (n==0|| n==1) return 0;
		A.add(0);	A.add(0);	
		B.add(0);   B.add(1);
		C.add(0);	C.add(1);
		D.add(0);	D.add(1);
		

		for(int i=1;i <= n;i++) {
			if(i!=1) calculateA(i);
			
			calculateB(i);
			calculateB2(i);
			calculateB3(i);
			calculateB4(i);
			calculateC(i);
			calculateC2(i);
			calculateD(i);
			calculateD2(i);
		}
	
		return A.get(n);
		
		
	}
	public static Set<Integer> calculateA(int i) {
		if(i==1) return null;
		Set<Integer> Set = new HashSet<Integer>();  
		int k=i-2;
		ArrayList<Integer> arr;
		Map<Integer,Map<Integer,ArrayList<Integer>>> mp=
				new HashMap<Integer,Map<Integer,ArrayList<Integer>>>();
		for(int j=0 ;j<=i-2;j++)
		{
			//System.out.println(j+ " : "+k);
			Set.add(A.get(j)^B.get(k));//L
	
			arr=new ArrayList<Integer>();
			arr.add(2*j+1);
			arr.add(2*j+2);
			arr.add(2*j+3);
			
			
			mapA.put(A.get(j)^B.get(k), arr);
			
			k--;
		}
		
		mp.put(i, mapA);
		if(map.get("A") ==null) map.putIfAbsent("A", mp);
		else	map.get("A").put(i, mapA);
		//map.put("A", mp);
		mapA=new HashMap<Integer,ArrayList<Integer>>();
		A.add(calculateMex(Set));
		return Set;
//		System.out.println("A--->" +calculateMex(Set));
	}
	public static Set<Integer> calculateB(int i) {
		Set<Integer> Set = new HashSet<Integer>();
		Map<Integer,Map<Integer,ArrayList<Integer>>> mp=
				new HashMap<Integer,Map<Integer,ArrayList<Integer>>>();
		ArrayList<Integer> arr=new ArrayList<Integer>();
		Set.add(A.get(i-1));
		arr.add(2*(i-1) + 1);
		arr.add(2*(i-1) + 2);
		arr.add(2*(i-1) + 4);
		mapB.put(A.get(i-1), arr);
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
			//map.put("B", mp);
		if(map.get("B") ==null) map.putIfAbsent("B", mp);
		else	map.get("B").put(i, mapB);
		
			mapB=new HashMap<Integer,ArrayList<Integer>>();
			return Set;
		
	}
	public static Set<Integer> calculateB2(int i) {
		Set<Integer> Set = new HashSet<Integer>();
		Map<Integer,Map<Integer,ArrayList<Integer>>> mp=
				new HashMap<Integer,Map<Integer,ArrayList<Integer>>>();
		ArrayList<Integer> arr=new ArrayList<Integer>();
		Set.add(A.get(i-1));
		arr.add(1);
		arr.add(3);
		arr.add(4);
		int k=i-2;
		mapB.put(A.get(i-1), arr);
		for(int j=0 ;j<=i-2;j++)
		{
			Set.add(B.get(j)^B.get(k)); //rotate L 90
			arr=new ArrayList<Integer>();
			arr.add(2*j+5);
			arr.add(2*j+3);
			arr.add(2*j+4);
			mapB.put(B.get(j)^B.get(k), arr);
			
			Set.add(A.get(j)^C.get(k)); 
			//  rotate L 280 left 

			arr=new ArrayList<Integer>();
			arr.add(2*(k+1) + 2);
			arr.add(2*(k+1) + 3);
			arr.add(2*(k+1) + 4);
			mapB.put(A.get(j)^C.get(k), arr);
			
			Set.add(A.get(j)^D.get(k)); // L
			arr=new ArrayList<Integer>();
			arr.add(2*(k+1) + 1);
			arr.add(2*(k+1) + 3);
			arr.add(2*(k+1) + 4);

			mapB.put(A.get(j)^D.get(k), arr);
			k--;
			
		}
		
		B.add(calculateMex(Set));
	
		
//		System.out.println("B--->" +calculateMex(Set));
		mp.put(i, mapB);
		if(map.get("B2") ==null) map.putIfAbsent("B2", mp);
		else	map.get("B2").put(i, mapB);
			mapB=new HashMap<Integer,ArrayList<Integer>>();
			
return Set;
		}
			
			
			
		
	
	public static Set<Integer> calculateB3(int i) {
		Set<Integer> Set = new HashSet<Integer>();
		Map<Integer,Map<Integer,ArrayList<Integer>>> mp=
				new HashMap<Integer,Map<Integer,ArrayList<Integer>>>();
		ArrayList<Integer> arr=new ArrayList<Integer>();
		Set.add(A.get(i-1));
		arr.add(2);
		arr.add(3);
		arr.add( 4);
		mapB.put(A.get(i-1),arr);
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
		
			
			arr.add(2*(k+1) + 1);
			arr.add(2*(k+1) + 3);
			arr.add(2*(k+1) + 4);
			
			
			mapB.put(A.get(j)^C.get(k), arr);
			
			Set.add(A.get(j)^D.get(k)); // L
			arr=new ArrayList<Integer>();
			arr.add(2*(k+1)+2);
			arr.add(2*(k+1) +3);
			arr.add(2*(k+1) + 4);
			mapB.put(A.get(j)^D.get(k), arr);
			k--;
		}
		
		B.add(calculateMex(Set));
//		System.out.println("B--->" +calculateMex(Set));
		mp.put(i, mapB);
		if(map.get("B3") ==null) map.putIfAbsent("B3", mp);
		else	map.get("B3").put(i, mapB);
			mapB=new HashMap<Integer,ArrayList<Integer>>();
			
		
	
			return Set;
		
	}
	public static Set<Integer> calculateB4(int i) {
		Set<Integer> Set = new HashSet<Integer>();
		Map<Integer,Map<Integer,ArrayList<Integer>>> mp=
				new HashMap<Integer,Map<Integer,ArrayList<Integer>>>();
		ArrayList<Integer> arr=new ArrayList<Integer>();
		
		int k=i-2;
		Set.add(A.get(i-1));
		arr.add(2*(k+1)+1);
		arr.add(2*(k+1)+2);
		arr.add(2*(k+1)+3);
		mapB.put(A.get(i-1),arr);
		for(int j=0 ;j<=i-2;j++)
		{
			Set.add(B.get(j)^B.get(k)); //rotate L 90
			arr=new ArrayList<Integer>();
			arr.add(2*(j)+2);
			arr.add(2*(j)+3);
			arr.add(2*(j)+4);
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
			
		if(map.get("B4") ==null) map.putIfAbsent("B4", mp);
		else	map.get("B4").put(i, mapB);
			mapB=new HashMap<Integer,ArrayList<Integer>>();
			return Set;
		
	}
	public static Set<Integer> calculateC(int i) {
		Set<Integer> Set = new HashSet<Integer>();
		ArrayList<Integer> arr=new ArrayList<Integer>();
		Map<Integer,Map<Integer,ArrayList<Integer>>> mp=
				new HashMap<Integer,Map<Integer,ArrayList<Integer>>>();
		Set.add(B.get(i-1));
		arr.add(2);
		arr.add(3);
		arr.add(4);
		mapC.put(B.get(i-1),arr);
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
		if(map.get("C") ==null) map.putIfAbsent("C", mp);
		else	map.get("C").put(i, mapC);
		mapB=new HashMap<Integer,ArrayList<Integer>>();
		C.add(calculateMex(Set));
		return Set;
		
//		System.out.println("C--->" +calculateMex(Set));

	}
	public static Set<Integer> calculateC2(int i) {
		Set<Integer> Set = new HashSet<Integer>();
		ArrayList<Integer> arr=new ArrayList<Integer>();
		Map<Integer,Map<Integer,ArrayList<Integer>>> mp=
				new HashMap<Integer,Map<Integer,ArrayList<Integer>>>();
		Set.add(B.get(i-1));
		arr.add(1);
		arr.add(3);
		arr.add(4);
		mapC.put(B.get(i-1),arr);
		int k=i-2;
		
		for(int j=0 ;j<=i-2;j++)
		{
			Set.add(B.get(j)^D.get(k));
			arr=new ArrayList<Integer>();
			arr.add(2*j + 3);
			arr.add(2*j + 4);
			arr.add(2*j + 5);
			mapC.put(B.get(j)^D.get(k),arr);
			Set.add(B.get(j)^C.get(k));
			arr=new ArrayList<Integer>();
			arr.add(2*j + 3);
			arr.add(2*j + 4);
			arr.add(2*j + 6);
			mapC.put(B.get(j)^C.get(k),arr);
			k--;
		}
		mp.put(i, mapC);
		if(map.get("C2") ==null) map.putIfAbsent("C2", mp);
		else	map.get("C2").put(i, mapC);
		mapB=new HashMap<Integer,ArrayList<Integer>>();
		C.add(calculateMex(Set));
		return Set;
		
//		System.out.println("C--->" +calculateMex(Set));

	}
	
	public static Set<Integer> calculateD(int i) {
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
		
		if(map.get("D") == null) map.putIfAbsent("D", mp);
		else	map.get("D").put(i, mapD);
		mapD=new HashMap<Integer,ArrayList<Integer>>();
		D.add(calculateMex(Set));
		return Set;
//		System.out.println("D--->" +calculateMex(Set));

	}
	public static Set<Integer> calculateD2(int i) {
		Set<Integer> Set = new HashSet<Integer>();
		ArrayList<Integer> arr=new ArrayList<Integer>();
		Map<Integer,Map<Integer,ArrayList<Integer>>> mp=
				new HashMap<Integer,Map<Integer,ArrayList<Integer>>>();
		//if(i==1) {
			
			
			
		//}
		Set.add(B.get(i-1));
		arr.add(2);
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
			arr.add(2*j + 6);
			mapD.put(B.get(j)^C.get(k), arr);
			Set.add(D.get(j)^B.get(k));
			arr=new ArrayList<Integer>();
			arr.add(2*j + 3);
			arr.add(2*j + 4);
			arr.add(2*j + 6);
			mapD.put(D.get(j)^B.get(k), arr);
			k--;
		}


		
		mp.put(i, mapD);
		if(map.get("D2") ==null) map.putIfAbsent("D2", mp);
		else	map.get("D2").put(i, mapD);
		

		mapD=new HashMap<Integer,ArrayList<Integer>>();
		D.add(calculateMex(Set));
		return Set;
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
	   

}