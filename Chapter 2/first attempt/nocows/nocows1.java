/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: nocows
*/
import java.util.*;
import java.io.*;
public class nocows1 {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("nocows.in"));
		PrintWriter pw = new PrintWriter(new File("nocows.out"));
		int N = in.nextInt();
		int K = in.nextInt();
		long [][] dp = new long[201][101];
		in.close();
		for(int k = 1; k <= K; k++) { // looping through all possible heights
			dp[1][k] = 1;
			for(int n = 2; n <= N; n++) { // looping through all nodes
				for(int p = 1; p <= n - 2; p++) { // looping through previous nodes
					dp[n][k] += dp[p][k - 1] * dp[n - p - 1][k - 1];
					dp[n][k] %= 9901;
				}
					
			}
		}
		
		pw.println((dp[N][K] - dp[N][K - 1] + 9901) % 9901);
		pw.close();
	}
	
	static class FastReader{
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("nocows.in"));
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
