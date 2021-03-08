/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: cowtour
*/
import java.util.*;
import java.awt.Point;
import java.io.*;
import java.text.DecimalFormat;
public class cowtourConsole {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static Node[] nodes = new Node[n];
	public static List<Integer> first = new ArrayList<Integer>(), second = new ArrayList<Integer>();
	public static double max_second = 0;
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(System.out);//new BufferedWriter(new FileWriter("cowtour.out")));
		
		input();
		initial_dijsktra();
		
		// add to proper list
		for(int i = 0; i < n; i++) {
//			System.out.println(nodes[i].distance);
			if(nodes[i].distance == Double.MAX_VALUE) {
				second.add(i);
				System.out.println("Infinity");
				continue;
			}
			first.add(i);
			System.out.println(nodes[i].distance);
		}
		
//		for(int i = 0; i < first.size(); i++) {
//			System.out.println("1: " + first.get(i));
//		}
//		for(int i = 0; i < second.size(); i++) {
//			System.out.println("2: " + second.get(i));
//		}
		
		// find dist between the each "the new bride"
		double min = Double.MAX_VALUE;
		int first_node = -1;
		int second_node = -1;
		for(int i = 0; i < first.size(); i++) {
			for(int j = 0; j < second.size(); j++) {
				// check distance between these two nodes
				double dist = nodes[first.get(i)].point.distance(nodes[second.get(j)].point);
				if(dist < min) {
//					System.out.println("first: " + nodes[first.get(i)].point + " | second: " + nodes[second.get(j)].point);
//					System.out.println("i: " + i + " | j: " + j);
					min = dist;
					first_node = nodes[first.get(i)].index;
					second_node = nodes[second.get(j)].index;
				}
			}
		}
		
//		System.out.println("first_node (i): " + first_node);
//		System.out.println("second_node (j): " + second_node);
		System.out.println("min: " + min + " | firstnode: " + nodes[first_node].point + " | secondnode: " + nodes[second_node].point);
		
		// reset the visited stuff in second i think, reset it all just cause why not
		for(int i = 0; i < second.size(); i++) {
			nodes[second.get(i)].visited = false;
			nodes[second.get(i)].distance = Double.MAX_VALUE;
		}
		secondary_dijsktra(nodes[second_node]);
		
		//dbg
		for(int i = 0; i < second.size(); i++) {
//			System.out.println(nodes[second.get(i)].point);
//			if(nodes[second.get(i)].distance == Double.MAX_VALUE) {
//				System.out.println("Infinity");
//				continue;
//			}
//			System.out.println(nodes[second.get(i)].distance);
			
			if(nodes[second.get(i)].distance > max_second) {
				max_second = nodes[second.get(i)].distance;
			}
		}
		
		double ans = nodes[first_node].distance + max_second + min;
//		System.out.println("first_node: " + first_node + " | distance: " + nodes[first_node].distance);
		
		DecimalFormat f = new DecimalFormat("##.000000");
		String formattedValue = f.format(ans);
		
//		ans = Math.round(ans*1000000.0)/1000000.0;
		out.println(formattedValue);
		
		out.close();
	}
	
	public static void initial_dijsktra() {
		// TODO Auto-generated method stub
		nodes[0].distance = 0;
		
		int numVisited = 0;
		while(numVisited < nodes.length) {
			// to find the next unvisited node with min distance to nodes[0] (our source)
			int mini = -1; // the node itself
			double min = Double.MAX_VALUE;
			for(int i = 0; i < nodes.length; i++) {
				if(!nodes[i].visited && nodes[i].distance < min) {
					mini = i;
					min = nodes[i].distance;
				}
			}
			
			if(mini == -1) {
				break;
			}
			
			nodes[mini].visited = true;
//			System.out.println("mini: " + mini);
			for(int i = 0; i < nodes[mini].edges.size(); i++) {
				Edge edge = nodes[mini].edges.get(i);
				// check if we need relaxation
				if(nodes[mini].distance + edge.weight < nodes[edge.destination].distance) {
//					System.out.println("i: " + i + " | nodes[mini].distance: " + nodes[mini].distance + " | edge.weight: " + edge.weight + " | nodes[edge.destination].distance: " + nodes[edge.destination].distance);
					nodes[edge.destination].distance = nodes[mini].distance + edge.weight;
					nodes[edge.destination].parent = mini;
				}
			}
			
			numVisited++;
		}
	}
	
	public static void secondary_dijsktra(Node source) {
		// TODO Auto-generated method stub
		source.distance = 0;
		
		int numVisited = 0;
		while(numVisited < second.size()) {
			// to find the next unvisited node with min distance to nodes[0] (our source)
			int mini = -1; // the node itself
			double min = Double.MAX_VALUE;
			for(int i = 0; i < second.size(); i++) {
				if(!nodes[second.get(i)].visited && nodes[second.get(i)].distance < min) {
					mini = i;
					min = nodes[second.get(i)].distance;
				}
			}
			
			if(mini == -1) {
				break;
			}
			
			nodes[second.get(mini)].visited = true;
			System.out.println(nodes[second.get(mini)].point);
			
//			System.out.println("mini: " + mini);
			for(int i = 0; i < nodes[second.get(mini)].edges.size(); i++) {
				Edge edge = nodes[second.get(mini)].edges.get(i);
				// check if we need relaxation
				if(nodes[second.get(mini)].distance + edge.weight < nodes[edge.destination].distance) {
//					System.out.println("i: " + i + " | nodes[mini].distance: " + nodes[mini].distance + " | edge.weight: " + edge.weight + " | nodes[edge.destination].distance: " + nodes[edge.destination].distance);
					nodes[edge.destination].distance = nodes[second.get(mini)].distance + edge.weight;
					nodes[edge.destination].parent = mini;
				}
			}
			
			numVisited++;
		}
	}
	
	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
			nodes[i] = new Node(in.nextInt(), in.nextInt(), i);
		}
		
		for(int i = 0; i < n; i++) {
			char[] arr = in.nextLine().toCharArray();
			for(int j = 0; j < n; j++) {
				if(arr[j] == '1') {
					nodes[i].edges.add(new Edge(j, nodes[i].point.distance(nodes[j].point)));
				}
			}
		}
		
		//dbg
//		for(int i = 0; i < n; i++) {
//			System.out.println(nodes[i].point);
//			for(int j = 0; j < nodes[i].edges.size(); j++) {
//				System.out.println(nodes[i].edges.get(j).destination + " | " + nodes[i].edges.get(j).weight);
//			}
//		}
	}

	static class Edge{
		int destination;
		double weight;
		
		public Edge(int destination, double weight) {
			this.destination = destination;
			this.weight = weight;
		}
	}
	
	static class Node{
		List<Edge> edges = new ArrayList<Edge>();
		double distance;
		int parent;
		int index;
		Point point;
		boolean visited; 
		
		public Node(int x, int y, int index) {
			point = new Point(x, y);
			this.index = index;
			visited = false;
			parent = -1;
			distance = Double.MAX_VALUE;
		}

		public Node() {
			// TODO Auto-generated constructor stub
		}
	}
	
	static class FastReader{
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));//FileReader("cowtour.in"));
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
