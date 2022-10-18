import java.lang.reflect.Array;
import java.util.Random;
import java.util.Stack;

public class SkipList<E extends Comparable<E>> implements AmhSortedSet<E> {

    private Node<E> head;
    private int height;
    private int numElts = 0;
    private Random rand;
    private double p;

    private int countOps = 0;

    public boolean add(E x) {
        // find the predecessor nodes on each level of the list
        Stack<Node<E>> preds = findAllPreds(x);
        Node<E> pred0 = preds.peek();
        if(pred0.nextNodes[0] != null && pred0.nextNodes[0].data.equals(x)) return false; // elt x was already present

        // create a new node for elt x, and generate its height
        Node<E> newNode = new Node<E>(x, chooseHeight());
        int newHeight = newNode.getHeight();

        // increase the height of the head node, if needed
        if (newHeight > height) {
            if (newHeight > head.nextNodes.length-1) {
                Node<E>[] temp = (Node<E>[]) Array.newInstance(Node.class, newHeight+1);
                for(int i = 0; i < head.nextNodes.length; i++) {
                    temp[i] = head.nextNodes[i];
                }
                head.nextNodes = temp;
            }
            for(int i = newHeight; i > height; i--) {
                head.nextNodes[i] = newNode;
            }
            height = newHeight;
        }

        // add x after its predecessor on each level within x's height
        // YOU FILL IN THIS PART



        // now we have one more element stored
        numElts++;
        return true;
    }

    public E remove(E x) {
        // find the predecessor nodes on each level of the list
        Stack<Node<E>> preds = findAllPreds(x);

        // if the element wasn't present, nothing to return
        Node<E> pred0 = preds.peek();
        if(pred0.nextNodes[0] == null) return null; // empty list
        if(pred0.nextNodes[0] != null && !pred0.nextNodes[0].data.equals(x)) return null; // non-empty list, elt x wasn't present

        // if the elment was present, now we need to remove it from each level on which it appears
        // YOU FILL IN THIS PART



        // now we have one fewer element stored
        numElts--;
        return null; // placeholder, CHANGE THIS to return the correct thing
    }

    public E find(E x) {
        // find the predecessor nodes on each level of the list
        Stack<Node<E>> preds = findAllPreds(x);
        Node<E> level0 = preds.pop(); // the top of the stack is the predecessor on level 0
        if (level0.nextNodes[0] == null) return null;
        else return level0.nextNodes[0].data;
    }

    public int size() {
        return numElts;
    }

    protected Stack<Node<E>> findAllPreds(E x) {
        // this method should return a stack containing the predecessor nodes of element x on each level,
        // with the predecessor on level 0 at the top of the stack and the predecessor at the highest
        // level on the bottom of the stack
        // YOU FILL IN THIS PART




        return null; // placeholder, CHANGE THIS to return the correct thing
    }

    public void print() {
        for(int i = 0; i <= height; i++) {
            Node<E> y = head;
            while(y.nextNodes[i] != null) {
                y = y.nextNodes[i];
                System.out.print(y.data + " ");
            }
            System.out.println();
        }
    }


    public int getOps() {
        return countOps;
    }

    private int chooseHeight() {
        int level = 0;
        double flip = rand.nextDouble();
        while(flip < p) {
            level++;
            flip = rand.nextDouble();
        }
        return level;
    }

    public SkipList() {
        head = new Node<E>(null, 0);
        height = 0;
        p = 0.5;
        rand = new Random();
    }

    public SkipList(int seed) {
        head = new Node<E>(null, 0);
        height = 0;
        p = 0.5;
        rand = new Random(seed);
    }

    public SkipList(double prob) {
        head = new Node<E>(null,0);
        height = 0;
        p = prob;
        rand = new Random();
    }

    public SkipList(double prob, int seed) {
        head = new Node<E>(null,0);
        height = 0;
        p = prob;
        rand = new Random(seed);
    }

}


/* WTFFFFFFFF */


// import java.lang.reflect.Array;
// import java.util.Random;
// import java.util.Stack;

// public class SkipList<E extends Comparable<E>> implements AmhSortedSet<E> {

//     private Node<E> head;
//     private int height;
//     private int numElts = 0;
//     private Random rand;
//     private double p;

//     private int countOps = 0;

//     public boolean add(E x) {
//         // find the predecessor nodes on each level of the list
//         Stack<Node<E>> preds = findAllPreds(x);
//         Node<E> pred0 = preds.peek();
//         //set new node to node after head]
        
//         if(pred0.nextNodes[0] != null && pred0.nextNodes[0].data.equals(x)) {
//             return false; // elt x was already present
//         }
//         // create a new node for elt x, and generate its height
//         Node<E> newNode = new Node<E>(x, chooseHeight());
//         int newHeight = newNode.getHeight();

//         // increase the height of the head node, if needed
//         if (newHeight > height) {
//             if (newHeight > head.nextNodes.length-1) {
//                 Node<E>[] temp = (Node<E>[]) Array.newInstance(Node.class, newHeight+1);
//                 for(int i = 0; i < head.nextNodes.length; i++) {
//                     temp[i] = head.nextNodes[i];
//                 }
//                 head.nextNodes = temp;
//             }
//             for(int i = newHeight; i > height; i--) {
//                 head.nextNodes[i] = newNode;
//             }
//             height = newHeight;
//         }

//         // add x after its predecessor on each level within x's height
//         // YOU FILL IN THIS PART
//         int currentLevel = 0;
//         while(currentLevel != height){
//             //add this number where it belongs
//             //the number will go after the number that is at the top of the stack.
//             if (!findAllPreds(x).isEmpty()){
//             Node<E> addbefore = findAllPreds(x).peek();
//             //switch
//             Node <E> temp = addbefore.next;
//             addbefore.next = (Node<E>) x;
//             temp.prev = (Node<E>) x;
//             }
        

//             currentLevel ++;
//         }
//         // I think I have it, but the next step will be to do this on each level. How do I do this? and check it?



//         // now we have one more element stored
//         numElts++;
//         return true;
//     }

//     public E remove(E x) {
//         // find the predecessor nodes on each level of the list
//         Stack<Node<E>> preds = findAllPreds(x);

//         // if the element wasn't present, nothing to return
//         Node<E> pred0 = preds.peek();
//         if(pred0.nextNodes[0] == null) return null; // empty list
//         if(pred0.nextNodes[0] != null && !pred0.nextNodes[0].data.equals(x)) return null; // non-empty list, elt x wasn't present

//         // if the elment was present, now we need to remove it from each level on which it appears
//         // YOU FILL IN THIS PART



//         // now we have one fewer element stored
//         numElts--;
//         return null; // placeholder, CHANGE THIS to return the correct thing
//     }

//     public E find(E x) {
//         // find the predecessor nodes on each level of the list
//         Stack<Node<E>> preds = findAllPreds(x);
//         Node<E> level0 = preds.pop(); // the top of the stack is the predecessor on level 0
//         if (level0.nextNodes[0] == null) return null;
//         else return level0.nextNodes[0].data;
//     }

//     public int size() {
//         return numElts;
//     }

//     protected Stack<Node<E>> findAllPreds(E x) {
//         // this method should return a stack containing the predecessor nodes of element x on each level,
//         // with the predecessor on level 0 at the top of the stack and the predecessor at the highest
//         // level on the bottom of the stack
//         // YOU FILL IN THIS PART

//         /*start on highest level, check if each node is less than 'x'
//         if it is greater than x, stop and go to the lower level.
//         store that in the stack
//         */
//         // int highestLevel = height - 1;
//         // Node<E> check = head;
//         // Integer numx = (Integer) x;
//         // Integer numcheck = (Integer) check.data;
//         // for (int i = highestLevel; i >= 0; i --){    
//         //    while (numcheck.intValue() < numx.intValue()){
//         //         check = check.nextNodes[i]; //go to the next node
//         //    }
//         // }
//         // return null; // placeholder, CHANGE THIS to return the correct thing
//         Node<E> currNode = head;
//         Stack<Node<E>> stackOfPreds = new Stack<Node<E>>();
//         boolean found = false;
//         while (!found) {
//             int index = 0;
//             //special case to return a node containing null - indicates value not in list
//             if (currNode == null) {
//                 stackOfPreds.push(currNode);
//                 return stackOfPreds;
//             }
//             // found it!
//             else if (x.equals(currNode.getData())) {
//                 found = true;
//             }
//             //Go to the next one over if it's not too high.
//             else if (currNode.getNext() != null && compare(currNode.getNext().getData(), x) <= 0) {
//                 currNode = currNode.getNext();
//             }
//             //It was too high, so go down instead.
//             else {
//                 currNode = currNode.down;
//             }
//             index++;
//             currNode = currNode.nextNodes[index];
            
            
//         }
//         return stackOfPreds;
//     }

//     private int compare(Object data, E x) {
//         int intObj1 = (int)data;
//         int intObj2 = (int)x;
 
//         // Get the difference
//         int difference = intObj1 - intObj2;
 
//         if (difference == 0) {
 
//             // Both are equal
//             return 0;
//         }
//         else if (difference < 0) {
 
//             // obj1 < obj2
//             return -1;
//         }
//         else {
 
//             // obj1 > obj2
//             return 1;
//         }
//     }

//     public void print() {
//         for(int i = 0; i <= height; i++) {
//             Node<E> y = head;
//             while(y.nextNodes[i] != null) {
//                 y = y.nextNodes[i];
//                 System.out.print(y.data + " ");
//             }
//             System.out.println();
//         }
//     }


//     public int getOps() {
//         return countOps;
//     }

//     private int chooseHeight() {
//         int level = 0;
//         double flip = rand.nextDouble();
//         while(flip < p) {
//             level++;
//             flip = rand.nextDouble();
//         }
//         return level;
//     }

//     public SkipList() {
//         head = new Node<E>(null, 0);
//         height = 0;
//         p = 0.5;
//         rand = new Random();
//     }

//     public SkipList(int seed) {
//         head = new Node<E>(null, 0);
//         height = 0;
//         p = 0.5;
//         rand = new Random(seed);
//     }

//     public SkipList(double prob) {
//         head = new Node<E>(null,0);
//         height = 0;
//         p = prob;
//         rand = new Random();
//     }

//     public SkipList(double prob, int seed) {
//         head = new Node<E>(null,0);
//         height = 0;
//         p = prob;
//         rand = new Random(seed);
//     }

// }