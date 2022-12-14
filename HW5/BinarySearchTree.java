import java.util.Stack;

//import java.util.*;
public class BinarySearchTree<K extends Comparable<K>, V> {
    Node<K,V> root;
    BinarySearchTree() {
        root = null;
    }
    Node<K,V> temp = root;
    
    public void add(K key, V value) {
        root = addroot(root, key,value);
    }

    Node<K,V> addroot(Node<K,V> addkey, K key, V value){
        //If the tree is empty
           if (addkey == null) {
            addkey = new Node<K,V>(key, value);
            return addkey;
        }
        /*Otherwise, check if the key is greater or less than the node
         * If it is less, add it to the left
         * If it is greater, add it to the right side*/
        String s1=String.valueOf(key); 
        String s2=String.valueOf(addkey.key);  
        if (s1.compareTo(s2)<0){
            addkey.left = addroot(addkey.left, key, value);
        }
        else if (s1.compareTo(s2)>0){
            addkey.right = addroot(addkey.right, key, value);
        }
        //add a case if its already there
        else if(s1.compareTo(s2) ==0){
            //update the value
            addkey.value = value;
        }
        return addkey;
    }

    public int delete(K key) {
        int answer = lookup(key);
        Node<K,V> curr = root;
        deleteNode(curr, key); //delete the node with recursion using the root
        return answer;
    }
    
    /*Delete with recursion
     * If node is null return  null
     * if the key is less than 
     */
    public Node<K,V> deleteNode(Node<K,V> del, K key) {
        //If node is null return  null
        if (del == null) {
            return null;
        }
        //if key is greater than, delete (recursion) on the right side
        if ((int)(key) > (int)(del.key)) {
            del.right = deleteNode(del.right, key);
        }
        //if its less, delete (recursion) on the left side
        else if ((int)(key) < (int)(del.key)) {
            del.left = deleteNode(del.left, key);
        }
        //then, check for children
        else {
            //no kids, no problem
            if (del.left == null && del.right == null) {
                del = null;
            }
            //damn, there's kids. 
            //check if we can use a successor
            else if (del.right != null) {
                del.key = successor(del);
                del.right = deleteNode(del.right, del.key);
            } 
            //can't use successor, so we replace with a predecessor
            else {
                del.key = predecessor(del);
                del.left = deleteNode(del.left, del.key);
            }
        }
        return del;
    }

    /* The sucessor is the smallest number on the right side
     * The predecssor is the biggest number on the left side*/
    public K successor(Node<K,V> root) {
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.key;
    }

    public K predecessor(Node<K,V> root) {
        root = root.left;
        while (root.right != null){
            root = root.right;
        }
        return root.key;
    }

    public int lookup(K key) {
        return lookup(root, key);
    }
    public int lookup(Node<K,V> findkey, K key){ 
        //if find is null, return -1. DNE
        if (findkey == null){
            return 0;
        }
        // String s1=String.valueOf(key); 
        // String s2=String.valueOf(findkey.key); 
        //great, we found it. return the value
        // System.out.println("Ran Lookup()- " + findkey.key + ": " + findkey.value);
        if (findkey.key.compareTo(key)==0){
            return (int)(findkey.value);
        }
        // recursion on left subtree /
        int res1 = lookup(findkey.left, key);
        // find found, no need to lookup anymore. return it
        if(res1>0) {
            return res1;
        }
        // find is not found in left, recursion on right subtree, and return it
        int res2 = lookup(findkey.right, key);
        return res2;
    }
     
    public void inOrderTraverse() {
        Node<K,V> temp = root;
        inOrderTraverseRecursive(temp);
    }

    public void trav(Node<K,V> node) {
        Stack <Node<K,V>> s = new Stack();
        while(!s.isEmpty() || node != null){
            if(node != null){
                s.push(node);
                node = node.left;
            }
            else{
                Node <K,V> temp = s.pop();
                System.out.print(temp.key);
                node = temp.right;
            }
        }
    }

    private void inOrderTraverseRecursive(Node<K,V> temp) {
        if (temp == null){
            return;
        }
        /*print all left nodes first,
         * then the "parent"
         * and finally the right node at each "parent
         * output should be in ascending order
        */
        //System.out.println(",");
        inOrderTraverseRecursive(temp.left);
        System.out.print(temp.key + ":" + temp.value + " ");
        inOrderTraverseRecursive(temp.right);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(7,7); //rn, i'm only adding at the temp
        bst.add(8,8);
        bst.add(3,3);
        bst.add(1,1);
        bst.add(5,5);
        bst.add(14, 12);
        bst.add(4,4);
        
        System.out.println("bst root: " + bst.root.key);
        bst.inOrderTraverse();
        System.out.println();
        System.out.println("Lookup: " + bst.lookup(3));
        System.out.println("Lookup: " + bst.lookup(14));
        // System.out.println("Remove: " + bst.delete(7));
        // System.out.println("Remove: " + bst.delete(12));
        bst.inOrderTraverse();
        System.out.println();
        System.out.println("bst root: " + bst.root.key);
        // bst.add(4,97);
        // System.out.println("Lookup: " + bst.lookup(4));
        System.out.println("trav");
        bst.trav(bst.root);

    }
}