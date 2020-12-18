/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: namenum
*/
import java.util.*;
import java.io.*;

public class namenum {
	public static FastReader in = new FastReader();
	public static long n = in.nextLong();
	public static ArrayList<String> arr = new ArrayList<String>();
	
	public static BufferedReader br;
	public static PrintWriter out;
	
	public static int tele(char dig) {
		int currDig = Integer.valueOf(dig);
		if(currDig <= 67 && currDig >= 65) {
			return 2;
			//System.out.println(2);
		}
		else if(currDig <= 70 && currDig >= 68) {
			return 3;
			//System.out.println(3);
		}
		else if(currDig <= 73 && currDig >= 71) {
			return 4;
			//System.out.println(4);
		}
		else if(currDig <= 76 && currDig >= 74) {
			return 5;
			//System.out.println(5);
		}
		else if(currDig <= 79 && currDig >= 77) {
			return 6;
			//System.out.println(6);
		}
		else if(currDig <= 83 && currDig >= 80 && currDig != 81) {
			return 7;
			//System.out.println(7);
		}
		else if(currDig <= 86 && currDig >= 84) {
			return 8;
			//System.out.println(8);
		}
		else if(currDig <= 89 && currDig >= 87) {
			return 9;
			//System.out.println(9);
		}
		else {
			// Q or Z
			//System.out.println(10);
			return 10;
		}
	}
	
	public static long convert(String name) {
		System.out.println(name);
		long output = 0;
		for(int i = 0; i < name.length(); i++) {
			char curr = name.charAt(i);
			int digit = tele(curr);
			if(digit != 10) {
				output *= 10;
				output += digit;
			}
		}
		System.out.println(output);
		return output;
	}
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		br = new BufferedReader(new FileReader("dict.txt"));

		boolean game = true;
		String line = br.readLine();
		while(line != null) {
			long potentAns = convert(line);
			if(potentAns == n) {
				out.println(line);
				game = false;
			}
			line = br.readLine();
		}
		
		if(game) {
			out.println("NONE");
		}
		out.close();
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("namenum.in"));
			}
			catch(IOException e) {
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
