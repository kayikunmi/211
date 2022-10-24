//import java.util.*;
public class BinarySearchTree<K extends Comparable<K>, V> {
    Node root;
    BinarySearchTree() {
        root = null;
    }
    
    public void add(int key, int value) {
        if (root == null) { //add at root
            // Insert the new data, if root is null.
            root = new Node(key, value);
        }
        else if ((int)(root.key) >= (int)(key)) {
            // if current root data is greater than the new data then now process the left sub-tree
            root.left = new Node(key, value);
        } 
        else {
            // if current root data is less than the new data then now process the right sub-tree
            root.right = new Node(key, value);
        }
        System.out.println("added " + key + " at " + value);
    }
      
    public V delete(int key) {return null;}
      
    public int lookup(int key) {
        // Key is equal to the key at root
        if (root==null || root.key==key){
            int lookupValue = root.value;
            return lookupValue;
        }
        // Key is greater than root's key
        if ((int)(root.key) < (int)(key)){
            root = root.right;
            return lookup(root.key);
        }
        // Key is smaller than root's key
        else if((int)(root.key) < (int)(key)){
            root = root.left;
            return lookup(root.key);
        }
        else{
            return -1;
        }
    }
     
    public void inOrderTraverse() {
        inOrderTraverseRecursive(root);
    }
      // print the values in this BST in sorted order (to p)

    private void inOrderTraverseRecursive(Node root) {
        if (root == null)
            return;
 
        /* first recur on left child */
       inOrderTraverseRecursive(root.left);
 
        /* then print the data of node */
        System.out.print(root.key + " ");
 
        /* now recur on right child */
        inOrderTraverseRecursive(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5,5); //rn, i'm only adding at the root
       bst.add(7,7);
       bst.add(3,3);
       bst.add(12,6);
       bst.add(13,3);
       bst.add(1,3);
       System.out.println("bst root: " + bst.root.key);
       bst.inOrderTraverse();

    }
}