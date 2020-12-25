/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: runround
*/
import java.util.*;
import java.io.*;
public class runroundConsole {
	public static FastReader in = new FastReader();
	public static long n = in.nextLong(), ans = 0;
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(System.out);//new BufferedWriter(new FileWriter("runround.out")));
		
		main_loop();
		//check1(123546);
		
		out.close();
	}
	
	public static void main_loop() {
		// TODO Auto-generated method stub
		// while loop for now
		long num = n+1;
		while(true) {
			if(!potential(num)) {
				num++;
				continue;
			}
			check1(num);
			num++;
		}
	}

	public static boolean potential(long num) {
		// TODO Auto-generated method stub
		ArrayList<Character> chars = new ArrayList<Character>();
		for(int i = 0; i < String.valueOf(num).length(); i++) {
			if(String.valueOf(num).charAt(i) == '0') {
				return false;
			}
			
			if(chars.contains(String.valueOf(num).charAt(i))) {
				return false;
			}
			chars.add(String.valueOf(num).charAt(i));
		}
		return true;
	}

	public static void check1(long num) {
		String numStr = String.valueOf(num) + String.valueOf(num);
		char[] arr = numStr.toCharArray();
		boolean[] digs = new boolean[10]; // 0 - 9
		
		//dbg
		System.out.println("numStr: " + numStr);
		System.out.println();
		
		int curr = 0;
		for(int i = 0; i < numStr.length()/2; i++) {
			//System.out.println(numStr.substring(i, i+1));
			System.out.println("curr: " + curr);
			int actualCurr = Character.getNumericValue(arr[curr]);
			System.out.println("actualCurr b4 mod: " + actualCurr);
			
			if(actualCurr > (numStr.length()/2)) {
				actualCurr %= (numStr.length()/2);
			}
			System.out.println("actualCurr: " + actualCurr);
			
			System.out.println("curr + acutalCurr: " + (curr + actualCurr));
			System.out.println("arr[curr + actualCurr]: " + arr[curr + actualCurr]);
			if(digs[Character.getNumericValue(arr[curr + actualCurr])]) {
				return;
			}
			else {
				digs[Character.getNumericValue(arr[curr + actualCurr])] = true;
			}
			
			//System.out.println(actualCurr);
			
			curr+=actualCurr;
			if(curr > (numStr.length()/2)) {
				curr %= (numStr.length()/2);
			}
		}
		
		out.println(num);
		out.close();
		System.exit(0);
	}
	
	public static void check(long num) {
		// TODO Auto-generated method stub
		System.out.println("num: " + num);
		String numStr = String.valueOf(num) + String.valueOf(num);
		System.out.println("numStr: " + numStr);
		ArrayList<Character> container = new ArrayList<Character>();//Arrays.asList(numStr.charAt(0)));
		int newboi = Integer.parseInt(numStr.substring(0, 1));
		System.out.println();
		for(int i = 0; i < numStr.length()/2; i++) {
			//System.out.println(Integer.parseInt(numStr.substring(i, i+1)));
			//+ ((Integer.parseInt(numStr.substring(i, i+1)) % numStr.length())) + 1);
			//System.out.println(i + (Integer.parseInt(numStr.substring(i, i+1)) % numStr.length())-2);
			int curr = newboi;
			System.out.println("curr: " + curr);
			int newNum;
			if(curr == numStr.length()/2) {
				newNum = curr;
			}
			else {
				newNum = curr % (numStr.length()/2);
			}
			//int newNum = Integer.parseInt(numStr.substring(i, i+1)) % (numStr.length()/2);
			System.out.println("newNum:" + newNum);
			System.out.println("charAt: " + numStr.charAt(newboi + newNum - 0));
			newboi = Integer.parseInt(String.valueOf(numStr.charAt(i + newNum - 0)));
			System.out.println("newboi: " + newboi);
			if(container.contains(numStr.charAt(i + newNum -0))) {
				//System.out.println("RETURN");
				return;
			}
			container.add(numStr.charAt(i + newNum-0));
			
			for(int j = 0; j  < container.size(); j++) {
				System.out.println("container: " + container.get(j));
			}
			System.out.println();
		}
		out.println(num);
		out.close();
		System.exit(0);
	}

	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));//FileReader(new File("runround.in")));
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
