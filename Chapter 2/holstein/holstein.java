/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: holstein
*/
import java.util.*;
import java.io.*;
public class holstein {
	public static FastReader in = new FastReader();
	public static int vits = in.nextInt();
	public static int[] reqs = new int[vits];
	public static int feds;
	public static int[][] feeds;
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("System.out")));
		
		input();
		
		
		
		for(int i = 0; i < feds; i++) {
			solve(i, reqs);
		}
		
		out.println("test");
		out.close();
	}
	
	public static void solve(int num, int[] temp) {
		
			
		
	}
	
	public static boolean enough(int i, int j) {
		for(int a = 0; a < vits; a++) {
			// check if enough vitamins
			if(feeds[i][a] + feeds[j][a] < reqs[a]) {
				return false;
			}
		}
		return true;
	}
	
	public static void input() {
		for(int i = 0; i < vits; i++) {
			reqs[i] = in.nextInt();
		}
		
		feds = in.nextInt();
		feeds = new int[feds][vits];
		for(int i = 0; i < feds; i++) {
			for(int j = 0; j < vits; j++) {
				feeds[i][j] = in.nextInt();
			}
		}
		
		// potentially need to sort feeds from small to greatest?
		// question is kind of vague w/ "smallest feedtype numbers"
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("holstein.in"));
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
