package first_level.exercise5;

import java.io.Serializable;

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
