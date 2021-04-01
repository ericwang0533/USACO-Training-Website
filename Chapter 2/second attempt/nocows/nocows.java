/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: nocows
*/
import java.util.*;
import java.io.*;
public class nocows {
	public static boolean testing = true;
	public static BufferedReader br; public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static PrintWriter out;
	
	public static void main(String[] args) throws IOException{
		out = (testing) ? new PrintWriter(System.out) : new PrintWriter(new FileWriter(new File("nocows.out")));
		
		out.close();
	}
	
	static class FastReader{
		public FastReader{
			try {
				br = (testing) ? new BufferedReader(new FileReader(new File("Chapter 2/second attempt/nocows/nocows.in"))) : 
			}
		}
	}
}
