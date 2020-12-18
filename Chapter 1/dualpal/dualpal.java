/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: dualpal
*/
import java.util.*;
import java.io.*;

public class dualpal {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static int s = in.nextInt();
	public static char[] arr = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
		
		int i = 0;
		while(i < n) {
			s++;
			int a = 0;
			
			if(palin(String.valueOf(s))) {
				a++;
			}
			for(int j = 2; j < 10; j++) {
				if(palin(convert(s, j))) {
					a++;
				}
				if(a == 2) {
					break;
				}
			}
			
			if(a >= 2) {
				out.println(s);
				i++;
			}
		}
		
		out.close();
	}
	
	public static String convert(int input, int base) {
		String res = "";
		while(input != 0) {
			int rem = input % base;
			res += arr[rem];
			input -= rem;
			input /= base;
		}
		return new StringBuilder(res).reverse().toString();
	}
	
	public static boolean palin(String input) {
		String reversed = new StringBuilder(input).reverse().toString();
		if(input.equals(reversed)) {
			return true;
		}
		return false;
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("dualpal.in"));
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
