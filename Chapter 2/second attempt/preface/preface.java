/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: preface
*/

import java.util.*;
import java.io.*;

public class preface {
	public static boolean debug = false, testing = false;
	public static BufferedReader br; public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static PrintWriter out;
	
	public static int n = in.nextInt();
	public static int[] ivxlcdm = new int[7];
	public static char[] chars = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
	//i = 1, v = 5, x = 10, l = 50, c = 100, d = 500, m = 1000
	
	public static void main(String[] args) throws IOException{
		out = (testing) ? new PrintWriter(new File("Chapter 2/second attempt/preface/preface.out")) : new PrintWriter(new File("preface.out"));
//		out.println("test");
		
		for(int i = 1; i <= n; i++) {
			solve(i);
			dbg(i + ": " + Arrays.toString(ivxlcdm).replaceAll(",", " |"));
		}
		
		for(int i = 0; i < 7; i++) {
			if(ivxlcdm[i] != 0) {
				out.println(chars[i] + " " + ivxlcdm[i]);
			}
		}
		
		out.close();
	}
	
	public static void solve(int num) {
		// TODO Auto-generated method stub
		while(num > 0) {
			if(num >= 1000) {
				num -= 1000;
				ivxlcdm[6]++;
				continue;
			}
			
			if(num >= 500) {
				if(num >= 900) {
					num -= 900;
					ivxlcdm[6]++;
					ivxlcdm[4]++;
					continue;
				}
				num -= 500;
				ivxlcdm[5]++;
				continue;
			}
			
			if(num >= 100) {
				if(num >= 400) {
					num -= 400;
					ivxlcdm[5]++;
					ivxlcdm[4]++;
					continue;
				}
				num -= 100;
				ivxlcdm[4]++;
				continue;
			}
			
			if(num >= 50) {
				if(num >= 90) {
					num -= 90;
					ivxlcdm[4]++;
					ivxlcdm[2]++;
					continue;
				}
				num -= 50;
				ivxlcdm[3]++;
				continue;
			}
			
			if(num >= 10){
				if(num >= 40) {
					num -= 40;
					ivxlcdm[3]++;
					ivxlcdm[2]++;
					continue;
				}
				num -= 10;
				ivxlcdm[2]++;
				continue;
			}
			
			if(num >= 5) {
				if(num >= 9) {
					num -= 9;
					ivxlcdm[2]++;
					ivxlcdm[0]++;
					continue;
				}
				num -= 5;
				ivxlcdm[1]++;
				continue;
			}
			
			if(num >= 1) {
				if(num >= 4) {
					num -= 4;
					ivxlcdm[1]++;
					ivxlcdm[0]++;
					continue;
				}
				num -= 1;
				ivxlcdm[0]++;
				continue;
			}
		}
	}

	static class FastReader{
		public FastReader() {
			try {
				br = (testing) ? new BufferedReader(new FileReader(new File("Chapter 2/second attempt/preface/preface.in"))) : new BufferedReader(new FileReader(new File("preface.in")));
			}
			catch(IOException e) {
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
		if(testing)
			System.out.println(obj);
	}
}
