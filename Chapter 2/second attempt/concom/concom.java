/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: concom
*/
import java.util.*;
import java.io.*;
public class concom {
	public static String fn = "concom";
	public static boolean testing = false;
	public static BufferedReader br; public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static PrintWriter out;
	public static int n = in.nextInt();
	public static company[] comps = new company[101];
	public static Set<String> ans = new TreeSet<String>();
//	public static ArrayList<Integer>[] ans = new ArrayList[101];
	
	public static void main(String[] args) throws IOException{
		out = (testing) ? new PrintWriter(System.out) : new PrintWriter(new FileWriter(fn+".out"));
		
		input();
		solve();
		
		Iterator itr = ans.iterator();
		while(itr.hasNext()) {
			out.println(itr.next());
		}
		
		out.close();
	}
	
//	static class stringBuilderSort implements Comparator<StringBuilder>{
//		public int compare(StringBuilder o1, StringBuilder o2) {
//			// TODO Auto-generated method stub
//			if(o1.) {
//				
//			}
//			return 0;
//		}
//	}
	
	private static void solve() {
		// TODO Auto-generated method stub
//		dbg(comps[1].childs.values());
		for(int i = 1; i < comps.length; i++) {
			company curr = comps[i];
//			ans[i] = new ArrayList<Integer>();
			for(Map.Entry<Integer, Integer> set : curr.childs.entrySet()) {
				dbg(set.getValue() + " " + set.getKey());
				if(set.getValue() <= 50) {
					continue;
				}
				
				ans.add(i + " " + set.getKey());
				for(int j = 0; j < curr.parents.size(); j++) {
					ans.add(curr.parents.get(j) + " " + set.getKey());
				}
//				ans[i].add(set.getKey());
			}
		}
		
		dbg(ans);
	}

	public static void input() {
		// TODO Auto-generated method stub
		
		for(int i = 1; i < 101; i++) {
			comps[i] = new company(i);
		}
		
		for(int i = 0; i < n; i++) {
			int num = in.nextInt();
			int sec = in.nextInt();
			int much = in.nextInt();
			comps[num].childs.put(sec, much);
			if(much > 50) {
				comps[sec].parents.add(num);
				for() {
					
				}
			}
//			comps[num] = new company(num, in.nextInt(), in.nextInt());
		}
		
//		for(int i = 0; i < n; i++) {
//			int num = in.nextInt();
//			int sec = in.nextInt();
//			int much = in.nextInt();
//			company curr = comps[num];
//			int alr = (curr.childs.get(sec) == null) ? 0 : curr.childs.get(sec);
//			if(alr > 50) {
//				continue;
//			}
//			
//			curr.childs.put(sec, alr + much);
//			if(alr + much > 50) {
//				comps[sec].parents.add(num);
//			}
////			comps[num] = new company(num, in.nextInt(), in.nextInt());
//		}
		
//		dbg(Arrays.toString(comps));
		for(int i = 1; i < 4; i++) {
			dbg(comps[i]);
		}
	}

	static class company{
		// childs -> i own x% in this comp
		// parents -> i am (fully) owned by this comp
		public HashMap<Integer, Integer> childs = new HashMap<>();
		public ArrayList<Integer> parents = new ArrayList<Integer>();
		public int ind;
//		public company(int i, int second, int much) {
//			ind = i;
//			childs.put(second, much);
//		}
		
		public company(int i) {
			ind = i;
		}
		
		public String toString() {
			return ind + ": " + childs + " | " + parents;
		}
	}
	
	static class FastReader{
		public FastReader() {
			try {
				br = (testing) ? new BufferedReader(new FileReader("Chapter 2/second attempt/"+fn+"/"+fn+".in")) : new BufferedReader(new FileReader(fn+".in"));
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
		if(testing) {
			System.out.println(obj);
		}
	}
}
