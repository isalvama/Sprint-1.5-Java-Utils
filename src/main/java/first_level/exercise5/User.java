package first_level.exercise5;

import java.io.*;
import java.util.Objects;

public class User implements Serializable {
    private final String id;
    private String userName;
    private boolean isPremium;
    private int points;

    public User( String id,
    String userName){
        this.id = id;
       this.userName = userName;
       isPremium = false;
        points = 0;}

    public void serializeUser(String outputPath) {
        String fileOutputPath = outputPath + "user.ser";
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileOutputPath))){
            objectOutputStream.writeObject(this);
            objectOutputStream.flush();
        } catch (IOException ioe){
            System.err.println("Error: " + ioe.getMessage());
        }
    }

    public void deserializeUser (String inputPath){
        String fileInputPath = inputPath + "user.ser";
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileInputPath))){
            User user2 = (User) objectInputStream.readObject();
            System.out.println(user2);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", isPremium=" + isPremium +
                ", points=" + points +
                '}';
    }
}
