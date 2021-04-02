/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: nocows
*/
import java.util.*;
import java.awt.Point;
import java.io.*;
public class nocows {
	public static boolean testing = true;
	public static BufferedReader br; public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static PrintWriter out;
	public static int n = in.nextInt(), k = in.nextInt();
//	public static ArrayList<Node> nodes = new ArrayList<Node>();
	public static ArrayList<Node>[] nodes = new ArrayList[k];
	
	public static void main(String[] args) throws IOException{
		out = (testing) ? new PrintWriter(System.out) : new PrintWriter(new FileWriter(new File("nocows.out")));
		
//		dbg(n + " " + k);
		rc();
		
		out.close();
	}
	
	public static void rc() {
		// TODO Auto-generated method stub
		Queue q = new LinkedList<>();
		q.add(0);
		while(!q.isEmpty()){
			
		}
	}

	static class Node{
		public Point pt;
		public Node parent;
		public Node(int x, int y, Node parent) {
			pt = new Point(x, y);
			this.parent = parent;
		}
		
		public String toString() {
			return pt.x + " " + pt.y + " " + parent.toString();
		}
	}
	
	static class FastReader{
		public FastReader(){
			try {
				br = (testing) ? new BufferedReader(new FileReader(new File("Chapter 2/second attempt/nocows/nocows.in"))) : new BufferedReader(new FileReader(new File("nocows.in")));
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
