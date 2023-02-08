/**
 * This represents a non-empty node of the list. It contains a piece of data
 * along with the rest of the list
 */
public class ElementNode implements IListOfInts {
    private int integer;
    private IListOfInts rest;

    /**
     * Constructs an Element node object with the given data and the rest of the list
     * @param integer the piece of data this object contains
     * @param rest the rest of the list
     */
    public ElementNode(int integer, IListOfInts rest) {
        this.integer = integer;
        this.rest =  rest;
    }

    /**
     * return a list obtained by adding the given data at the given index
     * @param data  the integer we want to add to the list
     * @param index the index location where we want to add the new data
     * @return a list obtained by adding the given data at the given index
     * @throws IllegalArgumentException if index out of range
     */
    @Override
    public IListOfInts addAtIndex(int data, int index) {
        // check if index out of range
        int length = this.count();
        if (index > length) {
            throw new IllegalArgumentException("Index out of range");
        }

        if (index == 0) {
            return this.addFront(data);
        }
        else return new ElementNode(this.integer,
                this.rest.addAtIndex(data, index - 1));
    }

    /**
     * return a list obtained by adding the given data at the front of the list
     * @param data the integer we want to add to the front of the list
     * @return a list obtained by adding the given data at the front of the list
     */
    @Override
    public IListOfInts addFront(int data) {
        return new ElementNode(data, this);
    }

    /**
     * return a list obtained by adding the given data at the back of the list
     * @param data the integer we want to add to the back of the list
     * @return a list obtained by adding the given data at the back of the list
     */
    @Override
    public IListOfInts addBack(int data) {
        return new ElementNode(this.integer, this.rest.addBack(data));
    }

    /**
     * return the data locating at the given index
     * @param index the index where we want to get the data
     * @return the data locating at the given index
     * @throws IllegalArgumentException if index out of range
     */
    @Override
    public int getDataAtIndex(int index) {
        // check if index out of range
        int length = this.count();
        if (index > length - 1) {
            throw new IllegalArgumentException("Index out of range");
        }

        if (index == 0) {
            return this.integer;
        }
        else return this.rest.getDataAtIndex(index - 1);
    }

    /**
     * return the number of integers in the list
     * @return the number of integers in the list
     */
    @Override
    public int count() {
        return 1 + this.rest.count();
    }

    /**
     * return the sum of integers in the list
     * @return the sum of integers in the list
     */
    @Override
    public int sum() {
        return this.integer + this.rest.sum();
    }

    /**
     * toString() method
     * @return the list as string with a white space after each integer
     */
    @Override
    public String toString() {
        return this.integer + " " + this.rest.toString();
    }
}
