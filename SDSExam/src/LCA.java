import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LCA {
	
	static int n,r,q;
	static int[]R;
	static int[][]ia;
	static int[][]x;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // ����� ����
		r = Integer.parseInt(st.nextToken()); // ��Ʈ ��� ��ȣ
		q = Integer.parseInt(st.nextToken()); // ������ ����
		
		R = new int[n+1]; //���� ��Ī �迭
		
		x = new int[n+1][3]; //�� ����� ���԰� ����� ����� �迭
		
		//���� �Է¹���
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n ; i++) {
			R[i] = Integer.parseInt(st.nextToken());
		}
		
		ia = new int[q+1][3];
		for (int i = 1; i <= q ; i++) {
			st = new StringTokenizer(br.readLine());
			ia[i][1] = Integer.parseInt(st.nextToken());
			ia[i][2] = Integer.parseInt(st.nextToken());
		}		
		//Ȯ���� ��

		dfs(1);
		
				
	}
	
	static void dfs(int w) {
		if(x[r][2] == n) return; //��Ʈ ����� ����ÿ� ����� ���� ������ ����

		for (int i = 1; i <=n; i++) {
			if(R[i] == w){
				x[w][2] = R[i];
				
			}
			
		}
		
		
	}
	
	
}


//for (int i = 1; i <= n ; i++) {
//System.out.print(R[i]+ " ");
//}
//
//System.out.println();
//
//for (int i = 1; i <= q ; i++) {
//System.out.println(IA[i][1]+ " " + IA[i][2]);
//}
