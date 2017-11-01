//https://koitp.org/problem/ASSEMBLY_LINE_SCHEDULING/read/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class assemblyLine 
{
    
    static int n,e1,e2,x1,x2,ans;
    static int[][]a;
    static int[][]t;
    static int[][]s;
 
    
    public static void main(String[] args) throws IOException
    {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        e1 = Integer.parseInt(st.nextToken());
        e2 = Integer.parseInt(st.nextToken());
        x1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
 
        a = new int[3][n+1];
        t = new int[3][n];
        s = new int[3][n+1];
 
        for (int i = 1; i <= 2; i++) 
        {
            st = new StringTokenizer(br.readLine());  
            // 위의 readline에서 readline이 끝났기 때문에 한번 더 선언을 해 주어야 함
            for (int j = 1; j <= n ; j++) 
            {
                a[i][j] = Integer.parseInt(st.nextToken());
            }    
            
        }
        
        for (int i = 1; i <= 2; i++) 
        {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n ; j++) 
            {
                t[i][j] = Integer.parseInt(st.nextToken());
            }    
            
        }
        
        s[1][1] = e1 + a[1][1];
        s[2][1] = e2 + a[2][1];
        
        for (int i = 2 ; i <= n; i++) 
        {
            s[1][i] = Math.min(s[1][i-1], s[2][i-1]+t[2][i-1])+a[1][i];
            s[2][i] = Math.min(s[2][i-1], s[1][i-1]+t[1][i-1])+a[2][i];
        }
        
        System.out.println(Math.min(s[1][n] + x1, s[2][n] + x2));
        
    }
    
}


/*
입력
6 2 4 3 2 
7 9 3 4 8 4 
8 5 6 4 5 7 
2 1 1 3 4 
2 1 2 2 1

출력값
38
*/

