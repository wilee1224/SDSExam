import java.util.Scanner;
 
public class NQueen {
    
    static int n, cnt=0 ; 
    static int[]ckCol; //colomn에 말이 있는지 check하는 배열
    static int[]ckRT;  //우(R) 상(T) 대각선에 말이 있는지 check하는 배열
    static int[]ckRB;  //우(R) 하(B) 대각선에 말이 있는지 check하는 배열
    static int[]q;
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
 
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        
        ckCol = new int[n+1];
        ckRT = new int[2*n+1];
        ckRB = new int[2*n+1];
        q = new int[n+1];
        
        dfs(0);
        System.out.print(cnt);
        
    }
 
    static void dfs(int w) //w는 행을 의미 행을 내려가면서 체크하기 위함
    {
 
            if(w == n) 
            {        
                cnt++;
                return;
            }
        
            for (int i = 0; i < n; i++) 
            {
//                System.out.print("w ="+w+"  ");
//                System.out.print("i ="+i+"  ");
//                System.out.print("ckCol[i] ="+ckCol[i]+"  ");
//                System.out.print("ckRT[w+i] ="+ckRT[w+i]+ "  ");
//                System.out.print("ckRB[n+w-i] ="+ckRB[n+w-i]+"  ");
//                System.out.println();
                
                //동일 colomm에 있는지, 우상 대각선에 있는지, 우하 대각선에 있는지 체크 후 있으면 continue
                if(ckCol[i] == 1 || ckRT[w+i] == 1 || ckRB[n+w-i] == 1) continue;
                ckCol[i] = ckRT[w+i] = ckRB[n+w-i] = 1;  //체크 후 없으면 지나갔음을 1로 표기
 
                dfs(w+1);                                //행을 증가시켜 다음 행으로 이동
                ckCol[i] = ckRT[w+i] = ckRB[n+w-i] = 0; //dfs끝나서 (w ==n) 이후에 방문했던 자리를 다시 0으로 초기화 해줌
            }
                
    }
    
    
}
/*
입력값 
4

출력값 
2
*/