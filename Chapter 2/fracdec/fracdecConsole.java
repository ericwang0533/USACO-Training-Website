/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: fracdec
*/
import java.util.*;
import java.io.*;
public class fracdecConsole {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static int num = in.nextInt();
	public static int den = in.nextInt();
	public static int div = num / den;
	public static char[] numArr = String.valueOf(num).toCharArray();
	public static char[] denArr = String.valueOf(num).toCharArray();
	public static boolean[] visited = new boolean[100010];
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(System.out);//new BufferedWriter(new FileWriter("fracdec.out")));
		
		if(num % den == 0) {
			out.println(0);
			out.close();
			System.exit(1);
		}
		
		solve();
		
		out.close();
	}
	
	public static void solve() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		ArrayList <Integer> digits = new ArrayList <Integer> (); // records the digits to add the 
		ArrayList <Integer> nvalues = new ArrayList <Integer> (); // finds out when to start adding parentheses
		num %= den;
		while(num > 0 && ! visited[num]) {
			visited[num] = true;
			nvalues.add(num);
			System.out.println(num);
			num *= 10;
			digits.add(num / den);
			System.out.println(num / den);
			num %= den;
		}
		
		for(int i = 0; i < digits.size(); i++) {
			if(num > 0 && nvalues.get(i) == num) str.append("(");
			str.append(digits.get(i));
		}
		
		
		str.append(num > 0 ? ")" : "");
		
		String s = div + "." + str.toString();
		int at = 0;
		while(s.length()-at > 76)
		{
			out.println(s.substring(at,at+76));
			at+=76;
		}
		if(at - s.length() != 0)
			out.println(s.substring(at));
	}

	static class FastReader{
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));//FileReader("fracdec.in"));
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
