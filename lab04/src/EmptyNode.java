/**
 * This represents an empty node in the list
 */
public class EmptyNode implements IListOfInts {
    /**
     * return a list obtained by adding the given data at the given index
     * @param data  the integer we want to add to the list
     * @param index the index location where we want to add the new data
     * @return a list obtained by adding the given data at the given index
     * @throws IllegalArgumentException if index is not 0.
     */
    @Override
    public IListOfInts addAtIndex(int data, int index) {
        if (index == 0) {
            return new ElementNode(data, this);
        } else throw new IllegalArgumentException("Index should be 0.");
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
        return new ElementNode(data, this);
    }

    /**
     * return the data locating at the given index
     * @param index the index where we want to get the data
     * @return the data locating at the given index
     * @throws IllegalArgumentException since it's an empty list
     */
    @Override
    public int getDataAtIndex(int index) {
        throw new IllegalArgumentException("This is an empty list");
    }

    /**
     * return the number of integers in the list
     * @return the number of integers in the list
     */
    @Override
    public int count() {
        return 0;
    }

    /**
     * return the sum of integers in the list
     * @return the sum of integers in the list
     */
    @Override
    public int sum() {
        return 0;
    }

    /**
     * toString() method
     * @return the list as string with a white space after each integer
     */
    @Override
    public String toString() {
        return "";
    }
}
