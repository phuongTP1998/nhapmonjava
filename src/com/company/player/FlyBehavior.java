package com.company.player;

import com.company.utils.GameRect;

/**
 * Created by trongphuong1011 on 10/22/2017.
 */
public class FlyBehavior extends MoveBehavior {
    public void move(GameRect gameRect) {
        if (gameRect.getX() <= 900) {
            gameRect.move(2, 0);
        } else if (gameRect.getX() >= 1200) {
            gameRect.move(-2, 0);
        }
    }
}