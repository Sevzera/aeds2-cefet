package classes;

public class DepthFirstSearcher {
    public static final byte white = 0;
    public static byte gray = 1;
    public static byte black = 2;
    private int timeOfVisitation[], timeOfExhaustion[], parent[];
    private Graph graph;
    private boolean cycleFound;

    public DepthFirstSearcher(Graph graph) {
        this.graph = graph;
        int n = this.graph.nVertices();
        this.cycleFound = false;
        timeOfVisitation = new int[n];
        timeOfExhaustion = new int[n];
        parent = new int[n];
    }

    private int DFSVisitation(int u, int currentTime, int label[]) {
        label[u] = gray; 
        this.timeOfVisitation[u] = ++currentTime; 
        if (!this.graph.isAdjacencyMatrixEmpty(u)) { 
            Graph.Edge a = this.graph.firstEdge(u); 
            while (a != null) { 
                int v = a.v2(); 
                if (label[v] == white) { 
                    this.parent[v] = u; 
                    currentTime = this.DFSVisitation(v, currentTime, label); 
                } else if (label[v] == gray && timeOfVisitation[v] < timeOfVisitation[u] && this.cycleFound == false) { 
                                                                                         
                    this.cycleFound = true; 
                    System.out.println("CICLO ENCONTRADO"); 
                }
                a = this.graph.nextEdge(u); 
            }
        }
        label[u] = black; 
        this.timeOfExhaustion[u] = ++currentTime; 
        return currentTime;
    }

    public void depthFirstSearch() {
        int currentTime = 0;
        int label[] = new int[this.graph.nVertices()];
        for (int u = 0; u < graph.nVertices(); u++) { 
            label[u] = white;
            this.parent[u] = -1;
        }
        
        for (int u = 0; u < graph.nVertices(); u++) 
            if (label[u] == white) 
                currentTime = this.DFSVisitation(u, currentTime, label); 
        if(this.cycleFound == false){ 
            System.out.println("CICLO NAO ENCONTRADO");
            this.cycleFound = false; 
        }
    }

    public int timeOfVisitation(int v) {
        return this.timeOfVisitation[v];
    }

    public int timeOfExhaustion(int v) {
        return this.timeOfExhaustion[v];
    }

    public int parent(int v) {
        return this.parent[v];
    }
}