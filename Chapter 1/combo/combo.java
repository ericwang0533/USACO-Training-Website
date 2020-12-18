/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: combo
*/
import java.util.*;
import java.io.*;
public class combo {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static int[] arr = {in.nextInt(), in.nextInt(), in.nextInt()};
	public static int[] brr = {in.nextInt(), in.nextInt(), in.nextInt()};
	public static int[] start = {brr[0] - 2, brr[1] - 2, brr[2] - 2};
	public static int[] end = {brr[0] + 2, brr[1] + 2, brr[2] + 2};
	public static int[] start1 = {arr[0] - 2, arr[1] - 2, arr[2] - 2};
	public static int[] end1 = {arr[0] + 2, arr[1] + 2, arr[2] + 2};
	public static int[] ans = {0, 0, 0};
	//public static ArrayList<String> ans = new ArrayList<>();
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
		
		if(n <= 5) {
			out.println(n * n * n);
		}
		else {
			for(int i = 0; i < 3; i++) {
				if(start[i] < 1) {
					start[i] += n;
				}
				
				if(end[i] > n) {
					end[i] -= n; 
				}
				
				if(start1[i] < 1) {
					start1[i] += n;
				}
				
				if(end1[i] > n) {
					end1[i] -= n; 
				}
				System.out.println(start[i] + " | " + end[i]);
				System.out.println(start1[i] + " | " + end1[i]);
			}
			
			/*for(int a = start[0]; a < end[0]; a++) {
				for(int b = start[1]; b < end[0]; b++) {
					for(int c = start[2]; c < end[2]; c++) {
						if((a <= end1[0] && a >= start1[0]) && (b <= end1[1] && b >= start1[1]) && (c <= end1[2] && c >= start1[2])) {
							ans++;
						}
					}
				}
			}*/
			for(int i = 0; i < 3; i++) {
				int counter = 0;
				for(int a = start[i]; counter < 5; counter++, a++) {
					if(a == n+1) {
						a = 1;
					}
					System.out.print(a);
					
					if(start1[i] > end1[i]) {
						if(a <= end1[i] || a >= start1[i]) {
							System.out.println("test1");
							ans[i]++;
						}
					}
					else {
						if(a <= end1[i] && a >= start1[i]) {
							System.out.println("test2");
							ans[i]++;
						}
					}
				}
			}
			
			
			System.out.println(Arrays.toString(ans));
			//int min = Math.min(Math.min(ans[0], ans[1]), ans[2]);
			out.println(250 - (ans[0] * ans[1] * ans[2]));
		}
		
		
		out.close();
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("combo.in"));
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
