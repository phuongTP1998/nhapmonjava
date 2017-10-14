package com.company.gamescene;

import com.company.player.Player;
import com.company.utils.GameRect;
import com.company.utils.SpriteRender;
import com.company.utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by trongphuong1011 on 9/20/2017.
 */
public class Level1Scene implements GameScene {
    private Image background;

    public Level1Scene(){
//        background1 = new BackGround(0,0,1000,700,Utils.loadImage("res/avatar.jpg"));
        background = Utils.loadImage("res/backgroundgame.jpg");
    }
    SpriteRender spriteRender = new SpriteRender("res/Player/player_down2.png");
    public Player player = new Player(new GameRect(50,20
            ,spriteRender.getImage().getWidth(null)
            ,spriteRender.getImage().getHeight(null))
            ,spriteRender);

    @Override
    public void KeyPressed(KeyEvent e) {

    }

    @Override
    public void KeyReleased(KeyEvent e) {

    }

    @Override
    public void draw(Graphics graphics) {
//        background1.draw(graphics);
        graphics.drawImage(background,0,0,1000,800,null);
    }

    @Override
    public void update() {

    }
}
