//https://koitp.org/problem/SLIDING_WINDOWS/read/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class slidingWindows {

    static int n,k;
    static int[]arr;
    static long[]SUM;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        SUM = new long[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            SUM[i] = arr[i]+SUM[i-1];
        }

        Deque<int[]> dqn = new ArrayDeque<int[]>();
        Deque<int[]> dqm = new ArrayDeque<int[]>();

        for (int i = 1; i <= n ; i++) {

            // min값을 구하는 과정
            while(!dqn.isEmpty() && dqn.peekLast()[0] > arr[i]){
                dqn.pollLast();  //현재 들어오는 값보다 기존 last값이 크면 last값을 제거함--> 최소값 유지됨
            }

            dqn.addLast(new int[]{arr[i], i});

            if( dqn.peekFirst()[1] <= i -k){ // k간격이상 벌어지면 범위 밖 앞의 값을 버림
                dqn.pollFirst();
            }

            // max 값을 구하는 과정
            while(!dqm.isEmpty() && dqm.peekLast()[0] < arr[i]){
                dqm.pollLast();
            }

            dqm.addLast(new int[]{arr[i], i});

            if( dqm.peekFirst()[1] <= i-k){
                dqm.pollFirst();
            }

            // 최종 답을 인쇄
            if(i >=k) {
                bw.write(String.valueOf(dqn.peekFirst()[0]) + " ");
                bw.write(String.valueOf(dqm.peekFirst()[0]) + " ");
                bw.write(String.valueOf(SUM[i]-SUM[i-k] + "\n"));
            }
        }
        bw.flush();
    }

}
 
/*
8 3
1 3 -1 -3 5 3 6 7
-1 3 3
-3 3 -1
-3 5 1
-3 5 5
3 6 14
3 7 16
 
*/