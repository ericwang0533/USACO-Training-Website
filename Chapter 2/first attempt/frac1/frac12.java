/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: frac1
*/
import java.util.*;
import java.io.*;
public class frac12 {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	//public static int counter = 0;
	public static ArrayList<Fraction> arr = new ArrayList<>();
	//public static String[][] mat = new String[321][2];
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
		
		//System.out.println(reduce(1, 2));
		//System.out.println(reduce(2, 4));
		
		out.println("0/1");
		//out.println("1/1");
		for(int i = 1; i <= n; i++) {
			for(int j = i; j <= n; j++) {
				if(!reduce(i, j)) {
					arr.add(new Fraction(i, j));
				}
			}
		}
		
		arr.sort((o1, o2) -> Double.compare(o1.decimal(), o2.decimal()));
		
		for(int i = 0; i < arr.size(); i++) {
			out.println(arr.get(i));
		}
		
		//System.out.println(Fraction.gcd(14, 15));
		//System.out.println(reduce(14, 15));
		//System.out.println(reduce(9, 12));
		
		//out.println("Test");
		out.close();
	}
	
	
	// true if it CAN be reduced
	// false if it CAN'T be reduced
	public static boolean reduce(int numer, int denom) {
		if(Fraction.gcd(numer, denom) == 1) {
			return false;
		}
		return true;
		/*for(int i = 2; i <= numer; i++) {
			if(denom%i == 0) {
				return true;
			}
		}
		return false;*/
	}
	
	static class Fraction{
		public int numerator;
		public int denominator;
		
		public Fraction(int numer, int denom) {
			numerator = numer;
			denominator = denom;
		}
		
		public static int gcd(int numer, int denom) {
			if(denom == 0) {
				return numer;
			}
			return gcd(denom, numer % denom);
		}
		
		public double decimal() {
			return (double) numerator / denominator; 
		}
		
		@Override
		public String toString() {
			return numerator + "/" + denominator;
		}
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("frac1.in"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
}
