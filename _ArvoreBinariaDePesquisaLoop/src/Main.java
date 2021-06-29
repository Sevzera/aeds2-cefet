import classes.*;

public class Main {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        int n = 0;
        for (int i = 1000; i <= 9000; i++) {
            tree.insert(n);
            tree.search(n);
            n = n + 1000;
        }

    }
}