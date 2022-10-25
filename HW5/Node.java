class Node<K,V> {
    K key;
    V value;
    Node<K,V> left, right;
   

    public Node(K item, V val) {
      key = item;
      value = val;
      left = right = null;
    }
  }
