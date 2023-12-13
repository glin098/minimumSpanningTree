

public class ShortestPath implements IShortestPath {
	private int [] cost;
	private String [] path;

	public ShortestPath(int [] cost, String [] path) {
		this.cost = cost.clone();
		this.path = path.clone();
	}
	
	@Override
	public int [] getCost() {
		return this.cost;
	}
	
	@Override
	public String [] getPath() {
		return this.path;
	}
}
