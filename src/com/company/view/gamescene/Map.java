package com.company.view.gamescene;

import com.company.controller.collide.Collider;
import com.company.view.graphics.SpriteRender;
import com.company.view.GameObject;
import com.company.view.graphics.GameRect;

/**
 * Created by trongphuong1011 on 10/18/2017.
 */
public class Map extends GameObject implements Collider {
    public Map(GameRect gameRect, SpriteRender spriteRender) {
        super(gameRect, spriteRender);
    }
}
