package classes;

import java.util.StringTokenizer;
import java.io.*;

public class TextParser {
    private BufferedReader delimitersFile, textFile;
    private StringTokenizer words;
    private String delimiters, previousWord, currentWord;

    private boolean isDelimiter(char key) {
        return (this.delimiters.indexOf(key) >= 0);
    }

    public TextParser(String delimitersFileTitle, String textFileTitle) throws Exception {
        this.delimitersFile = new BufferedReader(new FileReader(delimitersFileTitle));
        this.textFile = new BufferedReader(new FileReader(textFileTitle));
        // Os delimitadores devem estar juntos em uma única linha do arquivo
        this.delimiters = delimitersFile.readLine() + "\r\n";
        this.words = null;
        this.currentWord = null;
        this.previousWord = " ";
    }

    public String nextWord() throws Exception {
        String auxWord = "";
        String finalWord = "";
        if (this.currentWord != null) {
            auxWord = currentWord;
            currentWord = null;
            previousWord = auxWord;
            return auxWord;
        }
        if (words == null || !words.hasMoreTokens()) {
            String line = textFile.readLine();
            if (line == null)
                return null;
            line += " \n";
            this.words = new StringTokenizer(line, this.delimiters, true);
        }
        String aux = this.words.nextToken();
        while (isDelimiter(aux.charAt(0)) && words.hasMoreTokens()) {
            auxWord += aux;
            aux = this.words.nextToken();
        }
        if (auxWord.length() == 0)
            finalWord = aux;
        else {
            this.currentWord = aux;
            if (auxWord.length() == 1 && auxWord.equals(" ") && previousWord.length() > 0 && currentWord.length() > 0
                    && !isDelimiter(previousWord.charAt(0)) && !isDelimiter(currentWord.charAt(0)))
                auxWord = auxWord.trim();
            finalWord = auxWord;
        }
        this.previousWord = finalWord;
        return finalWord;
    }

    public void closeFiles() throws Exception {
        this.delimitersFile.close();
        this.textFile.close();
    }
}
