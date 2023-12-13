
import graph.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Dijkstra implements IDijkstra {
	private IGraph graph;
	private int [] D;
	private int [] P;
	
	public Dijkstra(IGraph graph) {
		this.graph = graph;
		this.D = new int[this.graph.getVertices() + 1];
		this.P = new int[this.graph.getVertices() + 1];
	}
	
	@Override
	public IGraph getGraph() {
		return this.graph;
	}
	
	@Override
	public IShortestPath solve() {
		int v;
		
		// Dijkstra's algorithm uses three sets: V (vertices of the graph), S (vertices to explore), and V-S
		
		// V = {1, 2, ... , n }, V contains all the vertices of the graph
		
		Set<Integer> V = new HashSet<Integer>();
		
		for (int i=1; i<=this.graph.getVertices(); i++)
			V.add(i);
		
		// S = {1}, initially contains vertex 1
		
		Set<Integer> S = new HashSet<Integer>();
		
		S.add(1);
		
		// minimum-costs array D and minimum-cost paths array P
		
		for (int i=1; i<=this.graph.getVertices(); i++) {
			this.D[i] = this.graph.getCost(1, i);			
			this.P[i] = (this.D[i] != Graph.INFINITE) ? 1 : 0;
		}
				
		// W = V {1, 2, 3, ... , n }

		Set<Integer> W = new HashSet<Integer>(V);
		
		for (int i=2; i<=this.graph.getVertices(); i++) {
			// W = V - S
			
			W.removeAll(S);

			// find a vertex v in W (V-S) with the minimum cost from the source

			v = minCostVertex(this.graph, W, this.D);
            
            S.add(v);
            W.remove(v);
            
            for (int j=2; j<=this.graph.getVertices(); j++)
                if (W.contains(j)) {
                	if ((this.graph.getCost(v,  j) != Graph.INFINITE) && (this.D[j] > this.D[v] + this.graph.getCost(v, j))) {
                		this.D[j] = this.D[v] + this.graph.getCost(v, j);
                		this.P[j] = v;
                	}
                }
		}
        
		return new ShortestPath(this.D, shortestPath(this.graph.getVertices(), this.D, this.P));
	}
	
	private static int minCostVertex(IGraph graph, Set<Integer> W, int [] D) {
		// finds the vertex v with in the set W (V-S) with the minimum cost from the source
		// for earch vertex j of G, check if j is in W (V-S) and the cost D[j] is the minimum, update v = j and min = D[j] (the minimum cost found so far)
		// return v

		int v=0, min = Graph.INFINITE;
		for (int j=2; j <=graph.getVertices(); j++){
			if (W.contains(j) && D[j] < min){
				v = j;
				min = D[j];
			}
		}
		return v;

	}
	
	private static String [] shortestPath(int vertices, int [] D, int [] P) {
		int vertex;
		Stack<Integer> path;
		String [] tour = new String[vertices + 1];
		
		for (int i=2; i<=vertices; i++) {
			path = new Stack<Integer>();
			
			path.push(i);

			vertex = path.peek();
			
			while (P[vertex] != 1) {
				path.push(P[vertex]);
				
				vertex = P[vertex];
			}
			
			path.push(1);
			
			tour[i] = "";
			
			while (!path.isEmpty()) {
				tour[i] = tour[i] + path.pop() + (path.isEmpty() ? "" : "-"); 
			}
		}
		
		return tour;
	}
}
