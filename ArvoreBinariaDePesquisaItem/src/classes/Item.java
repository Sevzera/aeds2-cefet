package classes;
public class Item {
    public int key;

    public Item(int key) {
        this.key = key;
    }

    public int compare(Item extItem) {
        if (this.key < extItem.key)
            return -1;
        else if (this.key > extItem.key)
            return 1;
        return 0;
    }
}