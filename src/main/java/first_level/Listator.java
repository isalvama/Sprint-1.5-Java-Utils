package first_level;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;


public class Listator {
final ArrayList<String> files = new ArrayList<>();

    public static String getDirContentSorted(String path) {
        File directory = new File(path);
        String[] dirContent;
        dirContent = directory.list();
        if (dirContent == null) {
            return "No content found in this path";
        }
        System.out.println(dirContent.length);
        ArrayList<String> elementsArray = new ArrayList<>(Arrays.asList(dirContent));
        Collections.sort(elementsArray);
        String content = "";
        for (String element : elementsArray) {
            content += element + "\n";
        }
        return content;
    }

    public static void getPathContentSorted(String path, int level) throws IOException {

        File directory = new File(path);
        if (!(directory.exists())) {
            System.out.println("The entered directory does not exist");
            return;
        }
        if (!directory.isDirectory()) {
            System.out.println("The entered path is not a directory");
            return;
        }
        List<File> files = new ArrayList<>(List.of(Objects.requireNonNull(directory.listFiles())));
        Collections.sort(files);
        for (File file : files) {
            System.out.println(file.toString());
            if (file.isDirectory()) {
                System.out.println(("D"));
                getPathContentSorted(file.getAbsolutePath(), level + 1);
            }
            if (file.isFile()) {
                System.out.println(("F"));
            }

        }
    }
}
