public class Node {
    public Movie data;
    public Node prev;
    public Node next;

    public Node(Movie data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}