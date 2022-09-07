public class Node {
    String data;
    Node nextNode;
    public Node next;
    public Node prev;

    public Node (String data){
        this.data = data;
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

    // public void displayData(){
    //     System.out.print(data + " ");
    //    }

    public Node getPrev() {
        return next;
    }
}
