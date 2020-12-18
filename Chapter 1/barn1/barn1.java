/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: barn1
*/
import java.util.*;
import java.io.*;

public class barn1 {
	public static FastReader in = new FastReader();
	public static int m = in.nextInt();
	public static int s = in.nextInt();
	public static int c = in.nextInt();
	public static int[] arr = new int[m-1];
	public static int[] brr = new int[c];
	public static int start1;
	public static int end1;
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		
		if(c <= m) {
			out.println(c);
		}
		else {
			for(int i = 0; i < c; i++) {
				brr[i] = in.nextInt();
			}
			Arrays.sort(brr);
			
			gaps();
			int ans = 0;
			for(int i = 0; i < m-1; i++) {
				ans += arr[i] - 1;
				System.out.println(arr[i]);
			}
			out.println(end1-start1+1-ans);
		}
		
		out.close();
	}
	
	public static void gaps() {
		int start = brr[0];
		start1 = start;
		int prev = start;
		int gap = 0;
		for(int i = 0; i < c-1; i++) {
			int curr = brr[i+1];
			if(curr != prev + 1) {
				//gap
				gap = curr - prev;
				System.out.println("curr: " + curr + " | prev: " + prev + " | gap: " + gap);
			}
			//else {
				//no gap
				if(gap != 0) {
					//need to check maxes
					System.out.println("yay");
					for(int j = 0; j < m-1; j++) {
						if(gap > arr[j]) {
							int temp = arr[j];
							arr[j] = gap;
							gap = temp;
						}
					}
					
				}
				gap = 0;
			//}
			
			prev = curr;
		}
		if(gap != 0) {
			//need to check maxes
			for(int j = 0; j < m-1; j++) {
				if(gap > arr[j]) {
					int temp = arr[j];
					arr[j] = gap;
					gap = temp;
				}
			}
			
		}
		end1 = prev;
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("barn1.in"));
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
