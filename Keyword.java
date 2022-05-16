import java.util.Comparator;

/**
 * This keyword object stores two things: 
 * the word as a string
 * the number of occurrences in the transcript as an int
 */
public class Keyword implements Comparable, Comparator {

	//variables
	private String name;
	private int count;

	/**
	 *Copy Constructor
	 */
	public Keyword() {
		name = null;
		count = 0;
	}

	/**
	 * Constructor with parameters
	 * @param name name of the word
	 * @param count number of instances found
	 */
	public Keyword(String name, int count) {
		this.name = name;
		this.count = count;
	}

	/**
	 * Getter for name
	 * @return a string representing the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter for count
	 * @return a int represenitng the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * Setter for count
	 * @param count number representing the count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	/**
	 * compares one keyword to another based on their number of occurrences
	 * only works if the parameter is an instance of the Keyword class
	 * for our purposes, we will only supply Keyword objects,
	 * so we do not have to worry about dealing with other types
	 * must be in DESCENDING ORDER, so we subtract the parameter's count from this object's count
	 */

	public int compareTo(Object o){
		if (o instanceof Keyword) {
			return ((Keyword) o).getCount() - this.getCount();
		}
		return -1;
	}

	/**
	 * compares the objects
	 * @param o1 the first object to be compared.
	 * @param o2 the second object to be compared.
	 * @return
	 */
	@Override
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Keyword && o2 instanceof Keyword) {
			Keyword k1 = (Keyword) o1;
			Keyword k2 = (Keyword) o2;
			return k1.getCount() - k2.getCount();
		}
		return -1;
	}

	/**
	 * toString method
	 * @return a string representing the name and count1
	 */
	public String toString() {
		return this.getName() + ": " + this.getCount();
	}
}
