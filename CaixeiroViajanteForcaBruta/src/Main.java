import classes.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        System.out.println("Digite o nome do arquivo texto");
        String filePath = "classes/files/tests/" + input.nextLine();
        if(!(filePath.contains(".txt")))
            filePath = filePath.concat(".txt");

        TSP problem = null;

        try {
            problem = new TSP(filePath);
        } catch (Exception e) {
            System.out.println("Arquivo de texto invalido");
            e.printStackTrace();
            return;
        }

        // System.out.println();
        // System.out.println("MATRIZ OBTIDA: ");
        // System.out.println("N: " + problem.nOfCities);
        // problem.printAdjacencyMatrix();
        // System.out.println();


        System.out.println("Escolha o metodo de solucao:\n1 - Forca Bruta\n2 - Metodo Heuristico");
        int metodo = input.nextInt();

        while(metodo != 1 && metodo != 2){
            System.out.println("Valor invalido, digite novamente");
            metodo = input.nextInt();
        }

        if(metodo == 1){
            BruteForceSolver brute = new BruteForceSolver(problem);
            long begin = System.nanoTime();
            brute.solve();
            long end = System.nanoTime();
            long execTime = end - begin;
            System.out.println("Tempo percorrido: " + execTime/10000 + " * 10^4 ns");
        } else if (metodo == 2){
            HeuristicSolver heuristic = new HeuristicSolver(problem);
            long begin = System.nanoTime();
            heuristic.solve();
            long end = System.nanoTime();
            long execTime = end - begin;
            System.out.println("Tempo percorrido: " + execTime/10000 + " * 10^4 ns");
        }

        input.close();
    }
}
