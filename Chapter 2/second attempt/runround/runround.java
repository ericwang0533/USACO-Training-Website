/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: runround
*/

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
public class runround {
	public static boolean debug = false, testing = false;
	public static BufferedReader br; public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static PrintWriter out;
	public static long m = in.nextLong();
	
	public static void main(String[] args) throws IOException{
		out = (testing) ? new PrintWriter(System.out) : new PrintWriter(new FileWriter("runround.out"));
		
//		dbg(rb(81362));
		
//		m++;
		while(true) {
//			// optimize m++
//			// unique digits
			m++;
			while(!uni(m)) {
				m++;
			}
			
			if(rb(m)) {
				out.println(m);
				break;
			}
//			dbg(m);
		}
		
		out.close();
	}
	
	public static boolean uni(long num) {
		// TODO Auto-generated method stub
		
//		return !(num+"").matches(".*(.).*\\1.*");
		
		char[] arr = String.valueOf(num).toCharArray();
		Arrays.sort(arr);
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] == arr[i-1]) {
				return false;
			}
		}
		
		return true;
	}

	public static boolean rb(long num) {
		// TODO Auto-generated method stub
//		List<Character> list = String.valueOf(num).chars().mapToObj((i) -> Character.valueOf((char)i)).collect(Collectors.toList());
		List<Integer> list = String.valueOf(num).chars().mapToObj((i) -> Integer.valueOf(Character.valueOf((char)i))-48).collect(Collectors.toList());
		
		int size = list.size();
		ArrayList<Integer> visited = new ArrayList<Integer>();
		
//		for(char a : arr) {
//			dbg(a);
//		}
		
//		dbg(size);
//		dbg(list);
		
		int prev = 0;
		for(int i = 0; i < size; i++) {
//			dbg(prev + list.get(prev));
//			int next = (prev + list.get(prev) - 48) % size;
			int next = (prev + list.get(prev)) % size;
//			dbg(list.get(prev));
//			dbg(next + " " + list.get(next));
			
			if(visited.contains(next)) {
				return false;
			}
			
			visited.add(next);
			prev = next;
		}
		
		return true;
	}

	static class FastReader{
		public FastReader() {
			try {
				br = (testing) ? new BufferedReader(new InputStreamReader(System.in)) : new BufferedReader(new FileReader(new File("runround.in")));
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
		
		String nextLing() {
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
