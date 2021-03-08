/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: prefix
*/
import java.util.*;
import java.io.*;
public class prefixNewNew4 {
	public static FastReader in = new FastReader();
	public static String[] prefixes;
	public static String sequence = "";
	public static int ans = 0;
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new FileWriter(new File("C:\\\\Users\\\\erics\\\\eclipse-workspace\\\\USACO Training Website\\\\Chapter 2\\\\prefix\\\\prefix.out")));
		
		input();
		//solve(0);
		
		
		
		out.println(ans);
		out.close();
	}
	
	public static void solve(int index) {
		ans = Math.max(ans, index);
		
		for(int i = 0; i < prefixes.length; i++) {
			if(sequence.startsWith(prefixes[i], index)) {
				solve(index+prefixes[i].length());
			}
		}
	}
	
	public static void input() {
		System.out.println("test");
		// TODO Auto-generated method stub
		String temp = "";
		String line;// = in.nextLine();
		while((line = in.nextLine()).length() != 1) {
			//System.out.println(line);
			temp += line + " "; //.split(" ");
			//line = in.nextLine();
		}
		prefixes = temp.split(" ");
		
		//String line1 = br.readLine();
		//sequence += line;
		//line = in.nextLine();
		//System.out.println();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		while((line = in.nextLine()) != null) {
			
			sequence += line;
//			System.out.println(sequence);
		}
		System.out.println("test");
		for(int i = 0; i < prefixes.length; i++) {
			System.out.println(prefixes[i] + " ");
		}
		System.out.println(sequence);
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader(new File("C:\\Users\\erics\\eclipse-workspace\\USACO Training Website\\Chapter 2\\prefix\\prefix.in")));
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
