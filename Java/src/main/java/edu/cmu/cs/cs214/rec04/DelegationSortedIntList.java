package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList{
    // Write your implementation below with API documentation
    private SortedIntList myIntList;
    private int totalAdded = 0;

    /**
     * Constructs a DelegationSortedIntList instance.
     */
    public DelegationSortedIntList() {
        myIntList = new SortedIntList();
    }

    @Override
    public boolean add(int num) {
        totalAdded++; // Increment for every addition attempt
        return myIntList.add(num);
    }

    @Override
    public boolean addAll(IntegerList list) {
        totalAdded += list.size();
        return myIntList.addAll(list); // already use add() inside, no need to add size again
    }

    @Override
    public int get(int index) {
        return myIntList.get(index);
    }

    @Override
    public boolean remove(int num) {
        return myIntList.remove(num);
    }

    @Override
    public boolean removeAll(IntegerList list) {
        boolean changed = false;
        for (int i = 0; i < list.size(); i++) {
            changed |= remove(list.get(i));
        }
        return changed;
    }

    @Override
    public int size() {
        return myIntList.size();
    }

    /**
     * Returns the total number of attempted element insertions.
     *
     * @return The total number of attempts to add elements to the list.
     */
    public int getTotalAdded() {
        return totalAdded;
    }
}