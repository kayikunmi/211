//import java.util.*;
public class BinarySearchTree<K extends Comparable<K>, V> {
    Node root;
    BinarySearchTree() {
        root = null;
    }
    
    public void add(int key, int value) {
        Node temp = root;
        if (temp == null) { //add at temp
            // Insert the new data, if temp is null.
            root = new Node(key, value);
        }
        else if ((int)(temp.key) >= (int)(key)) {
            // if current temp data is greater than the new data then now process the left sub-tree
            temp.left = new Node(key, value);
        } 
        else {
            // if current temp data is less than the new data then now process the right sub-tree
            temp.right = new Node(key, value);
        }
        System.out.println("added " + key + " at " + value);
    }
      
    public int delete(int key) {
        Node curr = root;
        // curr = deleteRec(curr, key);
        // int value = curr.value;
        return deleteRec(curr, key).value;
    }
    Node deleteRec(Node temp, int key) {
        if(temp.key == key){
            return temp;
        }
        // Return if the tree is empty
        // else if (temp == null)
        //   return temp;
    
        // Find the node to be deleted
        if (key < temp.key)
          temp = deleteRec(temp.left, key);
        else if (key > temp.key)
          temp = deleteRec(temp.right, key);
        else {
          // If the node is with only one child or no child
          if (temp.left == null)
            return temp.right;
          else if (temp.right == null)
            return temp.left;
    
          // If the node has two children
          // Place the inorder successor in position of the node to be deleted
          temp.key = minValue(temp.right);
    
          // Delete the inorder successor
          temp.right = deleteRec(temp.right, temp.key);
        }
    
        return temp;
      }
    
      // Find the inorder successor
      int minValue(Node temp) {
        int minv = temp.key;
        while (temp.left != null) {
          minv = temp.left.key;
          temp = temp.left;
        }
        return minv;
      }
      
    public int lookup(int key) {
        Node temp = root;
        // Key is equal to the key at temp
        if (temp==null || temp.key==key){
            int lookupValue = temp.value;
            return lookupValue;
        }
        // Key is greater than temp's key
        if ((int)(temp.key) < (int)(key)){
            temp = temp.right;
            return lookup(temp.key);
        }
        // Key is smaller than temp's key
        else if((int)(temp.key) < (int)(key)){
            temp = temp.left;
            return lookup(temp.key);
        }
        else{
            return -1;
        }
    }
     
    public void inOrderTraverse() {
        Node temp = root;
        inOrderTraverseRecursive(temp);
    }
      // print the values in this BST in sorted order (to p)

    private void inOrderTraverseRecursive(Node temp) {
        if (temp == null){
            return;
        }
        inOrderTraverseRecursive(temp.left);
        System.out.print(temp.key + " ");
        inOrderTraverseRecursive(temp.right);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5,5); //rn, i'm only adding at the temp
        bst.add(7,7);
        bst.add(3,3);
        
        System.out.println("bst root: " + bst.root.key);
        bst.inOrderTraverse();
        System.out.println();
        System.out.println("Lookup: " + bst.lookup(3));
        System.out.println("Remove: " + bst.delete(3));
        bst.inOrderTraverse();
        System.out.println();
        bst.add(2,2);

    }
}