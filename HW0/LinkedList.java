public class LinkedList {

  static Node head;
  Node tail;
  int size;

  public void add(String new_data){
    Node new_node = new Node(new_data);
    //If the Linked List is empty, then make the new node the head 
    if (head == null){
      head = new Node(new_data);
      size++;
      return;
    }
    //Else, traverse to find the last node, add the data and change to the new tail
    else{
      new_node.next = null;
      Node last = head;
      while (last.next != null)
        last = last.next;
        last.next = new_node;
        size++;
        return;
    }
  }

  public String traverse(){
    String retStr = "";
    Node current = head;
    while(current != null){
        retStr += current.getData();
        current = current.getNext();
    }
    return retStr;
  }

  public int count(String s){
    Node current = head;
        int count = 0;
        while (current != null) {
            if (current.data == s)
                count++;
            current = current.next;
        }
        return count;
  }

  void add(String s, int p) {     
    Node newNode = new Node(s); 
    newNode.data = s;
    newNode.next = null;
    newNode.prev = null;
    if(p < 1) {
      System.out.print("\np should be >= 1.");
    } 
    else if (p == 1) {
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    } 
    else {
      Node temp = new Node(s);
      temp = head;
      for(int i = 0; i < p-1; i++) {
        if(temp != null) {
          temp = temp.next;
        }
      }
      if(temp != null) {
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next = newNode;  
        if(newNode.next != null)
          newNode.next.prev = newNode;
      } 
      else {
        System.out.print("\nThe previous node is null.");
      }       
    }
    size++;
  }
//   //partly works. I can ID s at p, but i need to remove it from the list.
//   public String remove(int p) {
//     Node ref = head;
//     for (int i = 0; i < p; i++) {
//         ref = ref.next;
//     }
//     if (p == 0) {
//         head = ref.next;
//     } else {
//         ref.prev = ref.next;
//     }
//     return ref.getObject();
// }
// //fix this
// public boolean remove(String s){
//   if(count(s) >=1){
//     Node ref = head;
//     ref.prev = ref.next;
//     return true;
//   }
//   else{
//     return false;
//   }
// }

public void reverse() {
  Node prev = null;
  Node current = head;
  while (current != null) {
      Node next = current.getNext();
      current.setNext(prev);
      prev = current;
      current = next;
  }
  LinkedList.head = prev;
}

}
