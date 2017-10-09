package com.company.player;

import com.company.InputManager;
import com.company.controller.Controller;
import com.company.controller.ControllerManager;
import com.company.utils.GameObject;
import com.company.utils.GameRect;
import com.company.utils.SpriteRender;

/**
 * Created by trongphuong1011 on 10/9/2017.
 */
public class Dragon extends GameObject {
    private int dx, dy;
    private GameRect gameRect;

    public Dragon(GameRect gameRect, SpriteRender spriteRender) {
        super(gameRect, spriteRender);
        this.gameRect = gameRect;
        ControllerManager.instance.add(this);
    }

    public GameRect getGameRect() {
        return gameRect;
    }

    @Override
    public void update() {
        dx=0;
        if(InputManager.getInstance().isRight()){
            gameRect.move(5,0);
        }
        if(InputManager.getInstance().isLeft()){
            gameRect.move(-5,0);
        }
        if(InputManager.getInstance().isDown()){
            gameRect.move(0,5);
        }
        if(InputManager.getInstance().isUp()){
            gameRect.move(0,-5);
        }
    }
}
