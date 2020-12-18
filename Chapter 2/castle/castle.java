/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: castle
*/
import java.util.*;
import java.io.*;
public class castle {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static int m = in.nextInt();
	public static int[][] mat = new int[m][n];
	public static int[][] walls = new int[m][n];
	public static int[] roomnums = new int[m * n + 1]; //gonna be 1 based btw
	public static int iden = 1;
	public static int optrow = 0;
	public static int optcol = n-1;
	public static char optdirect = 'E';
	public static int optmax = 0;
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
		
		// get input (walls)
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				walls[i][j] = in.nextInt();
				//System.out.print(walls[i][j] + " ");
			}
			//System.out.println();
		}
		
		// loop through each cell, if its not filled, fill it
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(mat[i][j] == 0) {
					flood_fill(i, j);
					//System.out.println("exited a full loop");
					iden++;
				}
			}
		}
		
		// loop through each cell, check if it has a neighboring room, calculate the new max room if that wall is down
		// check cells to the right, and up
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				System.out.println("i: " + i + " | j: " + j);
				if(i != 0) {
					// check north walls
					if(mat[i][j] != mat[i-1][j]) {
						// its a neighbor
						if(roomnums[mat[i][j]] + roomnums[mat[i-1][j]] > optmax) {
							optmax = roomnums[mat[i][j]] + roomnums[mat[i-1][j]];
							optrow = i;
							optcol = j;
							optdirect = 'N';
						}
						else if(roomnums[mat[i][j]] + roomnums[mat[i-1][j]] == optmax) {
							if(j < optcol) {
								optrow = i;
								optcol = j;
								optdirect = 'N';
							}
							else if(j == optcol) {
								if(i > optrow) {
									optrow = i;
									optcol = j;
									optdirect = 'N';
								}
							}
						}
					}
				}
				
				if(j != n-1) {
					// check east walls
					if(mat[i][j] != mat[i][j+1]) {
						// its a neighbor
						if(roomnums[mat[i][j]] + roomnums[mat[i][j+1]] > optmax) {
							optmax = roomnums[mat[i][j]] + roomnums[mat[i][j+1]];
							optrow = i;
							optcol = j;
							optdirect = 'E';
						}
						else if(roomnums[mat[i][j]] + roomnums[mat[i][j+1]] == optmax) {
							if(j < optcol) {
								optrow = i;
								optcol = j;
								optdirect = 'E';
							}
							else if(j == optcol) {
								if(i > optrow) {
									optrow = i;
									optcol = j;
									optdirect = 'E';
								}
							}
						}
					}
				}
				System.out.println("optmax: " + optmax + " | optrow: " + optrow + " | optcol: " + optcol + " | optdirect: " + optdirect);
			}
		}
		
		System.out.println("optmax: " + optmax + " | optrow: " + optrow + " | optcol: " + optcol + " | optdirect: " + optdirect);
		
		// dbg code
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		
		for(int i = 1; i < iden; i++) {
			System.out.println(roomnums[i]);
		}
		
		out.println(iden-1);
		Arrays.sort(roomnums);
		out.println(roomnums[m*n]);
		out.println(optmax);
		out.println((optrow+1) + " " + (optcol+1) + " " + optdirect);
		//out.println("test");
		out.close();
	}
	
	// recursively flood fill each room
	public static void flood_fill(int row, int col) {
		
		// check bounds
		if(row < 0 || row >= m || col < 0 || col >= n) {
			//System.out.println("exited bc of board size: " + row + " " + col);
			return;
		}
		
		// check if already filled
		if(mat[row][col] != 0) {
			//System.out.println("exited bc already filled: " + row + " " + col);
			return;
		}
		
		//System.out.println("row: " + row + " | col: " + col);		
		
		// fill
		mat[row][col] = iden;
		
		// count size of rooms
		roomnums[iden]++;
		
		// check if the 4 neighbors are in the same room
		// base 2 the wall?
		int base2 = Integer.parseInt(Integer.toString(walls[row][col], 2));
		//System.out.println("base2: " + base2);
		if(base2%10 != 1) {
			//System.out.println("not west?");
			flood_fill(row, col-1);
		}
		if((base2/10)%10 != 1) {
			//System.out.println("not north?");
			flood_fill(row-1, col);
		}
		if((base2/100)%10 != 1) {
			//System.out.println("not east?");
			flood_fill(row, col+1);
		}
		if((base2/1000)%10 != 1) {
			//System.out.println("not south?");
			flood_fill(row+1, col);
		}
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("castle.in"));
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
