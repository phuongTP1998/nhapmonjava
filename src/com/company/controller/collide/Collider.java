package com.company.controller.collide;

import com.company.view.graphics.GameRect;

/**
 * Created by trongphuong1011 on 9/20/2017.
 */
public interface Collider {
    GameRect getGameRect();

    void onCollide(Collider other);
}
