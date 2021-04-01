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
	public static boolean debug = false, testing = false;
	public static BufferedReader br; public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static PrintWriter out;
	public static int n = in.nextInt();
	public static int c = in.nextInt();
//	public static ArrayList<Integer> on = new ArrayList<Integer>(), off = new ArrayList<Integer>();
	public static Set<Integer> on = new HashSet<Integer>(), off = new HashSet<Integer>();
	public static SortedSet<int[]> ans = new TreeSet<int[]>(new intComparator());
	public static Set<boolean[]> visited = new HashSet<boolean[]>();
	
	
	public static void main(String[] args) throws IOException{
		out = (testing) ? new PrintWriter(System.out) : new PrintWriter(new FileWriter("lamps.out"));

		input();
		rc(0, new boolean[] {true, true, true, true, true, true}, new ArrayList<Integer>()); //recursion
		output();
		
//		dbg(Arrays.deepToString(ans.toArray()));
		out.close();
	}
	
	public static void output() {
		// TODO Auto-generated method stub
		if(ans.size() == 0) {
			out.println("IMPOSSIBLE");
			return;
		}
		
		Iterator itr = ans.iterator();
		while(itr.hasNext()) {
			int[] arr = (int[]) itr.next();
//			dbg(Arrays.toString(arr));
			// replaces \[ or [ and \] or ] and \, or , and blanks
			String str = Arrays.toString(arr).replaceAll("\\[|\\]|\\,| ", "");
			
			StringBuilder builder = new StringBuilder(101);
			while (builder.length() < n) {
			    builder.append(str);
			}
			builder.setLength(n);
//			String result = builder.toString();
//			dbg(str);
			out.println(builder);
		}
	}

	public static void rc(int count, boolean[] arr, ArrayList<Integer> prevs) {
		// TODO Auto-generated method stub
		// true = on, false = off
		
		
		if(count == c || count == 6) {
			check(arr);
			return;
		}
		
		if(visited.contains(arr)) {
			return;
		}
		visited.add(arr);
		
		// BIG NOTE, ADDING COPY TTOOK MORE TIME :| was unneccessary :)
		if(!prevs.contains(1)) {			
			// but1 toggle all
			ArrayList<Integer> copy = (ArrayList<Integer>) prevs.clone(); copy.add(1);
			rc(count+1, new boolean[] {!arr[0], !arr[1], !arr[2], !arr[3], !arr[4], !arr[5]}, copy);
		}
		if(!prevs.contains(2)) {
			// but2 toggle odd
//			prevs.add(2);
			ArrayList<Integer> copy = (ArrayList<Integer>) prevs.clone(); copy.add(1);
			rc(count+1, new boolean[] {arr[0], !arr[1], arr[2], !arr[3], arr[4], !arr[5]}, copy);
		}
		if(!prevs.contains(3)) {
			// but3 toggle even
//			prevs.add(3);
			ArrayList<Integer> copy = (ArrayList<Integer>) prevs.clone(); copy.add(1);
			rc(count+1, new boolean[] {!arr[0], arr[1], !arr[2], arr[3], !arr[4], arr[5]}, copy);			
		}
		if(!prevs.contains(4)) {
			// but4 toggle 3rd
//			prevs.add(4);
			ArrayList<Integer> copy = (ArrayList<Integer>) prevs.clone(); copy.add(1);
			rc(count+1, new boolean[] {!arr[0], arr[1], arr[2], !arr[3], arr[4], arr[5]}, copy);			
		}
		
	}

	public static void check(boolean[] arr) {
		// TODO Auto-generated method stub
		// do magic to check if it works and add to a hashset
		
		Iterator itr = on.iterator();
		while(itr.hasNext()) {
			int num = (int) itr.next() - 1;
			if(!arr[num]) {
				return;
			}
		}
		
		Iterator itr1 = off.iterator();
		while(itr1.hasNext()) {
			int num = (int) itr1.next() - 1;
			if(arr[num]) {
				return;
			}
		}
		
//		dbg(Arrays.toString(arr));
		int[] arr1 = new int[6];
		for(int i = 0; i < 6; i++) {
			if(arr[i]) {
				arr1[i] = 1;
			}
		}
		ans.add(arr1);
	}

	public static void input() {
		// TODO Auto-generated method stub
		int a = in.nextInt();
		while(a != -1) {
			a%=6;
			if(a == 0) {
				a = 6;
			}
			on.add(a);
			a = in.nextInt();
		}
		
		int b = in.nextInt();
		while(b != -1) {
			b%=6;
			if(on.contains(b)) {
				out.println("IMPOSSIBLE");
				out.close();
				System.exit(0);
			}
			if(b == 0) {
				b = 6;
			}
			off.add(b);
			b = in.nextInt();
		}
		
		dbg(on);
		dbg(off);
	}
	
	static class intComparator implements Comparator<int[]>{
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			for(int i = 0; i < 6; i++) {
				if(o1[i] < o2[i]) {
					return -1;
				}
				else if(o1[i] > o2[i]) {
					return 1;
				}
			}
			return 0;
		}
		
	}
	
	static class FastReader{
		public FastReader() {
			try {
				br = (testing) ? new BufferedReader(new FileReader(new File("Chapter 2/second attempt/lamps/lamps.in"))) : new BufferedReader(new FileReader(new File("lamps.in")));
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
		if(debug) System.out.println(obj);
	}
}
