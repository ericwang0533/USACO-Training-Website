/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: zerosum
*/
import java.util.*;
import java.io.*;
public class zerosum1 {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static ArrayList<String> ans = new ArrayList<String>();
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(new BufferedWriter(new FileWriter("zerosum.out")));
		
		ArrayList<String> arr = new ArrayList<String>();
		int j = 1;
		for(int i = 0; i < n+(n-1); i++) {
			if(i%2 == 0) {
				arr.add(String.valueOf(j));
				j++;
			}
			else {
				arr.add(null);
			}
		}
		
//		for(int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		
//		ArrayList<String> temp = new ArrayList<String>(Arrays.asList("1","-","2","-","3","-","4"," ","5"," ","6","-","7"));
//		check(temp);
		
		solve(arr, 1);
		
		Collections.sort(ans);
		for(int i = 0; i < ans.size(); i++) {
			out.println(ans.get(i));
		}
		
		out.close();
	}
	
	public static void solve(ArrayList<String> arr, int pos) {
		// TODO Auto-generated method stub
		if(pos == arr.size()) {
			check(arr);
			return;
		}
		
		arr.set(pos, "+");
		solve(arr, pos+2);
		arr.set(pos, "-");
		solve(arr, pos+2);
		arr.set(pos, " ");
		solve(arr, pos+2);
	}

	public static void check(ArrayList<String> arr) {
		// TODO Auto-generated method stub
//		System.out.println(arr.toString());
//		System.out.println(arr.toString());
		ArrayList<String> cloned = (ArrayList<String>) arr.clone();
		while(cloned.contains(" ")) {
			int spaceInd = cloned.indexOf(" ");
			
			int multiplier = 1;
			while(cloned.get(spaceInd-multiplier).equals("0")) {
				multiplier+=2;
			}
//			System.out.println(multiplier);
			cloned.set(spaceInd-multiplier, (cloned.get(spaceInd-multiplier) + cloned.get(spaceInd+1)));
			cloned.set(spaceInd, "+");
			cloned.set(spaceInd+1, "0");
			
//			System.out.println(cloned.toString());
		}
		
		
//		System.out.println(cloned.toString());
		
		int sum = Integer.parseInt(cloned.get(0));
		for(int i = 1; i < cloned.size(); i+=2) {
			if(cloned.get(i).equals("+")) {
				sum += Integer.parseInt(cloned.get(i+1));
			}
			else {
				sum -= Integer.parseInt(cloned.get(i+1));
			}
		}
		
		if(sum == 0) {
			String line = arr.toString();
			line = line.substring(1, line.length()-1);
			line = line.replaceAll(", ", "");
			ans.add(line);
			//System.out.println(line);
		}
//		System.out.println(sum);
//		System.out.println();
//		int sum = Integer.parseInt(arr.getarr.size()-1]);
//		int oldSign = 0;
//		for(int i = arr.length-2; i >= 1; i-=2) {
////			System.out.print(arr[i]);
//			if(!arr[i].equals(" ")) {
//				if(arr[i].equals("+")) {
//					sum += Integer.parseInt(arr[i-1]);
//					oldSign = 1;
//				}
//				else {
//					// its a minus
//					sum -= Integer.parseInt(arr[i-1]);
//					oldSign = -1;
//				}
//			}
//			else {
//				// its a space (a.k.a, ggwp gl lol)
//				if(oldSign != 0) {
//					sum += (oldSign * Integer.parseInt(arr[i+1]));
//				}
//				arr[i-3] += arr[i-1];
//			}
////			System.out.println(sum);
//		}
		
//		System.out.println(sum);
//		System.out.println();
		
	}
	
	static class FastReader{
		public FastReader() {
			try {
				br = new BufferedReader(new FileReader("zerosum.in"));
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
