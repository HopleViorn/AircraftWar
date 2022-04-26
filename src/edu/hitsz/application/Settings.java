package edu.hitsz.application;
import java.io.Serializable;

public class Settings implements Serializable {
    enum Difficulty{Casual,Medium,Hard};
    enum SystemMusicState{ON,OFF};
    public static Difficulty difficulty;
    public static SystemMusicState systemMusicState;
}
