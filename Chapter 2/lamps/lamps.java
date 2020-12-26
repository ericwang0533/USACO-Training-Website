/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: lamps
*/
import java.util.*;
import java.io.*;
public class lamps {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt(), c = in.nextInt();
	public static ArrayList<Integer> on = new ArrayList<Integer>(), off = new ArrayList<Integer>();
	public static ArrayList<String> ans = new ArrayList<String>();
//	public static PrintWriter out;
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new FileWriter(new File("lamps.out")));
		
		input();
		int[] flips = new int[n];
		Arrays.fill(flips, 1);
		// 1 means its ON
		if(c < 4) {
			simulate(c, flips, 0);
		}
		else {
			simulate(4, flips, 0);
		}
		
		
		if(ans.size() == 0) {
			out.println("IMPOSSIBLE");
		}
		else {
			Collections.sort(ans);
			for(int i = 0; i < ans.size(); i++) {
				out.println(ans.get(i));
			}
		}
		out.close();
	}
	
	public static void simulate(int num, int [] flips, int curr) {
		// TODO Auto-generated method stub
//		System.out.println("num: " + num + " | curr: " + curr);
//		for(int i = 0; i < n; i++) { 
//			System.out.print(flips[i] + " "); 
//		}
//		System.out.println();
		if(num == curr) {
			// call check w/ flips
			check(flips);
			
			 
			return;
		}
		
		int[] all = new int[n];
		int[] odd = new int[n];
		int[] even = new int[n];
		int[] three = new int[n];
		for(int i = 0; i < n; i++) {
			all[i] = flips[i]+1;
			if(i%2 == 0) {
				odd[i] = flips[i];
				even[i] = flips[i]+1;
			}
			else {
				odd[i] = flips[i]+1;
				even[i] = flips[i];
			}
			
			if(i%3 == 0) {
				three[i] = flips[i]+1;
			}
			else {
				three[i] = flips[i];
			}
			
			
		}
		
		simulate(num, all, curr+1);
		simulate(num, odd, curr+1);
		simulate(num, even, curr+1);
		simulate(num, three, curr+1);
	}

	public static void check(int[] flips) {
		// TODO Auto-generated method stub
		for(int i = 0; i < on.size(); i++) {
			if(flips[on.get(i)-1]%2 == 0) {
				return;
			}
		}
		
		for(int i = 0; i < off.size(); i++) {
			if(flips[off.get(i)-1]%2 == 1) {
				return;
			}
		}
		
		String add = "";
		for(int i = 0; i < flips.length; i++) {
			add += flips[i]%2;
		}
		
		if(!ans.contains(add)) {
			ans.add(add);
			//out.println(add);
		}
		
	}

	public static void input() {
		// TODO Auto-generated method stub
		int next = in.nextInt();
		while(next != -1) {
			on.add(next);
			next = in.nextInt();
		}
		
		int next1 = in.nextInt();
		while(next1 != -1) {
			off.add(next1);
			next1 = in.nextInt();
		}
		
		/*
		 * for(int i = 0; i < on.size(); i++) { System.out.println(on.get(i)); }
		 * System.out.println(); for(int i = 0; i < off.size(); i++) {
		 * System.out.println(off.get(i)); }
		 */
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader(new File("lamps.in")));
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
