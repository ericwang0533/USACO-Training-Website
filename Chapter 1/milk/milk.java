/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: milk
*/
import java.util.*;
import java.io.*;
public class milk {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static int m = in.nextInt();
	public static int[][] arr = new int[m][2];
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
		
		for(int i = 0; i < m; i++) {
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
		}
		Arrays.sort(arr, Comparator.comparingDouble(o -> o[0]));
		
		int cost = 0;
		for(int i = 0; i < m; i++) {
			if(n - arr[i][1] < 0) {
				cost += (n * arr[i][0]);//(arr[i][1] - n) * arr[i][0];
				break;
			}
			else {
				cost += arr[i][0] * arr[i][1];
				n -= arr[i][1];
				if(n <= 0) {
					break;
				}
			}
			
			System.out.println(i+1 + ": n = " + n);
			System.out.println(i+1 + ": cost = " + cost);
		}
		
		
		out.println(cost);
		out.close();
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader(){
			try {
				br = new BufferedReader(new FileReader("milk.in"));
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
		String nextLine() throws IOException{
			String str = "";
			str = br.readLine();
			return str;
		}
	}
}
