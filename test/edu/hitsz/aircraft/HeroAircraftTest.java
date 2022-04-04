package edu.hitsz.aircraft;

import edu.hitsz.creator.MobEnemyFactory;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class HeroAircraftTest {
    private HeroAircraft heroAircraft;

    @BeforeAll
    static void init(){
        System.out.print("Test Start\n");
    }
    @BeforeEach
    void initEach(){
        heroAircraft=HeroAircraft.getInstance(0,0,0,0,100);
    }

    @AfterEach
    void post(){
        heroAircraft=null;
    }

    @Test
    void decreaseHp() {
        System.out.print("Testing decreaseHp\n");
        heroAircraft.decreaseHp(99);
        assertEquals(1,heroAircraft.getHp());
    }

    @Test
    void crash() {
        System.out.print("Testing crash\n");
        MobEnemyFactory mobEnemyFactory=new MobEnemyFactory();
        MobEnemy mobEnemy= (MobEnemy) mobEnemyFactory.create(0,0,0,0);
        assertTrue(heroAircraft.crash(mobEnemy));
        mobEnemy= (MobEnemy) mobEnemyFactory.create(100,0,0,0);
        assertFalse(heroAircraft.crash(mobEnemy));
    }
}