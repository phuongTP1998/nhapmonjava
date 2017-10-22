package com.company.player;

import com.company.controller.Collider;
import com.company.controller.CollisionManager;
import com.company.controller.ControllerManager;
import com.company.utils.GameObject;
import com.company.utils.GameRect;
import com.company.utils.SpriteRender;

import java.awt.*;

/**
 * Created by trongphuong1011 on 10/22/2017.
 */
public class EnemyBullet extends GameObject implements Collider {
    private int damage = 1;
    private MoveBehavior moveBehavior;

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    public EnemyBullet(GameRect gameRect, SpriteRender spriteRender) {
        super(gameRect, spriteRender);
        CollisionManager.instance.add(this);
        ControllerManager.instance.add(this);
        moveBehavior = new MoveBehavior();
    }

    public void getHit(int damage) {
        gameRect.setDead(true);
        CollisionManager.instance.remove(this);
        GameObject.remove(this);
    }

    public int getDamage() {
        return damage;
    }


    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
    }

    @Override
    public void update() {
        moveBehavior.move(gameRect);
        if (gameRect.getX() < 0 || gameRect.getY() > 700) {
            getHit(0);
        }
    }

    @Override
    public void onCollide(Collider other) {
        if (other instanceof Player) {
            ((Player) other).getHit(damage);
        }
    }
}
