/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: palsquare
*/
import java.util.*;
import java.io.*;

public class palsquare {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static char[] arr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		
		for(int i = 1; i < 301; i++) {
			int square = i * i;
			String squared = convert(square).toString();
			String reversed = new StringBuilder(squared).reverse().toString();
			System.out.println(squared + ": " + reversed);
			if(squared.equals(reversed)) {
				out.println(convert(i) + " " + squared);
			}
		}
		
		out.close();
	}
	
	public static StringBuilder convert(int i) {
		String ans = "";
		while(i != 0) {
			int rem = i % n;
			ans += arr[rem];
			i -= rem;
			i /= n;
		}
		return new StringBuilder(ans).reverse();
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("palsquare.in"));
			}
			catch(FileNotFoundException e) {
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
