/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: sort3
*/

import java.util.*;
import java.io.*;

public class sort3 {
	public static boolean debug = false, testing = false;
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static PrintWriter out;
	
	
	public static int n = in.nextInt(), ans = 0;
//	public static int ones = 0, twos = 0, threes = 0;
//	public static int[] arr = new int[n];
	public static ArrayList<Integer> ones = new ArrayList<Integer>();
	public static ArrayList<Integer> twos = new ArrayList<Integer>();
	public static ArrayList<Integer> threes = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException{
		out = testing ? new PrintWriter(new File("Chapter 2/second attempt/sort3/sort3.out")) : new PrintWriter(new File("sort3.out"));
//		out.println("test");
	
		input();
		direct();
		
		out.close();
	}
	
	public static void direct() {
		// TODO Auto-generated method stub
		int onesInTwo = 0, onesInThree = 0;
		dbg(ones.size() + " | " + twos.size() + " | " + threes.size());
//		dbg(ones.size() + " | " + (twos.size() + ones.size()));
		for(int i = 0; i < ones.size(); i++) {
			int temp = ones.get(i);
			if(temp > ones.size() && temp <= twos.size() + ones.size()) {
				onesInTwo++;
			}
			else if(temp > ones.size() + twos.size()) {
				onesInThree++;
			}
		}
		dbg(onesInTwo + " | " + onesInThree);
		
		
		int twosInOne = 0, twosInThree = 0; 
		for(int i = 0; i < twos.size(); i++) {
			int temp = twos.get(i);
			if(temp <= ones.size()) {
				twosInOne++;
			}
			else if(temp > ones.size() + twos.size()) {
				twosInThree++;
			}
		}
		dbg(twosInOne + " | " + twosInThree);
		
		int threesInOne = 0, threesInTwo = 0;
		for(int i = 0; i < threes.size(); i++) {
			int temp = threes.get(i);
			if(temp <= ones.size()) {
				threesInOne++;
			}
			else if(temp > ones.size() && temp <= twos.size() + ones.size()) {
				threesInTwo++;
			}
		}
		dbg(threesInOne + " | " + threesInTwo);
		
		
		// ones and twos
		int min12 = Math.min(onesInTwo, twosInOne);
		ans += min12;
		onesInTwo -= min12; twosInOne -= min12;
		dbg(ans);
		
		// ones and threes
		int min13 = Math.min(onesInThree, threesInOne);
		ans += min13;
		onesInThree -= min13; threesInOne -= min13;
		dbg(ans);
		
		// twos and threes
		int min23 = Math.min(twosInThree, threesInTwo);
		ans += min23;
		twosInThree -= min23; threesInTwo -= min23;
		dbg(ans);
		
		ans += ((onesInTwo + onesInThree + twosInOne + twosInThree + threesInOne + threesInTwo)/3) * 2;
		dbg(ans);
		out.println(ans);
	}

	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 1; i <= n; i++) {
//			arr[i] = in.nextInt();
			int temp = in.nextInt();
			if(temp == 1) {
				ones.add(i);
			}
			else if(temp == 2) {
				twos.add(i);
			}
			else {
				threes.add(i);
			}
		}
		
//		dbg(arr);
		dbg(ones);
		dbg(twos);
		dbg(threes);
	}

	static class FastReader{
		public FastReader() {
			try {
				br = testing ? new BufferedReader(new FileReader(new File("Chapter 2/second attempt/sort3/sort3.in"))) : new BufferedReader(new FileReader(new File("sort3.in")));
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
