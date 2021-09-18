package classes;

public class Dijkstra {
    private int parent[];
    private double weight[];
    private int timeOfVisitation[];
    private int currentTime;
    private Graph graph;

    public Dijkstra(Graph graph) {
        this.graph = graph;
    }

    public void generateTree(int root) throws Exception {
        int n = this.graph.nVertices();
        this.weight = new double[n];
        this.currentTime = 1;
        this.timeOfVisitation = new int[n];
        int vs[] = new int[n + 1];
        this.parent = new int[n];
        for (int u = 0; u < n; u++) {
            this.parent[u] = -1;
            weight[u] = Double.MAX_VALUE;
            vs[u + 1] = u;
        }
        timeOfVisitation[root] = currentTime;
        weight[root] = 0;

        MinHeapSorter heap = new MinHeapSorter(weight, vs);
        heap.build();
        while (!heap.isEmpty()) {
            int u = heap.removeLesserKey();
            if (!this.graph.isAdjacencyMatrixEmpty(u)) {
                Graph.Edge adj = graph.firstEdge(u);
                while (adj != null) {
                    int v = adj.v2();
                    if (timeOfVisitation[v] == 0) {
                        currentTime++;
                        timeOfVisitation[v] = currentTime;
                    }
                    if (this.weight[v] > (this.weight[u] + adj.weight())) {
                        parent[v] = u;
                        heap.changeKeyValue(v, this.weight[u] + adj.weight());
                    }
                    adj = graph.nextEdge(u);
                }
            }
        }
    }

    public int parent(int u) {
        return this.parent[u];
    }

    public double weight(int u) {
        return this.weight[u];
    }

    public double timeOfVisitation(int u) {
        return this.timeOfVisitation[u];
    }

    public void printPath(int first, int last) {
        if (first == last) {
            System.out.print((first + 1));
        } else if (this.parent[last] == -1) {
            System.out.println("Nao existe caminho de " + (first + 1) + " ate " + (last + 1));
        } else {
            printPath(first, this.parent[last]);
            System.out.print(" -> " + (last + 1));
        }
    }

    public void printArrays() {
        System.out.println("\nparent");
        for (int i = 0; i < this.graph.nVertices(); i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < this.parent.length; i++) {
            System.out.print((parent[i] + 1) + " ");
        }
        System.out.println("\nCUSTO");
        for (int i = 0; i < this.graph.nVertices(); i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < this.weight.length; i++) {
            System.out.print((int) weight[i] + " ");
        }
        System.out.println("\nTEMPO");
        for (int i = 0; i < this.graph.nVertices(); i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < this.timeOfVisitation.length; i++) {
            System.out.print((int) timeOfVisitation[i] + " ");
        }
    }

    public class MinHeapSorter {
        private double weight[];
        private int n, vertexIndex[], array[];

        public MinHeapSorter(double weight[], int v[]) {
            this.weight = weight;
            this.array = v;
            this.n = this.array.length - 1;
            this.vertexIndex = new int[this.n];
            for (int u = 0; u < this.n; u++)
                this.vertexIndex[u] = u + 1;
        }

        public void heapify(int left, int right) {
            int j = left * 2;
            int x = this.array[left];
            while (j <= right) {
                if ((j < right) && (this.weight[array[j]] > this.weight[array[j + 1]]))
                    j++;
                if (this.weight[x] <= this.weight[array[j]])
                    break;
                this.array[left] = this.array[j];
                this.vertexIndex[array[j]] = left;
                left = j;
                j = left * 2;
            }
            this.array[left] = x;
            this.vertexIndex[x] = left;
        }

        public void build() {
            int esq = n / 2 + 1;
            while (esq > 1) {
                esq--;
                this.heapify(esq, this.n);
            }
        }

        public int removeLesserKey() throws Exception {
            int lesserKey;
            if (this.n < 1)
                throw new Exception("Erro : heap vazio");
            else {
                lesserKey = this.array[1];
                this.array[1] = this.array[this.n];
                this.vertexIndex[array[this.n--]] = 1;
                this.heapify(1, this.n);
            }
            return lesserKey;
        }

        public void changeKeyValue(int i, double newValue) throws Exception {
            i = this.vertexIndex[i];
            int x = array[i];
            if (newValue < 0)
                throw new Exception("Erro : chave nova com valor incorreto");
            this.weight[x] = newValue;
            while ((i > 1) && (this.weight[x] <= this.weight[array[i / 2]])) {
                this.array[i] = this.array[i / 2];
                this.vertexIndex[array[i / 2]] = i;
                i /= 2;
            }
            this.array[i] = x;
            this.vertexIndex[x] = i;
        }

        boolean isEmpty() {
            return this.n == 0;
        }
    }
}
