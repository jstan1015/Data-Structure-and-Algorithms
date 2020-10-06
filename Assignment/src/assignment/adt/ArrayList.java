package assignment.adt;
import assignment.entity.Shop;
import java.util.Scanner;


public class ArrayList<T> implements ArrayListInterface <T> {
    private T[] list; // array of list entries
    private int numberOfEntries;
    private static final int DEFAULT_INITIAL_CAPACITY = 25;

    public ArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    } 

    public ArrayList(int initialCapacity) {
        numberOfEntries = 0;
        // the cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempList = (T[]) new Object[initialCapacity];
        list = tempList;
    } 

    public boolean add(T newEntry) {
        if (isArrayFull()) {
            doubleArray();
        }

        list[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
    }

    public boolean add(int newPosition, T newEntry) {
        boolean isSuccessful = true;

        if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
            if (isArrayFull()) {
                doubleArray();
            }

            makeRoom(newPosition);
            list[newPosition - 1] = newEntry;
            numberOfEntries++;
        } else {
            isSuccessful = false;
        }

        return isSuccessful;
    }

    public T remove(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            result = list[givenPosition - 1];

            if (givenPosition < numberOfEntries) {
                removeGap(givenPosition);
            }

            numberOfEntries--;
        }

        return result;
    }

    public void clear() {
        numberOfEntries = 0;
    }

    public boolean replace(int givenPosition, T newEntry) {
        boolean isSuccessful = true;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            list[givenPosition - 1] = newEntry;
        } else {
            isSuccessful = false;
        }

        return isSuccessful;
    }

    public T getEntry(int givenPosition) {
        T result = null;

        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            result = list[givenPosition - 1];
        }

        return result;
    }

    public int checkDuplicate() {
        int index = -1;
        for (int i = 0; i < numberOfEntries; i++) {
            for (int j = i+1; j < numberOfEntries; j++) {
                if(list[i].equals(list[j])){
                    System.out.println("Duplicate object found: " + list[j]);
                    index = j;
                    System.out.println("Index at: " + (index + 1));
                    promptRemove(index + 1);
                }
            }
        }
        return index;
    }

    private void promptRemove(int index) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to remove duplicate object at index: " + index + " yes/no");
        String ans = sc.nextLine();
        if(ans.equalsIgnoreCase("yes")) {
            remove(index);
        }

    }

    public boolean contains(T anEntry) {
        boolean found = false;
        for (int index = 0; !found && (index < numberOfEntries); index++) {
            if (anEntry.equals(list[index])) {
                found = true;
            }
        }
        return found;
    }

    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }
    public int size(){
        return numberOfEntries;
    }
    public T get(int index){
        return list[index];
    }
    public int getIndex(T entry){
        int index = -1;
        for(int i = 0; i < numberOfEntries; i++) {
            if(entry.equals(list[i])){
                index = i;
                return index;
            }
        }
        return index;
    }
    public boolean isFull() {
        return false;
    }

    public String toString() {
        String outputStr = "";
        for (int index = 0; index < numberOfEntries; ++index) {
            outputStr += list[index] + "\n";
        }

        return outputStr;
    }
    private boolean isArrayFull() {
        return numberOfEntries == list.length;
    }


//To double the size of the array of list entries
    private void doubleArray() {
        T[] oldList = list; // save reference to array of list entries
        int oldSize = oldList.length;     // save old max size of array

        list = (T[]) new Object[2 * oldSize];    // double size of array

        // copy entries from old array to new, bigger array
        for (int index = 0; index < oldSize; index++) {
            list[index] = oldList[index];
        }
    } 

//To room for a new entry at newPosition
     
    private void makeRoom(int newPosition) {
        int newIndex = newPosition - 1;
        int lastIndex = numberOfEntries - 1;

        // move each entry to next higher index, starting at end of
        // list and continuing until the entry at newIndex is moved
        for (int index = lastIndex; index >= newIndex; index--) {
            list[index + 1] = list[index];
        }
    }

//To shift entries that are beyond the entry to be removed to the next
    
    private void removeGap(int givenPosition) {
        // move each entry to next lower position starting at entry after tp
        // one removed and continuing until end of list
        int removedIndex = givenPosition - 1;
        int lastIndex = numberOfEntries - 1;

        for (int index = removedIndex; index < lastIndex; index++) {
            list[index] = list[index + 1];
        }
    }
}



