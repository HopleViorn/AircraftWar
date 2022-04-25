package edu.hitsz.user;

import java.io.Serializable;

public class User implements Serializable {
    public int userID;
    public int score;
    public User(int userID,int score){
        this.userID=userID;
        this.score=score;
    }
}
