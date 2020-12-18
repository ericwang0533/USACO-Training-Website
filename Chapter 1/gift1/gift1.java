/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: gift1
*/

import java.util.*;
import java.io.*;

public class gift1 {
	public static void main (String []args) throws IOException {
		BufferedReader input = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		StringTokenizer st = new StringTokenizer(input.readLine());
		int NP = Integer.parseInt(st.nextToken());
		
		ArrayList<String> names = new ArrayList<String>();
		int[] bank = new int[NP];
		
		for(int i = 0; i < NP; i++) {
			StringTokenizer st1 = new StringTokenizer(input.readLine());
			names.add(st1.nextToken());
		}

		for(int i = 0; i < NP; i++) {
			StringTokenizer st2 = new StringTokenizer(input.readLine());
			String person = st2.nextToken();
			int location = names.indexOf(person);
			//output.println(location);
			
			StringTokenizer st3 = new StringTokenizer(input.readLine());
			int totalMoney = Integer.parseInt(st3.nextToken());
			int getters = Integer.parseInt(st3.nextToken());
			
			if(getters != 0) {
				int price = totalMoney/getters;
				int leftover = totalMoney%getters;
				
				bank[location] = bank[location] - totalMoney + leftover;
				
				for(int j = 0; j < getters; j++) {
					StringTokenizer st4 = new StringTokenizer(input.readLine());
					String receiver = st4.nextToken();
					int location1 = names.indexOf(receiver);
					
					bank[location1] += price;
				}
			}
		}
		
		for(int i = 0; i < NP; i++) {
			output.println(names.get(i) + " " + bank[i]);
		}
		
		output.close();
		
		/*String[][] arr = new String[NP][2];
		for(int i = 0; i < NP; i++) {
			StringTokenizer st1 = new StringTokenizer(input.readLine());
			arr[i][0] = st1.nextToken();
			//output.println(arr[i]);
		}
		
		for(int i = 0; i < NP; i++) {
			StringTokenizer st2 = new StringTokenizer(input.readLine());
			StringTokenizer st3 = new StringTokenizer(input.readLine());
			int money = Integer.parseInt(st3.nextToken());
			int people = Integer.parseInt(st3.nextToken());
			int give = money/people;
			output.println(give);
			for(int j = 0; j < people; j++) {
				
			}
			
			
		}*/
		
		
	}
}
