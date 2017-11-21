//https://koitp.org/problem/ASSEMBLY_LINE_SCHEDULING/read/

/*
문제
    명우네 공장에는 두 개의 생산라인이 있고, 각 라인에는 n개의 공정이 순서대로 있다.
    하나의 제품이 완성이 되려면 두 생산라인 중 한 생산라인을 정해, 그 생산라인에 미완성 제품이 들어가고
    그 생산라인의 n개의 공정을 순서대로 지나, 생산라인에서 생산을 마무리하여 완성된다. 중간에 생산라인을 바꿀 수도 있다.

    첫 번째 생산라인의 i번째 공정에서 소요되는 시간은 S1,i이고, 두 번째 생산라인의 i번째 공정에서 소요되는 시간은 S2,i이다.
    그리고 첫 번째 생산라인에 진입하는 시간은 e1, 두 번째 생산라인에 진입하는 시간은 e2이고,
    첫 번째 생산라인에서 생산을 마무리 하는 시간은 x1, 두 번째 생산라인에서 생산을 마무리 하는 시간은 x2이다.
    마지막으로 첫 번째 생산라인의 i번째 공정을 마치고 두 번째 생산라인으로 바꾸는데 걸리는 시간은 t1,i이고,
    두 번째 생산라인의 i번째 공정을 마치고 첫 번째 생산라인으로 바꾸는데 걸리는 시간은 t2,i이다.
    즉, 명우의 공장은 아래와 같은 그림으로 표현된다.

    명우는 자신이 만들어놓은 공장에서 하나의 제품을 만드는데 걸리는 최소 시간을 알고 싶어한다.
    명우를 도와 하나의 제품을 만드는데 걸리는 최소 시간을 구하는 프로그램을 작성하시오.

입력
    첫 줄에 라인별 공정의 개수 n, 라인별 진입 시간과 마무리 시간 e1, e2, x1, x2가 주어진다.
    (2≤n≤300,000, 1 ≤ e1, e2, x1, x2 ≤ 200)

    두 번째 줄에 S1,1,S1,2,…,S1,n를 나타내는 n개의 자연수가 공백으로 구분되어 주어진다. (1≤S1,i≤200)
    세 번째 줄에 S2,1,S2,2,…,S2,n를 나타내는 n개의 자연수가 공백으로 구분되어 주어진다. (1≤S2,i≤200)
    네 번째 줄에 t1,1,t1,2,…,t1,n−1를 나타내는 n−1개의 자연수가 공백으로 구분되어 주어진다. (1≤t1,i≤200)
    다섯 번째 줄에 t2,1,t2,2,…,t2,n−1를 나타내는 n−1개의 자연수가 공백으로 구분되어 주어진다. (1≤t2,i≤200)

출력
    첫 줄에 하나의 제품을 만드는데 걸리는 최소 시간을 출력한다.
*/

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

