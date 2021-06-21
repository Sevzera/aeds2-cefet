import classes.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        Scanner input = new Scanner(System.in);

        int v = 0;
        Item refItem;

        System.out.println("Procedimento de insercao iniciado.\nDigite inteiros para inserir.\nDigite 0 para encerrar.");
        do {
            v = input.nextInt();
            tree.insert(new Item(v));
        } while (v != 0);

        System.out.println("Procedimento de busca iniciado.\nDigite um inteiro para buscar.\nDigite 0 para encerrar.");
        do {
            v = input.nextInt();
            refItem = tree.search(new Item(v));
            if (refItem == null)
                System.out.println("Item de valor " + v + " nao encontrado");
            else
                System.out.println("Item de valor " + refItem.key + " encontrado");
        } while (v != 0);

        input.close();
    }
}
