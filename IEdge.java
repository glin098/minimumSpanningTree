public interface IEdge extends Comparable<IEdge> {

	public int getSource();
	public int getDestination();
	public int getCost();
	@Override
	String toString();
	@Override
	public int compareTo(IEdge e);

}