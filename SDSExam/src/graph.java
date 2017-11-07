import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class graph {
	
	static int V,E,S,start,end;
	static boolean visited[];
	static ArrayList<Integer>[] adjList;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
	
		adjList = new ArrayList[V+1];
		visited = new boolean[V+1];
		
		for (int i = 1 ; i <= V; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
//			System.out.println(start + " " + end);
			adjList[start].add(end);
			adjList[end].add(start);
			
		}
		
		for (int i = 1; i <= V ; i++) {
			Collections.sort(adjList[i]);	
		}
		
		
//		for (int i = 1; i <= V ; i++) {
//			System.out.println(adjList[i]);	
//		}
		dfs(S);
		System.out.println();
		bfs(S);
	}
	
	static void dfs(int node)
	{
		visited[node] = true;
		System.out.print(node+" ");
		
		//인접리스트의 인덱스(node)를 기준으로 i를 하나씩 증가하면 가져옴
		for (int i = 0; i < adjList[node].size() ; i++) {
			if(!visited[adjList[node].get(i)]){
				dfs(adjList[node].get(i));
			}
		}
	}
	
	static void bfs(int node){
		//위에서 dfs에 visited를 사용했기 때문에 초기화
		for (int a = 1 ; a <= V; a++) visited[a] = false; 
    	Queue <Integer> que = new LinkedList<Integer>();
    	que.add(node);
        visited[node] = true;
        while(!que.isEmpty())
        {
    		int now = que.poll();
        	System.out.print(now+" ");
    		for(int i = 0 ; i < adjList[now].size(); i++){
    			if(!visited[adjList[now].get(i)]){
    				visited[adjList[now].get(i)] = true;
    				que.add(adjList[now].get(i));
    			}
    		}
    	}
    }

}