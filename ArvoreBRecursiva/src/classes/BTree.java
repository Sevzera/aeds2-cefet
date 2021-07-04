package classes;

public class BTree {
    private Page root;
    private int size, rootSize;

    public BTree(int m) {
        this.root = null;
        this.size = m;
        this.rootSize = 2 * m;
    }

    public void insert(Item externalItem) {
        Item returnedItem[] = new Item[1];
        boolean gotBigger[] = new boolean[1];
        Page returnedPage = this.insert(externalItem, this.root, returnedItem, gotBigger);
        if (gotBigger[0]) {
            Page auxPage = new Page(this.rootSize);
            auxPage.items[0] = returnedItem[0];
            auxPage.p[0] = this.root;
            auxPage.p[1] = returnedPage;
            this.root = auxPage;
            this.root.n++;
        } else
            this.root = returnedPage;
    }

    public Item search(Item externalItem) {
        return this.search(externalItem, this.root);
    }

    private Page insert(Item externalItem, Page p, Item[] returnedItem, boolean[] gotBigger) {
        Page returnedPage = null;
        if (p == null) {
            gotBigger[0] = true;
            returnedItem[0] = externalItem;
        } else {
            int i = 0;
            while ((i < p.n - 1) && (externalItem.key > p.items[i].key))
                i++;
            if (externalItem.key == p.items[i].key) {
                // System.out.println("Erro: Registro ja existente");
                ;
                gotBigger[0] = false;
            } else {
                if (externalItem.key > p.items[i].key)
                    i++;
                returnedPage = insert(externalItem, p.p[i], returnedItem, gotBigger);
                if (gotBigger[0])
                    if (p.n < this.rootSize) {
                        this.insertOnPage(p, returnedItem[0], returnedPage);
                        gotBigger[0] = false;
                        returnedPage = p;
                    } else {
                        Page auxPage = new Page(this.rootSize);
                        auxPage.p[0] = null;
                        if (i <= this.size) {
                            this.insertOnPage(auxPage, p.items[this.rootSize - 1], p.p[this.rootSize]);
                            p.n--;
                            this.insertOnPage(p, returnedItem[0], returnedPage);
                        } else
                            this.insertOnPage(auxPage, returnedItem[0], returnedPage);
                        for (int j = this.size + 1; j < this.rootSize; j++) {
                            this.insertOnPage(auxPage, p.items[j], p.p[j + 1]);
                            p.p[j + 1] = null;
                        }
                        p.n = this.size;
                        auxPage.p[0] = p.p[this.size + 1];
                        returnedItem[0] = p.items[this.size];
                        returnedPage = auxPage;
                    }
            }
        }
        return (gotBigger[0] ? returnedPage : p);
    }

    private void insertOnPage(Page p, Item externalItem, Page pRight) {
        int i = p.n - 1;
        while ((i >= 0) && (externalItem.key < p.items[i].key)) {
            p.items[i + 1] = p.items[i];
            p.p[i + 2] = p.p[i + 1];
            i--;
        }
        p.items[i + 1] = externalItem;
        p.p[i + 2] = pRight;
        p.n++;
    }

    private Item search(Item externalItem, Page p) {
        if (p == null) {
            return null;
        } else {
            int i = 0;
            while ((i < p.n - 1) && (externalItem.key > p.items[i].key)) {
                i++;
            }
            if (externalItem.key > p.items[i].key) {
                Globals.currentSearchDepth++;
                return search(externalItem, p.p[i + 1]);
            } else if (externalItem.key < p.items[i].key) {
                Globals.currentSearchDepth++;
                return search(externalItem, p.p[i]);
            } else {
                return p.items[i];
            }
        }
    }
}
