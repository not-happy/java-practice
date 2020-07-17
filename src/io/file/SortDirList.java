package io.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author xuyong
 * @since 2020/7/9 16:41
 **/
public class SortDirList {

    private String filepath;

    public SortDirList(String filepath) {
        this.filepath = filepath;
    }

    private String[] list() {
        File path = new File(filepath);
        String[] files = path.list();
        Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
        return files;
    }

    private String[] list(String regex) {
        File path = new File(filepath);
        String[] files = path.list(((dir, name) -> {
            Pattern pattern = Pattern.compile(regex);
            return pattern.matcher(name).matches();
        }));
        Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);
        return files;
    }

    public static void main(String[] args) {
        SortDirList sortDirList = new SortDirList("/Users/creator/Desktop");
        String[] files = sortDirList.list();
        for (String file : files) {
            System.out.println(file);
        }
        System.out.println("--------------------------------------");
        files = sortDirList.list("(.*\\.png)");
        for (String file : files) {
            System.out.println(file);
        }
    }

}
