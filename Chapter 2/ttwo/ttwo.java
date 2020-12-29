/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: ttwo
*/
import java.util.*;
import java.awt.Point;
import java.io.*;
public class ttwo {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static int[][] mat = new int[10][10];
	public static Point john, cow; 
	public static final int up = 0, right = 1, left = 2, down = 3;
	public static int ans = 0, johnDir = up, cowDir = up;
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("ttwo.out")));
		
		input();
		simulate();
		
		out.println(ans);
		out.close();
	}
	
	public static void simulate() {
		// TODO Auto-generated method stub
		while(john.x != cow.x || john.y != cow.y) {
			moveJohn();
			moveCow();
//			System.out.println("john: " + toPointString(john));
//			System.out.println("cow: " + toPointString(cow));
			ans++;
			if(ans > 10000) {
				ans = 0;
				break;
			}
//			if(ans >= 50) {
//				break;
//			}
		}
	}

	public static void moveCow() {
		// TODO Auto-generated method stub
		
		// first check if we need to rotate
		// check for obstacle and if its past the bounds
		if(cowDir == up) {
			if((cow.x - 1) <= -1 || mat[cow.x-1][cow.y] == 1) {
				// time to turn sideways boi
				cowDir = right;
			}
			else {
				cow.x--;
			}
		}
		else if(cowDir == right) {
			if((cow.y + 1) >= 10 || mat[cow.x][cow.y+1] == 1) {
				// time to turn sideways boi
				cowDir = down;
			}
			else {
				cow.y++;
			}
		}
		else if(cowDir == down) {
			if((cow.x + 1) >= 10 || mat[cow.x+1][cow.y] == 1) {
				// time to turn sideways boi
				cowDir = left;
			}
			else {
				cow.x++;
			}
		}
		else if(cowDir == left) {
			if((cow.y - 1) <= -1 || mat[cow.x][cow.y-1] == 1) {
				// time to turn sideways boi
				cowDir = up;
			}
			else {
				cow.y--;
			}
		}
	}

	public static void moveJohn() {
		// TODO Auto-generated method stub
		
		// first check if we need to rotate
		// check for obstacle and if its past the bounds
		if(johnDir == up) {
			if((john.x - 1) <= -1 || mat[john.x-1][john.y] == 1) {
				// time to turn sideways boi
				johnDir = right;
			}
			else {
				john.x--;
			}
		}
		else if(johnDir == right) {
			if((john.y + 1) >= 10 || mat[john.x][john.y+1] == 1) {
				// time to turn sideways boi
				johnDir = down;
			}
			else {
				john.y++;
			}
		}
		else if(johnDir == down) {
			if((john.x + 1) >= 10 || mat[john.x+1][john.y] == 1) {
				// time to turn sideways boi
				johnDir = left;
			}
			else {
				john.x++;
			}
		}
		else if(johnDir == left) {
			if((john.y - 1) <= -1 || mat[john.x][john.y-1] == 1) {
				// time to turn sideways boi
				johnDir = up;
			}
			else {
				john.y--;
			}
		}
		
		
		
	}
	


	public static void input() {
		// TODO Auto-generated method stub
//		System.out.println("test");
		for(int i = 0; i < 10; i++) {
			String temp = in.nextLine();
			String[] arr = temp.split("");
			for(int j = 0; j < 10; j++) {
				
				
//				System.out.println(j);
//				System.out.println(temp);
				
				if(!arr[j].equals("*")) {
					
					if(arr[j].equals("F")) {
						john = new Point(i, j);
					}
					else if(arr[j].equals("C")) {
						cow = new Point(i, j);
					}
					
				}
				else {
					mat[i][j] = 1;
				}
				
			}
		}
		
		
		// dbg
//		System.out.println("test");
//		System.out.println("    0  1  2  3  4  5  6  7  8  9");
//		for(int i = 0; i < 10; i++) {
//			System.out.print(i + ": ");
//			System.out.println(Arrays.toString(mat[i]));
//		}
//		
//		System.out.println("john start: " + toPointString(john));//.toString());
//		System.out.println("cow start: " + toPointString(cow));//.toString());
	}
	
	static String toPointString(Point pt){
		return String.valueOf(pt.x) + " " + String.valueOf(pt.y);
	}
	
	static class FastReader{
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("ttwo.in"));
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
