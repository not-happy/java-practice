package io.stream;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author xuyong
 * @since 2020/7/17 17:33
 **/
public class MemoryInput {

    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("src/io/stream/MemoryInput.java"));
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char) c);
        }
    }

}
