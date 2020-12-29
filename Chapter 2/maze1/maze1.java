/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: maze1
*/
import java.util.*;
import java.io.*;
public class maze1 {
	
	static char [][] grid;
	static int N;
	static int H;
	static int[] x = {1, -1, 0, 0};
	static int[] y = {0, 0, 1, -1};
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("maze1.in"));
		PrintWriter pw = new PrintWriter(new File("maze1.out"));
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
		
		int maxdist = 0;
		
		int [][] dist1 = bfs(exit1x, exit1y);
		int [][] dist2 = bfs(exit2x, exit2y);
		
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
	
}

class Coor {
    
    public int x;
    public int y;
    
    public Coor(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

//public class maze1 {
//    public static void main(String[] args) throws Exception {
//        // set startTime to measure how long the program takes
//        long startTime = System.currentTimeMillis();
//
//        // create input BufferedReader from file
//        BufferedReader br = new BufferedReader(new FileReader("maze1.in"));
//        StringTokenizer l = new StringTokenizer(br.readLine());
//        int W = Integer.parseInt(l.nextToken());
//        int H = Integer.parseInt(l.nextToken());
//        Node[] graph = new Node[W * H];
//        System.out.println(W+" "+H);
//        for (int i = 0; i < W; i++) {
//            for (int j = 0; j < H; j++) {
//                // DEBUG System.out.println(j * W + i);
//                graph[j * W + i] = new Node();
//            }
//        }
//        char[][] input = new char[2 * H + 1][2 * W + 1];
//        for (int i = 0; i < 2 * H + 1; i++) {
//            input[i] = br.readLine().toCharArray();
//        }
//        for (int i = 1; i < 2 * W + 1; i += 2) {
//            for (int j = 1; j < 2 * H + 1; j += 2) {
//                if (!(input[j][i] == ' ')) {
//                    break;
//                }
//                int x = (i - 1) / 2;
//                int y = (j - 1) / 2;
//                int num = y * W + x;
//                //List<Integer> temp = new ArrayList<>();
//                // DEBUG System.out.println(y + " " + x + " " + num);
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
//        List<Integer> ends = new ArrayList<>();
//        for (int i = 0; i < W; i++) {
//            for (int j = 0; j < H; j++) {
//                // DEBUG System.out.print("\n" + i + " " + j + " \t\t");
//                for (int k = 0; k < graph[j * W + i].edges.size(); k++) {
//                    int temp = graph[j * W + i].edges.get(k).destination;
//                    int x = temp % W;
//                    int y = temp / W;
//                    // DEBUG System.out.print((j*W+i)+" "+x + " " + y + "\t" + graph[j * W +
//                    // i].edges.get(k).weight + " \t\t");
//                }
//                if (j == 0 && input[0][i * 2 + 1] == ' ') {
//                    ends.add(j * W + i);
//                    // DEBUG System.out.println(i+" "+j);
//                }
//                if (j == H - 1 && input[2 * H][i * 2 + 1] == ' ') {
//                    ends.add(j * W + i);
//                    // DEBUG System.out.println(i+" "+j);
//                }
//                if (i == 0 && input[j * 2 + 1][0] == ' ') {
//                    ends.add(j * W + i);
//                    // DEBUG System.out.println(i+" "+j);
//                }
//                if (i == W - 1 && input[j * 2 + 1][2 * W] == ' ') {
//                    ends.add(j * W + i);
//                    // DEBUG System.out.println(i+" "+j);
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
//                // DEBUG System.out.println(i + " " + j + "\t" + distances[j * W + i]);
//                if (distances[j * W + i] > max) {
//                    max = distances[j * W + i];
//                }
//            }
//        }
//        // create PrintWriter to output results
//        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maze1.out")));
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
//                // DEBUG System.out.println(i);
//                if (!nodes[i].visited && nodes[i].distance < min) {
//                    mini = i;
//                    min = nodes[i].distance;
//                }
//            }
//            nodes[mini].visited = true;
//
//            for (int i = 0; i < nodes[mini].edges.size(); i++) {
//                Edge edge = nodes[mini].edges.get(i);
//                // DEBUG System.out.println(mini+" "+edge.destination);
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





//public class maze1 {
//	public static BufferedReader br;
//	public static StringTokenizer st;
//	public static FastReader in = new FastReader();
//	
//	public static PrintWriter out;
//	
//	public static void main(String[] args) throws IOException{
//		out = new PrintWriter(new BufferedWriter(new FileWriter("maze1.out")));
//		
//		out.close();
//	}
//	
//	static class FastReader{
//		public FastReader() {
//			try {
//				br = new BufferedReader(new FileReader("maze1.in"));
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
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
