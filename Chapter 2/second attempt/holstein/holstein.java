/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: holstein
*/

import java.util.*;
import java.io.*;

public class holstein {
	public static boolean debug = false, testing = false;
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static PrintWriter out;
	
	public static int v = in.nextInt(), g;
	public static int[] vits = new int[v];
	public static int[][] feeds;
	
	public static ArrayList<Integer> ans = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException{
		out = testing ? new PrintWriter("Chapter 2/second attempt/holstein/holstein.out") : new PrintWriter("holstein.out");
//		out.println("test");
		
		input();
		for(int i = 0; i < g; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>(Arrays.asList(i));
			int[] total = feeds[i];
			recurse(total, i, temp);
		}
		
//		dbg(ans);
		out.print(ans.size());
		for(int i = 0; i < ans.size(); i++) {
			out.print(" " + (ans.get(i) + 1));
		}
		out.println();
		
		out.close();
	}
	
	public static void recurse(int[] total, int start, ArrayList<Integer> temp) {
		// TODO Auto-generated method stub
//		dbg("");
//		dbg("");
//		dbg("total: " + Arrays.toString(total));
//		dbg("start: " + start);
//		dbg("temp: " + temp);
//		dbg("ans: " + ans);
//		dbg("");
		
		
		// check if needs to break
		boolean gameOver = true;
		for(int i = 0; i < v; i++) {
			if(total[i] < vits[i]) {
				gameOver = false;
				break;
			}
		}
		
		if(gameOver) {
			// implement check system 
			Collections.sort(temp);
			
//			dbg("won?");
//			dbg(Arrays.toString(total));
//			dbg("temp: " + temp);
//			dbg("ans: " + ans);
//			dbg("temp: " + temp);
//			dbg("ans.size(): " + ans.size() + " | temp.size(): " + temp.size());
			
			if(ans.size() == 0 || temp.size() < ans.size()) {
				ans = (ArrayList<Integer>) temp.clone();
//				dbg("hihihiih");
//				dbg("hi: " + ans);
				return;
			}
			else if(temp.size() == ans.size()) {
				for(int i = 0; i < temp.size(); i++) {
					if(temp.get(i) < ans.get(i)) {
						ans = temp;
						return;
					}
					else if(temp.get(i) == ans.get(i)) {
						continue;
					}
					else {
						break;
					}
				}
			}
			
			return;
		}
		
		if(start == g-1) {
//			dbg("return?, failed");
//			dbg(Arrays.toString(total));
//			dbg(temp);
			return;
		}

		
		for(int i = start+1; i < g; i++) {
			temp.add(i);
			int[] temp1 = new int[v];
			for(int j = 0; j < v; j++) {
				temp1[j] = total[j] + feeds[i][j];
			}
//			dbg(temp);
//			dbg(Arrays.toString(temp1));
			
			recurse(temp1, i, temp);
			
			temp.remove(temp.size()-1);
		}
	}

	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < vits.length; i++) {
			vits[i] = in.nextInt();
		}
//		dbg(Arrays.toString(vits));
		
		g = in.nextInt();
		feeds = new int[g][v];
		for(int i = 0; i < g; i++) {
			for(int j = 0; j < v; j++) {
				feeds[i][j] = in.nextInt();
			}
		}
		
//		dbg(Arrays.deepToString(feeds));
	}

	static class FastReader{
		public FastReader() {
			try {
				br = testing ? new BufferedReader(new FileReader(new File("Chapter 2/second attempt/holstein/holstein.in"))) : new BufferedReader(new FileReader(new File("holstein.in")));
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
			catch(IOException e){
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
