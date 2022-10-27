import java.util.*;
import java.io.*;

public class WordCount <K extends Comparable<K>, V>  {
    static void CountWords(String filename, BinarySearchTree words) throws FileNotFoundException {
        Scanner cin = new Scanner(new File(filename));
        while (cin.hasNext()) {
            String word = cin.next().toLowerCase().replaceAll("[';.:-^]*", ""); 
            word = word.toLowerCase();
            Integer count = words.lookup(word);
            if (count != null){
                count++;
                //System.out.println(count);
            }
            /*put each word in the words in an array
             * make each word into a key
             * if its in bst, increment value by 1
            */

            words.add(word, count); //add not working. Why?
        }
        cin.close();
    }


    public static void main(String[] args) throws FileNotFoundException {
        BinarySearchTree bst = new BinarySearchTree();
        CountWords("file.txt", bst);
        //System.out.println(bst);
        bst.inOrderTraverse();
        System.out.println();
        System.out.println("bst root: " + bst.root.key + ": " + bst.root.value);
    }
}