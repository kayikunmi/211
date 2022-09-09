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
  
  // public String remove(int p) {
  //   Node ref = head;
  //   for (int i = 0; i < p; i++) {
  //       ref = ref.next;
  //   }
  //   remove(ref.getObject());
  //   return ref.getObject();
  // }


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
        Node nodep = head;
        for (int z = 0; z < p; z++) {
          nodep = nodep.next;
        }
        Node copy1 = nodep;
        copy1.next = nodep.next;
        copy1.prev = nodep.prev;
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
        

        



        







// Node nodepPrev = head;
        // for (int z = 0; z < p-1; z++) {
        //   nodepPrev = nodepPrev.next; 
        // }



        
        /*save the first one as a temp node,
        keep iterating till the second node, save that as a temp
        take first temp's next/ prev and make them the second's next/prev
        node 2 will have node one's next/prev.
        set OG node  two's as the first temp's n/p

        */
     
        
        //starmye -> smartye

        //iterate through list, copy node 1 node 2
        //iterate through again to node one
        // node2copy.next =  node1.next, node2copy.prev = node1.prev, node1.prev.next = node2copy
        //node1.next.prev = node2copy 

        


        // nodep.prev.next = nodeq; 
        // nodep.next.prev = nodeq;

        // Node pTemp = nodep;
        // Node qTemp = nodeq;
        // Node pTempPrev = nodep.prev;
        // Node pTempNext = nodep.next;
        // Node qTempPrev = nodeq.prev;
        // Node qTempNext = nodeq.next;



        // nodep = nodeq;
        // nodeq = pTemp;


        

        // String data = nodep.data;
        // nodep.data = nodeq.data;
        // nodeq.data = data;
        return true;
      }
    }
    return false;  
  }
        

//         Node pPrev = nodepPrev; //s
//         //System.out.println(pPrev.data);
//         //System.out.println(nodep.data);//t
//         Node pNext = nodep.next;//a
//         //System.out.println(pNext.data);
//         Node pNextNext = nodep.next.next;
//         //System.out.println(pNextNext.data);
//         Node qPrev = nodeq.prev; //m
//         //System.out.println(qPrev.data);
//         //System.out.println(nodeq.data);//y
//         ////
//         Node qNext = nodeq.next; //e
//       //System.out.println(head.data);
// Node tp = nodep;
// nodeq.next = nodep.next;
//       //head.next = nodeq;
//       //nodep.prev = head;
//       //nodep.next = 

        
        

        



//         //Node tempPrev = qPrev;
//         // Node pPrevNext = null; 
//         // pPrevNext = pPrev.next;//y
//         // pPrev.next = nodeq;
        
        
//         // qPrev = pPrev;

        

        
      

//         // nodeq.prev.next = nodep;
//         // nodeq.next.prev = nodep;
//         // nodepPrev.next = nodeq;
//         // nodep.next.prev = nodeq;

      
//         // System.out.println("prev: " + qPrev.data);
      
        

  //       return true;
  //     }
  //   }
  //   return false;  
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
    head = prev;
  }

  // public void swap(int a, int b) {
  //       Node temp = head;
  //       if (this.head != null && this.head.data != null) {
  //           while (temp != null) {
  //             Node nodep = head;
  //             for (int z = 0; z < a; z++) {
  //               nodep = nodep.next; 
  //               System.out.print(nodep.data);
  //             }
  //             Node nodeq = head;
  //             for (int y = 0; y < b; y++) {
  //               nodeq = nodeq.next;
  //             }

  //   if (nodep.next == nodeq) { // right next to each other
  //       nodep.next = nodeq.next;
  //       nodeq.prev = nodep.prev;

  //       if (nodep.next != null)
  //       nodep.next.prev = nodep;

  //       if (nodeq.prev != null)
  //       nodeq.prev.next = nodeq;


  //           nodeq.next = nodep;
  //           nodeq.prev = nodep;
  //   } else {
  //       Node p = nodeq.prev;
  //       Node n = nodeq.next;

  //       nodeq.prev = nodep.prev;
  //       nodeq.next = nodep.next;

  //       nodep.prev = p;
  //       nodep.next = n;

  //       if (nodeq.next != null)
  //       nodeq.next.prev = nodeq;
  //       if (nodeq.prev != null)
  //       nodeq.prev.next = nodeq;

  //       if (nodep.next != null)
  //       nodep.next.prev = nodep;
  //       if (nodep.prev != null)
  //       nodep.prev.next = nodep;

  //   }

  //           }}}


  // public void swapNodes(int x, int y) 
  //   { 
  //     Node temp = head;
  //   if (this.head != null && this.head.data != null) {
  //     while (temp != null) {
  //       Node nodep = head;
  //       for (int z = 0; z < x; z++) {
  //         nodep = nodep.next; 
  //       }
  //       Node nodepPrev = head;
  //       for (int z = 0; z < y-1; z++) {
  //         nodepPrev = nodepPrev.next; 
  //       }
  //       Node nodeq = head;
  //       for (int b = 0; b < y; b++) {
  //         nodeq = nodeq.next;
  //       }
  //       // Nothing to do if x and y are same 
  //       if (x == y) return; 

  //       // Search for x (keep track of prevX and CurrX) 
  //       Node prevX = null, currX = head; 
  //       while (currX != null && currX.data != nodep.data) 
  //       { 
  //           prevX = currX; 
  //           currX = currX.next; 
  //       } 

  //       // Search for y (keep track of prevY and currY) 
  //       Node prevY = null, currY = head; 
  //       // while (currY != null && currY.data != nodeq.data) 
  //       // { 
  //       //     prevY = currY; 
  //       //     currY = currY.next; 
  //       // } 

  //       // // If either x or y is not present, nothing to do 
  //       // if (currX == null || currY == null) 
  //       //     return; 

  //       // // If x is not head of linked list 
  //       // if (prevX != null) 
  //       //     prevX.next = currY; 
  //       // else //make y the new head 
  //       //     head = currY; 

  //       // // If y is not head of linked list 
  //       // if (prevY != null) 
  //       //     prevY.next = currX; 
  //       // else // make x the new head 
  //       //     head = currX; 

  //       // Swap next pointers 
  //       Node timp = currX.next; 
  //       currX.next = currY.next; 
  //       currY.next = timp; 

  //   } 
  // }}}
  }


