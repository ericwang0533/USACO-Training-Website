/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: frac1
*/

import java.util.*;
import java.io.*;

public class frac1 {
	public static boolean testing = false;
	public static boolean debug = false;
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static PrintWriter out;
	public static int n = in.nextInt();
	public static ArrayList<String> arr = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException{
//		dbg(testing);
		if(testing) {			
			out = new PrintWriter(new File("Chapter 2/second attempt/frac1/frac1.out"));
		}
		else {			
			out = new PrintWriter(new File("frac1.out"));
		}
		
//		out.println("test");
		
		for(int i = 1; i < n; i++) {
			for(int j = i+1; j <= n; j++) {
				
				int gcd = reduce(i, j);
				String str = "";
				if(gcd != 1) {					
					str = i/gcd + "/" + j/gcd;
					dbg(str);
				}
				else {
					str = i + "/" + j;
					dbg(str);					
				}
				
				if(!arr.contains(str)) {
					arr.add(str);
				}
				
			}
		}
		
		
		dbg(arr);
		Collections.sort(arr, new arrSort());
		dbg(arr);
		
		out.println("0/1");
		for(String str : arr) {
			out.println(str);
		}
		out.println("1/1");
		
		out.close();
	}
	
	public static class arrSort implements Comparator<String>{
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			String[] o1arr = o1.split("/");
			String[] o2arr = o2.split("/");
			double dec1 = Double.parseDouble(o1arr[0]) / Double.parseDouble(o1arr[1]);
			double dec2 = Double.parseDouble(o2arr[0]) / Double.parseDouble(o2arr[1]);
			if(dec2 > dec1) {
				return -1;
			}
			else if(dec2 < dec1) {
				return 1;
			}
			else {
				return 0;
			}
		}
		
	}
	
	public static int reduce(int num, int den) {
		if(den == 0) {
			return num;
		}
		return reduce(den, num % den);
	}

	static class FastReader{
		public FastReader() {
			if(testing) { 		
//				System.out.println(testing);
				try {								
					br = new BufferedReader(new FileReader(new File("Chapter 2/second attempt/frac1/frac1.in")));
				}
				catch(FileNotFoundException e) {
					e.printStackTrace();
				}
			}
			else {				
//				System.out.println(testing + " 1ewfw");
				try {			
					br = new BufferedReader(new FileReader(new File("frac1.in")));					
				}
				catch(FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
	
	static void dbg(Object obj) {
		if(debug) {
			System.out.println(obj);
		}
	}
}
