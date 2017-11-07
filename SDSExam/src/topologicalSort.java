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
			indegree[y]++; //y�� ���� ��� ��ȣ�� indegree �迭�� �ϳ��� ī��Ʈ
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
			//indegree�� 0 �� ������ que�� ��� ����
			if(indegree[i]== 0) que.add(i);
		}
				
		while(!que.isEmpty()){
			int now = que.poll();
//			System.out.print(now+" ");
			bw.write(String.valueOf(now)+" ");
			
			//arr[now].size : ��������Ʈ �ε��� �׿� �پ� �ִ� ����� ���� ��ŭ�� for���� ������
			for (int i = 0; i < arr[now].size(); i++) {
				//for���� ���ʷ� ���鼭 que���� ���� ������ ����� indegree �ε����� �ϳ��� �پ
				indegree[arr[now].get(i)]--;
				// ���� ����� indegree �ε����� �ش��ϴ� ���� 0�̸� que�� �� �ε��� ���� �ִ´�.
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
