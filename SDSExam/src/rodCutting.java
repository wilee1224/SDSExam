import java.util.Scanner;

public class rodCutting {

	static int tc, N, max;
	static int[]val;
	static int[]D;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();		
		val = new int[N+1];
		D  = new int[N+1];

		for (int i = 1; i <= N; i++) {  //길이별 가치 입력받음
			val[i] = sc.nextInt();			
		}
//		for (int i = 1; i <= N; i++) {
//			System.out.print(val[i]+" ");
//		}

		

//		System.out.println();
		for (int i = 1; i <= N; i++) {
			int max = 0;
			for (int j = 1; j <= i; j++) {
				if(max < D[i-j]+val[j]){
					max = D[i-j]+val[j];
//					System.out.println("i : "+i+", max :"+max);
				}				
			}
			D[i] = max;
		}
		System.out.println(D[N]);
	}
}