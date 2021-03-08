/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: castle
*/

import java.util.*;
import java.io.*;

public class castle {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static PrintWriter out;
	public static boolean debug = true;
	public static int m = in.nextInt(), n = in.nextInt();
	public static int[][] mat = new int[n][m];
	public static int[][] fill = new int[n][m];
	public static int inc = 1;
	
	public static void main(String[] args) throws IOException{
//		out = new PrintWriter(new File("castle.out"));
		out = new PrintWriter(new File("Chapter 2/second attempt/castle/castle.out"));
//		out.println("test");
//		File here = new File(".");
//		dbg(here.getAbsolutePath());
		
		input();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(fill[i][j] == 0) {					
					ff(i, j);		
					dbg("her");
					inc++;
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			dbg(Arrays.toString(fill[i]));
		}
//		dbg(Arrays.deepToString(fill));
		
		out.close();
	}
	
	public static void ff(int r, int c) {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
			dbg(Arrays.toString(fill[i]));
		}
		dbg("");
		
		fill[r][c] = inc;
		boolean dead = false;
		
		if(mat[r][c] >= 8) {
			mat[r][c] -= 8;
		}
		else {
			if(r+1 < n && fill[r+1][n] == 0) {
				ff(r+1, c);
				dead = true;
			}
		}
		
		
		if(mat[r][c] >= 4) {
			mat[r][c] -= 4;
		
		}
		else {
			if(c+1 < m && fill[r][c+1] == 0) {
				ff(r, c+1);
				dead = true;
			}
		}
		
		
		if(mat[r][c] >= 2) {
			mat[r][c] -= 2;
		
		}
		else {
			if(r-1 >= 0 && fill[r-1][c] == 0) {
				dbg(r + " " + c);
				ff(r-1, c);
				dead = true;
			}
		}
		
		
		if(mat[r][c] >= 1) {
			mat[r][c] -= 1;
		}
		else {
			if(c-1 >= 0 && fill[r][c-1] == 0) {
				ff(r, c-1);
				dead = true;
			}
		}
		
		
		if(!dead) {
			dbg(r + " : inc : " + c);
//			inc++;
		}
	}

	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		dbg(Arrays.deepToString(mat));
	}

	static class FastReader{
		public FastReader() {
			try {
//				br = new BufferedReader(new FileReader(new File("castle.in")));
				br = new BufferedReader(new FileReader(new File("Chapter 2/second attempt/castle/castle.in")));
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
	
	static void dbg(Object obj) {
		if(debug) {
			System.out.println(obj);
		}
	}
}
