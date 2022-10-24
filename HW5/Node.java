// public class Node<K, V> {
//     // *** fields ***
//     K key;
//     V value;
//     Node<K, V> left, right;
 
//     // *** constructor ***
//     public Node(K key, V value) {
//         this.key = key;
//         this.value = value;
//         this.left = left;
//         this.right = right;
//     }
//     public V getValue() { 
//         return value; 
//     }
//     public void setValue(V newV) { 
//         value = newV; 
//     }
    
// }

class Node {
    int key;
    public int value;
    Node left, right;
   

    public Node(int item, int value) {
      key = item;
      left = right = null;
    }
  }
