import classes.*;

public class Main {
    public static void main(String[] args) {

        // GRAFO APRESENTADO NA AULA
        Graph g = new Graph(6);
        g.addEdge(0, 1, 6);
        g.addEdge(1, 0, 6);
        g.addEdge(0, 2, 1);
        g.addEdge(2, 0, 1);
        g.addEdge(0, 3, 5);
        g.addEdge(3, 0, 5);
        g.addEdge(2, 1, 2);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 3, 2);
        g.addEdge(3, 2, 2);
        g.addEdge(1, 4, 5);
        g.addEdge(4, 1, 5);
        g.addEdge(3, 5, 4);
        g.addEdge(5, 3, 4);
        g.addEdge(2, 4, 6);
        g.addEdge(4, 2, 6);
        g.addEdge(2, 5, 4);
        g.addEdge(5, 2, 4);
        g.addEdge(4, 5, 3);
        g.addEdge(5, 4, 3);

        // // EXEMPLO 1
        // Graph g = new Graph(9);
        // g.addEdge(0, 1, 5);
        // g.addEdge(1, 0, 5);
        // g.addEdge(0, 3, 10);
        // g.addEdge(3, 0, 10);
        // g.addEdge(0, 4, 5);
        // g.addEdge(4, 0, 5);
        // g.addEdge(0, 6, 10);
        // g.addEdge(6, 0, 10);
        // g.addEdge(0, 7, 10);
        // g.addEdge(7, 0, 10);
        // g.addEdge(1, 5, 5);
        // g.addEdge(5, 1, 5);
        // g.addEdge(1, 7, 5);
        // g.addEdge(7, 1, 5);
        // g.addEdge(1, 8, 10);
        // g.addEdge(8, 1, 10);
        // g.addEdge(2, 3, 5);
        // g.addEdge(3, 2, 5);
        // g.addEdge(2, 4, 10);
        // g.addEdge(4, 2, 10);
        // g.addEdge(2, 6, 5);
        // g.addEdge(6, 2, 5);
        // g.addEdge(3, 4, 5);
        // g.addEdge(4, 3, 5);
        // g.addEdge(3, 6, 10);
        // g.addEdge(6, 3, 10);
        // g.addEdge(4, 8, 10);
        // g.addEdge(8, 4, 10);
        // g.addEdge(5, 6, 15);
        // g.addEdge(6, 5, 15);
        // g.addEdge(7, 8, 20);
        // g.addEdge(8, 7, 20);

        // // EXEMPLO 2
        // Graph g = new Graph(8);
        // g.addEdge(0, 1, 8);
        // g.addEdge(1, 0, 8);
        // g.addEdge(0, 2, 2);
        // g.addEdge(2, 0, 2);
        // g.addEdge(0, 6, 9);
        // g.addEdge(6, 0, 9);
        // g.addEdge(2, 1, 3);
        // g.addEdge(1, 2, 3);
        // g.addEdge(2, 3, 9);
        // g.addEdge(3, 2, 9);
        // g.addEdge(2, 6, 6);
        // g.addEdge(6, 2, 6);
        // g.addEdge(3, 1, 2);
        // g.addEdge(1, 3, 2);
        // g.addEdge(3, 4, 6);
        // g.addEdge(4, 3, 6);
        // g.addEdge(3, 6, 2);
        // g.addEdge(6, 3, 2);
        // g.addEdge(4, 1, 7);
        // g.addEdge(1, 4, 7);
        // g.addEdge(4, 6, 4);
        // g.addEdge(6, 4, 4);
        // g.addEdge(5, 1, 5);
        // g.addEdge(1, 5, 5);
        // g.addEdge(5, 4, 5);
        // g.addEdge(4, 5, 5);
        // g.addEdge(5, 6, 6);
        // g.addEdge(6, 5, 6);
        // g.addEdge(7, 1, 6);
        // g.addEdge(1, 7, 6);
        // g.addEdge(7, 5, 4);
        // g.addEdge(5, 7, 4);
        // g.addEdge(7, 6, 3);
        // g.addEdge(6, 7, 3);

        System.out.println("MATRIZ DE ADJACENCIA");
        g.printAdjacencyMatrix();
        System.out.println("-----------------------------------");

        MinimumSpanningTree arvore = new MinimumSpanningTree(g);
        try {
            arvore.obterAgm(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
