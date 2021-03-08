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
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static int ans = 0;
	public static int sum = n * (n+1) / 2;
	public static PrintWriter out;
	
static long [][] dp;
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("subset.in"));
		PrintWriter pw = new PrintWriter(new File("subset.out"));
		int N = in.nextInt();
		in.close();
		int sum = (int) (N * N + N) / 2;
		int sumlim = sum / 2;
		dp = new long[40][800]; // n <= 39, n(n + 1) / 2 <= 800
		for(int x = 0; x <= N; x++) dp[x][0] = 1; // There is one way to make a sum of 0 with x elements
		for(int x = 1; x <= N; x++) {
			for(int y = 1; y <= (int) (N * N + N) / 4; y++) {
				dp[x][y] += dp[x - 1][y]; // += number of ways to make sum y with x - 1 elements
				if(x <= y) dp[x][y] += dp[x - 1][y - x]; // += number of ways to make sum y - x with x - 1 elements
			}
		}
		
		if(sum % 2 == 0) pw.println((long) dp[N][sumlim] / 2);
		else pw.println(0);
		pw.close();
	}
	
	public static void generate(int recent, int total) {
		// TODO Auto-generated method stub
		if(total == sum/2) {
			ans++;
			return;
		}
		
		if(total >= sum/2) {
			return;
		}
		
		for(int i = recent+1; i <= n; i++) {
			total += i;
			generate(i, total);
			total -= i;
		}
		
	}

	public static void check(int total) {
		// TODO Auto-generated method stub
//		for(int i = 0; i < nums.size(); i++) {
//			out.print(nums.get(i) + " ");
//		}
//		out.println();
//		if(nums.size() < n/2) {
//			return;
//		}
		
//		int sum = 0;
//		for(int i = 1; i <= n; i++) {
//			if(nums.contains(i)) {
//				sum += i;
//				continue;
//			}
//			sum -= i;
//		}
//		
		if(total == sum/2) {
			ans++;
		}
	}
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader(new File("subset.in")));
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
