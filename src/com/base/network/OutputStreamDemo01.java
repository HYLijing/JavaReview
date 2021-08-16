package com.base.network;

import java.io.*;

public class OutputStreamDemo01 {

    /**
     * 正常的发送不会一个字节一个字节的发送，都是会放在一个缓冲中，等缓冲满时才会发送。
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        FileOutputStream out = new FileOutputStream(new File("text.txt"));

        generateCharacters(out);

        out.close();
    }

    public static void generateCharacters(OutputStream out) throws IOException {

        int firstPrintableCharacters = 33;
        int numberOfPrintableCharacters = 94;
        int numberOfCharactersPerLine = 72;

        int start = firstPrintableCharacters;

        while (true) {

            for (int i = start; i < start + numberOfCharactersPerLine; i++) {

                out.write((i - firstPrintableCharacters) % numberOfPrintableCharacters);
            }

            out.write('\r');
            out.write('\n');

            start = ((start + 1) - firstPrintableCharacters)
                    % numberOfPrintableCharacters + firstPrintableCharacters;
        }
    }
}
