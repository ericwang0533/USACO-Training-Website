/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: subset
*/

import java.util.*;
import java.io.*;

public class subset {
	public static boolean debug = true, testing = true;
	public static BufferedReader br; public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static PrintWriter out;
	public static int n = in.nextInt();
	public static int target = n * (n+1);
	
	public static void main(String[] args) throws IOException{
		out = (testing) ? new PrintWriter(new File("Chapter 2/second attempt/subset/subset.out")) : new PrintWriter(new File("subset.out"));
//		out.println("test");
		
		if(n * (n+1) % 4 != 0) {
			out.println(0);
			out.close();
			System.exit(0);
		}
		
		out.println("hi");
		
		out.close();
	}
	
	static class FastReader{
		public FastReader() {
			try {
				br = (testing) ? new BufferedReader(new FileReader(new File("Chapter 2/second attempt/subset/subset.in"))) : new BufferedReader(new FileReader(new File("subset.in")));
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()){
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
		if(testing)
			System.out.println(obj);
	}
}
