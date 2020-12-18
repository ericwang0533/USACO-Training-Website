/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: wormhole
*/
import java.util.*;
import java.io.*;
public class wormhole {
	
	// Partners is one-indexed, with 0 representing a lack of a partner
	
	static int maxn = 12;
	
	static int n = 0;
	
	static int [] x = new int[maxn + 1];
	static int [] y = new int[maxn + 1];
	static int [] partners = new int[maxn + 1]; // Array with a number j at the ith index, meaning j is i's partner
	static int [] next_on_right = new int[maxn + 1];
	
	public static void main(String[] args) throws IOException {
		
		Scanner in = new Scanner(new File("wormhole.in"));
		PrintWriter pw = new PrintWriter(new File("wormhole.out"));
		
		n = in.nextInt();
		
		for(int i = 1; i <= n; i++) {
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			
			x[i] = x1;
			y[i] = y1;
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(x[j] > x[i] && y[i] == y[j]) {
					if(next_on_right[i] == 0 || x[j] - x[i] < x[next_on_right[i]] - x[i]) {
						next_on_right[i] = j;
					}
				}
			}
		}
		
		in.close();
		
		pw.println(solve());
		
		pw.close();
	}

	private static int solve() {
		
		int total = 0;
		
		// We first find i such that it doesnt have a partner
		
		int i = 0;
		
		for(i = 1; i <= n; i++) {
			if(partners[i] == 0)
				break;
		}
		
		if(i > n) {
			if(isCycle()) return 1;
			
			else return 0;
		}
		
		for(int j = i + 1; j <= n; j++) {
				
			if(partners[j] == 0) {
				//Now we try pairing i and j
				partners[i] = j;
				partners[j] = i;
				total += solve();
				partners[i] = partners[j] = 0;
			}
		}
		
		return total;
	}

	public static boolean isCycle() {
		for(int start = 1; start <= n; start++) {
			int pos = start;
			for(int count = 0; count < n; count++) {
				pos = next_on_right[partners[pos]];
			}
			
			if(pos != 0) return true;
		}
		
		return false;
	}

}
/*public class wormhole {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static int[] x = new int[13];
	public static int[] y = new int[13];
	public static int[] partner = new int[13];
	public static int[] next_on_right = new int[13];
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
		input();
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(x[j] > x[i] && y[i] == y[j]) {
					if(next_on_right[i] == 0 || x[j] - x[i] < x[next_on_right[i]] - x[i]) {
						next_on_right[i] = j;
					}
				}
			}
		}
		
		out.println(solve());
		
		out.close();
	}
	
	public static boolean cycle_exists() {
		for(int start = 1; start <= n; start++) {
			int pos = start;
			for(int count = 0; count < n; count++) {
				pos = next_on_right[partner[pos]];
			}
			if(pos != 0) {
				return true;
			}
		}
		
		System.out.println("cycle exists");
		return false;
	}
	
	public static int solve() {
		for(int i = 0; i < 13; i++) {
			System.out.print(partner[i] + " ");
		}
		System.out.println();
		
		int i, total = 0;
		for(i = 1; i < n+1; i++) {
			if(partner[i] == 0) {
				break;
			}
		}
		
		if(i > n) {
			if(cycle_exists()) {
				return 1;
			}
			return 0;
		}
		
		for(int j = i+1; j < n+1; j++) {
			System.out.println("inside j loop | j = " + j);
			if(partner[j] == 0) {
				partner[i] = j;
				partner[j] = i;
				total += solve();
				System.out.println("outside of total += solve() | total: " + total);
				partner[i] = partner[j] = 0;
			}
		}
		
		return total;
	}
	
	public static void input() {
		for(int i = 1; i < n+1; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
		}
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("wormhole.in"));
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
}*/
