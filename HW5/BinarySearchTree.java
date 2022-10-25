//import java.util.*;
public class BinarySearchTree<K extends Comparable<K>, V> {
    Node root;
    BinarySearchTree() {
        root = null;
    }
    Node temp = root;
    
    public void add(int key, int value) {
        root = insertRec(root, key,value);
    }

    Node insertRec(Node root, int key, int value){
        //Node temp = root;
        /* If the tree is empty,
           return a new node */
           if (root == null) {
            root = new Node(key, value);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        else if (key < root.key)
            root.left = insertRec(root.left, key, value);
        else if (key > root.key)
            root.right = insertRec(root.right, key, value);
 
        /* return the (unchanged) node pointer */
        return root;
    }
      
    public int delete(int key) {
        Node curr = root;
        return deleteRec(curr, key).value;
    }
    Node deleteRec(Node temp, int key) {
        if(temp.key == key){
            return temp;
        }
        //Return if the tree is empty
        // else if (temp == null)
          //return temp;
    
        // Find the node to be deleted
        if (key < temp.key){
            temp = deleteRec(temp.left, key);
        }
        else if (key > temp.key){
            temp = deleteRec(temp.right, key);
        }
        else {
          // If the node is with only one child or no child
          if (temp.left == null){
            return temp.right;
          }
          else if (temp.right == null){
            return temp.left;
        }
    
          // If the node has two children
          // Place the inorder successor in position of the node to be deleted
          temp.key = successor(temp.right);
    
          // Delete the inorder successor
          temp.right = deleteRec(temp.right, temp.key);
        }
    
        return temp;
    }
    
    // Find the inorder successor
    int successor(Node temp) {
        int minv = temp.key;
        while (temp.left != null) {
          minv = temp.left.key;
          temp = temp.left;
        }
        return minv;
      }

    

    public int lookup(int key) {
        return lookup(root, key);
    }
    static int lookup( Node node, int key)
    {
        if (node == null)
            return -1;
    
        if (node.key == key)
            return node.value;
    
        // then recur on left subtree /
        int res1 = lookup(node.left, key);
    
        // node found, no need to look further
        if(res1>0) return res1;
    
        // node is not found in left,
        // so recur on right subtree /
        int res2 = lookup(node.right, key);
    
        return res2;
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
        bst.add(7,7); //rn, i'm only adding at the temp
        bst.add(8,8);
        bst.add(3,3);
        // bst.add(1,1);
        // bst.add(5,5);
        // bst.add(14, 14);
        // bst.add(4,4);
        
        System.out.println("bst root: " + bst.root.key);
        bst.inOrderTraverse();
        System.out.println();
        System.out.println("Lookup: " + bst.lookup(3));
        System.out.println("Remove: " + bst.delete(3));
        bst.inOrderTraverse();
        System.out.println();
        //bst.add(2,2);

    }
}