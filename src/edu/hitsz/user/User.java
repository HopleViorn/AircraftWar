package edu.hitsz.user;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    public int userID;
    public int score;
    Date date;
    public User(int userID,int score,Date date){
        this.userID=userID;
        this.score=score;
        this.date=date;
    }
}
