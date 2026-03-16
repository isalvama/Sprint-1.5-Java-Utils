package second_level;

import first_level.exercise1_2_3_4.Listator;
import java.io.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties appProps = new Properties();
        try (InputStream is = Main.class.getClassLoader().getResourceAsStream("config.properties")){
            if (is == null) {
                System.err.println("Error: 'app.properties' file could not be found.");
                return;
            }

            appProps.load(is);

            if (appProps.isEmpty()) {
                System.err.println("Error: config.properties file is empty.");
                return;
            }

            if (appProps.size() == 1) {
                System.err.println("Error: config.properties file content only has one line.");
                return;
            }

            String inputDirectory = appProps.getProperty("input.directory");
            String outputFile = appProps.getProperty("output.file");
            Listator.writePathsInTxtFile(inputDirectory, outputFile);

        } catch (IOException ioe){
            System.err.println("Error:" + ioe.getMessage());
        }

    }
}
