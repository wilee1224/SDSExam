// https://koitp.org/problem/SDS_PRO_2_4/read/
// 가장 많은 수
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class muchNum {
 
    static int n, cnt=1, ansCnt=1, ans;
    static int[]InputArr;
    
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        InputArr = new int[n+1];
        InputArr[n] = Integer.MAX_VALUE;
            
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                InputArr[i] = Integer.parseInt(st.nextToken());            
            }
            
            Arrays.sort(InputArr);
            
// 입력값 확인하기 위해 그냥 찍어 봄            
//            for (int i = 0; i <= n; i++) {
//                System.out.print(InputArr[i]+" ");
//                
//            }
            
//            System.out.println();
            for (int i = 0; i < n ; i++) {
                if(InputArr[i] == InputArr[i+1]){
                    cnt++;
                    if(ansCnt < cnt) {
                        ansCnt = cnt; 
                        ans = InputArr[i+1];
                    }
//                    System.out.print("cnt ="+cnt+ " ");
//                    System.out.print("ansCnt ="+ansCnt+ " ");
                } else cnt = 1;    
//                System.out.println();
            }
            
            System.out.println(ans);
    }
 
}

/*입력
4
1
2
3
3

출력
3
*/
