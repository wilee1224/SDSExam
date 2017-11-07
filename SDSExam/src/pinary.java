//https://koitp.org/problem/PINARY/read/
//이친수 문제

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pinary {
	
	static int n;
	static long[][]d;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		d = new long[n+1][2];
		
		d[1][0] = 0;
		d[1][1] = 1;
		
		for (int i = 2 ; i <= n; i++) {
			// di를 i번째까지의 이친수의 개수
			// di0은 di 자리가 0으로 끝남
			// di1은 di 자리가 1로 끝남
			d[i][0] = d[i-1][0] + d[i-1][1]; 
			d[i][1] = d[i-1][0];
		}
		System.out.println(d[n][0]+d[n][1]);
		
	}

}
/*
3

2
*/