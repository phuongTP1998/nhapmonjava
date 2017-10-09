package com.company.controller;

import com.company.utils.GameRect;
import com.company.utils.SpriteRender;

import java.awt.*;

/**
 * Created by trongphuong1011 on 9/20/2017.
 */
public class Controller {
    protected GameRect gameRect;
    protected SpriteRender spriteRender;

    public Controller(){}

    public GameRect getGameRect(){ return gameRect;}

    public Controller(GameRect gameRect, SpriteRender spriteRender){
        this.gameRect = gameRect;
        this.spriteRender = spriteRender;
    }

    public void draw(Graphics graphics){ spriteRender.render(graphics,gameRect);}

    public void update(){}
}
