package io.stream;

import java.io.*;

/**
 * @author xuyong
 * @since 2020/7/17 17:48
 **/
public class BasicFileOutput {

    static String file = "BasicFileOutput.out";

    public interface Strategy {
        String process(String line);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("src/io/stream/BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(new FileWriter(file));

        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ":" + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read("BasicFileOutput.out"));
    }

}
