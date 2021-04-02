/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: zerosum
*/
import java.util.*;
import java.io.*;
public class zerosum {
	public static boolean testing = false;
	public static BufferedReader br; public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static PrintWriter out;
	public static int n = in.nextInt();
	public static int[] arr = new int[n + n - 1];
	public static Set<int[]> visited = new HashSet<int[]>(); 
	public static ArrayList<int[]> ans = new ArrayList<int[]>(); 
	
	public static void main(String[] args) throws IOException{
		out = (testing) ? new PrintWriter(System.out) : new PrintWriter(new FileWriter("zerosum.out"));
		
//		Arrays.fill(arr, 5);
		for(int i = 1, j = 0; j < arr.length; j+=2, i++) {
			arr[j] = i;
		}
		rc();
//		check(new int[] {1, 2, 2, 2, 3, 1, 4, 2, 5, 1, 6, 2, 7});
//		check(new int[] {1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, -1, 7});
		
		Collections.sort(ans, new customSorter());
		dbg(Arrays.deepToString(ans.toArray()));
		String str = Arrays.deepToString(ans.toArray());
		dbg(str.substring(2));
//		out.println("top");
		out.println(str.substring(2).replaceAll("\\[", "\n").replaceAll("\\,|\\]| ", "").replaceAll("-2", " ").replaceAll("-11", "+").replaceAll("-1", "-"));
//		out.println();
		out.close();
	}
	
	static class customSorter implements Comparator<int[]>{
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			for(int i = 1; i < o1.length; i+=2) {
				if(o1[i] != o2[i]) {
//					return Character.getNumericValue(o1[i]) - Character.getNumericValue(o2[i]);
					int first = -1, second = -1;
					if(o1[i] == -2) {
						first = 3;
					}
					else if(o1[i] == -11) {
						first = 2;
					}
					else if(o1[i] == -1) {
						first = 1;
					}
					
					if(o2[i] == -2) {
						second = 3;
					}
					else if(o2[i] == -11) {
						second = 2;
					}
					else if(o2[i] == -1) {
						second = 1;
					}
					
					return second - first;
				}
			}
			return 0;
		}
		
	}
	
	public static void rc() {
		// TODO Auto-generated method stub
		Queue q = new LinkedList<>();
		q.add(arr);
		q.add(1);
		while(!q.isEmpty()) {
//			dbg(q.poll());
//			dbg(q.poll());
//			dbg(q);
//			dbg("");
			int[] arr = (int[]) q.poll();
			int num = (int) q.poll();
			if(visited.contains(arr)) {
				continue;
			}
			visited.add(arr);
			
			if(num == arr.length) {
				check(arr);
				continue;
			}
			
//			dbg(Arrays.toString(arr));
//			dbg(num);
			
			int[] new1 = arr.clone();
			new1[num] = -11;
			q.add(new1);
			q.add(num+2);
			
			int[] new2 = arr.clone();
			new2[num] = -1;
			q.add(new2);
			q.add(num+2);
			
			int[] new3 = arr.clone();
			new3[num] = -2;
			q.add(new3);
			q.add(num+2);
		}
	}
	
	public static void check(int[] arr) {
		// TODO Auto-generated method stub
//		dbg("hi: " + Arrays.toString(arr));
		ArrayList<Integer> last = new ArrayList<Integer>();
		int prev = 0;
		for(int i = 0; i < arr.length; i++) {
			if(i%2 == 0) {
				prev *= 10;
				prev += arr[i];				
			}
			else{
				if(arr[i] != -2) {
					last.add(prev);
					last.add(arr[i]);
					prev = 0;
				}
			}
		}
		last.add(prev);
		
		if(last.size() == 0) {
			return;
		}
		
		int sum = last.get(0);
		for(int i = 1; i < last.size(); i+=2) {
			sum += ((last.get(i) == -1) ? -1 : 1) * last.get(i+1);
		}
		
		if(sum == 0) {
			dbg(last);
			ans.add(arr);
		}
//		dbg(sum);
		
//		dbg(last);
//		dbg("");
	}

	static class FastReader{
		public FastReader() {
			try {
				br = (testing) ? new BufferedReader(new FileReader(new File("Chapter 2/second attempt/zerosum/zerosum.in"))) : new BufferedReader(new FileReader(new File("zerosum.in")));
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
	
	static void dbg(Object obj) {
		if(testing) {
			if(obj instanceof Queue) {
				Iterator itr = ((Queue) obj).iterator();
				while(itr.hasNext()) {
					System.out.println(Arrays.toString((int[]) itr.next()));
					System.out.println(itr.next());
				}
				return;
			}
			System.out.println(obj);
		}
	}
}
