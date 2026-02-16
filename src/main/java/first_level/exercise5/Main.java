package first_level.exercise5;

import java.io.*;

public class Main {
    public static void main(String[] args){
        User user1 = new User("1234A", "isalvama");
        try{FileOutputStream fileOutputStream
                = new FileOutputStream("/Users/ines/sfos.ser");
      ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user1);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream
                = new FileInputStream("/Users/ines/sfos.ser");
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        User user2 = (User) objectInputStream.readObject();
            System.out.println(user2);

            objectInputStream.close(); } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    }

