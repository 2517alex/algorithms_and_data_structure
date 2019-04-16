package lisson_4;

public class MyLinkedList <Type> {

    private  class Node {
        Type data;
        Node next;
        Node previous;

        public Node(Type data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }


    private int size = 0;
    private Node first;
    private Node lact;

    public int size() {
        return size;
    }

    public boolean isEmpty () {
        return size == 0;
    }

}
