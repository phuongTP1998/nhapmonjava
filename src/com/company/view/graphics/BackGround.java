package com.company.view.graphics;

import com.company.controller.collide.Controller;

import java.awt.*;

/**
 * Created by trongphuong1011 on 9/20/2017.
 */
public class BackGround extends Controller {
    public BackGround(int x, int y, int width, int height, Image image){
        gameRect = new GameRect(x,y,width,height);
        spriteRender = new SpriteRender(image);
    }

    @Override
    public void update() {
        gameRect.move(-1,0);
        if(gameRect.getX()<=-1000){
            gameRect.setX(1000);
        }
    }
}
