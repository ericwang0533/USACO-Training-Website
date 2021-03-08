/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: money
*/
import java.util.*;
import java.io.*;
public class moneyConsole {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static int v = in.nextInt(), n = in.nextInt();
	public static Integer[] coins = new Integer[v];
	public static long[] ans = new long[n+1];
	public static long[] kc = new long[n+1];
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = new PrintWriter(System.out);//new BufferedWriter(new FileWriter("money.out")));
	
		input();		
		solve();
		
		for(int i = 0; i <= n; i++) {
			System.out.println(ans[i]);
		}
		
		
		out.println(ans[n]);
		out.close();
	}
	
	public static void solve() {
		// TODO Auto-generated method stub
		ans[0] = 1;

        // loop over every possible coin value
        for (int i = 0; i < coins.length; i++) {
            // loop over every sum
            for (int j = coins[i]; j < ans.length; j++) {
                // checks that j-coins[i] is greater or equal to 0
                //if (j >= coins[i]) {
                    // The number of ways to get a sum of j is the sum of all the number of ways to
                    // get values that are less than j by a value in coins[].

                    // If you add one coin of value coins[i] then the sum is coins[i] more.
                    // You can add the number of sums that are less than j by a number in coins[].
                    ans[j] += ans[j - coins[i]];
                    for(int a = 0; a <= n; a++) {
            			System.out.println(a + ": " + ans[a]);
            		}
                    System.out.println();
                //}
            }
        }
	}

	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < v; i++) {
			coins[i] = in.nextInt();
			
//			if(coins[i] <= n) {
//				kc[coins[i]]++;
//			}
//			
//			for(int j = 0; j < i; j++) {
//				if(coins[i] + coins[j] <= n) {
//					kc[coins]
//				}
//			}
			
		}
		Arrays.sort(coins);
//		ArrayList<Integer> unused_coins = new ArrayList<Integer>(Arrays.asList(coins));
//		kc_fill(0, 0, unused_coins);
//	
//		for(int i = 0; i < n+1; i++) {
//			System.out.println(i + ": " + kc[i]);
//		}
	}

	public static void kc_fill(int count, int ind, ArrayList<Integer> unused_coins) {
		// TODO Auto-generated method stub
		
		System.out.println("count: " + count + " | ind: " + ind);
		
		if(count <= n) {
			kc[count]++;
		}
		
		if(ind == v) {
			return;
		}
		
		int size = unused_coins.size();
		for(int i = 0; i < v; i++) {
			//System.out.println("coins[i]: " + coins[i]);
//			if(unused_coins.contains(coins[i])) {
//				unused_coins.remove(unused_coins.indexOf(coins[i]));
				kc_fill(count+coins[i], ind+1, unused_coins);
//			}
			
//			count-=coins[i];
		}
	}

	static class FastReader{
		public FastReader(){
			br = new BufferedReader(new InputStreamReader(System.in));//FileReader("money.in"));
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
