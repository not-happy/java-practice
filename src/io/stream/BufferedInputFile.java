package io.stream;

import java.io.*;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xuyong
 * @since 2020/7/17 16:46
 **/
public class BufferedInputFile {

    public interface Strategy {
        void process(String source) throws FileNotFoundException;
    }

    public interface LineStrategy {
        String process(String line);
    }

    private Strategy strategy;
    private LineStrategy lineStrategy;

    public BufferedInputFile(Strategy strategy, LineStrategy lineStrategy) {
        this.strategy = strategy;
        this.lineStrategy = lineStrategy;
    }

    public static String read(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null) {
            sb.append(s).append("\n");
        }
        in.close();
        return sb.toString();
    }

    public void reverse(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        LinkedList<String> list = new LinkedList<>();
        String s;
        while ((s = in.readLine()) != null) {
            list.add(s);
        }
        in.close();
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            if ((s = lineStrategy.process(list.get(i))) != null) {
                sb.append(s).append("\n");
            }
        }
        strategy.process(sb.toString());
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(read("src/io/stream/BufferedInputFile.java"));
        String filename = null;
        String find = null;
        if (args.length == 0) {
            filename = "src." + BufferedInputFile.class.getCanonicalName();
            filename = filename.replace(".", "/") + ".java";
        } else {
            for (int i = 0; i < args.length; i += 2) {
                switch (args[i]) {
                    case "-f":
                        filename = args[i + 1];
                        break;
                    case "-s":
                        find = args[i + 1];
                        break;
                    default:
                        throw new RuntimeException("无效的命令");
                }
            }
        }
        String finalFind = find;
        String file = "BufferedInputFile.out";
        AtomicInteger lineCount = new AtomicInteger(1);
        new BufferedInputFile(source -> {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(source);
            printWriter.close();
        }, line -> line.indexOf(finalFind) > 0
                ? lineCount.getAndIncrement() + ":" + line.replaceAll(finalFind, "<b>" + finalFind + "</b>") : null)
                .reverse(filename);
    }

}
