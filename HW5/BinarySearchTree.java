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


    int successor(Node root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.value;
      }
      int predecessor(Node root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.value;
      }
       
      Node deleteNode(Node del, int key) {

        if (del == null) return null;
        if (key > del.value) del.right = deleteNode(del.right, key);
        else if (key < del.value) del.left = deleteNode(del.left, key);
        else {
          if (del.left == null && del.right == null) del = null;
          else if (del.right != null) {
            del.value = successor(del);
            del.right = deleteNode(del.right, del.value);
          } 
          else {
            del.value = predecessor(del);
            del.left = deleteNode(del.left, del.value);
          }
        }
        return del;
      }
      

      
    public int delete(int key) {
        int answer = lookup(key);
        Node curr = root;
        deleteNode(curr, key);
        return answer;
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
        bst.add(1,1);
        bst.add(5,5);
        bst.add(14, 14);
        bst.add(4,4);
        
        System.out.println("bst root: " + bst.root.key);
        bst.inOrderTraverse();
        System.out.println();
        System.out.println("Lookup: " + bst.lookup(3));
        System.out.println("Remove: " + bst.delete(1));
        bst.inOrderTraverse();
        System.out.println();
        //bst.add(2,2);

    }
}