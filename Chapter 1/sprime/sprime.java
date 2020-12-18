/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: sprime
*/
import java.util.*;
import java.io.*;
public class sprime {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static int[] init = {2, 3, 5, 7};
	public static int[] primes = {1, 3, 7, 9};
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
		
		for(int i = 0; i < init.length; i++) {
			solve(init[i], 1);
		}
		
		//out.println("test");
		out.close();
	}
	
	public static void solve(int num, int len) {
		if(len == n) {
			out.println(num);
			return;
		}
		
		//System.out.println("num: " + num + " | len: " + len + " | prev: " + prev);
		for(int i = 0; i < primes.length; i++) {
			if(prime(num * 10 + primes[i])) {
				solve(num * 10 + primes[i], len+1);
			}
		}
	}
	
	public static boolean prime(int n) {
		//System.out.println("primecheck: " + n);
		if(n % 3 == 0 || n % 5 == 0) {
			//System.out.println(n + " %3 and 5 check");
			return false;
		}
		int divisor = (int) Math.sqrt(n);
		while(divisor > 6){
			if(n % divisor == 0) {
			//	System.out.println("not prime: " + divisor);
				return false;
			}
			divisor--;
		}
		//System.out.println("prime!: " + n);
		return true;
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("sprime.in"));
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
