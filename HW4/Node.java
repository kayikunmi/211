import java.lang.reflect.Array;

public class Node<E> {

    public E data;
    protected Node<E>[] nextNodes;
    public Node<E> next;
    public Node<E> prev;
    public Node<E> down;

    public E getData() {
        return data;    
    }
    public Node <E> getNext() {
        return next;
    }
    public Node <E> getPrev() {
        return prev;
    }
    public Node <E> getDown() {
        return down;
    }


    public void setNext(Node <E> nextNode) {
        this.next = nextNode;
    }
    public void setPrev(Node <E> prevNode) {
        this.prev = prevNode;
    }
    public void setDown(Node <E> downNode) {
        this.down = downNode;
    }

    //this is safe

    public int getHeight() {
        return nextNodes.length - 1;
    }

    public Node (E elt, int height){
        data = elt;
        nextNodes = (Node<E>[]) Array.newInstance(Node.class, height+1);
    }

}
