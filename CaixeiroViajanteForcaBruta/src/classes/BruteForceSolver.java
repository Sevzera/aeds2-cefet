package classes;

import java.util.ArrayList;

public class BruteForceSolver {
    
    TSP problem;
    boolean hasCycle;
    int minimumCostValue;
    ArrayList<Integer> minimumCostPath;
    int nOfPaths;

    public BruteForceSolver(TSP problem) {
        this.problem = problem;
        this.minimumCostValue = -1;
        this.minimumCostPath = new ArrayList<>();
        this.nOfPaths = 0;
    }

    public void solve() {

        hasCycle = false;

        // Caminho encontrado atual
        ArrayList<Integer> currentPath = new ArrayList<>();
        currentPath.add(0);

        // Armazena os vertices que foram visitados
        boolean[] visited = new boolean[this.problem.adjacencyMatrix.length];

        for (int i = 0; i < visited.length; i++)
            visited[i] = false;

        visited[0] = true;

        // Procura todos os ciclos hamiltonianos na matriz
        findCycle(this.problem.adjacencyMatrix, 1, currentPath, visited);

        if (!hasCycle) {
            System.out.println("Nao e possivel visitar todas as cidades sem repeti-las");
            return;
        }

        System.out.println(this.nOfPaths + " CAMINHOS ENCONTRADOS");
        System.out.println("CAMINHO DE CUSTO MINIMO:");
        for (int i = 0; i < minimumCostPath.size(); i++) {
            System.out.print(minimumCostPath.get(i));
            if(i != minimumCostPath.size() - 1)
                System.out.print(" -> ");
        }
        System.out.println(", CUSTO: " + minimumCostValue);


    }

    // Encontra todos os caminhos possiveis
    void findCycle(int adjacencyMatrix[][], int currentCity, ArrayList<Integer> currentPath, boolean[] visited) {
        // Se todas as cidades foram visitadas
        if (currentCity == adjacencyMatrix.length) {
            // Se existe estrada entre a ultima e a primeira cidade
            if (adjacencyMatrix[currentPath.get(currentPath.size() - 1)][currentPath.get(0)] != 0) {

                this.nOfPaths++;

                // Variavel de controle que armazena o custo do caminho atual
                int currentPathCost = 0;

                // Adiciona o vertice inicial no fim do caminho para considerar o custo de retorno
                currentPath.add(0);

                // Busca os valores o custo de cada estrada percorrida na matriz e soma ao custo atual
                for (int i = 0; i < currentPath.size(); i++) {
                    if (i > 0)
                        currentPathCost += adjacencyMatrix[currentPath.get(i)][currentPath.get(i - 1)];
                    // System.out.print(currentPath.get(i) + " ");
                }
                // System.out.println("-> CUSTO: " + currentPathCost);

                // Atualiza o custo minimo e o caminho percorrido
                if (this.minimumCostValue == -1) {
                    this.minimumCostValue = currentPathCost;
                    this.minimumCostPath = new ArrayList<>(currentPath);
                } else if (currentPathCost <= this.minimumCostValue) {
                    this.minimumCostValue = currentPathCost;
                    this.minimumCostPath = new ArrayList<>(currentPath);
                }

                // Remove o vertice final do caminho
                currentPath.remove(currentPath.size() - 1);

                // Define o problema como resolvivel
                hasCycle = true;
            }
            return;
        }

        // Testa cidades diferentes como as proximas a serem visitadas
        for (int v = 0; v < adjacencyMatrix.length; v++) {
            // Confere se existe caminho entre a cidade atual e as outras
            if (isAdjacentToAndUnvisited(v, adjacencyMatrix, currentPath, currentCity) && !visited[v]) {

                currentPath.add(v);
                visited[v] = true;

                // Testa a proxima cidade
                findCycle(adjacencyMatrix, currentCity + 1, currentPath, visited);

                // Reseta a cidade da iteracao atual
                visited[v] = false;
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }

    // Confere se existe caminho entre duas cidades
    boolean isAdjacentToAndUnvisited(int nextCity, int adjacencyMatrix[][], ArrayList<Integer> currentPath, int currentCity) {
        // Se nao existir estrada entre as cidades analisadas
        if (adjacencyMatrix[currentPath.get(currentCity - 1)][nextCity] == 0)
            return false;

        // Se a cidade ja estiver no caminho
        for (int i = 0; i < currentCity; i++)
            if (currentPath.get(i) == nextCity)
                return false;

        return true;
    }

}