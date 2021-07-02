package greedy;

public class WeightedGraph {
	
	int V;
	int E;
	WeightedEdge edge[];

	public WeightedGraph(int v, int e) {
		V = v;
		E = e;

		edge = new WeightedEdge[E];

		for(int i=0;i<e;i++) {
			edge[i] = new WeightedEdge();
		}

	}
}
