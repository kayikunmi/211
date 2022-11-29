import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;

public class RBTester {
    static int height, blackheight, heightLeft, heightRight = 0;
    // int height, heightLeft, heightRight = 0;

    public static void main (String[] args) {

	if (args.length != 1) { showUsageAndExit(); }

	RedBlackTree<Integer> rbt = new RedBlackTree<Integer>();
	Scanner                sc = null;
        try {
            sc = new Scanner(new File(args[0]));
        } catch (FileNotFoundException e) {
            System.err.printf("ERROR: Could not open file %s\n", args[0]);
            System.exit(1);
        }

	// Read instructions until there are no more.
	int line = 0;
	while (sc.hasNext()) {

	    line = line + 1;
	    int    value = 0;
	    try {
		value = sc.nextInt();
	    } catch (InputMismatchException e) {
		System.err.printf("ERROR: Could not read value on line %d\n", line);
		System.exit(1);
	    }
            String  color = sc.next();
            boolean red   = false;;
            if (color.equalsIgnoreCase("red")) {
                red = true;
            } else if (!color.equalsIgnoreCase("black")) {
                System.err.printf("ERROR: Unknown color %s on line %d\n", color, line);
                System.exit(1);
            }
            
            rbt.insert(value, red);
            
	}

        System.out.printf("Is it valid? %b\n", isRBTree(rbt));

    }

    
    private static void showUsageAndExit () {
	
	System.err.printf("USAGE: java RBTester <input pathname>\n");
	System.exit(1);

    }


    private static boolean isRBTree (RedBlackTree<Integer> rbt) {

	RBNode<Integer> root = rbt.root;
        // COMPLETE THIS METHOD.  YOU MAY/SHOULD USE HELPER METHODS.

        if(checkRoot(root) == true && 
        childofRedisBlack(root) == true && 
        checkLeafisBlack(root) == true &&
        blackHeight(root) == 0){
            return true;
        }

        else{
            return false;
        }
    }

    private static boolean checkRoot(RBNode<Integer> root){
        if(root.red!= true){
            //if it is false, that means the root is black
            return true;
        }
        else{
            return false;
        }
    }

    private static boolean childofRedisBlack(RBNode<Integer> root){
        if(root.red == true){
            //this node is red
            if((root.left.red != true) && (root.right.red != true)){
                return true;
            }
        }
        return false;
    }

    private static boolean checkLeafisBlack(RBNode<Integer> node)
    {
    /*if the root is null, dont return false, 
    cehck if its red or black then cehck if 
    kids are null, if they are, check if red or black*/
      
        // If node is null, return
        // if (node == null){
        //     if(node.red != true){
        //         return true;
        //     }
        // }
        
        // If node is leaf node, check that its black
        if (node.left == null && node.right == null)
        {   
            if(node.left.red!= true && node.right.red!= true){
                //if it is false, that means the leaf is black
                return true;
            }
        }
    
        // If left child exists, check for leaf
        // recursively
        if (node.left != null){
            checkLeafisBlack(node.left);
        }
          
        // If right child exists, check for leaf
        // recursively
        if (node.right != null){
            checkLeafisBlack(node.right);
        }
        return false;
    
    }

    // private static boolean rootToLeaf(RBNode<Integer> node){
    //     if (node == null) {
    //         return false;
    //     }
    //     if(heightLeft == heightRight)
    //     return true;
    // }

    // private static int blackHeight(RBNode<Integer> node){
    //     if (node.red == false){
    //         height++;
    //     }
    //     if (node.left != null){
    //         heightLeft = blackHeight(node.left);
    //     }
    //     else{
    //         heightLeft = 1;
    //     }
    //     if (node.right != null){
    //         heightRight = blackHeight(node.right);
    //     }
    //     else{
    //         heightRight = 1;
    //     }
    //     // if (heightLeft != heightRight)
    //     //     //YOU HAVE A PROBLEM!
    //     height += heightLeft;
    //     return height;
    // }

    private static int blackHeight(RBNode<Integer> root) {
        if (root == null)
            return blackheight; 

        if (root.red == false) {
            blackheight ++;

        } 
        // else {
        //     root.black_count = root.parent.black_count;
        // }
        if ((root.left == null) && (root.right == null)) {              
            blackheight ++;            
        }               
        // blackHeight(root.left);
        // blackHeight(root.right);
        if(blackHeight(root.left) == blackHeight(root.right)){
            return 0;
        }
        else{
            return -1;
        }
    } 


//true is red, false is black

} // class RBTest
