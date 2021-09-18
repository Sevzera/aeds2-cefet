import java.util.Scanner;

import classes.*;

public class Main {
    public static void main(String[] args) {

        // RETIRAR COMENTARIOS DO TESTE A SER FEITO

        // // EXEMPLO 1.1
        // Graph g = new Graph(5);
        // g.addEdge(0, 1, 8);
        // g.addEdge(0, 2, 4);
        // g.addEdge(0, 3, 5);
        // g.addEdge(1, 4, 9);
        // g.addEdge(2, 3, 1);
        // g.addEdge(2, 4, 5);
        // g.addEdge(3, 2, 5);
        // g.addEdge(3, 4, 2);
        // g.addEdge(3, 1, 3);

        // // EXEMPLO 1.2
        // Graph g = new Graph(5);
        // g.addEdge(0, 1, 3);
        // g.addEdge(0, 2, 10);
        // g.addEdge(0, 3, 2);
        // g.addEdge(1, 4, 5);
        // g.addEdge(2, 3, 4);
        // g.addEdge(2, 4, 2);
        // g.addEdge(3, 2, 7);
        // g.addEdge(3, 4, 7);
        // g.addEdge(3, 1, 8);

        // // EXEMPLO 2.1
        // Graph g = new Graph(5);
        // g.addEdge(0, 1, 3);
        // g.addEdge(0, 3, 5);
        // g.addEdge(1, 2, 2);
        // g.addEdge(1, 3, 2);
        // g.addEdge(2, 4, 2);
        // g.addEdge(3, 1, 3);
        // g.addEdge(3, 2, 5);
        // g.addEdge(3, 4, 9);
        // g.addEdge(4, 0, 6);
        // g.addEdge(4, 2, 4);

        // // EXEMPLO 2.2
        // Graph g = new Graph(5);
        // g.addEdge(0, 1, 3);
        // g.addEdge(0, 3, 5);
        // g.addEdge(1, 2, 6);
        // g.addEdge(1, 3, 2);
        // g.addEdge(2, 4, 2);
        // g.addEdge(3, 1, 1);
        // g.addEdge(3, 2, 4);
        // g.addEdge(3, 4, 6);
        // g.addEdge(4, 0, 3);
        // g.addEdge(4, 2, 7);

         // GRAFO DA PROVA
        Graph g = new Graph(8);
        g.addEdge(0, 1, 3);
        g.addEdge(0, 2, 2);
        g.addEdge(1, 6, 4);
        g.addEdge(2, 3, 3);
        g.addEdge(2, 7, 5);
        g.addEdge(3, 4, 5);
        g.addEdge(3, 7, 1);
        g.addEdge(4, 5, 4);
        g.addEdge(4, 6, 1);
        g.addEdge(5, 6, 3);
        g.addEdge(7, 6, 2);

        System.out.println("MATRIZ DE ADJACENCIA");
        g.printAdjacencyMatrix();
        System.out.println();

        Scanner input = new Scanner(System.in);
        int first, last;
        do{
        System.out.println("Digite o indice da origem da busca (MAX: " + g.nVertices() + ")");
        first = input.nextInt();
        } while (first > g.nVertices() || first < 1);
        do{
        System.out.println("Digite o indice do destino da busca (MAX: " + g.nVertices() + ")");
        last = input.nextInt();
        } while (last > g.nVertices() || last < 1);
        System.out.println();

        Dijkstra dijkstra = new Dijkstra(g);
        try {
            dijkstra.generateTree((first - 1));
            System.out.println("Melhor caminho");
            dijkstra.printPath((first - 1), (last - 1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nPeso do caminho: " + dijkstra.weight(last - 1));

        dijkstra.printArrays();
        input.close();
    }

}
