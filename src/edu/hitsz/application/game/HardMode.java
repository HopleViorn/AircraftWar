package edu.hitsz.application.game;

import edu.hitsz.aircraft.AbstractAircraft;
import edu.hitsz.aircraft.Boss;
import edu.hitsz.aircraft.Elite;
import edu.hitsz.aircraft.MobEnemy;
import edu.hitsz.application.AbstractGame;
import edu.hitsz.application.ImageManager;
import edu.hitsz.application.Main;

public class HardMode extends AbstractGame {
    public HardMode(){
        super();
        //3,4
        super.cycleDuration=new int[]{100,100};
        super.cycleTime=new int[]{0,0};
    }

    @Override
    public void bossSpawn() {
        boss=null;
        for(AbstractAircraft enemy : enemyAircrafts) {
            if(enemy instanceof Boss){
                boss= (Boss) enemy;
                break;
            }
        }
        if(boss!=null) return ;

        //1
        int bossScoreThreshold = 100;
        if(score-lastscore>= bossScoreThreshold){
            enemyAircrafts.add(
                    (Boss) bossFactory.create(
                            (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.MOB_ENEMY_IMAGE.getWidth())) * 1,
                            (int) (Math.random() * Main.WINDOW_HEIGHT * 0.2) * 1,5,0)
            );
            lastscore = score;
        }
    }

    int magic=0;
    int enemyMaxNumber=5;
    double prob=0.5;
    @Override
    protected void enemySpawn() {
        //2
        if(++magic>=10) {
            prob=1-(1-prob)*0.9;
            enemyMaxNumber= (int) (enemyMaxNumber*1.2);
            System.out.println("Difficulty leveled up!Enemy maximum number:"+enemyMaxNumber+".Elite Probability:"+prob+".");
            magic=0;
        }

        if (enemyAircrafts.size() < enemyMaxNumber) {
            MobEnemy mobEnemy = (MobEnemy) mobEnemyFactory.create(
                    (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.MOB_ENEMY_IMAGE.getWidth())) * 1,
                    (int) (Math.random() * Main.WINDOW_HEIGHT * 0.2) * 1,
                    0,
                    10
            );
            publisher.subscribe(mobEnemy);
            enemyAircrafts.add(mobEnemy);
        }
        //5
        if (Math.random() < prob) {//精英敌机
            Elite elite = (Elite)
                    eliteFactory.create(
                            (int) (Math.random() * (Main.WINDOW_WIDTH - ImageManager.MOB_ENEMY_IMAGE.getWidth())) * 1,
                            (int) (Math.random() * Main.WINDOW_HEIGHT * 0.2) * 1,
                            (int) ((Math.random() - 0.5) * 10),
                            15
                    );
            publisher.subscribe(elite);
            enemyAircrafts.add(elite);
        }
    }
}