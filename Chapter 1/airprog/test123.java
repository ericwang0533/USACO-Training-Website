import java.util.Collections;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class test123 {
	public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter("test.txt"));
		System.out.println("test");
		int m = 250;
		ArrayList<Integer> bisquares = new ArrayList<Integer>();
		for(int i = 0; i <= m; i++) {
			for(int j = 0; j <= m; j++) {
				int bisquared = (i * i) + (j * j);
				if(!bisquares.contains(bisquared)) {
					bisquares.add(bisquared);
				}
			}
		}
		Collections.sort(bisquares);
		
		for(int i = 0; i < bisquares.size(); i++) {
			out.print(bisquares.get(i) + ", ");
		}
	}
}
