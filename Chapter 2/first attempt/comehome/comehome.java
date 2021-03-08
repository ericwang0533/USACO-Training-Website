/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: comehome
*/
import java.util.*;
import java.io.*;
public class comehome {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();

	public static int n = in.nextInt();
	public static int ans = Integer.MAX_VALUE;
	public static int charAns = 0;
	public static Node[] nodes = new Node[52];
	
//	public static ArrayList<Node> nodes = new ArrayList<Node>();
//	public static Node barn = new Node(26);
//	public static Node[] lowercase = new Node[26];
//	public static ArrayList<Integer> cows = new ArrayList<Integer>();
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("comehome.out")));
		
//		char z = 'Z';
//		int z1 = z;
//		System.out.println(z1);
		
		for(int i = 0; i < 52; i++) {
			nodes[i] = new Node(i);
		}
		input();
		dijstrka();
		
		for(int i = 0; i < 25; i++) {
			if(nodes[i].distance < ans) {
				ans = nodes[i].distance;
				charAns = i;
			}
		}
		out.println(String.valueOf((char) (charAns + 65)) + " " + ans);
		
//		for(int i = 0; i < nodes.length; i++) {
//			System.out.println(nodes[i].distance);
//		}
		
		out.close();
	}
	
	public static void dijstrka() {
		// cause barn is da source
		nodes[25].distance = 0;
		
		int num_visited = 0;
		while(num_visited < nodes.length) {
			
			int mini = -1;
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < nodes.length; i++) {
				if(!nodes[i].visited && nodes[i].distance < min) {
					min = nodes[i].distance;
					mini = i;
				}
			}
			
			if(mini == -1) {
				break;
			}
			
			nodes[mini].visited = true;
//			System.out.println("mini: " + mini);
			
			// check which to RELAX
			for(int i = 0; i < nodes[mini].edges.size(); i++) {
				Edge edge = nodes[mini].edges.get(i);
				if(nodes[mini].distance + edge.weight < nodes[edge.destination].distance) {
					nodes[edge.destination].distance = nodes[mini].distance + edge.weight;
				}
			}
			
			
			num_visited++;
		}
		// find the next min unvisited node
		
	}
	
	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
			int first = in.next().charAt(0) - 65;
			int second = in.next().charAt(0) - 65;
			
			if(first >= 26) {
				first -= 6;
			}
			if(second >= 26) {
				second -= 6;
			}
			
//			System.out.println(first + " " + second);
			
//			if(second < first) {
//				int temp = first;
//				first = second;
//				second = temp;
//			}
			
			
			
			
			int weight = in.nextInt();
			
			nodes[first].edges.add(new Edge(weight, second));
			nodes[second].edges.add(new Edge(weight, first));
			
//			System.out.println(first + " " + second + " " + weight);
			
//			if(first >= 65 && first <= 89) {
//				// uppercase not Z?
//				nodes.add(new Node(first-65, new Edge(weight, second-97)));
//			}
//			else if(first == 90) {
//				// barn or Z?
//				barn.edges.add(new Edge(weight, second-97));
//			}
//			else {
//				// lowercase?
//				lowercase[first-97].edges.add(new Edge(weight, second-97));
//			}
			
//			if(first.matches("[A-Y]") ) {
//				// node
//				nodes.add(new Node(first, new Edge(weight, second)));
//				
//			}
//			else if(first.equals("Z")) {
//				// da barn
//				barn.edges.add(new Edge(weight, second));
//			}
//			else {
//				// lowercase
//				
//			}
		}
	
		// dbg
//		for(int i = 0; i < nodes.length; i++) {
//			System.out.println(nodes[i].start);
//			for(int j = 0; j < nodes[i].edges.size(); j++) {
//				System.out.println(nodes[i].edges.get(j).destination + " : " + nodes[i].edges.get(j).weight);
//			}
//		}
		
//		for(int i = 0; i < lowercase.length; i++) {
//			System.out.println(lowercase[i].start);
//			for(int j = 0; j < lowercase[i].edges.size(); j++) {
//				System.out.println(lowercase[i].edges.get(j).pasture + " : " + lowercase[i].edges.get(j).weight);
//			}
//		}
//		
//		System.out.println(barn.start);
//		for(int j = 0; j < barn.edges.size(); j++) {
//			System.out.println(barn.edges.get(j).pasture + " : " + barn.edges.get(j).weight);
//		}
	}

	static class Edge{
		int weight;
		int destination;
		
		public Edge(int weight, int destination) {
			this.weight = weight;
			this.destination = destination;
		}
	}
	
	static class Node{
		int start;
		int distance;
		boolean visited;
		List<Edge> edges = new ArrayList<Edge>();
	
		public Node(int start) {
			this.start = start;
			distance = Integer.MAX_VALUE;
			visited = false;
		}
		
		public Node(int start, Edge edge) {
			this.start = start;
			distance = Integer.MAX_VALUE;
			edges.add(edge);
			visited = false;
		}
	}		
	
	static class FastReader{
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("comehome.in"));
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
