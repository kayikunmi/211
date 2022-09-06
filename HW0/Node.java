public class Node {
    String data;
    Node nextNode;
    public Node next;
    public Object prev;

    public Node (String data2){
        this.data = data2;
    }

    public Node(String s, Node cur) {
    }

    public String getData() {
        return data;    }

    public Node getNext() {
        return next;
    }

    public String getObject() {
        return data;
    }
}
