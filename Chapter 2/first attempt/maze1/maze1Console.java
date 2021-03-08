/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: maze1
*/
import java.util.*;

import java.io.*;
public class maze1Console {
	
	static char [][] grid;
	static int N;
	static int H;
	static int[] x = {1, -1, 0, 0};
	static int[] y = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);//new File("maze1.in"));
		PrintWriter pw = new PrintWriter(System.out);//new File("maze1.out"));
		N = in.nextInt();
		H = in.nextInt();
		String throwaway = in.nextLine();
		grid = new char[2 * H + 1][2 * N + 1];
		for(int i = 0; i < 2 * H + 1; i++) {
			String s = in.nextLine();
			while(s.length() < 2 * N + 1) s += " ";
			char [] arr = s.toCharArray();
			grid[i] = arr;
		}
		
		
		
		in.close();
		/* for(char [] c : grid) {
			for(char ch : c) System.out.print(ch + " ");
			System.out.println();
		} */
		
		int exit1x = -1;
		int exit1y = -1;
		int exit2x = -1;
		int exit2y = -1;
		
		for(int i = 0; i <= 2 * N; i++) {
		    for(int j = 0; j <= 2 * H; j++) {
		        if(grid[j][i] == ' ' && isEdge(j, i)) {
		            if(exit1x == -1) {
		                exit1x = i; 
		                exit1y = j;
		            }
		            else {
		                exit2x = i; 
		                exit2y = j;
		            }
		        }
		    }
		}
		
		System.out.println(exit1x + " " + exit1y);
		System.out.println(exit2x + " " + exit2y);
		
		int maxdist = 0;
		
		int [][] dist1 = bfs(exit1x, exit1y);
		
		for(int i = 0; i < dist1.length; i++) {
			System.out.println(Arrays.toString(dist1[i]));
		}
		System.out.println();
		int [][] dist2 = bfs(exit2x, exit2y);
		for(int i = 0; i < dist2.length; i++) {
			System.out.println(Arrays.toString(dist2[i]));
		}
		
		for(int i = 1; i <= 2 * N; i += 2) {
		    for(int j = 1; j <= 2 * H; j += 2) {
		        maxdist = Math.max(maxdist, Math.min(dist1[j][i], dist2[j][i]));
		    }
		}
		
		pw.println(maxdist / 2 + 1);
		
		pw.close();
	}
	
	public static boolean isEdge(int x, int y) {
	    return x == 0 || x == 2 * H || y == 0 || y == 2 * N;
	}
	
	public static boolean isBounded(int x, int y) {
	    return x >= 0 && x <= 2 * H && y >= 0 && y <= 2 * N;
	}
	
	public static int[][] bfs(int srcx, int srcy) {
	    Queue <Coor> q = new LinkedList <Coor> ();
	    boolean [][] visited = new boolean[2 * H + 1][2 * N + 1];
	    q.add(new Coor(srcx, srcy));
	    visited[srcy][srcx] = true;
	    int [][] dist = new int[2 * H + 1][2 * N + 1];
	    
	    while(! q.isEmpty()) {
	        Coor c = q.remove();
	        for(int i = 0; i < 4; i++) {
	            int xcoor = c.x + x[i];
	            int ycoor = c.y + y[i];
	            if(isBounded(ycoor, xcoor) && grid[ycoor][xcoor] == ' ' && ! visited[ycoor][xcoor]) {
	                visited[ycoor][xcoor] = true;
	                q.add(new Coor(xcoor, ycoor));
	                dist[ycoor][xcoor] = dist[c.y][c.x] + 1;
	            }
	        }
	    }
	    
	    /* for(int [] row : dist) {
	        for(int c : row) System.out.print(c + " ");
	        System.out.println();
	    }
	    
	    System.out.println(); */
	    return dist;
	}

	static class Coor {
	    
	    public int x;
	    public int y;
	    
	    public Coor(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
	}
}



//public class maze1Console {
//    public static void main(String[] args) throws Exception {
//        // set startTime to measure how long the program takes
//        long startTime = System.currentTimeMillis();
//
//        // create input BufferedReader from file
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //FileReader("maze1.in"));
//        StringTokenizer l = new StringTokenizer(br.readLine());
//        int W = Integer.parseInt(l.nextToken());
//        int H = Integer.parseInt(l.nextToken());
//        Node[] graph = new Node[W * H];
////        System.out.println(W+" "+H);
////        for (int i = 0; i < W; i++) {
////            for (int j = 0; j < H; j++) {
////                 System.out.println(j * W + i);
////                graph[j * W + i] = new Node();
////            }
////        }
//        for(int i = 0; i < graph.length; i++) {
//        	graph[i] = new Node();
//        }
////        Arrays.fill(graph, new Node());
////        for(int i = 0 ; i < graph.length; i++) {
////        	System.out.println(graph[i].visited);
////        }
//        char[][] input = new char[2 * H + 1][2 * W + 1];
//        for (int i = 0; i < 2 * H + 1; i++) {
//            input[i] = br.readLine().toCharArray();
//        }
//        
//        System.out.println("   01234567890");
//        for(int i = 0; i < input.length; i++) {
//        	System.out.print(i + ": ");
//        	for(int j = 0; j < input[i].length; j++) {
//        		System.out.print(input[i][j]);
//        	}
//        	System.out.println();
//        }
//        
//        for (int i = 1; i < 2 * W + 1; i += 2) {
//            for (int j = 1; j < 2 * H + 1; j += 2) {
//                if (!(input[j][i] == ' ')) {
//                    break;
//                }
//                System.out.println("i: " + i + " | j: " + j );
//                int x = (i - 1) / 2;
//                int y = (j - 1) / 2;
//                int num = y * W + x;
//                //List<Integer> temp = new ArrayList<>();
//                 System.out.println(y + " " + x + " " + num);
//                if (x > 0 && input[j][i - 1] == ' ' && num - 1 >= 0) {
//                    graph[num].edges.add(new Edge(y*W+x-1, 1));
//                }
//                if (x < W-1 && input[j][i + 1] == ' ' && num + 1 < W * H) {
//                    graph[num].edges.add(new Edge(y*W+x+1, 1));
//                }
//                if (y > 0 && input[j - 1][i] == ' ' && num - W >= 0) {
//                    graph[num].edges.add(new Edge((y-1)*W+x, 1));
//                }
//                if (y < H-1 && input[j + 1][i] == ' ' && num + W < W * H) {
//                    graph[num].edges.add(new Edge((y+1)*W+x, 1));
//                }
//            }
//        }
//        
//        for(int i = 0; i < graph.length; i++) {
//        	System.out.println(i);
//        	for(int j = 0; j < graph[i].edges.size(); j++) {
//        		System.out.println("destination: " + graph[i].edges.get(j).destination + " | weight: " + graph[i].edges.get(j).weight);
//        	}
//        }
//
//        List<Integer> ends = new ArrayList<>();
//        for (int i = 0; i < W; i++) {
//            for (int j = 0; j < H; j++) {
//                 System.out.print("\n" + i + " " + j + " \t\t");
//                for (int k = 0; k < graph[j * W + i].edges.size(); k++) {
//                    int temp = graph[j * W + i].edges.get(k).destination;
//                    int x = temp % W;
//                    int y = temp / W;
//                     System.out.print((j*W+i)+" "+x + " " + y + "\t" + graph[j * W + i].edges.get(k).weight + " \t\t");
//                }
//                if (j == 0 && input[0][i * 2 + 1] == ' ') {
//                    ends.add(j * W + i);
//                     System.out.println(i+" "+j);
//                }
//                if (j == H - 1 && input[2 * H][i * 2 + 1] == ' ') {
//                    ends.add(j * W + i);
//                     System.out.println(i+" "+j);
//                }
//                if (i == 0 && input[j * 2 + 1][0] == ' ') {
//                    ends.add(j * W + i);
//                     System.out.println(i+" "+j);
//                }
//                if (i == W - 1 && input[j * 2 + 1][2 * W] == ' ') {
//                    ends.add(j * W + i);
//                     System.out.println(i+" "+j);
//                }
//            }
//        }
//        int[] distances = new int[(W + 1) * (H + 1)];
//        Arrays.fill(distances, -1);
//        for (int e = 0; e < ends.size(); e++) {
//            int x = ends.get(e) % W;
//            int y = ends.get(e) / W;
//            System.out.println(x + " " + y);
//            Node end = graph[ends.get(e)];
//            Node[] temp = new Node[(W + 1) * (H + 1)];
//            temp = dijkstra(graph, end);
//
//            for (int i = 0; i < temp.length; i++) {
//                if (i==328) {
//                    int t = 328;
//                    System.out.print(i);
//                    while (temp[t].distance > 0) {
//                        int x1 = t % W;
//                        int y1 = t / W;
//                        t = temp[t].parent;
//                        int x2 = t % W;
//                        int y2 = t / W;
//                        if (x2-x1>1 || y2-y1>1) 
//                        System.out.print("\t\t" + x1+" "+y1+" "+ x2+" "+y2+" "+(x2 - x1) + " " + (y2 - y1));
//                    }
//                    System.out.println();
//                }
//                // System.out.println(ends.get(e)+"\t"+i+"\t"+temp[i].distance+"\t"+distances[i]);
//                if (distances[i] == -1 || temp[i].distance < distances[i]) {
//                    distances[i] = temp[i].distance;
//                }
//            }
//            for (int i = 0; i < graph.length; i++) {
//                graph[i].reset();
//            }
//        }
//        int max = 0;
//        for (int i = 0; i < W; i++) {
//            for (int j = 0; j < H; j++) {
//                 System.out.println(i + " " + j + "\t" + distances[j * W + i]);
//                if (distances[j * W + i] > max) {
//                    max = distances[j * W + i];
//                }
//            }
//        }
//        // create PrintWriter to output results
//        PrintWriter out = new PrintWriter(System.out);//new BufferedWriter(new FileWriter("maze1.out")));
//        out.println(max + 1);
//        out.close();
//        // print final time taken
//        System.out.println(System.currentTimeMillis() - startTime);
//    }
//
//    public static Node[] dijkstra(Node[] nodes, Node source) {
//        // distance(j) is distance from source vertex to vertex j
//        // parent(j) is the vertex that precedes vertex j in any shortest path (to
//        // reconstruct the path subsequently)
//
//        source.distance = 0;
//        source.parent = -1;
//
//        int numVisited = 0;
//        while (numVisited < nodes.length) {
//            // find unvisited vertex with min distance to source; call it vertex i
//            int mini = 0;
//            int min = Integer.MAX_VALUE;
//            for (int i = 0; i < nodes.length; i++) {
//                 System.out.println(i);
//                if (!nodes[i].visited && nodes[i].distance < min) {
//                    mini = i;
//                    min = nodes[i].distance;
//                }
//            }
//            nodes[mini].visited = true;
//
//            for (int i = 0; i < nodes[mini].edges.size(); i++) {
//                Edge edge = nodes[mini].edges.get(i);
//                 System.out.println(mini+" "+edge.destination);
//                if (nodes[mini].distance + edge.weight < nodes[edge.destination].distance) {
//                    nodes[edge.destination].distance = nodes[mini].distance + edge.weight;
//                    nodes[edge.destination].parent = mini;
//                }
//            }
//            numVisited++;
//        }
//        return nodes;
//    }
//
//    public static class Edge {
//        int destination;
//        int weight;
//
//        public Edge(int destination, int weight) {
//            this.destination = destination;
//            this.weight = weight;
//        }
//    }
//
//    public static class Node {
//        int distance;
//        boolean visited;
//        int parent;
//        List<Edge> edges = new ArrayList<>();
//
//        public Node(int distance, boolean visited, int parent) {
//            this.distance = distance;
//            this.visited = visited;
//            this.parent = parent;
//        }
//
//        public Node() {
//            this.distance = Integer.MAX_VALUE;
//            this.visited = false;
//            this.parent = -1;
//        }
//
//        public void reset() {
//            this.distance = Integer.MAX_VALUE;
//            this.visited = false;
//            this.parent = -1;
//        }
//    }
//}



//public class maze1Console {
//	public static BufferedReader br;
//	public static StringTokenizer st;
//	public static FastReader in = new FastReader();
//	public static int w = in.nextInt(), h = in.nextInt();
//	public static String[][] wall = new String[(2 * h) + 1][(2 * w) + 1];
//	public static int[][] stepArr = new int[(2 * h) + 1][(2 * w) + 1];
//	public static int ans = 0;
//	public static PrintWriter out;
//	
//	public static void main(String[] args) throws IOException{
//		out = new PrintWriter(System.out);//new BufferedWriter(new FileWriter("maze1.out")));
//		
//		input();
////		System.out.println(wall[0][1].equals(" "));
//		for(int i = 0; i < (2*h)+1; i++) {
//			for(int j = 0; j < (2*w)+1; j++) {
//				if(wall[i][j].equals(" ")) {
//					stepArr[i][j] = flood_fill(i, j, 0, i, j);
//				}
//			}
//		}
//		
//		for(int i = 0; i < (2*h)+1; i++) {
//			System.out.println(Arrays.toString(stepArr[i]));
//		}
//		
//		out.close();
//	}
//	
//	public static int flood_fill(int x, int y, int steps, int prevx, int prevy) {
//		// TODO Auto-generated method stub
//		System.out.println("x: " + x + " | y: " + y + " | steps: " + steps + " | prevx: " + prevx + " | prevy: " + prevy);
//		
//		// check if its an EXIT
//		if(x == (2 * h) || x == 0 || y == 0 || y == (2 * w)) {
//			return 0;
//		}
////		if((x+1 == (2 * h) && wall[x+1][y].equals(" ")) || (x-1 == 0 && wall[x-1][y].equals(" ")) || (y-1 == 0 && wall[x][y-1].equals(" ")) || (y+1 == (2 * w) && wall[x][y+1].equals(" "))) {
////			return 0;
////		}
//		
//		// check the four sides
////		if(x-2 > -1 && wall[x-2][y].equals(" ") && (x-2 != prevx || y != prevy)) {
////			return 1 + flood_fill(x-2, y, steps+1, x, y);
////		}
////		if(x+2 <= (2*h) && wall[x+2][y].equals(" ") && (x+2 != prevx || y != prevy)) {
////			return 1 + flood_fill(x+2, y, steps+1, x, y);
////		}
////		if(y+2 <= (2*w) && wall[x][y+2].equals(" ") && (x != prevx || y+2 != prevy)) {
////			return 1 + flood_fill(x, y+2, steps+1, x, y);
////		}
////		if(y-2 > -1 && wall[x][y-2].equals(" ") && (x != prevx || y-2 != prevy)) {
////			return 1 + flood_fill(x, y-2, steps+1, x, y);
////		}
//		
//		if(wall[x-1][y].equals(" ") && (x-1 != prevx || y != prevy)) {
//			return 1 + flood_fill(x-1, y, steps+1, x, y);
//		}
//		if(wall[x+1][y].equals(" ") && (x+1 != prevx || y != prevy)) {
//			return 1 + flood_fill(x+1, y, steps+1, x, y);
//		}
//		if(wall[x][y+1].equals(" ") && (x != prevx || y+1 != prevy)) {
//			return 1 + flood_fill(x, y+1, steps+1, x, y);
//		}
//		if(wall[x][y-1].equals(" ") && (x != prevx || y-1 != prevy)) {
//			return 1 + flood_fill(x, y-1, steps+1, x, y);
//		}
//		
//		return steps;
//		
//	}
//
//	public static void input() {
//		// TODO Auto-generated method stub
//		for(int i = 0; i < (2*h)+1; i++) {
//			String line = in.nextLine();
//			wall[i] = line.split("");
//		}
//		
//		for(int i = 0; i < (2*h)+1; i++) {
//			for(int j = 0; j < (2*w)+1; j++) {
//				System.out.print(wall[i][j]);
//			}
//			System.out.println();
//		}
//	}
//
//	static class FastReader{
//		public FastReader() {
//			br = new BufferedReader(new InputStreamReader(System.in));//FileReader("maze1.in"));
//		}
//		String next() {
//			while(st == null || !st.hasMoreElements()) {
//				try {
//					st = new StringTokenizer(br.readLine());
//				}
//				catch(IOException e) {
//					e.printStackTrace();
//				}
//			}
//			return st.nextToken();
//		}
//		int nextInt() {
//			return Integer.parseInt(next());
//		}
//		double nextDouble() {
//			return Double.parseDouble(next());
//		}
//		long nextLong() {
//			return Long.parseLong(next());
//		}
//		String nextLine() {
//			String str =  "";
//			try {
//				str = br.readLine();
//			}
//			catch(IOException e) {
//				e.printStackTrace();
//			}
//			return str;
//		}
//	}
//}
