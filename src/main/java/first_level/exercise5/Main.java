package first_level.exercise5;

import java.io.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args){

        if (args.length == 0) {
            System.out.println("There are no arguments.\n Type: java first_level.exercise5.Main <path of serialized file to create>\"");
        }
        String outputPath = args[0];
        User user1 = new User("1234A", "isalvama");
            user1.serializeUser(outputPath);
            user1.deserializeUser(outputPath);
    }
}

