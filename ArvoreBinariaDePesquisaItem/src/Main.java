import classes.*;

public class Main {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        Item n = new Item(10);
        for (int i = 1000; i <= 9000; i++) {
            tree.insert(n);
            tree.search(n);
            n = new Item(n.key + 1000);
        }



    }
}