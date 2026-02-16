package first_level.exercise3;

import java.io.IOException;

public class Main {
    public static void main (String [] args){

        try{PathWriter.writePathsInTxtFile("/Users/ines/IdeaProjects", "/Users/ines/bw.txt");}catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }

        try{PathWriter.readPathsInTxtFile("/Users/ines/bw.txt");} catch(IOException ioe){
            System.out.println(ioe.getMessage());

        }
    }
}
