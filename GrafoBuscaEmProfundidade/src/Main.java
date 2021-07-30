import classes.*;

public class Main{
    public static void main(String[] args) {

        // // EXEMPLO 1
        // XGrafo grafo = new XGrafo(8);
        // grafo.insereAresta(0, 1, 1);
        // grafo.insereAresta(1, 0, 1);
        // grafo.insereAresta(0, 3, 1);
        // grafo.insereAresta(3, 0, 1);
        // grafo.insereAresta(0, 4, 1);
        // grafo.insereAresta(4, 0, 1);
        // grafo.insereAresta(2, 1, 1);
        // grafo.insereAresta(1, 2, 1);
        // grafo.insereAresta(2, 3, 1);
        // grafo.insereAresta(3, 2, 1);
        // grafo.insereAresta(2, 6, 1);
        // grafo.insereAresta(6, 2, 1);
        // grafo.insereAresta(3, 7, 1);
        // grafo.insereAresta(7, 3, 1);
        // grafo.insereAresta(1, 5, 1);
        // grafo.insereAresta(5, 1, 1);
        // grafo.insereAresta(4, 5, 1);
        // grafo.insereAresta(5, 4, 1);
        // grafo.insereAresta(7, 6, 1);
        // grafo.insereAresta(6, 7, 1);
        // grafo.insereAresta(4, 7, 1);
        // grafo.insereAresta(7, 4, 1);
        // grafo.insereAresta(5, 6, 1);
        // grafo.insereAresta(6, 5, 1);

        // // EXEMPLO 2
        // XGrafo grafo = new XGrafo(10);
        // grafo.insereAresta(9, 6, 1);
        // grafo.insereAresta(0, 2, 1);
        // grafo.insereAresta(0, 1, 1);
        // grafo.insereAresta(0, 5, 1);
        // grafo.insereAresta(0, 3, 1);
        // grafo.insereAresta(5, 4, 1);
        // grafo.insereAresta(5, 6, 1);
        // grafo.insereAresta(1, 2, 1);
        // grafo.insereAresta(2, 4, 1);
        // grafo.insereAresta(2, 3, 1);
        // grafo.insereAresta(4, 6, 1);
        // grafo.insereAresta(6, 7, 1);
        // grafo.insereAresta(6, 8, 1);
        // grafo.insereAresta(7, 8, 1);

        // GRAFO QUADRADO
        XGrafo grafo = new XGrafo(4);
        grafo.insereAresta(0, 1, 1);
        grafo.insereAresta(1, 2, 1);
        grafo.insereAresta(2, 3, 1);
        grafo.insereAresta(3, 0, 1);

        grafo.imprime();
        XCiclo ciclo = new XCiclo(grafo);
        ciclo.buscaEmProfundidade();

    }

}