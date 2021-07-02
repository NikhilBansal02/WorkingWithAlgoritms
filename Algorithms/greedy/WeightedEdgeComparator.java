package greedy;

import java.util.Comparator;

public class WeightedEdgeComparator implements Comparator<WeightedEdge> {

	@Override
	public int compare(WeightedEdge o1, WeightedEdge o2) {
		return o1.weight - o2.weight;
		
	}

	

	
		
}
