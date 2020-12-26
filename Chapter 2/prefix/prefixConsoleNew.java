
/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: prefix
*/
import java.util.*;
import java.io.*;

public class prefixConsoleNew {
	public static FastReader in = new FastReader();
	// public static ArrayList<String> prefixes = new ArrayList<String>();
	public static String[] prefixes;
	public static String sequence = "";
	public static int ans = 0;
	public static PrintWriter out;
	public static int lines = 1;
	public static BufferedReader br;
	public static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		out = new PrintWriter(new FileWriter(new File("C:\\\\Users\\\\erics\\\\eclipse-workspace\\\\USACO Training Website\\\\Chapter 2\\\\prefix\\\\prefix.out")));

		input();
		solve(0);

		out.println(ans);
		out.close();
	}

	public static void solve(int index) {
		ans = Math.max(ans, index);
		
		if(index >= (lines * 60)) {
			System.out.println(sequence);
			String line;
			if((line = in.nextLine()) == null) {
				return;
			}
			sequence += line;
			lines++;
		}

		for (int i = 0; i < prefixes.length; i++) {
			if (sequence.startsWith(prefixes[i], index)) {
				solve(index + prefixes[i].length());
				return;
			}
		}
	}

	public static void input() {
		// TODO Auto-generated method stub
		System.out.println("test");
		out.println("test");
		String temp = "";
		String line;// = in.nextLine();
		while ((line = in.nextLine()).length() != 1) {
			// System.out.println(line);
			temp += line + " "; // .split(" ");
			// line = in.nextLine();
		}
		prefixes = temp.split(" ");

		// String line1 = br.readLine();
		// sequence += line;
		// line = in.nextLine();
		// System.out.println();
		// StringTokenizer st = new StringTokenizer(br.readLine());
		sequence += in.nextLine();
		System.out.println(sequence);
//		while ((line = in.nextLine()) != null ) {
//
//			sequence += line;
//			
//			if(line.equals("end")) {
//				break;
//			}
////			System.out.println(sequence);
//		}
////		System.out.println("test");
//		for (int i = 0; i < prefixes.length; i++) {
//			System.out.println(prefixes[i] + " ");
//		}
//		System.out.println(sequence);
	}

	static class FastReader {
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader(new File("C:\\Users\\erics\\eclipse-workspace\\USACO Training Website\\Chapter 2\\prefix\\prefix.in")));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
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
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
