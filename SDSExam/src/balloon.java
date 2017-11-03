import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class balloon {
    
    static int n, ans;
    static int[]h,a;
    
 
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        
        h = new int[n+1];
        a = new int[n+1];
        
        st = new StringTokenizer(br.readLine());        
        for (int i = 1; i <= n; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }
    
        ans = 1;
        
        for (int i = 2; i <= n ; i++) {
            System.out.print("i :"+i+ " ");
            if(h[i] == h[i-1]-1) {System.out.print("감소"); continue;}    
            if(h[i] == h[i-1]) {System.out.print("동등"); ans++;}
            if(h[i] > h[i-1]) {System.out.print("증가");ans++;}
            System.out.println("ing ans :"+ans);
                
            }
        
        System.out.println(ans);
        
        }
    }