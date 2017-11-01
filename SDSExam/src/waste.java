//https://koitp.org/problem/WASTE/read/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class waste {
    
    static int n;
    static int[][]d;
    static int[][]a;
    
 
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        d = new int[n+1][n+1];
        a = new int[n+1][n+1];
        
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n ; j++) {
                    a[i][j] = Integer.parseInt(st.nextToken());        
                    // 폐지가 놓여져 있는 값 입력 받음
                }
        }
        
        for (int i = 0; i <  n ; i++) {
            for (int j = 0; j < n ; j++) {
//                System.out.print(a[i][j]+" ");    
            }
//            System.out.println();
            
        }
//        System.out.println();
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {                
                d[i][j] = Math.max(d[i-1][j],d[i][j-1]) + a[i][j];
                //현재의 바로 직전(위 또는 왼쪽) 둘 중에서 최대값과 현재의 값을 더한 값이 최대값
                
//                System.out.print(d[i][j]+" ");
            }
//            System.out.println();
        }
        
        System.out.println(d[n][n]);
        
    }
 
}

/*
입력값
4 
1 0 1 7 
2 0 2 0 
0 2 2 1
1 3 3 2

출력값 
13
*/