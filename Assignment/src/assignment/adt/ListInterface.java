package assignment.adt;

public interface ListInterface<T> {
    
    void add(T newEntry);
    
    boolean remove(T anEntry);
    
    T getEntry(int index);
    
    boolean contains(T anEntry);
    
    boolean isEmpty();
    
    String toString();
    
}
