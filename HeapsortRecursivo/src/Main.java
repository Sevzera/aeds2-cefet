import classes.*;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Digite um inteiro para definir o tamanho do heap.");
        int size;
        size = input.nextInt();
        Item[] array = new Item[size + 1];
        array[0] = new Item(0);
       
        System.out.println("Procedimento de insercao iniciado.\nDigite inteiros para inserir.");  
        int n = 0;
        Random gen = new Random();
        for (int i = 1; i < array.length; i++) {
            // n++; // ORDENADO
            n = gen.nextInt(10000); // ALEATORIO
            array[i] = new Item(n);
        }

        Heap heap = new Heap(array);
        heap.heapsort();

        for (int i = 1; i < array.length; i++) {
            System.out.print(heap.array[i].key + " ");
        }

        System.out.println("\n" + Globals.heapCounter);
        Globals.heapCounter = 0;
        input.close();
    }
}
