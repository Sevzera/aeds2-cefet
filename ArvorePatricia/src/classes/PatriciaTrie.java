package classes;

import java.util.ArrayList;
import java.util.Arrays;

public class PatriciaTrie {

    private Node root;

    public PatriciaTrie() {

        this.root = null;

    }

    public void search(Word inputWord) {
        Node searchNode = search(root, inputWord);

        if (Arrays.equals(searchNode.word.bits, inputWord.bits)) { // se os bits da palavra procurada forem iguais aos bits da palavra no node encontrado
            System.out.println("Palavra [" + inputWord.key + "] encontrada");
            System.out.println("Ocorrencias:\nLinhas -> " + searchNode.word.rows.toString() + "\nColunas -> " + searchNode.word.cols.toString()); // linhas e colunas formam 
        } else { // se nao                                                                                                                        // pares em indices equivalentes
            System.out.println("Palavra " + inputWord.key + " nao encontrada");
        }
    }

    private Node search(Node root, Word inputWord) {
        Node currentNode, nextNode;

        if (root == null) // retorna nulo caso nao exista raiz (logo, nao existiria arvore)
            return null;

        currentNode = root;
        nextNode = root.leftChild; // condicoes iniciais para a busca (leftChild tera uma copia atribuida durante a insercao)

        while (nextNode.bitNumber > currentNode.bitNumber) { // compara o indice no node atual com o indice no proximo
            currentNode = nextNode; // se for maior, quer dizer que temos que descer mais na arvore
            if (inputWord.bits[nextNode.bitNumber - 1] == 1) // se a palavra procurado tem bit 1 no indice atual da busca, desce pra direita
                nextNode = nextNode.rightChild;
            else if (inputWord.bits[nextNode.bitNumber - 1] == 0) // se a palavra procurado tem bit 1 no indice atual da busca, desce pra esquerda
                nextNode = nextNode.leftChild;

        }

        return nextNode;
    }

    public void insert(Word inputWord) {
        root = insert(root, inputWord);
    }

    private Node insert(Node root, Word inputWord) {

        Node currentNode, parentNode, deepestCompatibleNode, newNode;

        if (root == null) { // cria a raiz caso esta seja nula (ou seja, caso nao exista arvore)
            inputWord.cols.add(Globals.currentCol);
            inputWord.rows.add(Globals.currentRow);
            root = new Node(inputWord);
            root.bitNumber = 0;
            root.leftChild = root;
            root.rightChild = null;
            return root;
        }

        deepestCompatibleNode = search(root, inputWord); // encontra o ultimo node analisado na busca pela sequencia de bits a ser inserida
        int i = 1;
        while (inputWord.bits[i - 1] == deepestCompatibleNode.word.bits[i - 1] && i < 128) { // encontra o indice armazenado nesse ultimo node
            i++;                                                                             // (esse sera o indice do bit que diferencia a palavras das outras)
        }

        if (i == 128) { // caso o indice seja 128, quer dizer que a palavra ja foi inserida antes
            ArrayList<Integer> auxCols = deepestCompatibleNode.word.cols; //  entao, armazenamos em uma lista auxiliar as posicoes em que ela ja foi identificada no texto
            ArrayList<Integer> auxRows = deepestCompatibleNode.word.rows;
            inputWord.cols.addAll(auxCols);
            inputWord.rows.addAll(auxRows); // e adicionamos essas posicoes na lista da palavra (esta sera inserida novamente, mas com a lista das posicoes atualizada)
        }

        parentNode = root;
        currentNode = root.leftChild; // condicoes iniciais de busca (leftChild tera uma copia atribuida durante a insercao)

        while (currentNode.bitNumber > parentNode.bitNumber && currentNode.bitNumber < i) { // compara o indice no node atual com o indice no proximo, em um maximo de i niveis de profundidade
            parentNode = currentNode; // se for maior, quer dizer que temos que descer mais na arvore
            if (inputWord.bits[currentNode.bitNumber - 1] == 1) // se a palavra procurado tem bit 1 no indice atual da busca, desce pra direita
                currentNode = currentNode.rightChild;
            else if (inputWord.bits[currentNode.bitNumber - 1] == 0) // se a palavra procurado tem bit 1 no indice atual da busca, desce pra esquerda
                currentNode = currentNode.leftChild;
        }

        inputWord.cols.add(Globals.currentCol);
        inputWord.rows.add(Globals.currentRow);
        newNode = new Node(inputWord);
        newNode.bitNumber = i; // cria um novo node com a palavra inserida e o ultimo indice de divisao, com a nova posicao do texto na lista

        if (newNode.word.bits[i - 1] == 1) {
            newNode.leftChild = currentNode;
            newNode.rightChild = newNode;
        } else if (newNode.word.bits[i - 1] == 0) {
            newNode.leftChild = newNode;
            newNode.rightChild = currentNode; // condicoes abstratas para buscas futuras (aqui e onde leftChild assume a copia de um dos nodes, a depender do bit divisivo)
        }

        if (currentNode == parentNode.leftChild)
            parentNode.leftChild = newNode;
        else if (currentNode == parentNode.rightChild)
            parentNode.rightChild = newNode; // o novo node e atribuido a um dos lados do pai

        return root;
    }
}