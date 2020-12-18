/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: pprime
*/
import java.util.*;
import java.io.*;
/*public class pprime {
	static int a;
	static int b;
	static List <Integer> palprimes;
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("pprime.in"));
		PrintWriter pw = new PrintWriter(new File("pprime.out"));
		a = in.nextInt();
		b = in.nextInt();
		palprimes = new ArrayList <Integer> ();
		in.close();
		
		
		String [] start = new String[20];
		
		for(int i = 0; i <= 9; i++) {
			start[i] = Integer.toString(i);
			start[10 + i] = Integer.toString(i * 10 + i); }
		start[10] = "00";
		
		for(int i = 0; i < 20; i++) dfs(start[i]);
		Collections.sort(palprimes);
		for(Integer i : palprimes) pw.println(i);
		pw.close();
	}
	public static void dfs(String s) {
		if(isPrime(s) && a <= Integer.parseInt(s) && b >= Integer.parseInt(s)) palprimes.add(Integer.parseInt(s));
		if(s.length() + 2 > Integer.toString(b).length()) return;
		for(int i = 0; i <= 9; i++) dfs(i + s + i);
	}
	public static boolean isPrime(String s) {
		int n = Integer.parseInt(s);
		if(n % 2 == 0 || n % 3 == 0) return false;
		for(int i = 5; i <= (int) Math.sqrt(n); i += 2) if(n % i == 0) return false;
		return true;
	}
}*/
public class pprime {
	public static FastReader in = new FastReader();
	public static int a = in.nextInt(), b = in.nextInt();
	public static int numOfDigs = String.valueOf(a).length();
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("pprime.in"));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		//int a = Integer.parseInt(st.nextToken());
		//int b = Integer.parseInt(st.nextToken());
		//int numOfDigs = String.valueOf(a).length();
		//br.close();
		out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
		
		//TODO 
		//manually hardcode 1/2 dig palinprimes
		//create loop of 3dig palindromes
			//then check if prime
		//repeat for 5, 7
		//out.print(a);
		if(a <= 11) {
			if(a <= 5 && b >= 5) {
				out.println(5);
			}
			if(a <= 7 && b >= 7) {
				out.println(7);
			}
			if(b >= 11) {
				out.println(11);
			}
		}
		
		
		if(numOfDigs <= 3) {
			int d1=1, d2=0;
			if(numOfDigs == 3) {
				d2 = a % 10;
				d1 = (a / 10) % 10;
			}
//			//System.out.println(d1 + " " + d2);
			for(; d1 <= 9; d1+=2) {
				for(; d2 <= 9; d2++) {
					int potent = 100 * d1 + 10 * d2 + d1;
					if(potent < a) {
						continue;
					}
					//System.out.println("potent: " + potent + " | d1: " + d1 + " | d2: " + d2);
					if(potent > b) {
						//System.out.println(potent);
						break;
					}
					if(prime(potent)) {
						out.println(potent);
					}
				}
				d2 = 0;
			}
		}
		
		if(numOfDigs <= 5) {
			int d1=1, d2=0, d3=0;
			if(numOfDigs == 5) {
				d3 = (a / 100) % 10;
				d2 = (a / 1000) % 10;
				d1 = (a / 10000) % 10;
				//System.out.println("d1: " + d1 + " | d2: " + d2 + " | d3: " + d3);
			}
			for(; d1 <= 9; d1+=2) {
				for(; d2 <= 9; d2++) {
					for(; d3 <= 9; d3++) {
						int potent = 10000 * d1 + 1000 * d2 + 100 * d3 + 10 * d2 + d1;
						if(potent < a) {
							//System.out.println("continue 5: " + potent);
							continue;
						}
						if(potent > b) {
							break;
						}
						if(prime(potent)) {
							out.println(potent);
						}
					}
					d3 = 0;
				}
				d2 = 0;
			}
		}
		
		if(numOfDigs <= 7) {
			int d1=1, d2=0, d3=0, d4=0;
			if(numOfDigs == 7) {
				d4 = (a / 1000) % 10;
				d3 = (a / 10000) % 10;
				d2 = (a / 100000) % 10;
				d1 = (a / 1000000) % 10;
				System.out.println("d1: " + d1 + " | d2: " + d2 + " | d3: " + d3 + " | d4: " + d4);
			}
			for(; d1 <= 9; d1+=2) {
				for(; d2 <= 9; d2++) {
					for(; d3 <= 9; d3++) {
						for(; d4 <= 9; d4++) {
							int potent = 1000000 * d1 + 100000 * d2 + 10000 * d3 + 1000 * d4 + 100 * d3 + 10 * d2 + d1;
							if(potent > b) {
								break;
							}
							if(potent < a) {
								//System.out.println("continue 7");
								continue;
							}
							if(prime(potent)) {
								out.println(potent);
							}
						}
						d4 = 0;
					}
					d3 = 0;
				}
				d2 = 0;
			}
		}
		
		
		
		
		/*out.println("test");
		for(int i = a; i <= b; i++) {
			
			if(palin(i) && prime(i)) {
				out.println(i);
			}
			
			//System.out.println("i: " + i + " | numOfDigs: " + numOfDigs);
			if(i % (int) Math.pow(10, numOfDigs) == 0) {
				//System.out.println(i);
				numOfDigs++;
			}
			if(numOfDigs%2 == 0) {
				if(numOfDigs == 2) {
					out.println(11);
				}
				i = (int) Math.pow(10, numOfDigs); //((numOfDigs+1) * 10);
				numOfDigs++;
			}
			
		}
		//System.out.println(palin(151));
		//System.out.println(palin(200));
		//System.out.println(prime(100));
		//System.out.println(prime(7));
		//out.println(a + b);*/
		out.close();
	}
	
	public static boolean prime(int n) {
		if(n % 3 == 0 || n % 5 == 0) {
			return false;
		}
		int divisor = (int) Math.sqrt(n);
		while(divisor != 6) {
			if(n % divisor == 0) {
				return false;
			}
			divisor--;
		}
		
		return true;
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("pprime.in"));
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
