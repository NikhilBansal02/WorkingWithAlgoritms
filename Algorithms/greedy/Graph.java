package greedy;

public class Graph {

	int V;
	int E;
	Edge edge[];

	Integer Parent[];

	public Graph(int v, int e) {
		V = v;
		E = e;

		edge = new Edge[E];

		for(int i=0;i<e;i++) {
			edge[i] = new Edge();
		}

		Parent = new Integer[V];

		for(int i=0;i<V;i++) {
			Parent[i] = -1;
		}
	}

	public int find(int i) {

		if(this.Parent[i] == -1) {
			return i;
		}
		
		return find(Parent[i]);
	}
	
	public void union(int x,int y) {
		
		Parent[x] = y;
	}
	
	public boolean isCycle(Graph graph) {
		
		for(int i=0;i<graph.E;i++) {
			
			int x = find(graph.edge[i].src);
			int y = find(graph.edge[i].dest);
			
			if(x == y)
				return true;
			
			union(x,y);
			
		}
		
		return false;
	}
}