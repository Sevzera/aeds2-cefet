package classes;
public class Node {
    Item item;
    Node left, right;

    public Node(Item item) {
        this.item = item;
        this.left = null;
        this.right = null;
    }

}