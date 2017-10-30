import java.util.Scanner;
 
public class assemblyLine 
 
{
    static int n,e1,e2,x1,x2,ans;
    static int[][]a;
    static int[][]t;
    static int[][]s;
 
    public static void main(String[] args) 
    {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
 
        n = sc.nextInt();
        e1 = sc.nextInt();
        e2 = sc.nextInt();
        x1 = sc.nextInt();
        x2 = sc.nextInt();
 
        a = new int[3][n+1];
        t = new int[3][n];
        s = new int[3][n+2];
 
        for (int i = 1; i <= 2; i++) 
        {
            for (int j = 1; j <= n ; j++) 
            {
                a[i][j] = sc.nextInt();
            }    
        }
 
        for (int i = 1; i <= 2; i++) 
        {
            for (int j = 1; j < n ; j++) 
            {
                t[i][j] = sc.nextInt();
            }    
        }
 
        s[1][1] = e1 + a[1][1];
        s[2][1] = e2 + a[2][1];
 
        for (int i = 2 ; i <= n; i++) 
        {
            s[1][i] = Math.min(s[1][i-1], s[2][i-1]+t[2][i-1])+a[1][i];
            s[2][i] = Math.min(s[2][i-1], s[1][i-1]+t[1][i-1])+a[2][i];
        }
 
        s[1][n+1] = s[1][n] + x1;
        s[2][n+1] = s[2][n] + x2;
 
        ans = Math.min(s[1][n+1], s[2][n+1]);
 
        System.out.println(ans);
    }
}