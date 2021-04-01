/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: prefix
*/
import java.util.*;
import java.io.*;
public class prefix1 {
	public static FastReader in = new FastReader();
//	public static String[] prefixes;
	public static ArrayList<String> prefixes = new ArrayList<String>();
	public static String sequence = "";
	public static StringBuilder sequence1 = new StringBuilder();
	public static int ans = 0;
	public static PrintWriter out;
	public static boolean[] visited;
	public static ArrayList<Integer> toVisit = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new FileWriter(new File("prefix.out")));
		input();
		solve(0);
		while(!toVisit.isEmpty()) {
			solve(toVisit.get(0));
		}
		
		out.println(ans);
		out.close();
	} 
	
	public static void solve(int index) {
		//System.out.println(index);
		ans = Math.max(ans, index);
		
		if(!toVisit.isEmpty()) {
			toVisit.remove(0);
		}
		
		
		if(index == sequence.length()) {
			out.println(ans);
			out.close();
			System.exit(0);
			//return;
		}
//		if(visited[index]) {
//			return;
//		}
//		else {
//			visited[index] = true;
//		}
		
//		for(int i = 0; i < prefixes.length; i++) {
//			if(sequence.startsWith(prefixes[i], index)) {
//				if(visited[index+prefixes[i].length()]) {
//					continue;
//				}
//				visited[index+prefixes[i].length()] = true;
//				toVisit.add(index+prefixes[i].length());
//				//solve(index+prefixes[i].length());
//			}
//		}
		for(int i = 0; i < prefixes.size(); i++) {
			if(sequence.startsWith(prefixes.get(i), index)) {
				if(visited[index+prefixes.get(i).length()]) {
					continue;
				}
				visited[index+prefixes.get(i).length()] = true;
				toVisit.add(index+prefixes.get(i).length());
				//solve(index+prefixes[i].length());
			}
		}
//		Collections.sort(toVisit, Comparator.reverseOrder());
	}
	
	public static void input() {
//		System.out.println("test");
		// TODO Auto-generated method stub
//		String temp = "";
		String line;// = in.nextLine();
//		while((line = in.nextLine()).length() != 1) {
//			//System.out.println(line);
//			temp += line + " "; //.split(" ");
//			//line = in.nextLine();
//		}
//		prefixes = temp.split(" ");
		
		while(!(line = in.next()).equals(".")) {
			prefixes.add(line);
		}
		
		//Arrays.sort(prefixes);
		
		//String line1 = br.readLine();
		//sequence += line;
		//line = in.nextLine();
		//System.out.println();
		//StringTokenizer st = new StringTokenizer(br.readLine());
		while((line = in.nextLine()) != null) {
			
			sequence1.append(line);
//			System.out.println(sequence);
		}
		sequence = sequence1.toString();
		visited = new boolean[sequence.length()+1];
//		System.out.println("test");
//		for(int i = 0; i < prefixes.length; i++) {
//			System.out.println(prefixes[i] + " ");
//		}
//		System.out.println(sequence);
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader(new File("prefix.in")));
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
