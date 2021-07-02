package greedy;

import java.util.Arrays;
import java.util.stream.Stream;

public class KruskalsMST {

	public static void main(String[] args) {
		
		WeightedGraph graph = new WeightedGraph(9,14);
		
		graph.edge[0].src  = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].weight = 4;
		
		graph.edge[1].src  = 1;
		graph.edge[1].dest = 2;
		graph.edge[1].weight = 8;
		
		graph.edge[2].src  = 2;
		graph.edge[2].dest = 3;
		graph.edge[2].weight = 7;
		
		graph.edge[3].src  = 3;
		graph.edge[3].dest = 4;
		graph.edge[3].weight = 9;
		
		graph.edge[4].src  = 4;
		graph.edge[4].dest = 5;
		graph.edge[4].weight = 10;
		
		graph.edge[5].src  = 5;
		graph.edge[5].dest = 6;
		graph.edge[5].weight = 2;
		
		graph.edge[6].src  = 6;
		graph.edge[6].dest = 7;
		graph.edge[6].weight = 1;
		
		graph.edge[7].src  = 7;
		graph.edge[7].dest = 0;
		graph.edge[7].weight = 8;
		
		graph.edge[8].src  = 7;
		graph.edge[8].dest = 1;
		graph.edge[8].weight = 11;
		
		graph.edge[9].src  = 7;
		graph.edge[9].dest = 8;
		graph.edge[9].weight = 7;
		
		graph.edge[10].src  = 8;
		graph.edge[10].dest = 6;
		graph.edge[10].weight = 6;
		
		graph.edge[11].src  = 8;
		graph.edge[11].dest = 2;
		graph.edge[11].weight = 2;
		
		graph.edge[12].src  = 2;
		graph.edge[12].dest = 5;
		graph.edge[12].weight = 4;
		
		graph.edge[13].src  = 3;
		graph.edge[13].dest = 5;
		graph.edge[13].weight = 14;
		
		
		sortEdgesByWeightAsc(graph);
//		Stream.of(graph.edge)
//		.forEach( e ->{
//				System.out.print(e.src+" "+e.dest+" "+e.weight);
//				System.out.println();
//		});
		
		buildMST(graph);
	}
	
	public static void sortEdgesByWeightAsc(WeightedGraph graph) {
		
		Arrays.sort(graph.edge,new WeightedEdgeComparator());
		
	}
	
	private static void buildMST(WeightedGraph graph) {
		
		Integer Parent[] = new Integer[graph.V];
		for(int i =0;i<graph.V;i++) {
			Parent[i] = -1;
		}
		
		int mstEdges = 0;//graph.V - 1;//8
		int minWeight=0;
		
		for(int i=0;i<graph.E;i++) {
			
			int x = find(Parent,graph.edge[i].src);
			int y = find(Parent,graph.edge[i].dest);
			
			if(x == y)
				continue;
			else {
				union(Parent,x,y);
				minWeight = minWeight + graph.edge[i].weight;
				
				mstEdges++;
				System.out.println("Selected Edges are :" +graph.edge[i].src+" "+graph.edge[i].dest);
			//	System.out.println("Mst Egdes : "+mstEdges);
				if(mstEdges == (graph.V-1)) {
					break;
				}
			}
		}
//		System.out.println("Sum of MST : "+minWeight);
//		Stream.of(Parent)
//		.forEach(System.out::println);
		
	}

	public static int find(Integer[] parent, int i) {
		
		if(parent[i] == -1)
			return i;
		
		return find(parent, parent[i]);
	}
	
	public static void union(Integer[] parent, int x, int y) {
			
		parent[x] = y;
	}
	
}
