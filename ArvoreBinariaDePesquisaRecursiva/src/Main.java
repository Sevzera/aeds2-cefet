import classes.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        Scanner input = new Scanner(System.in);

        int v;
        Item refItem;

        System.out.println("Procedimento de insercao iniciado.\nDigite inteiros para inserir.\nDigite 0 para encerrar.");
        v = input.nextInt();
        
        do {
            tree.insert(new Item(v));
            v = input.nextInt();
        } while (v != 0);

        System.out.println("Procedimento de busca iniciado.\nDigite um inteiro para buscar.\nDigite 0 para encerrar.");
        v = input.nextInt();
        
        do {
            refItem = tree.search(new Item(v));
            if (refItem == null) {
                System.out.println("Item de valor " + v + " nao encontrado apos " + Globals.currentSearchDepth + " comparacoes");
            } else if (v != 0) {
                System.out.println("Item de valor " + refItem.key + " encontrado no nivel " + Globals.currentSearchDepth);
            }
            Globals.currentSearchDepth = 0;
            v = input.nextInt();
        } while (v != 0);

        input.close();
    }
}
