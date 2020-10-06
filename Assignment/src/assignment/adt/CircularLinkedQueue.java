package assignment.adt;

public class CircularLinkedQueue<T> implements QueueInterface<T> {

   private Node lastNode; 
   private int size;
   
    public CircularLinkedQueue() {
        lastNode = null;
        size = 0;
    } 

    public void enqueue(T newEntry) {

        Node newNode = new Node(newEntry);

        if (isEmpty()) {
            lastNode = newNode;
            lastNode.next=lastNode;
        } else {
 
            if (lastNode.next == null) {
                lastNode.next=newNode;
                newNode.next=lastNode;
            } else {
                newNode.next=lastNode.next;
                lastNode.next=newNode;
            }
        }
            size++;
        lastNode = newNode;
    }

    public T dequeue() {
        T entry;

        if (isEmpty()) { // empty queue
            return null;
        } else // 1 entry queue
        if (lastNode.next.equals(lastNode)) {
            entry = lastNode.data;
            lastNode.data=null; // deleting the node's entry
            lastNode.next = null; // deleting the node
            
            size--;
            return entry;
        } else {

            // queue more than 1 entry
            Node nodeToRemove = lastNode.next; // 1st node
            Node newFirstNode = lastNode.next.next;

            entry = nodeToRemove.data;
            //nodeToRemove.next = null; // delete the front entry

            lastNode.next = newFirstNode;

            size--;
            
            return entry;
        }
        
        
    }

    public int getSize() {
        return size;
    }

    
    
    public T getFront() {
        T front = null;

        if (!isEmpty()) {
            front = lastNode.next.data;
        }

        return front;
    }

    public boolean isEmpty() {
        boolean result = false;
        if (lastNode == null || lastNode.next == null) {
            result = true;
        }

        return result;
    }

    public void clear() {
        lastNode = null;
    }

    public String toString() {
        String s = "";
        boolean exception = true;
        Node firstNode = lastNode.next;
        Node firstNodeCopy = lastNode.next;
        while (firstNode != firstNodeCopy || exception) {
            exception = false;
            s += firstNode.data + "\n";
            firstNode = firstNode.next;
        }
        return s;
    }

    private class Node implements java.io.Serializable {

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
