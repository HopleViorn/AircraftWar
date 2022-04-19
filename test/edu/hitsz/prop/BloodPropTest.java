package edu.hitsz.prop;

import edu.hitsz.aircraft.Boss;
import edu.hitsz.aircraft.HeroAircraft;
import edu.hitsz.application.Main;
import edu.hitsz.creator.BloodPropFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BloodPropTest {
    BloodPropFactory bloodPropFactory=new BloodPropFactory();
    HeroAircraft heroAircraft=HeroAircraft.getInstance(0,0,0,0,100);
    BloodProp bloodProp;
    @BeforeAll
    static void init(){
        System.out.print("Test Start\n");
    }
    @BeforeEach
    void initEach(){
        bloodProp=(BloodProp) bloodPropFactory.create(0,0,0,10);
    }

    @AfterEach
    void post(){
        bloodProp=null;
    }

    @Test
    void setLocation() {
        System.out.print("setLocation Test");
        int x=(int)Math.random()*(Main.WINDOW_WIDTH),y=(int)Math.random()*Main.WINDOW_HEIGHT;
        bloodProp.setLocation(x,y);
        assertEquals(x,bloodProp.getLocationX());
        assertEquals(y,bloodProp.getLocationY());
    }

    @Test
    void crash() {
        System.out.print("Test Blood Supply");
        heroAircraft.setLocation(0,0);
        assertTrue(bloodProp.crash(heroAircraft));
        assertTrue(heroAircraft.crash(bloodProp));
    }
}