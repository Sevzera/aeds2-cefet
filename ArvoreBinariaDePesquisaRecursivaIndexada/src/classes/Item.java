package classes;
public class Item {
    public int key;
    public int nodeDepth;

    public Item(int key) {
        this.key = key;
    }

    public String toString(){
        return "" + key;
    }
}