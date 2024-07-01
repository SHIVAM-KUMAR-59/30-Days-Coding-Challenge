
public class InsertUsingRecursion {

    private Node head;
    private Node tail;
    private int size;

    public InsertUsingRecursion() {
        this.size = 0;
    }

    // Display
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print("| " + temp.value + " |" + " --> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // Insert Using Recursion
    public void insertRecursion(int val, int index) {
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }
        node.next = insertRec(val, index--, node.next);
        return node;
    }

    // Basic Singly Linked List Class
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        InsertUsingRecursion list = new InsertUsingRecursion();
        list.insertRecursion(5, 0);
        list.insertRecursion(10, 1);
        list.insertRecursion(15, 2);
        list.insertRecursion(20, 3);
        list.display();
    }

}