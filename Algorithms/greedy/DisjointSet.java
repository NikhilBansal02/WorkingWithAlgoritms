/*
 * Disjoint Set (Or Union-Find)
 * Set 1 (Detect Cycle in an Undirected Graph)
 * https://www.geeksforgeeks.org/union-find/
 * 
 */
package greedy;

public class DisjointSet {
	

	public static void main(String[] args) {
		
		Graph graph = new Graph(3,3);

		graph.edge[0].src  = 0;
		graph.edge[0].dest = 1;
		
		graph.edge[1].src  = 1;
		graph.edge[1].dest = 2;
		
		graph.edge[2].src  = 0;
		graph.edge[2].dest = 2;
		
		if(graph.isCycle(graph))
			System.out.println("Cycle is present");
		else
			System.out.println("No cycle");
		
	}
}
