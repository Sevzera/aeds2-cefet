package classes;

public class BinaryTree {

    Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int key) {
        Node n = new Node(key);
        if (this.root == null) {
            root = n;
        } else {
            Node mid;
            Node ref = this.root;
            while (true) {
                mid = ref;
                if (n.key < ref.key) {
                    if (ref.left == null) {
                        mid.left = n;
                        break;
                    }
                    ref = ref.left;
                } else if (n.key > ref.key) {
                    if (ref.right == null) {
                        mid.right = n;
                        break;
                    }
                    ref = ref.right;
                }
            }

        }
    }

    public void search(int key) {
        int depth = 0;
        if (this.root.key == key) {
            System.out.println("Valor " + key + " encontrado na raiz");
        } else {
            Node ref = this.root;
            while (true) {
                if (ref == null) {
                    System.out.println("Valor nao encontrado na arvore");
                    break;
                }
                if (key < ref.key) {
                    depth++;
                    ref = ref.left;
                } else if (key > ref.key) {
                    depth++;
                    ref = ref.right;
                } else if (key == ref.key) {
                    System.out.println("Valor " + key + " encontrado no nivel " + depth);
                    break;
                }
            }

        }
    }

}
