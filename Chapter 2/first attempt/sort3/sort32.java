/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: sort3
*/
import java.util.*;
import java.io.*;
public class sort32 {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static int[] maxes = new int[3+1]; //1 based :D
	public static ArrayList<Integer> arr = new ArrayList<Integer>();
	//public static boolean[] good = new boolean[n];
	public static int[] switches = new int[6];
	public static int ans = 0;
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
		
		input();
		
		//TODO
		//swap places of 
		
		for(int i = 0; i < n; i++) {
			if(i < maxes[1]) {
				// 1s group
				if(arr.get(i) == 2) {
					switches[0]++;
				}
				else if(arr.get(i) == 3) {
					switches[1]++;
				}
			}
			else if(i < maxes[2] + maxes[1]) {
				// 2s group
				if(arr.get(i) == 1) {
					switches[2]++;
				}
				else if(arr.get(i) == 3) {
					switches[3]++;
				}
			}
			else {
				// 3s groups
				if(arr.get(i) == 1) {
					switches[4]++;
				}
				else if(arr.get(i) == 2) {
					switches[5]++;
				}
			}
		}
		
		for(int i = 0; i < 6; i++) {
			System.out.println(switches[i]);
		}
		System.out.println();
		
		int temp1 = Math.min(switches[0], switches[2]);
		for(int i = 0; i < temp1; i++) {
			switches[0]--;
			switches[2]--;
			ans++;
			System.out.println("switches 0 2");
		}
		
		int temp2 = Math.min(switches[1], switches[4]);
		for(int i = 0; i < temp2; i++) {
			switches[1]--;
			switches[4]--;
			ans++;
			System.out.println("switches 1 4");
		}
		
		int temp3 = Math.min(switches[3], switches[5]);
		for(int i = 0; i < temp3; i++) {
			switches[3]--;
			switches[5]--;
			ans++;
			System.out.println("switches 3 5");
		}
		
		int sum = 0;
		for(int i = 0; i < 6; i++) {
			sum += switches[i];
		}
		System.out.println(sum);
		sum /= 3;
		sum *= 2;
		System.out.println(sum);
		System.out.println(ans);
		out.println(sum + ans);
		
		// dbg
		System.out.println(maxes[1]);
		System.out.println(maxes[2]);
		System.out.println(maxes[3]);
		
		
		//out.println("test");
		out.close();
	}
	
	public static void input() {
		for(int i = 0; i < n; i++) {
			int curr = in.nextInt();
			arr.add(curr);
			maxes[curr]++;
		}
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("sort3.in"));
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
