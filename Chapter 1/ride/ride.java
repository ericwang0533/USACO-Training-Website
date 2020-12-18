/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: ride
*/

import java.io.*;
import java.util.*;

class ride {
	public static void main (String []args) throws IOException{
		BufferedReader input = new BufferedReader(new FileReader("ride.in"));
		PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		StringTokenizer st = new StringTokenizer(input.readLine());
		StringTokenizer st1 = new StringTokenizer(input.readLine());
		
		String comet = st.nextToken();
		String group = st1.nextToken();
		char[] cometChars = comet.toCharArray();
		char[] groupChars = group.toCharArray();
		int cometNum = 1;
		int groupNum = 1;
		
		for(int i = 0; i < cometChars.length; i++) {
			int num = cometChars[i];
			//System.out.println(cometChars[i]);
			//System.out.println(num);
			num -= 64;
			//System.out.println(num);
			cometNum *= num;
			
		}
		
		for(int i = 0; i < groupChars.length; i++) {
			int num = groupChars[i];
			num -= 64;
			groupNum *= num;
		}
		
		if((cometNum % 47) == (groupNum % 47)) {
			output.println("GO");
		}
		else {
			output.println("STAY");
			//output.println(cometNum);
			//output.println(groupNum);
		}
		//output.println("tet");
		output.close();
	}
}
