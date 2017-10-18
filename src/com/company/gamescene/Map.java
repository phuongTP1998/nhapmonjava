package com.company.gamescene;

import com.company.controller.Collider;
import com.company.utils.GameObject;
import com.company.utils.GameRect;
import com.company.utils.SpriteRender;

/**
 * Created by trongphuong1011 on 10/18/2017.
 */
public class Map extends GameObject implements Collider {
    public Map(GameRect gameRect, SpriteRender spriteRender) {
        super(gameRect, spriteRender);
    }
}
