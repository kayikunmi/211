//Kayikunmi- LinkedList.java
public class LinkedList {

  Node head;
  Node tail;
  int size;

  public void add(String new_data){
    Node newNode = new Node(new_data);
    //is the list empty?
    if (head == null){
      head = new Node(new_data);
      size++;
      return;
    }
    else{
      newNode.next = null;
      Node last = head;
      while (last.next != null)
        last = last.next;
        last.next = newNode;
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
    /*
    Works, but can't access nodep.prev
    */
    Node temp = head;
    if (this.head != null && this.head.data != null) {
      while (temp != null) {
        Node nodep = head;
        for (int z = 0; z < p; z++) {
          nodep = nodep.next;
        }
        //use this to try to get nodep.prev?
        // it works, but doesn't??? i'm confused
        Node nodepPrev = head;
        for (int z = 0; z < p-1; z++) {
          nodepPrev = nodepPrev.next;
        }
        Node copy1 = nodep;
        copy1.next = nodep.next;
        copy1.prev = nodepPrev;
        Node nodeq = head;
        for (int y = 0; y < q; y++) {
          nodeq = nodeq.next;
        }

        Node copy2 = nodeq;
        copy2.next = copy1.next;
        copy2.prev = copy1.prev;
        copy2.prev.next = copy1;
        copy2.next.prev = copy1;
        copy1.next = nodeq.next;
        copy1.prev = nodeq.prev;
        copy1.prev.next  = copy1;
        copy1.next.prev = copy1;
      }
    }
    return true;
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

}


