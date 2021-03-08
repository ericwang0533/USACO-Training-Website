/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: subset
*/
import java.util.*;
import java.io.*;
public class subsetConsole {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static int ans = 0;
	public static PrintWriter out;
	public static int sum = n * (n+1) / 2;
	public static long startTime = System.currentTimeMillis();
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(System.out);//new BufferedWriter(new FileWriter("subset.out")));
	
		if(sum%2 == 1) {
			out.println(0);
		}
		else {
			generate(1, 1);
			
			out.println(ans);
		}
		//ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(1));
		
		//System.out.println(sum);
		System.out.println(System.currentTimeMillis() - startTime);
		out.close();
	}
	
	public static void generate(int recent, int total) {
		// TODO Auto-generated method stub
		//check(total);
		
		if(total == sum/2) {
			ans++;
			return;
		}
		
		if(total >= sum/2) {
			return;
		}
		
		for(int i = recent+1; i <= n; i++) {
			total += i;
			generate(i, total);
			total -= i;
		}
		
	}

	public static void check(int total) {
		// TODO Auto-generated method stub
//		for(int i = 0; i < nums.size(); i++) {
//			out.print(nums.get(i) + " ");
//		}
//		out.println();
//		if(nums.size() < n/2) {
//			return;
//		}
		
//		int sum = 0;
//		for(int i = 1; i <= n; i++) {
//			if(nums.contains(i)) {
//				sum += i;
//				continue;
//			}
//			sum -= i;
//		}
//		
		System.out.println(total);
		if(total == sum/2) {
			ans++;
		}
	}

	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));//FileReader(new File("subset.in")));
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
