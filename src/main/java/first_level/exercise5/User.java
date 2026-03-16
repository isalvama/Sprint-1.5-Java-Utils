package first_level.exercise5;

import java.io.*;

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

    public void validateOutputFile (String outputFileStr) throws IOException {
        File outputFile = new File(outputFileStr);
        File parentDir = outputFile.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            if (!parentDir.mkdirs()){
                throw new IOException("The directories " + parentDir.getAbsolutePath() + " could not be created.");
            }
        }
    }

    public void serializeUser(String outputPath) throws IOException {
        String fileOutputPath = outputPath + File.separator + "user.ser";
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileOutputPath))) {
            objectOutputStream.writeObject(this);
            objectOutputStream.flush();
        }
    }

    public void deserializeUser (String inputPath) throws IOException, ClassNotFoundException {
        String fileInputPath = inputPath + "user.ser";
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileInputPath))) {
            User user2 = (User) objectInputStream.readObject();
            System.out.println(user2);
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
