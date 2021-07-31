package classes;

public class Graph {
    public static class Edge {
        private int v1, v2, weight;

        public Edge(int v1, int v2, int peso) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = peso;
        }

        public int peso() {
            return this.weight;
        }

        public int v1() {
            return this.v1;
        }

        public int v2() {
            return this.v2;
        }
    }

    private int adjacencyMatrix[][];
    private int nVertices;
    private int adjacencyIndex[];

    public Graph(int nVertices) {
        this.adjacencyMatrix = new int[nVertices][nVertices];
        this.adjacencyIndex = new int[nVertices];
        this.nVertices = nVertices;
        for (int i = 0; i < this.nVertices; i++) {
            for (int j = 0; j < this.nVertices; j++)
                this.adjacencyMatrix[i][j] = 0;
            this.adjacencyIndex[i] = -1;
        }
    }

    public void addEdge(int v1, int v2, int peso) {
        this.adjacencyMatrix[v1][v2] = peso;
    }

    public boolean areAdjacent(int v1, int v2) {
        return (this.adjacencyMatrix[v1][v2] > 0);
    }

    public boolean isAdjacencyMatrixEmpty(int v) {
        for (int i = 0; i < this.nVertices; i++)
            if (this.adjacencyMatrix[v][i] > 0)
                return false;
        return true;
    }

    public Edge firstEdge(int v) {
        this.adjacencyIndex[v] = -1;
        return this.nextEdge(v);
    }

    public Edge nextEdge(int v) {
        this.adjacencyIndex[v]++;
        while ((this.adjacencyIndex[v] < this.nVertices) && (this.adjacencyMatrix[v][this.adjacencyIndex[v]] == 0))
            this.adjacencyIndex[v]++;
        if (this.adjacencyIndex[v] == this.nVertices)
            return null;
        else
            return new Edge(v, this.adjacencyIndex[v], this.adjacencyMatrix[v][this.adjacencyIndex[v]]);
    }

    public Edge removeEdge(int v1, int v2) {
        if (this.adjacencyMatrix[v1][v2] == 0)
            return null;
        else {
            Edge edge = new Edge(v1, v2, this.adjacencyMatrix[v1][v2]);
            this.adjacencyMatrix[v1][v2] = 0;
            return edge;
        }
    }

    public void printAdjacencyMatrix() {
        System.out.print("  ");
        for (int i = 0; i < this.nVertices; i++)
            System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i < this.nVertices; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < this.nVertices; j++)
                System.out.print(this.adjacencyMatrix[i][j] + " ");
            System.out.println();
        }
    }

    public int nVertices() {
        return this.nVertices;
    }
}