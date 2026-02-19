package first_level.exercise1_2_3;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class Listator {

    public static String getPathContentSorted(String path, int level) {
        File directory = new File(path);
        if (!(directory.exists())) {
            return "The entered directory does not exist";
        }
        if (!directory.isDirectory()) {
            System.out.println();
            return "The entered path is not a directory";
        }
       List<File> files = new ArrayList<>(List.of(Objects.requireNonNull(directory.listFiles())));
        Collections.sort(files);
        String content = "";
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
        for (File file : files) {
            content += file.toString();
            String fileTime = dateFormat.format(file.lastModified());
            if (file.isDirectory()) {
                content += " (Directory) " + fileTime + "\n";
                content += getPathContentSorted(file.getAbsolutePath(), level + 1);
            }
            if (file.isFile()) {
                content += " (File) " + fileTime + "\n";
            }
        }
        return content;
    }

    public static void writePathsInTxtFile(String inputDirectoryPath, String outputFilePath) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))){
            bw.write(getPathContentSorted(inputDirectoryPath, 0));
        } catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

    public static void readPathsInTxtFile(String filePathToRead) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePathToRead))){
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
}
