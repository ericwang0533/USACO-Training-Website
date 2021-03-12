/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: hamming
*/

import java.util.*;
import java.io.*;
public class hamming {
	public static boolean debug = false, testing = false;
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static PrintWriter out;
	
	public static int N = in.nextInt(), B = in.nextInt(), D = in.nextInt(); 
	public static int count = 1;
	public static code[] ans = new code[N];
	
	public static void main(String[] args) throws IOException{
		out = (testing) ? new PrintWriter(new File("Chapter 2/second attempt/hamming/hamming.out")) : new PrintWriter(new File("hamming.out"));
//		out.println("test");
//		int test = 5;
//		String str = Integer.toBinaryString(test);
//		dbg(str);
//		String copy = String.format("%" + b + "s", str);
//		copy = copy.replace(' ', '0');
//		dbg(copy);
		
		ans[0] = new code(0);
		
		outer:
		for(int i = 1; i < Math.pow(2, B); i++) {
//			dbg(i);
			String str = String.format("%" + B + "s", Integer.toBinaryString(i)).replace(' ', '0');
			for(int j = 0; j < count; j++) {
//				dbg(ans[j].bin);
//				dbg(str);
//				dbg(Arrays.toString(ans));
//				dbg("");
				if(!ham(ans[j].bin, str)) {
					continue outer;
				}
			}
			
			ans[count] = new code(i, str);
			count++;
			
			if(count == N) {
//				dbg(Arrays.toString(ans));
				break outer;
			}
		}
		
		for(int i = 0; i < N; i++) {
			if((i+1)%10 == 0 && i != 0) {
				out.println(ans[i].dec);
				continue;
			}
			
			if(i == N-1) {
				out.println(ans[i].dec);				
				break;
			}
			out.print(ans[i].dec + " ");
		}
		out.close();
	}
	
	public static boolean ham(String a, String b) {
		// TODO Auto-generated method stub		
		dbg(a);
		dbg(b);
//		dbg("");
		
		int hamD = 0;
		for(int i = 0; i < B; i++) {
			if(a.charAt(i) != b.charAt(i)) {
				hamD++;
			}
		}
		
		if(hamD >= D) {
			dbg("tru");
			dbg("");
			return true;
		}
		
		dbg("false");
		dbg("");
		return false;
		
	}

	static class code{
		public int dec;
		public String bin;
		public code(int dec) {
			this.dec = dec;
			bin = String.format("%" + B + "s", Integer.toBinaryString(dec)).replace(' ', '0');
		}
		
		public code(int dec, String str) {
			this.dec = dec;
			bin = str;
		}
		
		@Override
		public String toString() {
			return String.valueOf(dec);
		}
		
	}
	
	static class FastReader{
		public FastReader() {
			try {
				br = (testing) ? new BufferedReader(new FileReader(new File("Chapter 2/second attempt/hamming/hamming.in"))) : new BufferedReader(new FileReader(new File("hamming.in")));
			}
			catch(FileNotFoundException e) {
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
	
	static void dbg(Object obj) {
		if(debug)
			System.out.println(obj);
	}
}
