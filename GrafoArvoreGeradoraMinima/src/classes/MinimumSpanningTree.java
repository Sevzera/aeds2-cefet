package classes;

public class MinimumSpanningTree {

    private int parent[];
    private double weights[];
    private Graph graph;
    public int MSTWeight;

    public MinimumSpanningTree(Graph graph) {
        this.graph = graph;
        this.MSTWeight = 0;
    }

    public void obterAgm(int root) throws Exception { // metodo para formar a arvore geradora minima
        int n = this.graph.nVertices();
        this.weights = new double[n]; // peso dos vértices
        int vs[] = new int[n + 1]; // vértices
        boolean heapItems[] = new boolean[n];
        this.parent = new int[n];
        for (int u = 0; u < n; u++) {
            this.parent[u] = -1;
            weights[u] = Double.MAX_VALUE; // ∞
            vs[u + 1] = u; // Heap indireto a ser construído
            heapItems[u] = true;
        }
        // condicoes iniciais sao definidas ate aqui 
        weights[root] = 0;
        MinHeapSorter heap = new MinHeapSorter(weights, vs);
        heap.build();
        while (!heap.isEmpty()) {
            int u = heap.removeLesserKey();
            heapItems[u] = false;
            if (!this.graph.isAdjacencyMatrixEmpty(u)) {
                Graph.Edge adj = graph.firstEdge(u);
                while (adj != null) {
                    int v = adj.v2();
                    if (heapItems[v] && (adj.peso() < this.peso(v))) {
                        parent[v] = u;
                        heap.changeKeyValue(v, adj.peso());
                    }
                    adj = graph.nextEdge(u);
                }
            }
        }
        System.out.println("AGM GERADA");
        System.out.println("ARESTAS:");
        for(int i = 1; i < this.graph.nVertices(); i++){
            System.out.println(this.parent[i] + " <-> " + i + " de peso " + (int) weights[i]);
            this.MSTWeight += weights[i];
        }
        System.out.println("PESO TOTAL DA ARVORE: " + this.MSTWeight);
    }

    public int parent(int u) {
        return this.parent[u];
    }

    public double peso(int u) {
        return this.weights[u];
    }

    public void imprime() {
        for (int u = 0; u < this.weights.length; u++)
            if (this.parent[u] != -1)
                System.out.println(" ( " + parent[u] + " ," + u + ") −− p: " + peso(u));
    }

    public class MinHeapSorter {
        private double weights[];
        private int n, vertexIndex[], array[];

        public MinHeapSorter(double weights[], int v[]) {
            this.weights = weights;
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
                if ((j < right) && (this.weights[array[j]] > this.weights[array[j + 1]]))
                    j++;
                if (this.weights[x] <= this.weights[array[j]])
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
            this.weights[x] = newValue;
            while ((i > 1) && (this.weights[x] <= this.weights[array[i / 2]])) {
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
