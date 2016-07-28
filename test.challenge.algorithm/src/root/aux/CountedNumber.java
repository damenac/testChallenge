package root.aux;

public class CountedNumber {

	/** Number referenced in the position of the array */
	private Integer number;
	
	/** Amount of duplicated values */
	private int count;
	
	/**
	 * Constructor of the class. Receives the number referenced in the position, initializes the counter in 1.
	 * @param number
	 * @param count
	 */
	public CountedNumber(Integer number){
		this.number = number;
		this.count = 1;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public int getCount() {
		return count;
	}

	public void increaseCount() {
		this.count++;
	}
}
