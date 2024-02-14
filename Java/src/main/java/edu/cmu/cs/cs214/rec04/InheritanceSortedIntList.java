package edu.cmu.cs.cs214.rec04;

import java.util.Collection;

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class InheritanceSortedIntList extends SortedIntList {
    // Counter to keep track of the number of attempted insertions
    private int totalAdded = 0;

    /**
     * Adds a new element to the list while ensuring the list remains sorted.
     * Overrides the add method from SortedIntList to increment the totalAdded
     * counter.
     * 
     * @param value The integer value to add to the list.
     * @return true if the list changed as a result of the call.
     */
    @Override
    public boolean add(int value) {
        totalAdded++; // Increment for every attempt to add, regardless of success.
        return super.add(value); // Call the superclass method to maintain sorting.
    }

    /**
     * Adds all of the elements in the specified IntegerList to this list, ensuring
     * the list remains sorted. This method overrides the addAll method from
     * SortedIntList
     * to increment the totalAdded counter by the number of elements in the
     * specified list.
     * 
     * @param list IntegerList containing elements to be added to this list.
     * @return true if the list changed as a result of the call.
     */
    @Override
    public boolean addAll(IntegerList list) {
        return super.addAll(list); // already use add() inside, no need to add size again
    }


    /**
     * Provides access to the total number of attempted element insertions.
     * 
     * @return The total number of attempted insertions.
     */
    public int getTotalAdded() {
        return totalAdded;
    }

}