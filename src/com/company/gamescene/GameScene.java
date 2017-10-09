package com.company.gamescene;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by trongphuong1011 on 9/20/2017.
 */
public interface GameScene {
    void KeyPressed(KeyEvent e);

    void KeyReleased(KeyEvent e);

    void draw(Graphics graphics);

    void update();
}
