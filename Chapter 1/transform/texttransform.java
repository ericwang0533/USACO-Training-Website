import java.util.*;
import java.io.*;
public class texttransform{
    public static FastReader in = new FastReader();
    public static int n = in.nextInt();
    public static ArrayList<String> arr = new ArrayList<String>();
    public static ArrayList<String> used = new ArrayList<String>();
    
    public static String shift(String trans){
        int length = trans.length();
        if(length == 1){
            return trans;
        }
        String newString = trans.substring(1, length) + trans.substring(0, 1);
        return newString;
    }
    
    public static void main(String[] args) throws IOException{
        for(int i = 0; i < n; i++){
            arr.add(in.next());
        }   
        int ans = 0;
        for(int i = 1; i < n; i++){
            String newString = arr.get(i);
            for(int j = 0; j < arr.get(i).length() - 1; j++){
                newString = shift(newString);
                if(newString.equals(arr.get(i-1))){
                    System.out.println(newString);
                    used.add(newString);
                	ans++;
                }
            }
        }
        System.out.println(ans);
    }
    
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt(){
            return Integer.parseInt(next());
        }
        
        double nextDouble(){
            return Double.parseDouble(next());
        }
        
        long nextLong(){
            return Long.parseLong(next());
        }
        
        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
    } 
}