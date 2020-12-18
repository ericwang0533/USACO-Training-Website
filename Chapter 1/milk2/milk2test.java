import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class milk2test {
	public static void main(String[] args) throws IOException{
		int n = 6;
		
		int[][] arr = { {100, 200}, {200, 400}, {500, 800}, {800, 1600}, {50, 100}, {1700, 3200}};

		
		/*if(arr[i][0] <= arr[i-1][1]) {		// the times connected
			counter += arr[i][1] - arr[i-1][1];
		}
		else {
			max = Math.max(counter, max);
			min = Math.max(min, arr[i][0] - arr[i-1][1]);
		}*/
		
		// attempt to sort a 2d array
		Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
		
		int max = arr[0][1] - arr[0][0];
		int min = 0;
		int counter = max;
		int startend = arr[0][1];
		
		/*for(int i = 1; i < n; i++) {
			if(arr[i][0] <= arr[i-1][1]) {
				if(arr[i][1] > arr[i-1][1]) {
					counter += arr[i][1] - arr[i-1][1];
				}
				startend = arr[i][1];
			}
			else {
				max = Math.max(max, counter);
				if(arr[i][1] > startend) {
					min = Math.max(min, arr[i][0] - arr[i-1][1]);
				}
				counter = 0;
			}
		}*/
		
		for(int i = 1; i < n; i++) {
			if(arr[i][0] <= startend) {
				if(arr[i][1] > startend) {
					counter += arr[i][1] - arr[i-1][1];
					startend = arr[i][1];
				}
			}
			else {
				max = Math.max(max, counter);
				if(arr[i][1] > startend) {
					min = Math.max(min, arr[i][0] - arr[i-1][1]);
				}
				counter = 0;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(max + " " + min);
		//out.close();
	}
}
