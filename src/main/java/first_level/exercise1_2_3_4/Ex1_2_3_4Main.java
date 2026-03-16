package first_level.exercise1_2_3_4;

import java.io.IOException;

public class Ex1_2_3_4Main {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.err.println("Error: There are no arguments.\n Type: java -cp out:src/main/resources first_level.exercise1_2_3_4.Ex1_2_3_4Main \"<directory to read>\" \"<file to save>\"");
            return;
        }

        if (args.length == 1) {
            String inputDirectory = args[0];
            System.out.println(Listator.getPathContentSorted(inputDirectory, 0));
        }

        if (args.length == 2) {
            String inputDirectoryStr = args[0];
            String outputFileStr = args[1];
            try {
                Listator.validateOutputFile(outputFileStr);
                Listator.writePathsInTxtFile(inputDirectoryStr, outputFileStr);
                Listator.readPathsInTxtFile(outputFileStr);
            } catch (IOException ioe){
                System.err.println("Error: " + ioe.getMessage());
            }

        } else {
            System.err.println("Error: There are too many arguments and only one or two are expected.\n Type: Type: java -cp out:src/main/resources first_level.exercise1_2_3_4.Ex1_2_3_4Main \"<directory to read>\" \"<file to save>\"");
        }
    }
}
