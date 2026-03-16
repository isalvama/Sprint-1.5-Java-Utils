package first_level.exercise1_2_3_4;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class Listator {

    public static void validateOutputFile (String outputFileStr) throws IOException {
        File outputFile = new File(outputFileStr);
        File parentDir = outputFile.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            if (!parentDir.mkdirs()){
                throw new IOException("The directories " + parentDir.getAbsolutePath() + " could not be created.");
            }
        }
    }


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
        StringBuilder content = new StringBuilder();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
        for (File file : files) {
            content.append(("- ").repeat(level)).append(file.getName());
            String fileTime = dateFormat.format(file.lastModified());
            if (file.isDirectory()) {
                content.append(" (D)").append(fileTime).append("\n");
                content.append(getPathContentSorted(file.getAbsolutePath(), level + 1));
            }
            if (file.isFile()) {
                content.append(" (F)").append(fileTime).append("\n");
            }
        }
        return content.toString();
    }

    public static void writePathsInTxtFile(String inputDirectoryPath, String outputFilePath) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))){
            bw.write(getPathContentSorted(inputDirectoryPath, 0));
        }
    }

    public static void readPathsInTxtFile(String filePathToRead) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePathToRead))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
