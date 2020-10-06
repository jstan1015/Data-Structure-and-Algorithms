package assignment.adt;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchTree<T extends Comparable<? super T>> implements SearchTreeInterface<T> {

  private BinaryNode root;

  public BinarySearchTree() {
    root = null;
  }

  public BinarySearchTree(T rootData) {
    root = new BinaryNode(rootData);
  }

  public boolean contains(T entry) {
    return getEntry(entry) != null;
  }

  public T getEntry(T entry) {
    return findEntry(root, entry);
  }

  private T findEntry(BinaryNode rootNode, T entry) {
    T result = null;

    if (rootNode != null) {
      T rootEntry = rootNode.data;

      if (entry.equals(rootEntry)) {
        result = rootEntry;
      } else if (entry.compareTo(rootEntry) < 0) {
        result = findEntry(rootNode.left, entry);
      } else {
        result = findEntry(rootNode.right, entry);
      }
    }
    return result;
  }

  public T add(T newEntry) {
    T result = null;

    if (isEmpty()) {
      root = new BinaryNode(newEntry);
    } else {
      result = addEntry(root, newEntry);
    }

    return result;
  }

  
  private T addEntry(BinaryNode rootNode, T newEntry) {
    T result = null;
    int comparison = newEntry.compareTo(rootNode.data);

    if (comparison == 0) {				// newEntry matches entry in root
      result = rootNode.data;
      rootNode.data = newEntry;
    } else if (comparison < 0) {			// newEntry < entry in root
      if (rootNode.left != null) {
        result = addEntry(rootNode.left, newEntry);
      } else {
        rootNode.left = new BinaryNode(newEntry);
      }
    } else {                                            // newEntry > entry in root
      if (rootNode.right != null) {
        result = addEntry(rootNode.right, newEntry);
      } else {
        rootNode.right = new BinaryNode(newEntry);
      }
    }
    return result;
  }

  public T remove(T entry) {
    ReturnObject oldEntry = new ReturnObject(null);

    BinaryNode newRoot = removeEntry(root, entry, oldEntry);

    root = newRoot;

    return oldEntry.get();
  }

//To remove an entry from the tree rooted at a given node.
 
  private BinaryNode removeEntry(BinaryNode rootNode, T entry, ReturnObject oldEntry) {
    if (rootNode != null) {
      T rootData = rootNode.data;
      int comparison = entry.compareTo(rootData);

      if (comparison == 0) {      // entry == root entry
        oldEntry.set(rootData);
        rootNode = removeFromRoot(rootNode);
      } else if (comparison < 0) {  // entry < root entry
        BinaryNode leftChild = rootNode.left;
        BinaryNode subtreeRoot = removeEntry(leftChild, entry, oldEntry);
        rootNode.left = subtreeRoot;
      } else {                      // entry > root entry
        BinaryNode rightChild = rootNode.right;
        rootNode.right = removeEntry(rightChild, entry, oldEntry);
      }
    }

    return rootNode;
  }

  //To removes the entry in a given root node of a subtree.
  private BinaryNode removeFromRoot(BinaryNode rootNode) {
    // Case 1: rootNode has two children
    if (rootNode.left != null && rootNode.right != null) {
      // find node with largest entry in left subtree
      BinaryNode leftSubtreeRoot = rootNode.left;
      BinaryNode largestNode = findLargest(leftSubtreeRoot);

      // replace entry in root
      rootNode.data = largestNode.data;

      // remove node with largest entry in left subtree
      rootNode.left = removeLargest(leftSubtreeRoot);
    } 
    // Case 2: rootNode has at most one child
    else if (rootNode.right != null) {
      rootNode = rootNode.right;
    } else {
      rootNode = rootNode.left;
    }

	  // Assertion: if rootNode was a leaf, it is now null
    return rootNode;
  }

 
//To finds the node containing the largest entry in a given tree
   

  private BinaryNode findLargest(BinaryNode rootNode) {
    if (rootNode.right != null) {
      rootNode = findLargest(rootNode.right);
    }

    return rootNode;
  }

//To removes the node containing the largest entry in a given tree
  private BinaryNode removeLargest(BinaryNode rootNode) {
    if (rootNode.right != null) {
      BinaryNode rightChild = rootNode.right;
      BinaryNode root = removeLargest(rightChild);
      rootNode.right = root;
    } else {
      rootNode = rootNode.left;
    }

    return rootNode;
  }

  public boolean isEmpty() {
    return root == null;
  }

  public void clear() {
    root = null;
  }

  public Iterator<T> getInorderIterator() {
    return new InorderIterator();
  }

  public Iterator<T> getPreorderIterator() {
    throw new UnsupportedOperationException();
  }

  public Iterator<T> getPostorderIterator() {
    throw new UnsupportedOperationException();
  }

  // ReturnObject is the type for method removeEntry's 3rd parameter, oldEntry,
  // which is used for returning the removed entry
  private class ReturnObject {

    private T item;

    private ReturnObject(T entry) {
      item = entry;
    }

    public T get() {
      return item;
    }

    public void set(T entry) {
      item = entry;
    }
  }

  private class BinaryNode {

    private T data;
    private BinaryNode left;
    private BinaryNode right;

    private BinaryNode() {
      this(null);
    }

    private BinaryNode(T dataPortion) {
      this(dataPortion, null, null);
    }

    private BinaryNode(T data, BinaryNode left, BinaryNode right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }

    private boolean isLeaf() {
      return (left == null) && (right == null);
    }

  }

  private class InorderIterator implements Iterator<T> {

    private QueueInterface<T> queue = new ArrayQueue<T>();

    public InorderIterator() {
      inorder(root);
    }

    private void inorder(BinaryNode treeNode) {
      if (treeNode != null) {
        inorder(treeNode.left);
        queue.enqueue(treeNode.data);
        inorder(treeNode.right);
      }
    }

    public boolean hasNext() {
      return !queue.isEmpty();
    }

    public T next() {
      if (!queue.isEmpty()) {
        return queue.dequeue();
      } else {
        throw new NoSuchElementException("Illegal call to next(); iterator is after end of list.");
      }
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }
  }
    public void displayTree() {
        Iterator it = getInorderIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println("\n");
    }

}
