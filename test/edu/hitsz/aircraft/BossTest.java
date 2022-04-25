package edu.hitsz.aircraft;

import edu.hitsz.application.Game;
import edu.hitsz.application.Main;
import edu.hitsz.creator.BossFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BossTest {
    private Boss boss;
    private BossFactory bossFactory=new BossFactory();

    @BeforeAll
    static void init(){
        System.out.print("Test Start\n");
    }
    @BeforeEach
    void initEach(){
        boss=(Boss) bossFactory.create(0,0,0,10);
    }

    @AfterEach
    void post(){
        boss=null;
    }
    @Test
    void getHp() {
        System.out.print("getHp Test\n");
        assertEquals(60,boss.getHp());
    }

    @Test
    void forward() {
        System.out.print("Boundary Test\n");

        while(boss.getLocationY()<=Main.WINDOW_HEIGHT) {
            boss.forward(Game.getTimeInterval());
        }
        assertTrue(boss.notValid());
    }
}