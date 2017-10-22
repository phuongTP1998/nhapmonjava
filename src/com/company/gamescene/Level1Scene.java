package com.company.gamescene;

import com.company.GameWindow;
import com.company.controller.ControllerManager;
import com.company.graphics.BackGround;
import com.company.player.EnemyBird;
import com.company.player.EnemyBullet;
import com.company.player.EnemyController;
import com.company.player.Player;
import com.company.utils.GameRect;
import com.company.utils.SpriteRender;
import com.company.utils.Utils;
import javafx.scene.layout.Background;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by trongphuong1011 on 9/20/2017.
 */
public class Level1Scene implements GameScene {
    public static int BORDER_LEFT = 0;
    public static int BORDER_RIGHT = 940;
    public static int BORDER_UP = 200;
    public static int BORDER_DOWN = 490;
    private BackGround background1,background2;
    public static Level1Scene instance;
    private int countdowntime=0;
    SpriteRender spriteRender = new SpriteRender("res/Player/player_down2.png");
    Player player = new Player(new GameRect(450, 490
            , spriteRender.getImage().getWidth(null)
            , spriteRender.getImage().getHeight(null))
            , spriteRender,1);
    EnemyBullet enemyBullet = new EnemyBullet(new GameRect(450, 490
            ,  30, 30),
            new SpriteRender("res/bomb.png"));


    public Level1Scene() {
        background1 = new BackGround(0,0,1000,700,Utils.loadImage("res/backgroundgame1.png"));
        background2 = new BackGround(1000,0,1000,700,Utils.loadImage("res/backgroundgame2.png"));
        new Map(new GameRect(0, 150, 1000, 50), new SpriteRender("res/background1.jpg"));
        new Map(new GameRect(0, 550, 1000, 50), new SpriteRender("res/background1.jpg"));
        EnemyBird enemyBird1 = new EnemyBird
                (new GameRect(100, 50, 50, 50), new SpriteRender("res/bird/bird_left_1.png"));
        EnemyBird enemyBird2 = new EnemyBird
                (new GameRect(400, 80, 50, 50), new SpriteRender("res/bird/bird_left_1.png"));
        EnemyBird enemyBird3 = new EnemyBird
                (new GameRect(500, 40, 50, 50), new SpriteRender("res/bird/bird_left_1.png"));
        EnemyController enemyController = new EnemyController
                (new GameRect(100, 490, 50, 50), new SpriteRender("res/walkEnemy/walkEnemy_left_1.png"));
        enemyController.setShootEnable(false);
        ControllerManager.instance.add(enemyController);
        ControllerManager.instance.add(enemyBird1);
        ControllerManager.instance.add(enemyBird2);
        ControllerManager.instance.add(enemyBird3);
        GameWindow.instance.clip = Utils.playSound("res/soundtrackGAME.wav",true);
    }


    @Override
    public void KeyPressed(KeyEvent e) {

    }

    @Override
    public void KeyReleased(KeyEvent e) {

    }

    @Override
    public void draw(Graphics graphics) {
        background1.draw(graphics);
        background2.draw(graphics);
    }

    @Override
    public void update() {
        background1.update();
        background2.update();
        System.out.println(countdowntime);
        if(countdowntime%500==0){
            EnemyController enemyController = new EnemyController
                    (new GameRect(100, 490, 50, 50), new SpriteRender("res/walkEnemy/walkEnemy_left_1.png"));
            enemyController.setShootEnable(false);
            ControllerManager.instance.add(enemyController);
        }
        countdowntime++;
    }
}
