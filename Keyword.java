import java.util.Comparator;

/*
 * This keyword object stores two things: 
 * the word as a string
 * the number of occurrences in the transcript as an int
 */
public class Keyword implements Comparable, Comparator {
	private String name;
	private int count;
	
	public Keyword() {
		
	}
	public Keyword(String name, int count) {
		this.name = name;
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	//compares one keyword to another based on their number of occurrences
	//only works if the parameter is an instance of the Keyword class
	//for our purposes, we will only supply Keyword objects, so we do not have to worry about dealing with other types
	//must be in DESCENDING ORDER, so we subtract the parameter's count from this object's count
	public int compareTo(Object o){
		if (o instanceof Keyword) {
			return ((Keyword) o).getCount() - this.getCount();
		}
		return -1;
	}
	@Override
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Keyword && o2 instanceof Keyword) {
			Keyword k1 = (Keyword) o1;
			Keyword k2 = (Keyword) o2;
			return k1.getCount() - k2.getCount();
		}
		return -1;
	}
	
	public String toString() {
		return this.getName() + ": " + this.getCount();
	}
}
