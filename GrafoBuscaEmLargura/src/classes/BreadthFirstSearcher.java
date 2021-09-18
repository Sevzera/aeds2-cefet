package classes;

public class BreadthFirstSearcher {
    public static final byte white = 0;
    public static byte gray = 1;
    public static byte black = 2;
    private int weight[], parent[], timeOfVisitation[];
    int currentTime;
    private Graph graph;

    public BreadthFirstSearcher(Graph graph) {
        this.graph = graph;
        int n = this.graph.nVertices();
        this.weight = new int[n];
        this.parent = new int[n];
        this.timeOfVisitation = new int[n];
        currentTime = 1;
    }

    private void BFSVisitation(int u, int color[]) throws Exception {
        color[u] = gray;
        this.weight[u] = 0;
        FIFO fifo = new FIFO();
        fifo.addItem(u);
        while (!fifo.isEmpty()) {
            Integer aux = (Integer) fifo.removeItem();
            u = aux.intValue();
            if (!this.graph.isAdjacencyMatrixEmpty(u)) {
                Graph.Edge a = this.graph.firstEdge(u);
                while (a != null) {
                    int v = a.v2();
                    if (color[v] == white) {
                        currentTime++;
                        timeOfVisitation[v] = currentTime;
                        color[v] = gray;
                        this.weight[v] = this.weight[u] + 1;
                        this.parent[v] = u;
                        fifo.addItem(v);
                    }
                    a = this.graph.nextEdge(u);
                }
            }
            color[u] = black;
        }
    }

    public void breadthFirstSearch() throws Exception {
        int color[] = new int[this.graph.nVertices()];
        for (int u = 0; u < graph.nVertices(); u++) {
            color[u] = white;
            this.weight[u] = Integer.MAX_VALUE;
            this.parent[u] = -1;
            this.timeOfVisitation[u] = -1;
        }
        timeOfVisitation[0] = currentTime;
        for (int u = 0; u < graph.nVertices(); u++)
            if (color[u] == white)
                this.BFSVisitation(u, color);
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
        System.out.println("\nNIVEIS ABAIXO DA RAIZ");
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

    public void printPath(int first, int last) {
        if  (first == last) {
            System.out.print(first + 1);
        } else if (this.parent[last] == -1) {
            System.out.println("Nao existe caminho de " +  (first + 1) + " ate " + (last + 1));
        } else {
            printPath (first, this.parent[last]);
            System.out.print(" -> " + (last + 1));
        }
    }

    public int weight(int v) {
        return this.weight[v];
    }

    public int parent(int v) {
        return this.parent[v];
    }

    public class FIFO {
        private static class Item {
            Object item;
            Item next;
        }

        private Item front;
        private Item back;

        // Operações
        public FIFO() { // Cria uma Fila vazia
            this.front = new Item();
            this.back = this.front;
            this.front.next = null;
        }

        public void addItem(Object x) {
            this.back.next = new Item();
            this.back = this.back.next;
            this.back.item = x;
            this.back.next = null;
        }

        public Object removeItem() throws Exception {
            Object item = null;
            if (this.isEmpty())
                throw new Exception("Erro : A fila esta vazia ");
            this.front = this.front.next;
            item = this.front.item;
            return item;
        }

        public boolean isEmpty() {
            return (this.front == this.back);
        }
    }
}