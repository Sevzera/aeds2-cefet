package classes;

public class BinaryTree {

    Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(Item item) {
        Node n = new Node(item);
        if (this.root == null) {
            root = n;
        } else {
            Node mid;
            Node ref = this.root;
            while (true) {
                mid = ref;
                if (item.key < ref.item.key) {
                    if (ref.left == null) {
                        mid.left = n;
                        break;
                    }
                    ref = ref.left;
                } else if (item.key > ref.item.key) {
                    if (ref.right == null) {
                        mid.right = n;
                        break;
                    }
                    ref = ref.right;
                }
            }

        }
    }

    public void search(Item item) {
        int depth = 0;
        if (this.root.item.key == item.key) {
            System.out.println("Valor " + item.key + " encontrado na raiz");
        } else {
            Node ref = this.root;
            while (true) {
                if (ref == null) {
                    System.out.println("Valor nao encontrado na arvore");
                    break;
                }
                if (item.key < ref.item.key) {
                    depth++;
                    ref = ref.left;
                } else if (item.key > ref.item.key) {
                    depth++;
                    ref = ref.right;
                } else if (item.key == ref.item.key) {
                    System.out.println("Valor " + item.key + " encontrado no nivel " + depth);
                    break;
                }
            }

        }
    }

}
