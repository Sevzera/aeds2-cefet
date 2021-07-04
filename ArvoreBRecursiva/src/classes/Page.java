package classes;

public class Page {
    
    int n;
    Item items[];
    Page p[];

    public Page(int mm) {
        this.n = 0;
        this.items = new Item[mm];
        this.p = new Page[mm + 1];
    }

}
