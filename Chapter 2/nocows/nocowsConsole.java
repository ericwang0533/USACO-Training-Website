/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: nocows
*/
import java.util.*;
import java.io.*;
public class nocowsConsole {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
//	public static int n = in.nextInt(), k = in.nextInt(), ans = 0;
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(System.out);//new BufferedWriter(new FileWriter("nocows.out")));
		
		int N = in.nextInt();
		int K = in.nextInt();
		long [][] dp = new long[201][101];
		for(int k = 1; k <= K; k++) { // looping through all possible heights
			dp[1][k] = 1;
			for(int n = 2; n <= N; n++) { // looping through all nodes
				for(int p = 1; p <= n - 2; p++) { // looping through previous nodes
					dp[n][k] += dp[p][k - 1] * dp[n - p - 1][k - 1];
					System.out.println("n: " + n + " | k: " + k + " | p: " + p + " | dp[p][k-1]: " + dp[p][k-1] + " | dp[n-p-1][k-1]: " + dp[n-p-1][k-1] + " | dp[n][k]: " + dp[n][k]);
					dp[n][k] %= 9901;
				}
					
			}
		}
		
		System.out.println("    1 2 3 4");
		System.out.println("    -------");
		for(int i = 1; i <= 9; i++) {
			System.out.print(i + " | ");
			for(int j = 1; j <= 4; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("dp[N][K]: " + dp[N][K] + " | dp[N][K-1]: " + dp[N][K-1]);
		System.out.println((dp[N][K] - dp[N][K - 1] + 9901) % 9901);
		
		
		/*
		 * if(n == 0 || k == 0) { out.println(0); out.close(); System.exit(0); }
		 * 
		 * if(n == 1 || k == 1) { out.println(1); out.close(); System.exit(0); }
		 * 
		 * Node[][] mat = new Node[k][n]; int[] temp = {2, 2}; mat[0][0] = new Node(2,
		 * temp); solve(mat, 0, 0); mat[0][0].vals[0] = 0; solve(mat, 0, 0);
		 * mat[0][0].vals[0] = 2; mat[0][0].vals[1] = 0; solve(mat, 0, 0);
		 * 
		 * //System.out.println(mat[0][0].vals[0]);
		 */		
		out.close();
	}
	
	/*
	 * public static void solve(Node[][] mat, int height, int nodes) { // TODO
	 * Auto-generated method stub if(height == k || nodes == n) { if(height == k &&
	 * nodes == n) { ans++; } return; }
	 * 
	 * System.out.println(mat[0][0].vals[0] + " " + mat[0][0].vals[1]);
	 * 
	 * // each node has 2 options, 0 or 2
	 * 
	 * }
	 * 
	 * public static class Node { public int children; public int[] vals;
	 * 
	 * public Node(int children, int[] vals) { this.children = children; this.vals =
	 * vals; } }
	 */

	static class FastReader{
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));//FileReader("nocows.in"));
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
