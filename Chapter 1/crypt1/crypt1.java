/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: crypt1
*/
import java.util.*;
import java.io.*;
public class crypt1 {
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static ArrayList<Integer> arr = new ArrayList<Integer>();
	public static int ans = 0;
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
		input();
		
		int three = (arr.get(0) * 100) + (arr.get(0) * 10) + arr.get(0); 
		int two = (arr.get(0) * 10) + (arr.get(0));
		if(five(three, two) && partials(three, two)) {
			ans++;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; i < n; j++) {
				for(int a = 0; a < n; a++) {
					for(int b = 0; b < n; b++) {
						for(int c = 0; c < n-1; c++) {
							//switch the ones digit of two
							two = two - arr.get(c) + arr.get(c+1);
							System.out.println("three: " + three + " | two: " + two + " | c");
							if(five(three, two) && partials(three, two)) {
								ans++;
							}
						}
						
						if(b == n-1) {
							break;
						}
						//switch the tens digit of two
						two = (arr.get(b+1) * 10) + arr.get(0);
						System.out.println("three: " + three + " | two: " + two + " | b");
						if(five(three, two) && partials(three, two)) {
							ans++;
						}
					}
					
					if(a == n-1) {
						break;
					}
					//switch the ones digit of three
					three = three - arr.get(a) + arr.get(a+1);
					two = (arr.get(0) * 10) + (arr.get(0));
					System.out.println("three: " + three + " | two: " + two + " | a");
					if(five(three, two) && partials(three, two)) {
						ans++;
					}
				}
				
				if(j == n-1) {
					break;
				}
				//switch the tens digit of three
				int temp = (three % 100);
				System.out.println("temp: " + temp);
				three = three - temp + (arr.get(j+1) * 10) + arr.get(0);
				two = (arr.get(0) * 10) + (arr.get(0));
				System.out.println("three: " + three + " | two: " + two + " | j");
				if(five(three, two) && partials(three, two)) {
					ans++;
				}
			}
			
			if(i == n-1) {
				break;
			}
			//switch the hundreds digit of three
			three = (arr.get(i+1) * 100) + (arr.get(0) * 10) + arr.get(0); 
			two = (arr.get(0) * 10) + (arr.get(0));
			System.out.println("three: " + three + " | two: " + two + " | i");
			if(five(three, two) && partials(three, two)) {
				ans++;
			}
		}
		
		out.println(ans);
		//out.println("test");
		out.close();
	}
	
	public static boolean five(int three, int two) {
		int prod = three * two;
		if(String.valueOf(prod).length() != 4) {
			return false;
		}
		else {
			for(int i = 0; i < 4; i++) {
				if(!arr.contains(prod % 10)) {
					return false;
				}
				prod /= 10;
			}
		}
		return true;
	}
	
	public static boolean partials(int three, int two) {
		int partial1 = three * (two % 10);
		if(String.valueOf(partial1).length() != 3) {
			return false;
		}
		else {
			for(int i = 0; i < 3; i++) {
				if(!arr.contains(partial1 % 10)) {
					return false;
				}
				partial1 /= 10;
			}
		}
		
		int partial2 = three * (two / 10);
		if(String.valueOf(partial2).length() != 3) {
			return false;
		}
		else {
			for(int i = 0; i < 3; i++) {
				if(!arr.contains(partial2 % 10)) {
					return false;
				}
				partial2 /= 10;
			}
		}
		
		return true;
	}
	
	public static void input() {
		for(int i = 0; i < n; i++) {
			arr.add(in.nextInt());
		}
		Collections.sort(arr);
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("crypt1.in"));
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
