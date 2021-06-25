package classes;

public class SBBTree {

    Node root;
    private boolean propSBB;

    private static final byte Horizontal = 0;
    private static final byte Vertical = 1;

    public SBBTree() {
        this.root = null;
        this.propSBB = true;
    }

    public void insert(Item externalItem) {
        this.root = insert(externalItem, null, this.root, true);
    }

    public Item search(Item externalItem) {
        return this.search(externalItem, this.root);
    }

    private Node insert(Item externalItem, Node parent, Node child, boolean childLeft) {
        if (child == null) {
            child = new Node();
            child.item = externalItem;
            child.incL = Vertical;
            child.incR = Vertical;
            child.left = null;
            child.right = null;
            if (parent != null) {
                if (childLeft) {
                    parent.incL = Horizontal;
                } else {
                    parent.incR = Horizontal;
                }
            }
            this.propSBB = false;
            System.out.println("Item de valor " + child.item.key + " adicionado");
        } else if (externalItem.key < child.item.key) {
            child.left = insert(externalItem, child, child.left, true);
            if (!this.propSBB)
                if (child.incL == Horizontal) {
                    if (child.left.incL == Horizontal) {
                        child = this.leftLeft(child);
                        if (parent != null)
                            if (childLeft)
                                parent.incL = Horizontal;
                            else
                                parent.incR = Horizontal;
                    } else if (child.left.incR == Horizontal) {
                        child = this.leftRight(child);
                        if (parent != null)
                            if (childLeft)
                                parent.incL = Horizontal;
                            else
                                parent.incR = Horizontal;
                    }
                } else
                    this.propSBB = true;
        } else if (externalItem.key > child.item.key) {
            child.right = insert(externalItem, child, child.right, false);
            if (!this.propSBB)
                if (child.incR == Horizontal) {
                    if (child.right.incR == Horizontal) {
                        child = this.rightRight(child);
                        if (parent != null)
                            if (childLeft)
                                parent.incL = Horizontal;
                            else
                                parent.incR = Horizontal;
                    } else if (child.right.incL == Horizontal) {
                        child = this.rightLeft(child);
                        if (parent != null)
                            if (childLeft)
                                parent.incL = Horizontal;
                            else
                                parent.incR = Horizontal;
                    }
                } else
                    this.propSBB = true;
        } else {
            System.out.println("Erro: Registro ja existente");
            this.propSBB = true;
        }
        return child;
    }

    private Item search(Item item, Node n) {
        if (n == null) {
            Globals.currentSearchDepth++;
            return null;
        } else if (item.key < n.item.key) {
            Globals.currentSearchDepth++;
            return search(item, n.left);
        } else if (item.key > n.item.key) {
            Globals.currentSearchDepth++;
            return search(item, n.right);
        } else {
            return n.item;
        }
    }

    private Node leftLeft(Node ap) {
        Node ap1 = ap.left;
        ap.left = ap1.right;
        ap1.right = ap;
        ap1.incL = Vertical;
        ap.incL = Vertical;
        ap = ap1;
        return ap;
    }

    private Node leftRight(Node ap) {
        Node ap1 = ap.left;
        Node ap2 = ap1.right;
        ap1.incR = Vertical;
        ap.incL = Vertical;
        ap1.right = ap2.left;
        ap2.left = ap1;
        ap.left = ap2.right;
        ap2.right = ap;
        ap = ap2;
        return ap;
    }

    private Node rightRight(Node ap) {
        Node ap1 = ap.right;
        ap.right = ap1.left;
        ap1.left = ap;
        ap1.incR = Vertical;
        ap.incR = Vertical;
        ap = ap1;
        return ap;
    }

    private Node rightLeft(Node ap) {
        Node ap1 = ap.right;
        Node ap2 = ap1.left;
        ap1.incL = Vertical;
        ap.incR = Vertical;
        ap1.left = ap2.right;
        ap2.right = ap1;
        ap.right = ap2.left;
        ap2.left = ap;
        ap = ap2;
        return ap;
    }

}
