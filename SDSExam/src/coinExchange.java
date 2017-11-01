import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
//동전교환
//https://koitp.org/problem/COIN/read/
// 주어진 동전이 배수관계에 있다면 그리디, 그렇지 않으면 DP로 접근
 
public class coinExchange {
    
    static int n,W;
    static int[]c;
    static int[][]d;
 
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        c = new int[n+1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
 
        for (int i = 1; i <= n ; i++) {
            System.out.print (c[i]+" ");
            
        }
        
        
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
 
        d = new int[n+1][W+1];
        
        for (int i = 1; i <= W; i++) {
            d[0][i] = -1;
        }
        
        d[0][0] = 0;        
        for (int i = 1; i <= n ; i++) {
            for (int j = 0; j <= W; j++) {
                d[i][j] = d[i-1][j];
                if(j-c[i] >= 0 && d[i][j-c[i]] != -1) {
                    if(d[i][j] == -1 || d[i][j] > d[i][j-c[i]]+1)
                        d[i][j] = d[i][j-c[i]]+1;
                }
                        
            }
            
        }
        
        System.out.println(d[n][W]);
        
    }
 
}