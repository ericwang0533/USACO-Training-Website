/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: numtri
*/
import java.util.*;
import java.io.*;
public class numtri {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static int[][] mat = new int[n][n];
	public static int ans = 0;
	public static int iter = 1;
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
		
		input();
		for(int i = n - 2; i >= 0; i--) {
			for(int j = 0; j <= i; j++) {
				//System.out.println("i: " + i + " | j: " + j + " | mat[i][j]: " + mat[i][j] + " | max: " + Math.max(mat[i+1][j], mat[i+1][j+1]));
				mat[i][j] += Math.max(mat[i + 1][j], mat[i + 1][j + 1]);
				
			}
		}
		
		out.println(mat[0][0]);
		//solve(0, 0, 0);
		
		//out.println(ans);
		//out.println("test");
		out.close();
	}
	
	public static void solve(int row, int col, int sum) {
		sum += mat[row][col];
		System.out.println("i: " + iter + " | row: " + row + " | col: " + col + " | sum: " + sum);
		iter++;
		// check to see if we reached bottom row
		// then compare if greater than ans
		if(row == n-1) {
			ans = Math.max(sum, ans);
			return;
		}
		
		solve(row+1, col, sum);
		solve(row+1, col+1, sum);
	}
	
	public static void input() {
		for(int i = n-1; i >= 0; i--) {
			int counter = 0;
			for(int j = i; j < n; j++) {
				mat[n-i-1][counter] = in.nextInt();
				counter++;
			}
		}
		
		/*for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}*/
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("numtri.in"));
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
