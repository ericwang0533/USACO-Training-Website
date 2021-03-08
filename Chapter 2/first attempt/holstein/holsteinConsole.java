/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: holstein
*/
import java.util.*;
import java.io.*;
public class holsteinConsole {
	public static FastReader in = new FastReader();
	public static int vits = in.nextInt();
	public static int[] reqs = new int[vits];
	public static int feds;
	public static int[][] feeds;
	public static int ansLen = Integer.MAX_VALUE;
	public static ArrayList<Integer> ansTrack;
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(System.out);
		
		input();
		
		
		
		for(int i = 0; i < feds; i++) {
			System.out.println("i: " + i);
			ArrayList<Integer> track1 = new ArrayList<Integer>();
			solve(i, reqs, 0, track1);
		}
		
		System.out.println("ansLenans: " + ansLen);
		//System.out.println(ansTrack.size());
		out.print(ansLen + " ");
		for(int i = 0; i < ansTrack.size(); i++) {
			System.out.println(ansTrack.get(i)+1);
			out.print(ansTrack.get(i) + 1  + " ");
		}
		//out.println("test");
		out.close();
	}
	
	public static void solve(int num, int[] temp, int size, ArrayList<Integer> track) {
		System.out.println(num + " " + size);
		for(int i = 0; i < track.size(); i++) {
			System.out.println("track: " + (track.get(i) + 1));
		}
		
		if(enough(temp)) {
			System.out.println("enough is corrected");
			if(size < ansLen) {
				ansLen = size;
				System.out.println("ansLen inside first if: " + ansLen);
				Collections.sort(track);
				ansTrack = (ArrayList<Integer>) track.clone();
			}
			else if(size == ansLen) {
				Collections.sort(track);
				for(int i = 0; i < track.size(); i++) {
					if(track.get(i) != ansTrack.get(i)) {
						if(track.get(i) < ansTrack.get(i)) {
							ansTrack = (ArrayList<Integer>) track.clone();
						}
						else {
							break;
						}
					}
				}
			}
			System.out.println("ansLen: " + ansLen);
			for(int i = 0; i < ansTrack.size(); i++) {
				System.out.println("ansTrack: " + (ansTrack.get(i)+1));
			}
			return;
		}
		
		if(num+1 > feds) {
			return;
		}
		
		int[] temp1 = new int[vits];
		track.add(num);
		for(int i = 0; i < vits; i++) {
			temp1[i] = temp[i] - feeds[num][i];
		}
		for(int i = num+1; i <= feds; i++) {
			solve(i, temp1, size+1, track);
			//track.remove(track.size()-1);
		}
		if(track.size() >= 1) {
			track.remove(track.size()-1);
		}
		
	}
	
	public static boolean enough(int[] temp) {
		for(int i = 0; i < vits; i++) {
			System.out.println(temp[i]);
		}
		for(int a = 0; a < vits; a++) {
			// check if enough vitamins
			if(temp[a] > 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void input() {
		for(int i = 0; i < vits; i++) {
			reqs[i] = in.nextInt();
		}
		
		feds = in.nextInt();
		feeds = new int[feds][vits];
		for(int i = 0; i < feds; i++) {
			for(int j = 0; j < vits; j++) {
				feeds[i][j] = in.nextInt();
			}
		}
		
		// potentially need to sort feeds from small to greatest?
		// question is kind of vague w/ "smallest feedtype numbers"
	}
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));//new FileReader("holstein.in"));
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
