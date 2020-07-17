package io.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * @author xuyong
 * @since 2020/7/9 17:02
 **/
public class SumDirList {

    private String filepath;

    public SumDirList(String filepath) {
        this.filepath = filepath;
    }

    private long total(String regex) {
        File file = new File(filepath);

        String[] files = file.list((dir, name) -> {
            Pattern pattern = Pattern.compile(regex);
            return pattern.matcher(name).matches();
        });

        long total = 0;
        for (String item : files) {
            total += new File(filepath + item).length();
        }

        return total;
    }

    public static void main(String[] args) {
        SumDirList sumDirList = new SumDirList("/Users/creator/Desktop/");
        System.out.println(sumDirList.total(".*") / 1024 + " KB");
    }

}