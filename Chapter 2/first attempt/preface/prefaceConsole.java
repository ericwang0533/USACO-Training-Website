/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: preface
*/
import java.util.*;
import java.io.*;
public class prefaceConsole {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static int [] ans = new int[7]; //i, v, x, l, c, d, m  = 0;
	public static String [] symb = {"I", "V", "X", "L", "C", "D", "M"};
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(System.out);//"preface.out")));
		
		for(int i = 1; i <= n; i++) {
			solve(i);
			out.println(i);
			output();
		}
		
		output();
		out.close();
	}
	
	public static void solve(int i) {
		// TODO Auto-generated method stub
		while(i != 0) {
			
			if(i >= 1000) {
				i -= 1000;
				ans[6]++;
			}
			
			else if(i >= 500) {
				i -= 500;
				ans[5]++;
			}
			
			else if(i >= 100) {
				i -= 100;
				ans[4]++;
			}
			
			else if(i >= 50) {
				
				if(i >= 90) {
					i-=90;
					ans[4]++;
					ans[2]++;
				}
				else {
					i -= 50;
					ans[3]++;
				}
				
			}
			
			else if(i >= 10) {
				if(i >= 40) {
					i -= 40;
					ans[3]++;
					ans[2]++;
				}
				else {
					i -= 10;
					ans[2]++;
				}
			}
			
			else if(i >= 5) {
				
				if(i == 9) {
					i -= 9;
					ans[0]++;
					ans[2]++;
				}
				else {
					i -= 5;
					ans[1]++;
				}
				
				
			}
			
			else {
				
				if(i == 4) {
					ans[0]++;
					ans[1]++;
				}
				else {
					ans[0] += i;
				}
				break;
			}
			
		}
		
	}

	public static void output() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 7; i++) {
			if(ans[i] == 0) {
				continue;
			}
			
			out.println(symb[i] + " " + ans[i]);
		}
	}

	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));//FileReader(new File("preface.in")));
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
