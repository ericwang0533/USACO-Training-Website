/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: milk3
*/
import java.util.*;
import java.io.*;
public class milk3 {
	public static FastReader in = new FastReader();
	public static int a = in.nextInt();
	public static int b = in.nextInt();
	public static int c = in.nextInt();
	public static int x = 0, y = 0, z = c;
	public static ArrayList<Integer> ans = new ArrayList<Integer>(Arrays.asList(c));
	public static boolean[][][] searched = new boolean[a+1][b+1][c+1];
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
		
		/*System.out.print("x: " + x + " | y: " + y + " | z: " + z);
		System.out.println();
		left();
		System.out.println("TESTESTESTET");
		
		System.out.print("x: " + 0 + " | y: " + 0 + " | z: " + c);
		System.out.println();
		right();*/
		solve(Math.min(a, c), 0, c - Math.min(a, c), 2);
		solve(0, Math.min(b, c), c - Math.min(b, c), 1);
		
		Collections.sort(ans);
		for(int i = 0; i < ans.size(); i++) {
			if(i == ans.size()-1) {
				out.println(ans.get(i));
			}
			else {
				out.print(ans.get(i) + " ");
			}
			
		}
		//out.println();
		//out.println("test");
		out.close();
	}
	
	//which
	//0: x - y / y - x
	//1: y - z / z - y
	//2: x - z / z - x
	
	public static void solve(int x, int y, int z, int which) {
		System.out.println("x: " + x + " | y: " + y + " | z: " + z + " | which: " + which);
		if(searched[x][y][z]) {
			return;
		}
		searched[x][y][z] = true;
		
		if(which == 0) {
			int temp = z + y;
			System.out.println("z + y, which == 0");
			System.out.println("x: " + x + " | y: " + y + " | z: " + z);
			solve(x, Math.min(b, temp), (temp - Math.min(b, temp)), 1);
			//y = Math.min(b, temp);
			//z = temp - y;
			
			int temp1 = x + z;
			System.out.println("x + z, which == 0");
			System.out.println("x: " + x + " | y: " + y + " | z: " + z);
			solve((temp1 - Math.min(c, temp1)), y, Math.min(c, temp1), 2);
			//z = Math.min(c, temp1);
			//x = temp1 - z;
		}
		else if(which == 1) {
			int temp = y + x;
			System.out.println("y + x, which == 1");
			System.out.println("x: " + x + " | y: " + y + " | z: " + z);
			solve(Math.min(a, temp), (temp - Math.min(a, temp)), z, 0);
			//x = Math.min(a, temp);
			//y = temp - x;
			
			int temp1 = x + z;
			System.out.println("x + z, which == 1");
			System.out.println("x: " + x + " | y: " + y + " | z: " + z);
			solve((temp1 - Math.min(c, temp1)), y, Math.min(c, temp1), 2);
		}
		else {
			int temp = y + x;
			System.out.println("y + x, which == 2");
			System.out.println("x: " + x + " | y: " + y + " | z: " + z);
			solve(Math.min(a, temp), (temp - Math.min(a, temp)), z, 0);
			
			int temp1 = z + y;
			System.out.println("z + y, which == 2");
			System.out.println("x: " + x + " | y: " + y + " | z: " + z);
			solve(x, Math.min(b, temp1), (temp1 - Math.min(b, temp1)), 1);
		}
		
		if(x == 0) {
			if(!ans.contains(z)) {
				ans.add(z);
			}
		}
		
		
		
	}
	
	public static void left() {
		int which = 0;
		while(true) {
			if(which%3 == 0) {
				int temp = z + y;
				y = Math.min(b, temp);
				z = temp - y;
			}
			else if(which%3 == 1) {
				int temp = y + x;
				x = Math.min(a, temp);
				y = temp - x;
			}
			else {
				int temp = x + z;
				z = Math.min(c, temp);
				x = temp - z;
			}
			
			if(x == 0) {
				if(!ans.contains(z)) {
					ans.add(z);
				}
			}
			
			System.out.print("x: " + x + " | y: " + y + " | z: " + z);
			System.out.println();
			if(which == 100) {
				break;
			}
			which++;
		}
	}
	
	public static void right() {
		x = 0; y = 0; z = c;
		int which = 0;
		while(true) {
			if(which%3 == 0) {
				int temp = x + z;
				x = Math.min(a, temp);
				z = temp - x;
			}
			else if(which%3 == 1) {
				int temp = x + y;
				y = Math.min(b, temp);
				x = temp - y;
			}
			else {
				int temp = y + z;
				z = Math.min(c, temp);
				y = temp - z;
			}
			
			if(x == 0) {
				if(!ans.contains(z)) {
					ans.add(z);
				}
			}
			
			System.out.print("x: " + x + " | y: " + y + " | z: " + z);
			System.out.println();
			if(which == 100) {
				break;
			}
			which++;
		}
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("milk3.in"));
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
