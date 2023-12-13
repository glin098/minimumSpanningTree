import graph.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Vector;

public class Kruskal implements IMST {
	private IGraph graph;
	private Vector<IEdge> mst;
	
	public Kruskal(IGraph graph) {
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
		int c1, c2;
		
		// Kruskal's algorithm uses a priority queue to store the edges (i, j) of the graph
				
		Queue<IEdge> edges = new PriorityQueue<IEdge>();
		
		for (int i=1; i<=this.graph.getVertices(); i++) {
			for (int j=i+1; j<=this.graph.getVertices(); j++) {
				if (this.graph.getCost(i, j) != Graph.INFINITE) {
					edges.add(new Edge(i, j, this.graph.getCost(i, j)));
				}
			}
		}
		
		// initially, each vertex of the graph is in a different connected component of the MST
		
		int totalConnectedComponents = this.graph.getVertices();
		
		@SuppressWarnings("unchecked")
		Set<Integer> [] connectedComponents = new HashSet[totalConnectedComponents + 1];		
		
		for (int i=1; i<=this.graph.getVertices(); i++) {
			connectedComponents[i] = new HashSet<Integer>();
			connectedComponents[i].add(i);
		}

		// initially, the MST has no edges

		this.mst = new Vector<IEdge>();
		
		while (totalConnectedComponents > 1) {
			// get the edge(u, v) with the minimum cost
			
			edge = edges.poll();
		
			// check if vertices u and v are not in the same connected component
			
			c1 = conectedComponentContainsVertex(connectedComponents, edge.getSource());
			c2 = conectedComponentContainsVertex(connectedComponents, edge.getDestination());
			
			if (c1 != c2) {
				connectedComponents[c1].addAll(connectedComponents[c2]);
				connectedComponents[c2].clear();
				
				totalConnectedComponents--;
				
				this.mst.add(edge);
			}			
		}	
	}
			
	private static int conectedComponentContainsVertex(Set<Integer> [] connectedComponents, int v) {
		for (int i=1; i<connectedComponents.length; i++)
			if (connectedComponents[i].contains(v))
				return i;
		
		return -1;
	}
}
