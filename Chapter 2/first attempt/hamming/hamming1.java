/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: hamming
*/
import java.util.*;
import java.io.*;
public class hamming1 {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt(), b = in.nextInt(), d = in.nextInt();
	public static ArrayList<Integer> ans = new ArrayList<Integer>(Arrays.asList(0));
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
		
		outerloop:
			for(int i = 1; i < Math.pow(2, b); i++) {
				for(int j = 0; j < ans.size(); j++) {
					if(hamming_distance(i, ans.get(j)) < d) {
						continue outerloop;
					}
				}
				
				ans.add(i);
				if(ans.size() == n) {
					break;
				}
				//System.out.println("i: " + i + " | i-1: " + (i-1));
				//System.out.println("hamming distance: "  + hamming_distance(i, i-1));
			}
			
			for(int i = 0; i < ans.size(); i++) {
				if(i != 1 && (i % 10 == 0 || i == 0)) {
					out.print(ans.get(i));
					continue;
				}
				
				if(i % 10 == 9) {
					out.println(" " + ans.get(i));
				}
				else {
					out.print(" " + ans.get(i));
				}
			}
			if(ans.size() % 10 != 0) {
				out.println();
			}
			
			out.close();
		}
		
		public static int hamming_distance(int a, int b) {
			String A = Integer.toBinaryString(a); 
			String B = Integer.toBinaryString(b);
			while(A.length() > B.length()) {
				B = "0" + B;
			}
			while(B.length() > A.length()) {
				A = "0" + A;
			}
			System.out.println("A: " + A);
			System.out.println("B: " + B);
			int counter = 0;
			for(int i = 0; i < A.length(); i++) {
				if(A.charAt(i) != B.charAt(i)) {
					counter++;
				}
			}
			return counter;
		}
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader(new File("hamming.in")));
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
