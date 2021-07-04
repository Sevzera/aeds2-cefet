import classes.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random gen = new Random();

        int v;

        System.out.println("Digite um inteiro para definir a ordem da arvore.");
        v = input.nextInt();
        BTree tree = new BTree(v);
        
        // long begin = System.nanoTime();

        System.out.println("Procedimento de insercao iniciado");
        int insertValue = 0;
        for (int n = 0; n < 100000; n++) {
            tree.insert(new Item(insertValue));
            insertValue = insertValue + 10000; // ORDENADO
            // insertValue = gen.nextInt(1000000000); // ALEATORIO
        }

        long begin = System.nanoTime();

        System.out.println("Procedimento de busca iniciado");
        int searchValue = 1000000000;
        Item refItem = tree.search(new Item(searchValue));
        if (refItem == null) {
            System.out.println("Item de valor " + searchValue + " nao encontrado apos " + Globals.currentSearchDepth + " comparacoes");
        } else {
            System.out.println("Item de valor " + refItem.key + " encontrado apos " + Globals.currentSearchDepth + " comparacoes");
        }

        long end = System.nanoTime();
        long execTime = end - begin;
        System.out.println("Tempo percorrido: " + execTime/10000 + " * 10^4 ns");

        Globals.currentSearchDepth = 0;
        input.close();
    }
}
