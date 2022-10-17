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
    public Node getNext() {
        return next;
    }
    public Node getPrev() {
        return prev;
    }
    public Node getDown() {
        return down;
    }


    public void setNext(Node nextNode) {
        this.next = nextNode;
    }
    public void setPrev(Node prevNode) {
        this.prev = prevNode;
    }
    public void setDown(Node downNode) {
        this.down = downNode;
    }

    //this is safe

    public int getHeight() {
        return nextNodes.length - 1;
    }

    public Node(E elt, int height){
        data = elt;
        nextNodes = (Node<E>[]) Array.newInstance(Node.class, height+1);
    }

}
