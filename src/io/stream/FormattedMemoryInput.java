package io.stream;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * @author xuyong
 * @since 2020/7/17 17:39
 **/
public class FormattedMemoryInput {

    public static void main(String[] args) throws IOException {
        try {
            DataInputStream in = new DataInputStream(new ByteArrayInputStream(BufferedInputFile.read("src/io/stream/FormattedMemoryInput.java").getBytes()));
            while (in.available() != 0) {
                System.out.print((char) in.readByte());
            }
        } catch (EOFException e) {
            System.out.println("结束");
        }

    }

}
