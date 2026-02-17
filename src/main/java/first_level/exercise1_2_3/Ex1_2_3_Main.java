package first_level.exercise1_2_3;

import java.io.IOException;

public class Ex1_2_3_Main {
    public static void main(String[] args) throws IOException {
       System.out.println(Listator.getPathContentSorted("/Users/ines/IdeaProjects/TascaS1.02/src/main/java", 0));

       try{
            Listator.writePathsInTxtFile("/Users/ines/IdeaProjects", "/Users/ines/bw.txt");
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }

        try{Listator.readPathsInTxtFile("/Users/ines/bw.txt");} catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

}
