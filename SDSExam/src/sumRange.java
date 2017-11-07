import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sumRange {
	
	static int n,q,tn,s,e;
	static int[]arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		q = Integer.parseInt(st.nextToken());
				
		arr = new int[2*n];
		tn = 2*n-1;
		s = s + tn -1;
		e = e + tn -1;
		
		for (int i = 0; i < n ; i++) {
			arr[i] = i+1;
		}
		
		
		
		
		
		
	}

}
