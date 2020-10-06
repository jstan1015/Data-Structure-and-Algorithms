package assignment.adt;

public class LinkedStack<T> implements StackInterface<T> {

    Node firstNode;
    int size;

    public LinkedStack() {
        
        firstNode = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }
    
    
    @Override
    public void push(T newEntry) {
        Node newNode= new Node(newEntry);
        
       if(firstNode==null){
           firstNode = newNode;
       }else{
       
       newNode.next = firstNode;
       firstNode = newNode;
       }
       size++;
    }

    @Override
    public T pop() {
       Node returnNode = null;
       if(firstNode != null){
           returnNode = firstNode;
           firstNode = firstNode.next;
           size--;
       }
       
       return(T) returnNode.data;
    }

    @Override
    public T peek() {
        
           Node returnNode = null;
       if(firstNode != null){
           returnNode = firstNode;
         
       }
       
       return(T) returnNode.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
       firstNode=null;
       size = 0;
    }
    
     private class Node<T> implements java.io.Serializable {

        private T data; 
        private Node next; 

        private Node() {
            data = null;
            next = null;
        } 



        private Node(T dataPortion) {
            data = dataPortion;
            next = null;
        }

        private Node(Node nextNode) {
            data = null;
            next = nextNode;
        }

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }
    }
    
    
    
}
