package first_level.exercise5;

import java.io.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args){

        if (args.length == 0) {
            System.out.println("There are no arguments.\n Type: java -cp out:src/main/resources first_level.exercise5.Main \"<directory_to_store_serialized_file/>\"");
            return;
        }

        String outputPath = args[0];
        User user1 = new User("1234A", "isalvama");

        try {
            user1.validateOutputFile(outputPath);
            user1.serializeUser(outputPath);
            user1.deserializeUser(outputPath);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

