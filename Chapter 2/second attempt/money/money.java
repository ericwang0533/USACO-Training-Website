/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: money
*/
import java.util.*;
import java.io.*;
public class money {
	public static boolean testing = true;
	public static BufferedReader br; public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static PrintWriter out;
	public static int v = in.nextInt(), n = in.nextInt();
	public static int[] coins = new int[v];
	public static int[] dp = new int[n+1]; 
	
	public static void main(String[] args) throws IOException{
		out = (testing) ? new PrintWriter(System.out) : new PrintWriter(new FileWriter("money.out"));
		
		input();
		solve();
		
		out.close();
	}
	
	public static void solve() {
		// TODO Auto-generated method stub
		for(int i = 1; i <= n; i++) {
			
		}
	}

	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < v; i++) {
			coins[i] = in.nextInt();
		}
		Arrays.sort(coins);
		dbg(Arrays.toString(coins));
	
		dp[0] = 0;
	}

	static class FastReader {
		public FastReader() {
			try {
				br = (testing) ? new BufferedReader(new FileReader(new File("Chapter 2/second attempt/money/money.in"))) : new BufferedReader(new FileReader(new File("money.in")));
			}
			catch(IOException e) {
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
		
		double nextDoule() {
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
		if(testing) {
			System.out.println(obj);
		}
	}
}