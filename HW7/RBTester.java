import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;

public class RBTester {
    static int height, blackheight, heightLeft, heightRight = 0;


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
            } 
            else if (!color.equalsIgnoreCase("black")) {
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
        childofRedisBlack(root) == true && //not working
        checkLeafisBlack(root) == true && 
        bheight(root.right) == bheight(root.right) //not working
        ){
            return true;
        }
        else{
            return false;
        }
    }

    private static boolean checkRoot(RBNode<Integer> root){
        if(root.red!= true){
            //if it is false, that means the root is black
            System.out.println("checkRoot");
            return true;
        }
        else{
            return false;
        }
    }

    private static boolean childofRedisBlack(RBNode<Integer> node){
        if((node.red == true) && (node.left.red != true) && (node.right.red != true)){
            //this node is red
            System.out.println("childofredisblack");
            // childofRedisBlack(node.left);
            // childofRedisBlack(node.right);
            return true;
        }
        else{
            return false;
        }
    }

    private static boolean checkLeafisBlack(RBNode<Integer> node){
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
            if(node.isNullLeaf()){
                //if it is false, that means the leaf is black
                System.out.println("checkleafisblack");
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

    //the black height from root to node function not working
    /*
     * while temp is black?
     * start at the leaf.
     * if the parrent is black, add one.
     * make the parent the new temp
     * then run the function again at the new temp
     * after this, save the answer for this one path, 
     * compare it with the other paths in the tree
     * and stop when the heights change
     */

    private static int bheight(RBNode<Integer> node){
        while(node.isNullLeaf() == false){
            if(node.red != true){
                blackheight++;
            }
            bheight(node.left);
        }
        return blackheight;
    }

//true is red, false is black

} // class RBTest
