package classes;

public class Heap {

    public Item[] array;
    public int n;

    public Heap(Item[] v) {
        this.array = v;
        this.n = v.length - 1;
        this.build();
    }

    public void heapsort() {
        int right = n;
        while (right > 1) {
            Item aux = this.array[1];
            this.array[1] = this.array[right];
            this.array[right] = aux;
            right--;
            this.heapify(1, right);
        }
    }

    private void build() {
        int left = n / 2 + 1;
        while (left > 1) {
            left--;
            this.heapify(left, this.n);
        }
    }

    private void heapify(int left, int right) {
        int j = left * 2;
        Item aux = this.array[left];
        while (j <= right) {
            if ((j < right) && (this.array[j].key < this.array[j + 1].key)) {
                Globals.heapCounter++;
                j++;
            }
            if (aux.key >= this.array[j].key) {
                Globals.heapCounter++;
                break;
            }
            this.array[left] = this.array[j];
            left = j;
            j = left * 2;
        }
        this.array[left] = aux;
    }

}
