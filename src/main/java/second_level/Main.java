package second_level;

import first_level.exercise1_2_3.Listator;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        String appConfigPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("app.properties")).getPath();
        Properties appProps = new Properties();
        appProps.load(new FileReader(appConfigPath));

        String inputDirectory = appProps.getProperty("input.directory");
        String outputFile = appProps.getProperty("output.file");
        Listator.writePathsInTxtFile(inputDirectory, outputFile);

    }
}
