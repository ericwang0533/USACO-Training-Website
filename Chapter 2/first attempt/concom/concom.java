/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: concom
*/
import java.util.*;
import java.io.*;
//public class concom {
//	public static BufferedReader br;
//	public static StringTokenizer st;
//	public static FastReader in = new FastReader();
//	public static int n = in.nextInt();
//	public static int[][] mat = new int[101][101];
//	public static ArrayList<Integer> company_nums = new ArrayList<Integer>();
//	public static ArrayList<String> ans = new ArrayList<String>();
//	public static boolean gameOver = false;
//	public static PrintWriter out;
//	
//	public static void main(String[] args) throws IOException{
//		out = new PrintWriter(new BufferedWriter(new FileWriter("concom.out")));
//		
//		input();
////		solve2();
////		solve2();
////		solve2();
//		while(!gameOver) {
//			gameOver = true;
//			solve2();
//		}
////		solve2();
//		
//		Collections.sort(ans, new SpecialComparator());
//		for(int i = 0; i < ans.size(); i++) {
//			out.println(ans.get(i));
//		}
//		
//		out.close();
//	}
//	
//	public static void solve2() {
//		// TODO Auto-generated method stub
//		for(int i = 0; i < company_nums.size(); i++) {
//			for(int j = 1; j <= 100; j++){ //company_nums.get(company_nums.size()-1); j++) {
////				System.out.println(mat[company_nums.get(i)][j]);
//				
//				int[] company_nums_get_i = mat[company_nums.get(i)];
//				if(company_nums_get_i[j] >= 50 && j != company_nums.get(i)) {
//					String temp = String.valueOf(company_nums.get(i)) + " " + String.valueOf(j);
//					if(!ans.contains(temp)) {
//						ans.add(temp);
//						for(int a = 1; a <= 100; a++){//company_nums.get(company_nums.size()-1); a++) {
//							if(company_nums_get_i[a] < 50) {
//								company_nums_get_i[a] += mat[j][a];
//							}
//						}
//						gameOver = false;
//					}
//					
//					
//					
//				}
//			}
//		}
//	}
//
////	public static void solve() {
////		// TODO Auto-generated method stub
////		
////		// loop through each company_num
////		for(int i = 0; i < company_nums.size(); i++) {
////			for(int j = 1; j <= 100; j++){ //company_nums.get(company_nums.size()-1); j++) {
//////				System.out.println(mat[company_nums.get(i)][j]);
////				
////				
////				if(mat[company_nums.get(i)][j] >= 50 && j != company_nums.get(i)) {
////					if(!ans.contains(String.valueOf(company_nums.get(i)) + " " + String.valueOf(j))) {
////						ans.add(String.valueOf(company_nums.get(i)) + " " + String.valueOf(j));
////					}
////					
////					for(int a = 1; a <= 100; a++){//company_nums.get(company_nums.size()-1); a++) {
////						mat[company_nums.get(i)][a] += mat[j][a];
////					}
////					
////				}
////			}
////		}
////		
////		
////	}
//
//	public static void input() {
//		// TODO Auto-generated method stub
//		for(int i = 0; i < n; i++) {
//			int company_num = in.nextInt();
//			
//			
//			mat[company_num][company_num] = 100;
//			mat[company_num][in.nextInt()] = in.nextInt();
////			if(mat[company_num][company_num] == 0) {
////				mat[company_num][company_num] = 100;
////				mat[company_num][in.nextInt()] = in.nextInt();
////			}
////			else {
////				mat[company_num][in.nextInt()] = in.nextInt();
////			}
//		
//			if(!company_nums.contains(company_num)) {
//				company_nums.add(company_num);
//			}
//		
//		}
////		Collections.sort(company_nums);
//		
////		for(int i = 0; i < 101; i++) {
////			System.out.println(Arrays.toString(mat[i]));
////		}
////		
////		for(int i = 0; i < company_nums.size(); i++) {
////			System.out.println(company_nums.get(i));
////		}
//	}
//	
//	static class SpecialComparator implements Comparator<String>{
//		public int compare(String first, String second) {
//			String[] firstArr = first.split(" ");
//			String[] secondArr = second.split(" ");
//			if(Integer.parseInt(firstArr[0]) > Integer.parseInt(secondArr[0])) {
//				return 1;
//			}
//			else if(Integer.parseInt(firstArr[0]) < Integer.parseInt(secondArr[0])) {
//				return -1;
//			}
//			else {
//				if(Integer.parseInt(firstArr[1]) > Integer.parseInt(secondArr[1])) {
//					return 1;
//				}
//				else {
//					return -1;
//				}
////				else if(Integer.parseInt(firstArr[1]) < Integer.parseInt(secondArr[1])){
////					return -1;
////				}
////				else {
////					return 0;
////				}
//			}
//		}
//	}
//	
//	static class FastReader{
//		public FastReader() {
//			try {
//				br = new BufferedReader(new FileReader("concom.in"));
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
//			String str = "";
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

public class concom {
    public static int max = 100;
    public static int[][] owns = new int[max + 1][max + 1];
    public static boolean[][] controls = new boolean[max + 1][max + 1];

    public static void main(String[] args) throws Exception {
        // set startTime to measure how long the program takes
        long startTime = System.currentTimeMillis();

        // create input BufferedReader from file
        BufferedReader br = new BufferedReader(new FileReader("concom.in"));

        // get N, the number of input triples to follow
        int N = Integer.parseInt(br.readLine());

        // DEBUG System.out.println(N);


        // i always controls itself
        for (int i = 0; i <= max; i++) {
            controls[i][i] = true;
        }
        
        
        for (int i = 0; i < N; i++) {
            StringTokenizer l = new StringTokenizer(br.readLine());
            addOwner(Integer.parseInt(l.nextToken()), Integer.parseInt(l.nextToken()), Integer.parseInt(l.nextToken()));
        }
        // DEBUG for (int i = 0; i <= max; i++) {
        // DEBUG System.out.println(Arrays.toString(Arrays.copyOfRange(stakes[i], 0, max
        // + 1)));
        // DEBUG }
        br.close();

        // create PrintWriter to output results
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("concom.out")));

        for (int i = 0; i <= max; i++) {
            for (int j = 0; j <= max; j++) {
                if (i!=j && controls[i][j]) {
                    out.println(i + " " + j);
                }
            }
        }
        out.close();
        // print final time taken
        System.out.println(System.currentTimeMillis() - startTime);
    }

    public static void addController(int i, int j) {
        // DEBUG System.out.println("addController: "+i+" "+j);
        // ignore if already controlling
        if (controls[i][j]) {
            return;
        }
        // set control
        controls[i][j] = true;
        // if i controls j, add all of i's stuff to j
        for (int k = 0; k <= max; k++) {
            owns[i][k] += owns[j][k];
        }
        // everything that controls i controls j
        for (int k = 0; k <= max; k++) {
            if (controls[k][i]) {
                addController(k, j);
            }
        }
        // call addController on everything i not holds
        for (int k = 0; k <= max; k++) {
            if (owns[i][k] > 50) {
                addController(i, k);
            }
        }
    }

    public static void addOwner(int i, int j, int percent) {
        // DEBUG System.out.println("addOwner: "+i+" "+j+" "+percent);
        // add percent amount of j to everything that controls i
        for (int k = 0; k <= max; k++) {
            if (controls[k][i]) {
                owns[k][j] += percent;
            }
        }
        // does anything now control j?
        for (int k = 0; k <= max; k++) {
            if (owns[k][j] > 50) {
                addController(k, j);
            }
        }
    }
}
