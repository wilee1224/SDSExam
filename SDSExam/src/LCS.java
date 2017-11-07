import java.util.Scanner;

public class LCS {

	static String A, B;
	static char[]ans;
		
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		A = sc.nextLine();
		B = sc.nextLine();
		
		System.out.println(LCS(A,B));
		
		for (int i = 1; i <Math.min(A.length(),B.length()) ; i++) {
			System.out.print(ans[i]);
		}
	}

	static int LCS(String A, String B)
	{
		int[][] D = new int[A.length()+1][B.length()+1];
		
		ans = new char[Math.min(A.length(),B.length())];
//		System.out.println(A.length());
//		System.out.println(B.length());
			
		for (int i = 1; i < D.length; i++) 
		{
			for (int j = 1; j < D[i].length; j++) 
			{
				if(A.charAt(i-1) == B.charAt(j-1))
				{
					D[i][j] = D[i-1][j-1]+1;
					System.out.print("*");
//					System.out.print("A charAt ="+A.charAt(j-1)+"  ");
					ans[j-1] = A.charAt(j);
				} else
					{
						D[i][j] = Math.max(D[i-1][j], D[i][j-1]);
					}
				System.out.print(D[i][j]+" ");	

			}	
			System.out.println();
		}		
		return D[A.length()][B.length()];
	}

}
