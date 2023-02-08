/**
 * This interface presents all the operations to be
 * supported by a list of integers
 */
public interface IListOfInts {

    /**
     * return a list obtained by adding the given data at the given index
     * @param data the integer we want to add to the list
     * @param index the index location where we want to add the new data
     * @return a list obtained by adding the given data at the given index
     */
    IListOfInts addAtIndex(int data, int index);

    /**
     * return a list obtained by adding the given data at the front of the list
     * @param data the integer we want to add to the front of the list
     * @return a list obtained by adding the given data at the front of the list
     */
    IListOfInts addFront(int data);

    /**
     * return a list obtained by adding the given data at the back of the list
     * @param data the integer we want to add to the back of the list
     * @return a list obtained by adding the given data at the back of the list
     */
    IListOfInts addBack(int data);

    /**
     * return the data locating at the given index
     * @param index the index where we want to get the data
     * @return the data locating at the given index
     */
    int getDataAtIndex(int index);

    /**
     * return the number of integers in the list
     * @return the number of integers in the list
     */
    int count();

    /**
     * return the sum of integers in the list
     * @return the sum of integers in the list
     */
    int sum();
}
