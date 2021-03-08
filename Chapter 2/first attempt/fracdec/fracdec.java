/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: fracdec
*/
import java.util.*;
import java.io.*;
//public class fracdec {
//	public static BufferedReader br;
//	public static StringTokenizer st;
//	public static FastReader in = new FastReader();
//	
//	public static PrintWriter out;
//	
//	public static void main(String[] args) throws IOException{
//		out = new PrintWriter(new BufferedWriter(new FileWriter("fracdec.out")));
//		
//		out.close();
//	}
//	
//	static class FastReader{
//		public FastReader() {
//			try {
//				br = new BufferedReader(new FileReader("fracdec.in"));
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

public class fracdec {
	
	/*
	 * 1/7 = 0.14285714285714....
	 * 
	 * 7 | 1
	 */
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("fracdec.in"));
		// Scanner in = new Scanner("100000 9817");
		PrintWriter pw = new PrintWriter(new File("fracdec.out"));
		int num = in.nextInt();
		int den = in.nextInt();
		int div = num / den;
		if(num % den == 0) pw.println((double) num/den);
		else {
			StringBuilder str = new StringBuilder();
			boolean [] visited = new boolean[100010]; // checks whether number is already visited
			ArrayList <Integer> digits = new ArrayList <Integer> (); // records the digits to add the 
			ArrayList <Integer> nvalues = new ArrayList <Integer> (); // finds out when to start adding parentheses
			num %= den;
			while(num > 0 && ! visited[num]) {
				visited[num] = true;
				nvalues.add(num);
				num *= 10;
				digits.add(num / den);
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
				pw.println(s.substring(at,at+76));
				at+=76;
			}
			if(at - s.length() != 0)
				pw.println(s.substring(at));
			
		}
		in.close();
		pw.close();
	}

}