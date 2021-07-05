//TC - O(V^2)
//https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/

package greedy;

public class PrimsMST {

	static final int V = 9;

	public static void main(String[] args) {

		/*int graph[][] = new int[][] {{0,2,0,6,0},
			{2,0,3,8,5},
			{0,3,0,0,7},
			{6,8,0,0,9},
			{0,5,7,9,0}};*/
		
		int graph[][] = new int[][] {
			{0,4,0,0,0,0,0,8,0},
			{4,0,8,0,0,0,0,11,0},
			{0,8,0,7,0,4,0,0,2},
			{0,0,7,0,9,14,0,0,0},
			{0,0,0,9,0,10,0,0,0},
			{0,0,4,14,10,0,2,0,0},
			{0,0,0,0,0,2,0,1,6},
			{8,11,0,0,0,0,1,0,7},
			{0,0,2,0,0,0,6,7,0}
		};

		createMSTUsingPrims(graph);

	}

	public static void createMSTUsingPrims(int[][] graph) {

		int parent[] = new int[V];//Keep tracks for parent of each vertex.
		int key[]    = new int[V];//For keeping track of minimum edge reaching out to vertex.
		boolean mstSet[] = new boolean[V]; //Tracks vertices which are included.

		//For all vertices, set all vertices with infinite value.
		for(int i=0;i<V;i++) {
			mstSet[i] = false;
			key[i] = Integer.MAX_VALUE; 
		}

		key[0] = 0;
		parent[0] = -1;

		for(int i=0;i<V;i++) {

			int u = minKey(key,mstSet);
			mstSet[u] = true;

			for(int v=0;v<V;v++) {
				if(graph[u][v] !=0 && mstSet[v] == false && graph[u][v] < key[v]) {

					key[v] = graph[u][v];
					parent[v] = u;
				}
			}
		}

		printMST(parent,key);

	}

	public static void printMST(int[] parent, int[] key) {

		for(int i=1;i<V;i++) {
			System.out.println(parent[i] +" - " +i + " - "+key[i]);
		}
	}

	public static int minKey(int[] key, boolean[] mstSet) {

		int minKey   = Integer.MAX_VALUE;
		int minIndex = 0;

		for(int i=0;i<V;i++) {
			if(mstSet[i] == false && key[i] < minKey) {
				minKey = key[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

}
