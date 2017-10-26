package com.company.controller.behavior;

import com.company.view.graphics.GameRect;

/**
 * Created by trongphuong1011 on 10/22/2017.
 */
public class FallBehavior extends MoveBehavior {
    @Override
    public void move(GameRect gameRect) {
        gameRect.move(0,6);
    }
}
