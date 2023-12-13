import graph.IGraph;
import java.util.Vector;

public interface IMST {

	public IGraph getGraph();
	public Vector<IEdge> getMST();
	public void solve();

}