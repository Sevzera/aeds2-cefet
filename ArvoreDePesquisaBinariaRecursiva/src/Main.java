import classes.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        Scanner input = new Scanner(System.in);

        // int v = 0;
        // Item refItem = new Item(0);
        // Item condItem = new Item(0);

        // System.out.println(
        //         "Procedimento de insercao iniciado.\nDigite inteiros positivos para inserir.\nDigite 0 para encerrar.");
        // do {
        //     v = input.nextInt();
        //     refItem.key = v;
        //     tree.insert(refItem);
        //     System.out.println("Item de valor " + refItem.key + " adicionado");
        // } while (v > 0);

        // System.out.println(
        //         "Procedimento de busca iniciado.\nDigite um inteiro positivo para buscar.\nDigite 0 para encerrar.");
        // do {
        //     v = input.nextInt();
        //     refItem.key = v;
        //     condItem = tree.search(refItem);
        //     if (condItem == refItem) {
        //         System.out.println("Item de valor " + condItem.toString() + " encontrado.");
        //     } else {
        //         System.out.println("Item nao encontrado.");
        //     }
        // } while (v > 0);

        input.close();
    }
}
