import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class topologicalSort {
	
	static int v,e,x,y;
	static ArrayList<Integer>[] arr;
	static int[] indegree;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[v+1];
		indegree = new int[v+1];
		
		for (int i = 1 ; i <= v; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= e; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			arr[x].add(y); 
			arr[y].add(x);		
			indegree[y]++; //y로 들어가는 노드 번호를 indegree 배열에 하나씩 카운트
		}
		
/*		for (int i = 1; i <= v ; i++) {
			System.out.println(arr[i]);	
		}
		
		for (int i = 1; i <= v ; i++) {
			System.out.print(indegree[i]+" ");
		}
*/		
/*		Queue<Integer> Q1 = new LinkedList<Integer>();
        Queue<Integer> Q2 = new LinkedList<Integer>();
        Queue<Integer> Answer = new LinkedList<Integer>();
        for (int i = 1; i <= v; i++) {
            if (indegree[i] == 0) Q2.add(i);
        }
        while (!Q2.isEmpty()) {
            Q1 = Q2;
            Q2 = new LinkedList<Integer>();
            while (!Q1.isEmpty()) {
                int xx = Q1.poll();
                for (int yy : arr[xx]) {
                    indegree[yy]--;
                    if (indegree[yy] == 0) Q2.add(yy);
                }	
                Answer.add(xx);
            }
        }
 
        while (!Answer.isEmpty()) { 
            bw.write(Answer.poll() + ((!Answer.isEmpty())? " " : "\n"));
        }*/
		Queue<Integer> que = new LinkedList<Integer>();
		for (int i = 1; i <= v ; i++) {
			//indegree가 0 인 노드부터 que에 모두 넣음
			if(indegree[i]== 0) que.add(i);
		}
				
		while(!que.isEmpty()){
			int now = que.poll();
//			System.out.print(now+" ");
			bw.write(String.valueOf(now)+" ");
			
			//arr[now].size : 인접리스트 인덱스 항에 붙어 있는 요소의 길이 만큼만 for문을 돌린다
			for (int i = 0; i < arr[now].size(); i++) {
				//for문을 차례로 돌면서 que에서 뽑은 현재의 노드의 indegree 인덱스를 하나씩 줄어감
				indegree[arr[now].get(i)]--;
				// 현재 노드의 indegree 인덱스에 해당하는 값이 0이면 que에 그 인덱스 값을 넣는다.
				if(indegree[arr[now].get(i)] == 0) que.add(arr[now].get(i));
				
			}
						
		}
		
        bw.flush();
        bw.close();
	}
}

//
//
//bw.write(String.valueOf(dqn.peekFirst()[0]) + " ");
//bw.write(String.valueOf(dqm.peekFirst()[0]) + " ");
//bw.write(String.valueOf(SUM[i]-SUM[i-k] + "\n"));
