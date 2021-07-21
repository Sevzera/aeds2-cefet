import classes.*;

public class Main {
    public static void main(String[] args) throws Exception {

        PatriciaTrie tree = new PatriciaTrie();
        String delimitersPath = "classes/tests/delimiters.txt";
        String filePath = "classes/tests/test1.txt"; // MUDAR PARA O DIRETÓRIO DO TESTE
        ExtraiPalavra extractor = new ExtraiPalavra(delimitersPath, filePath);

        Word word;
        String currentKey;
        while (true) {
            currentKey = extractor.proximaPalavra();
            if (currentKey == null)
                break;

            if (currentKey.isEmpty() || currentKey.isBlank()) {
                if (currentKey.contains("\n") || currentKey.contains("\r")) {
                    Globals.currentCol = 1;
                    Globals.currentRow++;
                } else {
                    Globals.currentCol++;
                }
            } else {
                currentKey = currentKey.replaceAll("[-+.^:,]", "");
                word = new Word(currentKey);
                tree.insert(word);
            }
        }

        // // EXEMPLO 1
        // tree.search(new Word("trabalho"));
        // System.out.println();
        // tree.search(new Word("computacao"));
        // System.out.println();
        // tree.search(new Word("governo"));
        // System.out.println();
        // tree.search(new Word("educacao"));
        // System.out.println();
        // tree.search(new Word("tecnologia"));
        // System.out.println();
        // tree.search(new Word("formacao"));
        // System.out.println();
        // tree.search(new Word("desenvolvimento"));
        // System.out.println();
        // tree.search(new Word("que"));
        // System.out.println();
        // tree.search(new Word("informatica"));
        // System.out.println();
        // tree.search(new Word("em"));
        // System.out.println();
        // tree.search(new Word("crise"));

        // // EXEMPLO 2
        // tree.search(new Word("sociedade"));
        // System.out.println();
        // tree.search(new Word("software"));
        // System.out.println();
        // tree.search(new Word("ideia"));
        // System.out.println();
        // tree.search(new Word("pessoa"));
        // System.out.println();
        // tree.search(new Word("informatica"));
        // System.out.println();
        // tree.search(new Word("etica"));
        // System.out.println();
        // tree.search(new Word("muito"));
        // System.out.println();
        // tree.search(new Word("ciencia"));
        // System.out.println();
        // tree.search(new Word("computacao"));
        // System.out.println();
        // tree.search(new Word("que"));
        // System.out.println();
        // tree.search(new Word("area"));
        // System.out.println();
        // tree.search(new Word("moral"));

        extractor.fecharArquivos();
    }
}
