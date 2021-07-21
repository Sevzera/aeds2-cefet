package classes;

import java.util.ArrayList;

public class Word {
    public String key;
    public ArrayList<Integer> cols;
    public ArrayList<Integer> rows;
    public int[] bits = new int[128];

    public Word(String key) {
        this.key = key;
        this.cols = new ArrayList<Integer>();
        this.rows = new ArrayList<Integer>();
        this.stringToBits();
    }

    public void stringToBits() {
        int size = key.length();
        if (size > 16) {
            size = 16;
        }

        int bitsWritten = 0;
        int currentCharValue = 0;
        int currentCharIndex = 0;

        String binaryCharString;

        for (int i = 0; i < size; i++) {

            binaryCharString = Integer.toBinaryString((int) this.key.charAt(i));
            while (binaryCharString.length() < 8) {
                binaryCharString = "0" + binaryCharString;
            }

            for (int j = bitsWritten; j < bitsWritten + 8; j++) {
                currentCharValue = binaryCharString.charAt(currentCharIndex);
                if (currentCharValue == 48) {
                    this.bits[j] = 0;
                } else if (currentCharValue == 49) {
                    this.bits[j] = 1;
                }
                currentCharIndex++;
            }

            currentCharIndex = 0;
            bitsWritten += 8;

        }

    }

}
