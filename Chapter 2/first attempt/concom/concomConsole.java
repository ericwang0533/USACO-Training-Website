/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: concom
*/
import java.util.*;
import java.io.*;
public class concomConsole {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static int[][] mat = new int[101][101];
	public static ArrayList<Integer> company_nums = new ArrayList<Integer>();
	public static ArrayList<String> ans = new ArrayList<String>();
	public static boolean gameOver = false;
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(System.out);
		
		input();
		while(!gameOver) {
			gameOver = true;
			solve2();
		}
//		solve2();
//		solve2();
//		solve2();
		
		
//		for(int i = 0; i < 101; i++) {
//			System.out.println(Arrays.toString(mat[i]));
//		}
		
		Collections.sort(ans, new SpecialComparator());
		for(int i = 0; i < ans.size(); i++) {
			out.println(ans.get(i));
		}
		
//		ArrayList<String> test = new ArrayList<String>(Arrays.asList("4 2", "4 5", "4 3"));
//		Collections.sort(test, new SpecialComparator());
//		
//		for(int i = 0; i < test.size(); i++) {
//			System.out.println(test.get(i));
//		}
		
		out.close();
	}
	
	public static void solve2() {
		// TODO Auto-generated method stub
		for(int i = 0; i < company_nums.size(); i++) {
			for(int j = 1; j <= 100; j++){ //company_nums.get(company_nums.size()-1); j++) {
//				System.out.println(mat[company_nums.get(i)][j]);
				
				
				if(mat[company_nums.get(i)][j] >= 50 && j != company_nums.get(i)) {
					if(!ans.contains(String.valueOf(company_nums.get(i)) + " " + String.valueOf(j))) {
						ans.add(String.valueOf(company_nums.get(i)) + " " + String.valueOf(j));
						for(int a = 1; a <= 100; a++){//company_nums.get(company_nums.size()-1); a++) {
							mat[company_nums.get(i)][a] += mat[j][a];
						}
						gameOver = false;
					}
					
					
					
				}
			}
		}
	}
	
	public static void solve() {
		// TODO Auto-generated method stub
		
		// loop through each company_num
		for(int i = 0; i < company_nums.size(); i++) {
			for(int j = 1; j <= 100; j++){ //company_nums.get(company_nums.size()-1); j++) {
//				System.out.println(mat[company_nums.get(i)][j]);
				
				
				if(mat[company_nums.get(i)][j] >= 50 && j != company_nums.get(i)) {
					if(!ans.contains(String.valueOf(company_nums.get(i)) + " " + String.valueOf(j))) {
						ans.add(String.valueOf(company_nums.get(i)) + " " + String.valueOf(j));
					}
					
					for(int a = 1; a <= 100; a++){//company_nums.get(company_nums.size()-1); a++) {
						mat[company_nums.get(i)][a] += mat[j][a];
					}
					
				}
			}
		}
		
		
	}

	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
			int company_num = in.nextInt();
			
			
			mat[company_num][company_num] = 100;
			mat[company_num][in.nextInt()] = in.nextInt();
//			if(mat[company_num][company_num] == 0) {
//				mat[company_num][company_num] = 100;
//				mat[company_num][in.nextInt()] = in.nextInt();
//			}
//			else {
//				mat[company_num][in.nextInt()] = in.nextInt();
//			}
		
			if(!company_nums.contains(company_num)) {
				company_nums.add(company_num);
			}
		
		}
//		Collections.sort(company_nums);
		
//		for(int i = 0; i < 101; i++) {
//			System.out.println(Arrays.toString(mat[i]));
//		}
		
//		for(int i = 0; i < company_nums.size(); i++) {
//			System.out.println(company_nums.get(i));
//		}
	}
	
	static class SpecialComparator implements Comparator<String>{
		public int compare(String first, String second) {
//			System.out.println(first);
//			System.out.println(second);
			String[] firstArr = first.split(" ");
			String[] secondArr = second.split(" ");
//			System.out.println(Arrays.toString(firstArr));
//			System.out.println(Arrays.toString(secondArr));
			if(Integer.parseInt(firstArr[0]) > Integer.parseInt(secondArr[0])) {
				return 1;
			}
			else if(Integer.parseInt(firstArr[0]) < Integer.parseInt(secondArr[0])) {
				return -1;
			}
			else {
				if(Integer.parseInt(firstArr[1]) > Integer.parseInt(secondArr[1])) {
					return 1;
				}
				else {
					return -1;
				}
//				else if(Integer.parseInt(firstArr[1]) < Integer.parseInt(secondArr[1])){
//					return -1;
//				}
//				else {
//					return 0;
//				}
			}
		}
	}

	static class FastReader{
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));//FileReader("concom.in"));
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
