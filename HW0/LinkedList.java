public class LinkedList {

  Node head;
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

  public void add(String s, int p) {     
    Node newNode = new Node(s); 
    newNode.data = s;
    newNode.next = null;
    newNode.prev = null;
    if(p < 1) {
      System.out.println("Error: p should be >= 1.");
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
        System.out.println("Error: The previous node is null.");
      }       
    }
    size++;
  }
  
  public String remove(int p) {
    Node ref = head;
    for (int i = 0; i < p; i++) {
        ref = ref.next;
    }
    remove(ref.getObject());
    return ref.getObject();
  }


  public boolean remove(String s) {
    Node temp = head;
    Node prev = null;
    if (this.head != null && this.head.data == s) {
        this.head = this.head.next;
        return true;
    }
    while (temp != null) {
        if (temp.data == s) {
            prev.next = temp.next;
            return true;
        }
        prev = temp;
        temp = temp.next;
    }
    return false;
  }
  public boolean removeAll(String s){
    Node current = head;
        while (current != null) {
            if (current.data == s)
            remove(s);
            current = current.next;
        }
        return true;
  }

  public boolean swap(int p, int q) {
    //i swapped the data, not nodes. FIX THIS
    Node temp = head;
    if (this.head != null && this.head.data != null) {
      while (temp != null) {
        Node pNode = head;
        for (int z = 0; z < p; z++) {
          pNode = pNode.next; 
        }
        Node qNode = head;
        for (int y = 0; y < q; y++) {
          qNode = qNode.next;
        }
        String data = pNode.data;
        pNode.data = qNode.data;
        qNode.data = data;
        return true;
      }
    }
    return false;  
  }

  public void reverse() {
    Node prev = null;
    Node current = head;
    while (current != null) {
        Node next = current.getNext();
        current.setNext(prev);
        prev = current;
        current = next;
    }
    head = prev;
  }
  
  // public void swapNodes(int x, int y)
  //   {
  //       if (x == y)
  //           return;
  //       Node prevX = null, currX = head;
  //       while (currX != null && currX.data != x) {
  //           prevX = currX;
  //           currX = currX.next;
  //       }
  //       Node prevY = null, currY = head;
  //       while (currY != null && currY.data != y) {
  //           prevY = currY;
  //           currY = currY.next;
  //       }
  //       if (currX == null || currY == null)
  //           return;
  //       if (prevX != null)
  //           prevX.next = currY;
  //       else 
  //           head = currY;
  //       if (prevY != null)
  //           prevY.next = currX;
  //       else 
  //           head = currX;
  //       Node temp = currX.next;
  //       currX.next = currY.next;
  //       currY.next = temp;
  //   }
}  


