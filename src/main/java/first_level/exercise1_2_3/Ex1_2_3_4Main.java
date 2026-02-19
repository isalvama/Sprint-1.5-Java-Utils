package first_level.exercise1_2_3;

import java.io.IOException;

public class Ex1_2_3_4Main {
    public static void main(String[] args) throws IOException {

        if (args.length < 2){
            System.err.println("Error: There are no arguments.\n Type: java first_level.exercise1_2_3.Ex1_2_3_Main <directory to read> <file to save>\"");
        }

        String inputDirectory = args[0];
        String outputFile = args[1];


       System.out.println(Listator.getPathContentSorted(inputDirectory, 0));

       try{
            Listator.writePathsInTxtFile(inputDirectory, outputFile);
        }catch(IOException ioe){
            System.err.println("Error: " + ioe.getMessage());
        }

        try{Listator.readPathsInTxtFile(outputFile);
        }catch(IOException ioe){
            System.err.println("Error: " + ioe.getMessage());
        }
    }

}
