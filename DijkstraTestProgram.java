

import graph.Graph;

public class DijkstraTestProgram {

	public static void main(String[] args) {
		
		// graph 1
		
		int [][] cost1 = { { -1, 10, -1, 30, 100},
				           { -1, -1, 50, -1,  -1},
				           { -1, -1, -1, -1,  10},
				           { -1, -1, 20, -1,  60},
				           { -1, -1, -1, -1,  -1} };
		
		IDijkstra dijkstra1 = new Dijkstra(new Graph(cost1));
		
		IShortestPath d1 = dijkstra1.solve();
		
		int [] mincost1 = d1.getCost();
		String [] path1 = d1.getPath();
		
		System.out.println(dijkstra1.getGraph().toString("Graph 1"));		
		System.out.println("Dijkstra's Shortest Path from vertex 1 \n");
		
		for (int i=2; i<path1.length; i++) {
			System.out.println(path1[i] + " with cost " + mincost1[i]);
		}
		
		System.out.println("");
		
		// graph 2
		
		int [][] cost2 = { { -1,  2, -1,  4, -1,  7,  3,  6 },
  		                   { -1, -1,  1, -1, -1, -1,  3,  2 },
		                   { -1, -1, -1,  2,  1,  3,  1,  2 },
				           { -1, -1, -1, -1,  3,  1, -1, -1 },
				           { -1, -1, -1, -1, -1,  1,  2, -1 },
				           { -1, -1, -1, -1, -1, -1,  2, -1 },
				           { -1, -1, -1, -1, -1, -1, -1,  1 },
				           { -1, -1, -1, -1, -1, -1, -1, -1 } };
		
		IDijkstra dijkstra2 = new Dijkstra(new Graph(cost2));
		
		IShortestPath d2 = dijkstra2.solve();
		
		int [] mincost2 = d2.getCost();
		String [] path2 = d2.getPath();
		
		System.out.println(dijkstra2.getGraph().toString("Graph 2"));		
		System.out.println("Dijkstra's Shortest Path from vertex 1 \n");
		
		for (int i=2; i<path2.length; i++) {
			System.out.println(path2[i] + " with cost " + mincost2[i]);
		}
		
		System.out.println("");
		
		// graph 3
		
		int [][] cost3 = { {  0,  1,  2, -1, -1, -1 },
						   { -1,  0, -1,  6, -1, -1 },
						   { -1,  2,  0,  4,  3, -1 },
						   { -1, -1, -1,  0, -1,  3 },
						   { -1, -1, -1,  1,  0,  5 },
						   { -1, -1, -1, -1, -1,  0 } };
		
		IDijkstra dijkstra3 = new Dijkstra(new Graph(cost3));
		
		IShortestPath d3 = dijkstra3.solve();
		
		int [] mincost3 = d3.getCost();
		String [] path3 = d3.getPath();
		
		System.out.println(dijkstra3.getGraph().toString("Graph 3"));		
		System.out.println("Dijkstra's Shortest Path from vertex 1 \n");
		
		for (int i=2; i<path3.length; i++) {
			System.out.println(path3[i] + " with cost " + mincost3[i]);
		}
		
		System.out.println("");

		
	}
}