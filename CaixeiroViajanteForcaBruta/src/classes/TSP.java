package classes;

import static classes.TSP.fileMatrixType.FULL_MATRIX;
import static classes.TSP.fileMatrixType.LOWER_DIAG;
import static classes.TSP.fileMatrixType.UPPER_DIAG;

public class TSP {

    private TextParser extractor;
    private String delimitersPath = "classes/files/delimiters.txt";

    public enum fileMatrixType {
        UPPER_DIAG, LOWER_DIAG, FULL_MATRIX
    }

    fileMatrixType fileMatrixType;

    public int nOfCities;
    public int[][] adjacencyMatrix;

    public TSP(String filePath) throws Exception {

        this.extractor = new TextParser(delimitersPath, filePath);
        this.setFileConditions();
        this.setAdjacencyMatrix();

    }

    public void printAdjacencyMatrix() {
        for (int i = 0; i < nOfCities; i++) {
            for (int j = 0; j < nOfCities; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void setFileConditions() throws Exception {

        String currentWord = "";

        while (!(currentWord.contains("DIMENSION"))) {
            currentWord = this.extractor.nextWord();

            if (currentWord.equals("EOF")) {
                System.out.println("Formato de arquivo texto nao compativel");
                System.exit(0);
            }
        }

        while (!(currentWord.matches("\\d+")))
            currentWord = this.extractor.nextWord();

        this.nOfCities = Integer.parseInt(currentWord);
        this.adjacencyMatrix = new int[this.nOfCities][this.nOfCities];

        while (!(currentWord.contains("EDGE_WEIGHT_FORMAT"))) {

            currentWord = this.extractor.nextWord();

            if (currentWord.equals("EOF")) {
                System.out.println("Formato de arquivo texto nao compativel");
                System.exit(0);
            }
        }

        while (!(currentWord.contains("FULL_MATRIX")) && !(currentWord.contains("UPPER_DIAG_ROW"))
                && !(currentWord.contains("LOWER_DIAG_ROW"))) {
            currentWord = this.extractor.nextWord();
        }

        if (currentWord.contains("FULL_MATRIX"))
            this.fileMatrixType = FULL_MATRIX;
        else if (currentWord.contains("UPPER_DIAG_ROW"))
            this.fileMatrixType = UPPER_DIAG;
        else if (currentWord.contains("LOWER_DIAG_ROW"))
            this.fileMatrixType = LOWER_DIAG;
    }

    private void setAdjacencyMatrix() throws Exception {

        String currentWord = "";
        int currentValue;
        int currentCity = 0;
        if (this.fileMatrixType == UPPER_DIAG) {
            while (!(currentWord.equals("EOF"))) {

                currentWord = this.extractor.nextWord();

                if (currentWord.equals("0")) {

                    this.adjacencyMatrix[currentCity][currentCity] = 0;

                    if (currentCity < this.nOfCities - 1) {
                        for (int i = currentCity + 1; i < this.nOfCities; i++) {

                            do {
                                currentWord = this.extractor.nextWord();
                            } while (currentWord.isBlank());

                            currentValue = Integer.parseInt(currentWord);
                            this.adjacencyMatrix[currentCity][i] = currentValue;
                            this.adjacencyMatrix[i][currentCity] = currentValue;
                        }
                        currentCity++;
                    }
                }
            }
        } else if (this.fileMatrixType == LOWER_DIAG) {
            int diffPos;
            while (!(currentWord.equals("EOF"))) {

                currentWord = this.extractor.nextWord();

                if (currentWord.equals("0")) {

                    this.adjacencyMatrix[currentCity][currentCity] = 0;

                    if (currentCity < this.nOfCities - 1) {
                        diffPos = currentCity;

                        for (int i = 0; i < currentCity + 1; i++) {

                            do {
                                currentWord = this.extractor.nextWord();
                            } while (currentWord.isBlank());

                            currentValue = Integer.parseInt(currentWord);
                            this.adjacencyMatrix[currentCity - diffPos][currentCity + 1] = currentValue;
                            this.adjacencyMatrix[currentCity + 1][currentCity - diffPos] = currentValue;
                            diffPos--;
                        }
                        currentCity++;
                    }
                }
            }
        } else if (this.fileMatrixType == FULL_MATRIX) {
            int row = 0, col = 0;

            while(!(currentWord.contains("\n"))){
                currentWord = extractor.nextWord();
            }

            while (!(currentWord.equals("EOF"))) {

                currentWord = this.extractor.nextWord();

                if (currentWord.matches("\\d+")) {

                    this.adjacencyMatrix[row][col] = Integer.parseInt(currentWord);
                    row++;

                } else if (currentWord.equals("\n")) {

                    col++;
                    row = 0;

                }
            }

        }
        extractor.closeFiles();
    }
}
