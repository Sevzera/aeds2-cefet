package classes;

public class BinaryTree {

    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(Item externalItem) {
        this.root = this.insert(externalItem, this.root);
    }

    public Item search(Item externalItem) {
        return this.search(externalItem, this.root);
    }

    private Node insert(Item externalItem, Node n) {
        if (n == null) {
            n = new Node();
            n.item = externalItem;
        } else if (externalItem.key < n.item.key)
            n.left = insert(externalItem, n.left);
        else if (externalItem.key > n.item.key)
            n.right = insert(externalItem, n.right);
        else
            System.out.println("Erro: Registro ja existente");
        return n;
    }

    private Item search(Item externalItem, Node n) {
        if (n == null)
            return null;
        else if (externalItem.key < n.item.key)
            return search(externalItem, n.left);
        else if (externalItem.key > n.item.key)
            return search(externalItem, n.right);
        else
            return n.item;
    }

}