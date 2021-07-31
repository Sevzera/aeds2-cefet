import classes.*;

public class Main{
    public static void main(String[] args) {

        // RETIRAR COMENTARIOS DO TESTE A SER FEITO

        // g QUADRADO
        Graph g = new Graph(4);
        g.addEdge(0, 1, 1);
        g.addEdge(1, 2, 1);
        g.addEdge(2, 3, 1);
        g.addEdge(3, 0, 1);

        // // EXEMPLO 1
        // Graph g = new Graph(8);
        // g.insereAresta(0, 1, 1);
        // g.insereAresta(1, 0, 1);
        // g.insereAresta(0, 3, 1);
        // g.insereAresta(3, 0, 1);
        // g.insereAresta(0, 4, 1);
        // g.insereAresta(4, 0, 1);
        // g.insereAresta(2, 1, 1);
        // g.insereAresta(1, 2, 1);
        // g.insereAresta(2, 3, 1);
        // g.insereAresta(3, 2, 1);
        // g.insereAresta(2, 6, 1);
        // g.insereAresta(6, 2, 1);
        // g.insereAresta(3, 7, 1);
        // g.insereAresta(7, 3, 1);
        // g.insereAresta(1, 5, 1);
        // g.insereAresta(5, 1, 1);
        // g.insereAresta(4, 5, 1);
        // g.insereAresta(5, 4, 1);
        // g.insereAresta(7, 6, 1);
        // g.insereAresta(6, 7, 1);
        // g.insereAresta(4, 7, 1);
        // g.insereAresta(7, 4, 1);
        // g.insereAresta(5, 6, 1);
        // g.insereAresta(6, 5, 1);

        // // EXEMPLO 2
        // Graph g = new Graph(10);
        // g.insereAresta(9, 6, 1);
        // g.insereAresta(0, 2, 1);
        // g.insereAresta(0, 1, 1);
        // g.insereAresta(0, 5, 1);
        // g.insereAresta(0, 3, 1);
        // g.insereAresta(5, 4, 1);
        // g.insereAresta(5, 6, 1);
        // g.insereAresta(1, 2, 1);
        // g.insereAresta(2, 4, 1);
        // g.insereAresta(2, 3, 1);
        // g.insereAresta(4, 6, 1);
        // g.insereAresta(6, 7, 1);
        // g.insereAresta(6, 8, 1);
        // g.insereAresta(7, 8, 1);

        g.printAdjacencyMatrix();
        depthFirstSearcher s = new depthFirstSearcher(g);
        s.depthFirstSearch();

    }

}