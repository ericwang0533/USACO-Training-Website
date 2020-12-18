/* Use the slash-star style comments or the system won't see your
   identification information */
/*
ID: your_id_here
LANG: JAVA
TASK: friday
*/

import java.util.*;
import java.io.*;

public class friday {
	/*public static void main(String[] args) throws IOException {
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
	    BufferedReader br = new BufferedReader(new FileReader("friday.in"));
	    int years = Integer.parseInt(br.readLine())-1;
	    int dayOfWeek = 2;
	    int[] week = new int[] {0, 0, 0, 0, 0, 0, 0};
	    int[] month = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	    for (int y = 1900; y <= 1900+years; y++) {
	        boolean leap = false;
	        if (y % 400 == 0) {
	            leap = true;
	        } else if (y % 100 == 0) {
	            leap = false;
	        } else if (y % 4 == 0) {
	            leap = true;
	        } else {
	            leap = false;
	        }
	        if (leap) {
	            month[1] = 29;
	        } else {
	            month[1] = 28;
	        }
	        for (int m: month) {
	            dayOfWeek+=12;
	            dayOfWeek%=7;
	            week[dayOfWeek]++;
	            dayOfWeek+=m-12;
	        }
	    }
	    out.println(week[0]+" "+week[1]+" "+week[2]+" "+week[3]+" "+week[4]+" "+week[5]+" "+week[6]);
	    br.close();
	    out.close();
	  }*/

		public static void main (String []args) throws IOException {
		BufferedReader input = new BufferedReader(new FileReader("friday.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter (new FileWriter("friday.out")));
		StringTokenizer st = new StringTokenizer(input.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[7];
		//int[] add = {3, 2, 3, 0, 3, 2, 3, 2, 3, 3, 2, 3};
		int[] add = {3, 3, 0, 3, 2, 3, 2, 3, 3, 2, 3, 2};
		
		
		//int day = 3;
		int day = 5;
		
		int year = 1900;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 12; j++) {
				
				if(isLeapYr(year) == true && j == 2) {
					day += 1;
					if(day > 7) {
						day %= 7;
					}
					arr[day-1]++;
					//out.println(" " + j + " leap");
					//out.println(day);
				}
				else {
					day += add[j];
					if(day > 7) {
						day %= 7;
					}
					arr[day-1]++;
					//out.println(" " + j + " ");
					//out.println(day);
				}
				
			}
			year++;
		}
		
		
		out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " + arr[4] + " " + arr[5] + " " + arr[6]);
		out.close();
	}
	
	public static boolean isLeapYr (int year) {
		Boolean isLeapYr = false;
		if(year%4 == 0) {
			if(year%100 == 0) {
				if(year%400 == 0) {
					isLeapYr = true;
				}
			}
			else {
				isLeapYr = true;
			}
		}
		return isLeapYr;
	}
}



/*int month = 1;
		
		int arr[] = new int[7];
		
		int day = 7;
		Boolean leapyear = false;
		for(int i = 0; i < 1; i++) {
			for(int j = 0; j < 12; j++) {
				if(month%2 == 1) { //31 days
					//31
					//add three days
					if(day == 4) {
						day = 7;
					}
					else{
						day += 3;
						day %= 7;
					}
					arr[day-1]++;
					out.println("31, j: " + j + "num: " + day);
					//out.println(day);
				}
				else { // if month is EVEN
					if (leapyear == false && j == 1) { //IF IT IS FEBURARY and it isnt a LEAP YEAR (28 days)
						arr[day-1]++;
						out.println("28, j: " + j + "num: " + day);
						//out.println(day);
					}
					else if(leapyear == true && j == 1) { // IF IT IS FEBURARY and it is a LEAP YEAR (29 days)
						if(day == 6) {
							day = 7;
						}
						else {
							day += 1;
							day %= 7;
						}
						
						arr[day-1]++;
						out.println("29, j: " + j + "num: " + day);
					}
					else if(j == 7) { // IF IT IS AUGUST the 8th month (j = 7), (31 DAYS)
						month++;
						out.println("J = 7 SKIPED LOL");
						continue;
					}
					else { // 30 days
						if(day == 5) {
							day = 7;
						}
						else {
							day += 2;
							day %= 7;
						}
				
						arr[day-1]++;
						out.println("30, j:" + j + "num: " + day);
					}
				}
				month++;
			}
		}
		
		out.println(arr[0] + " " + arr[1] + " " + arr[2] + " " + arr[3] + " " + arr[4] + " " + arr[5] + " " + arr[6]);
		out.close();*/
