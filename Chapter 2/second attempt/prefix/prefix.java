/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: prefix
*/
import java.util.*;
import java.io.*;
public class prefix {
	public static boolean testing = false;
	public static BufferedReader br; public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static PrintWriter out;
	public static ArrayList<String> prims = new ArrayList<String>();
	public static StringBuilder str = new StringBuilder();
	public static Set<Integer> visited = new HashSet<Integer>();
	public static int ans = 0;
	
	public static void main(String[] args) throws IOException{
		out = (testing) ? new PrintWriter(System.out) : new PrintWriter(new FileWriter("prefix.out"));
		
		input();
//		dbg(str.length());
		rc();
		out.println(ans);
		
		out.close();
	}
	
	public static void rc() {
		// TODO Auto-generated method stub
		
		PriorityQueue pq = new PriorityQueue<Integer>(reverseComp);
		pq.add(0);
		while(!pq.isEmpty()) {
			dbg(pq);
			int pos = (int) pq.poll();
			if(visited.contains(pos)) {
				return;
			}
			visited.add(pos);
			ans = Math.max(ans, pos);
			
			for(int i = 0; i < prims.size(); i++) {
				String curr = prims.get(i);
				int end = pos + curr.length();
				if(end > str.length()) {
					break;
				}
				if(curr.equals(str.substring(pos, end))) {
					pq.add(end);
				}
			}
		}
		
	}
	
	static Comparator<Integer> reverseComp = (o1, o2) -> {
		return o2 - o1;
	};
	
	public static void input() {
		// TODO Auto-generated method stub
		String s = in.next();
		while(!s.equals(".")) {
			prims.add(s);
			s = in.next();
		}
		
		for(String test = in.nextLine(); test != null; test = in.nextLine()) {
			int len = test.length();
			if(len == 76) {				
				str.append(test.substring(0, test.length()-1));
				continue;
			}
			
			str.append(test);
		}
		dbg(prims);
		dbg(str);
		
		Collections.sort(prims, new Sort());
		dbg(prims);
	}

	static class Sort implements Comparator<String>{
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			return Integer.compare(o1.length(), o2.length());
		}
		
	}
	
	static class FastReader{
		public FastReader() {
			try {
				br = (testing) ? new BufferedReader(new FileReader(new File("Chapter 2/second attempt/prefix/prefix.in"))) : new BufferedReader(new FileReader(new File("prefix.in")));
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		public String next() {
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
		if(testing) System.out.println(obj);
	}

}
