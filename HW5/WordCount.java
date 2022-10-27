import java.util.*;
import java.io.*;

public class WordCount <K extends Comparable<K>, V>  {
    static BinarySearchTree CountWords(String filename) throws FileNotFoundException {
        BinarySearchTree words = new BinarySearchTree<>();

        Scanner cin = new Scanner(new File(filename));
        while (cin.hasNext()) {
            String word = cin.next().toLowerCase().replaceAll("[';.,:-^]*", ""); 
            word = word.toLowerCase();
            Integer count = (Integer)(words.lookup(word));
         
            if (word.contains(word)){//checks string rn
                //System.out.println("good morning");
                count++;
                words.add(word, count);//replace old value with new value
                //System.out.println(count);
            }
            /*put each word in the words in an array
             * make each word into a key
             * if its in bst, increment value by 1
            */

           // words.add(word, 1); //if the word was not there before, add it to the BST and start with a value of 1
        }
        
        cin.close();
        return words;
    }


    public static void main(String[] args) throws FileNotFoundException {
        BinarySearchTree bst = new BinarySearchTree();
        bst = CountWords("sampletext.txt");
        //System.out.println(bst);
        bst.inOrderTraverse();
        System.out.println();
        System.out.println("The bst root: " + bst.root.key + ": " + bst.root.value);
    }
}