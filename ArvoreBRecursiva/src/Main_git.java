// import classes.*;
// import java.util.Scanner;

// public class Main_git {
//     public static void main(String[] args) {

//         Scanner input = new Scanner(System.in);

//         int v;
//         Item refItem;

//         System.out.println("Digite um inteiro para definir a ordem da arvore.");
//         v = input.nextInt();
//         BTree tree = new BTree(v);
        
//         System.out.println("Procedimento de insercao iniciado.\nDigite inteiros para inserir.\nDigite 0 para encerrar.");
//         do {
//             v = input.nextInt();
//             tree.insert(new Item(v));
//         } while (v != 0);

//         System.out.println("Procedimento de busca iniciado.\nDigite um inteiro para buscar.\nDigite 0 para encerrar.");
//         do {
//             v = input.nextInt();
//             refItem = tree.search(new Item(v));
//             if (refItem == null) {
//                 System.out.println("Item de valor " + v + " nao encontrado apos " + Globals.currentSearchDepth + " comparacoes");
//             } else if (v != 0) {
//                 System.out.println("Item de valor " + refItem.key + " encontrado no nivel " + Globals.currentSearchDepth);
//             }
//             Globals.currentSearchDepth = 0;
//         } while (v != 0);

//         input.close();
//     }
// }
