package com.company.player;

import com.company.utils.GameRect;

/**
 * Created by trongphuong1011 on 10/22/2017.
 */
public class FallBehavior extends MoveBehavior {
    @Override
    public void move(GameRect gameRect) {
        gameRect.move(0,6);
    }
}
