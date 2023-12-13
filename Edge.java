public class Edge implements IEdge {
    private int u, v, cost;

    public Edge(int u, int v, int cost) {
        this.u = u;
        this.v = v;
        this.cost = cost;
    }

    @Override
	public int getSource() {
        return this.u;
    }

    @Override
	public int getDestination() {
        return this.v;
    }

    @Override
	public int getCost() {
        return this.cost;
    }
    
    @Override
	public String toString() {
    	return "(" + this.getSource() + "," + this.getDestination() + ") = " + this.getCost();
    }
    
	@Override
	public int compareTo(IEdge e) {
		return (this.getCost() == e.getCost()) ? 0 : ((this.getCost() > e.getCost()) ? 1 : - 1); // same as (this.getCost() - e.getCost());
	}
}
