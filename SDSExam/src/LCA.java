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
		
		n = Integer.parseInt(st.nextToken()); // 노드의 개수
		r = Integer.parseInt(st.nextToken()); // 루트 노드 번호
		q = Integer.parseInt(st.nextToken()); // 질의의 개수
		
		R = new int[n+1]; //조상 지칭 배열
		
		x = new int[n+1][3]; //각 노드의 진입과 진출시 기록할 배열
		
		//값을 입력받음
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
		//확인차 찍어봄

		dfs(1);
		
				
	}
	
	static void dfs(int w) {
		if(x[r][2] == n) return; //루트 노드의 진출시에 기록이 남아 있으면 종료

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
