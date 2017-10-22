package com.company.player;

import com.company.controller.Collider;
import com.company.graphics.Animation;
import com.company.utils.GameRect;
import com.company.utils.SpriteRender;
import com.company.utils.Utils;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by trongphuong1011 on 10/22/2017.
 */
public class EnemyBird extends EnemyController implements Collider {
    private int cooldown = 200;
    private Animation animationLeft;
    private Animation animationRight;
    private boolean isLeft=false;

    public EnemyBird(GameRect gameRect, SpriteRender spriteRenderer) {
        super(gameRect, spriteRenderer);
        this.setMoveBehavior(new FlyBehavior());

        ArrayList<Image> imagesLeft = new ArrayList<>();
        imagesLeft.add(Utils.loadImage("res/bird/bird_left_1.png"));
        imagesLeft.add(Utils.loadImage("res/bird/bird_left_2.png"));
        imagesLeft.add(Utils.loadImage("res/bird/bird_left_3.png"));
        imagesLeft.add(Utils.loadImage("res/bird/bird_left_4.png"));
        imagesLeft.add(Utils.loadImage("res/bird/bird_left_5.png"));
        imagesLeft.add(Utils.loadImage("res/bird/bird_left_6.png"));
        imagesLeft.add(Utils.loadImage("res/bird/bird_left_7.png"));
        imagesLeft.add(Utils.loadImage("res/bird/bird_left_8.png"));
        animationLeft = new Animation(imagesLeft,10,false);

        ArrayList<Image> imagesRight = new ArrayList<>();
        imagesRight.add(Utils.loadImage("res/bird/bird_right_1.png"));
        imagesRight.add(Utils.loadImage("res/bird/bird_right_2.png"));
        imagesRight.add(Utils.loadImage("res/bird/bird_right_3.png"));
        imagesRight.add(Utils.loadImage("res/bird/bird_right_4.png"));
        imagesRight.add(Utils.loadImage("res/bird/bird_right_5.png"));
        imagesRight.add(Utils.loadImage("res/bird/bird_right_6.png"));
        imagesRight.add(Utils.loadImage("res/bird/bird_right_7.png"));
        imagesRight.add(Utils.loadImage("res/bird/bird_right_8.png"));
        animationRight = new Animation(imagesRight,10,false);
    }

    public void shooting() {
        EnemyBullet enemyBullet = new EnemyBullet(new GameRect(this.gameRect.getX(), this.gameRect.getY(), 30, 30),
                new SpriteRender("res/bomb.png"));
        enemyBullet.setMoveBehavior(new FallBehavior());
    }

    @Override
    public void draw(Graphics graphics) {
        if(isLeft){
            animationLeft.draw(graphics,gameRect);
        } else {
            animationRight.draw(graphics,gameRect);
        }
    }

    @Override
    public void setMoveBehavior(MoveBehavior moveBehavior) {
        super.setMoveBehavior(moveBehavior);
    }

    @Override
    public void update() {
        cooldown--;
        if(cooldown<=0){
            shooting();
            cooldown=200;
        }

        if (gameRect.getX() <= initPosX) {
            dx = 2;
            isLeft = false;
        } else if (gameRect.getX() >= initPosX + 500) {
            dx = -2;
            isLeft = true;
        }
        gameRect.move(dx,0);
    }

    @Override
    public void onCollide(Collider other) {
        super.onCollide(other);
    }
}
