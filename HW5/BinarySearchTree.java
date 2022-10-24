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
      
    public int delete(int key) {
        root = deleteRec(root, key);
        int value = root.value;
        return value;
    }
    Node deleteRec(Node root, int key) {
        // Return if the tree is empty
        if (root == null)
          return root;
    
        // Find the node to be deleted
        if (key < root.key)
          root.left = deleteRec(root.left, key);
        else if (key > root.key)
          root.right = deleteRec(root.right, key);
        else {
          // If the node is with only one child or no child
          if (root.left == null)
            return root.right;
          else if (root.right == null)
            return root.left;
    
          // If the node has two children
          // Place the inorder successor in position of the node to be deleted
          root.key = minValue(root.right);
    
          // Delete the inorder successor
          root.right = deleteRec(root.right, root.key);
        }
    
        return root;
      }
    
      // Find the inorder successor
      int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
          minv = root.left.key;
          root = root.left;
        }
        return minv;
      }
      
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
        if (root == null){
            return;
        }
        inOrderTraverseRecursive(root.left);
        System.out.print(root.key + " ");
        inOrderTraverseRecursive(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5,5); //rn, i'm only adding at the root
        bst.add(7,7);
        bst.add(3,3);
        
        System.out.println("bst root: " + bst.root.key);
        bst.inOrderTraverse();
        System.out.println();
        System.out.println("Remove: " + bst.delete(3));
        bst.inOrderTraverse();
        System.out.println();
        bst.add(2,2);

    }
}