/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: transform
*/
import java.util.*;
import java.io.*;

public class transform {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static String[][] before = new String[n][n];
	public static String[][] after = new String[n][n];
	public static PrintWriter out;
	public static boolean gameover = false;
	
	public static void input(String[][] mat) {
		for(int i = 0; i < n; i++) {
			String temp = in.nextLine();
			String[] arr = temp.split("");
			for(int j = 0; j < n; j++) {
				mat[i][j] = arr[j];
			}
		}
	}
	
	public static void reflect() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n/2+1; j++) {
				if(!before[i][j].equals(after[i][n-1-j])) {
					return;
				}
			}
		}
		out.println(4);
		gameover = true;
	}
	
	public static void reflectRotate() {
		String reflect[][] = new String[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n/2+1; j++) {
				reflect[i][j] = before[i][n-1-j];
				reflect[i][n-1-j] = before[i][j];
			}
		}
		
		String temp[][] = new String[n][n];
		String temp2[][] = new String[n][n];
		String temp3[][] = new String[n][n];
		boolean t = true;
		boolean t2 = true;
		boolean t3 = true;
		
		for(int i = 0; i < n; i++) {
			int a = n-1;
			outerloop:
			for(int j = 0; j < n; j++) {
				temp[a][i] = reflect[i][j];
				if(!temp[a][i].equals(after[a][i])) {
					t = false;
				}
				a--;
			}
		}
		if(t) {
			System.out.println(5);
			gameover = true;
			return;
		}
		
		for(int i = 0; i < n; i++) {
			int a = n-1;
			outerloop:
			for(int j = 0; j < n; j++) {
				temp2[a][i] = temp[i][j];
				if(!temp2[a][i].equals(after[a][i])) {
					t2 = false;
				}
				a--;
			}
		}
		if(t2) {
			out.println(5);
			gameover = true;
			return;
		}
		
		
		for(int i = 0; i < n; i++) {
			int a = n-1;
			outerloop:
			for(int j = 0; j < n; j++) {
				temp3[a][i] = temp2[i][j];
				if(!temp3[a][i].equals(after[a][i])) {
					t3 = false;
					break outerloop;
				}
				a--;
			}
		}
		if(t3) {
			out.println(5);
			gameover = true;
			return;
		}
		
	}
	
	public static void identical() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!before[i][j].equals(after[i][j])) {
					return;
				}
			}
		}
		out.println(6);
		gameover = true;
	}
	
	public static void rotate() {
		String temp[][] = new String[n][n];
		String temp2[][] = new String[n][n];
		String temp3[][] = new String[n][n];
		boolean t = true;
		boolean t2 = true;
		boolean t3 = true;
		for(int i = 0; i < n; i++) {
			int a = n-1;
			for(int j = 0; j < n; j++) {
				temp[a][i] = before[i][j];
				if(!temp[a][i].equals(after[a][i])) {
					t = false;
				}
				a--;
			}
		}
		
		
		for(int i = 0; i < n; i++) {
			int a = n-1;
			for(int j = 0; j < n; j++) {
				temp2[a][i] = temp[i][j];
				if(!temp2[a][i].equals(after[a][i])) {
					t2 = false;
				}
				a--;
			}
		}
		
		
		
		for(int i = 0; i < n; i++) {
			int a = n-1;
			for(int j = 0; j < n; j++) {
				temp3[a][i] = temp2[i][j];
				if(!temp3[a][i].equals(after[a][i])) {
					t3 = false;
				}
				a--;
			}
		}
		if(t3) {
			out.println(1);
			gameover = true;
			return;
		}
		if(t2) {
			out.println(2);
			gameover = true;
			return;
		}
		if(t) {
			out.println(3);
			gameover = true;
			return;
		}
	}
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		input(before);
		input(after);
		
		rotate();
		if(!gameover) {
			reflect();
		}
		if(!gameover) {
			reflectRotate();
		}
		if(!gameover) {
			identical();
		}
		if(!gameover) {
			out.println(7);
		}
		out.close();
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("transform.in"));
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try{
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
