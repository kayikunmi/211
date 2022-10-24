// public class Node<K,V> { 
//     K key; 
//     V value;
//     Node left;
//     Node right; 

//     public Node(K data){ 
//         key = data; 
//         left = null;
//         right = null; 
//     } 

//     public Node(K key, V value) {
// 		this.key = key;
// 		this.value = value;
// 	}

// 	public String toString() {
// 		String s = "\"" + key + ":" + value + "\"";
// 		return s;
// 	}
// }

public class Node<K, V> {
    // *** fields ***
    K key;
    V value;
    Node<K, V> left, right;
 
    // *** constructor ***
    public Node(K key, V value,
                         Node<K, V> left, Node<K, V> right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }
    public V getValue() { 
        return value; 
    }
    public void setValue(V newV) { 
        value = newV; 
    }
    
}