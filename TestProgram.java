import graph.*;
import java.util.Vector;

public class TestProgram {

	/*
	 * The minimum-cost spanning tree (MST) connects all the vertices of a graph at the minimum cost 
	 *  
	 */
	
	public static void printMST(String title, IMST mst, boolean graph) {	
		int cost = 0;

		if (graph)
			System.out.println(mst.getGraph().toString("Graph"));
		
		System.out.println(title + "\n");
		
		Vector<IEdge> tree = mst.getMST();
		
		for (IEdge e : tree) {
			cost = cost + e.getCost();
			
			System.out.println(e.toString());
		}
		
		System.out.println("\nMST cost is " + cost + "\n");
	}

	public static void main(String[] args) {
		
		int [][] cost = { { -1,  6,  1,  5, -1, -1 },
				  		  {  6, -1,  5, -1,  3, -1 },
				  		  {  1,  5, -1,  5,  6,  4 },
				  		  {  5, -1,  5, -1, -1,  2 },
				  		  { -1,  3,  6, -1, -1,  6 },
				  		  { -1, -1,  4,  2,  6, -1 } };
				  		
		IMST prim = new Prim(new Graph(cost));
			
		prim.solve();
		
		printMST("Prim's Minimum-cost Spanning Tree (MST)", prim, true);
		
		IMST kruskal = new Kruskal(new Graph(cost));
		
		kruskal.solve();
		
		printMST("Kruskal's Minimum-cost Spanning Tree (MST)", kruskal, false);

	}
}

