/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: namenum
*/
import java.util.*;
import java.io.*;

public class namenum2 {
	public static FastReader in = new FastReader();
	public static String n = in.next();
	public static ArrayList<String> arr = new ArrayList<String>();
	
	public static BufferedReader br;
	public static PrintWriter out;
	
	public static void loop() {
		String word = String.valueOf(n);
		int tempNum = word.length();
		
		int j = 0;
		while(tempNum != 0) {
			String curr = word.substring(j, j+1);
			int currDig = Integer.parseInt(curr);
			tempNum--;
			
			int size = arr.size();
			
			if(currDig == 2) {
				if(size == 0) {
					arr.add("A");
					arr.add("B");
					arr.add("C");
				}
				
				for(int i = 0; i < size; i++) {
					String temp = arr.get(i);
					arr.add(temp + "B");
					arr.add(temp + "C");
					arr.set(i, temp + "A");
				}
			}
			else if(currDig == 3) {
				if(size == 0) {
					arr.add("D");
					arr.add("E");
					arr.add("F");
				}
				
				for(int i = 0; i < size; i++) {
					String temp = arr.get(i);
					arr.add(temp + "E");
					arr.add(temp + "F");
					arr.set(i, temp + "D");
				}
			}
			else if(currDig == 4) {
				if(size == 0) {
					arr.add("G");
					arr.add("H");
					arr.add("I");
				}
				
				for(int i = 0; i < size; i++) {
					String temp = arr.get(i);
					arr.add(temp + "H");
					arr.add(temp + "I");
					arr.set(i, temp + "G");
				}
			}
			else if(currDig == 5) {
				if(size == 0) {
					arr.add("J");
					arr.add("K");
					arr.add("L");
				}
				
				for(int i = 0; i < size; i++) {
					String temp = arr.get(i);
					arr.add(temp + "K");
					arr.add(temp + "L");
					arr.set(i, temp + "J");
				}
			}
			else if(currDig == 6) {
				if(size == 0) {
					arr.add("M");
					arr.add("N");
					arr.add("O");
				}
				
				for(int i = 0; i < size; i++) {
					String temp = arr.get(i);
					arr.add(temp + "N");
					arr.add(temp + "O");
					arr.set(i, temp + "M");
				}
			}
			else if(currDig == 7) {
				if(size == 0) {
					arr.add("P");
					arr.add("R");
					arr.add("S");
				}
				
				for(int i = 0; i < size; i++) {
					String temp = arr.get(i);
					arr.add(temp + "R");
					arr.add(temp + "S");
					arr.set(i, temp + "P");
				}
			}
			else if(currDig == 8) {
				if(size == 0) {
					arr.add("T");
					arr.add("U");
					arr.add("V");
				}
				
				for(int i = 0; i < size; i++) {
					String temp = arr.get(i);
					arr.add(temp + "U");
					arr.add(temp + "V");
					arr.set(i, temp + "T");
				}
			}
			else if(currDig == 9) {
				if(size == 0) {
					arr.add("W");
					arr.add("X");
					arr.add("Y");
				}
				
				for(int i = 0; i < size; i++) {
					String temp = arr.get(i);
					arr.add(temp + "X");
					arr.add(temp + "Y");
					arr.set(i, temp + "W");
				}
			}
			j++;
		}
	}

	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		br = new BufferedReader(new FileReader("dict.txt"));
		
		loop();
		
		for(int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		
		boolean game = true;
		String line = br.readLine();
		while(line != null) {
			if(arr.contains(line)) {
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
