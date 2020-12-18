/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: skidesign
*/
import java.util.*;
import java.io.*;
public class skidesign {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static int[] arr = new int[n];
	public static int cost = Integer.MAX_VALUE;
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
		input();
		
		if(check()) {
			out.println(cost);
		}
		else {
			for(int i = arr[0]; i <= arr[n-1] - 17; i++) {
				System.out.println(i);
				int temp = 0;
				for(int j = 0; j < n; j++) {
					if(!(arr[j] <= i+17 && arr[j] >= i)) {
						int tosquare = Math.min(Math.abs(arr[j]-i), Math.abs(arr[j]-i-17));
						temp += tosquare * tosquare;
						System.out.println(temp);
					}
				}
				cost = Math.min(temp, cost);
			}
		}
		
		out.println(cost);
		out.close();
	}
	
	public static void input() {
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		Arrays.sort(arr);
	}
	
	public static boolean check() {
		if(arr[n-1] - arr[0] <= 7) {
			return true;
		}
		return false;
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("skidesign.in"));
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
		long nextLone() {
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
