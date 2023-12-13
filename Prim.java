import graph.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class Prim implements IMST {
	private IGraph graph;
	private Vector<IEdge> mst;
	
	public Prim(IGraph graph) {
		this.graph = graph;
	}
	
	@Override
	public IGraph getGraph() {
		return this.graph;
	}

	@Override
	public Vector<IEdge> getMST() {
		return this.mst;
	}

	@Override
	public void solve() {
		IEdge edge;
		
		// Prim's algorithm uses three sets: V (vertices of the graph), U (current vertices in the MST), and V-U
		
		// V = {1, 2, ... , n }, V contains all the vertices of the graph
		
		Set<Integer> V = new HashSet<Integer>();
		
		for (int i=1; i<=this.graph.getVertices(); i++) {
			V.add(i);
		}
		
		// U = {1}, initially the MST has vertex 1
		
		Set<Integer> U = new HashSet<Integer>();
		
		U.add(1);

		// W = V - U, initially W is {2, 3, ... , n }

		Set<Integer> W = new HashSet<Integer>();	
		
		W.addAll(V);
		W.removeAll(U);
		
		// initially, the MST has no edges
		
		this.mst = new Vector<IEdge>();
		
		// while U does not contain all the vertices
		
		while (!U.equals(V)) {
			// (u, w, c) is the edge with the minimum cost from U to W
			
			edge = minCostEdge(this.graph, U, W);
						
			this.mst.add(edge);
			
			// add vertex w to set U
			
			U.add(edge.getDestination());
			
			// remove vertex w from set W
			
			W.remove(edge.getDestination());
		}
	}	
	
	private static IEdge minCostEdge(IGraph graph, Set<Integer> U, Set<Integer> W) {
		// returns an edge (u, v, min) from U to W (V-S) with the minimum cost
		//
		// for each vertex i in G
		//    for each vertex j in G
		//    	if (U contains i and W contains j and cost(i, j) < min) {
		//			min = cost(i, j)
		//			u = i, w = j
		//		}
		//
		// return edge(u, w, min)

		int min = Graph.INFINITE;
		int u = 0, w = 0;

		for (int i = 1; i<graph.getVertices(); i++){
			if(U.contains(i)){
				for (int j = 1; j<=graph.getVertices(); j++){
					if(W.contains(j)) {
						if(graph.getCost(i, j) < min){
							min = graph.getCost(i, j);
							u = i;
							w = j;
						}
					}
				}
			}
		}
		return new Edge(u, w, min);
	}	
}
