package first_level.exercise3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PathWriter {

    public static void writePathsInTxtFile(String pathToRead, String filePathToCreate) throws IOException {
        try (
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePathToCreate));)
            {bw.write(getPathContentSorted(pathToRead, 0));
        } catch(IOException ioe){
            System.out.println(ioe.getMessage());
    }
    }

    public static void readPathsInTxtFile(String filePathToRead) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new FileReader(filePathToRead));){
            String line;
            while((line = br.readLine()) != null){
            System.out.println(line);}
        } catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

    public static String getPathContentSorted(String path, int level) throws IOException {

        File directory = new File(path);
        if (!(directory.exists())) {
            System.out.println("The entered directory does not exist");
            return "";
        }
        if (!directory.isDirectory()) {
            System.out.println("The entered path is not a directory");
            return "";
        }
        String content = "";
        List<File> files = new ArrayList<>(List.of(Objects.requireNonNull(directory.listFiles())));
        Collections.sort(files);
        for (File file : files) {
            content += file.toString();
            if (file.isDirectory()) {
                content += " (Directory) \n";
                      content += getPathContentSorted(file.getAbsolutePath(), level + 1);
            }
            if (file.isFile()) {
                content += " (File) \n";
            }
        }
        return content;
    }
}
