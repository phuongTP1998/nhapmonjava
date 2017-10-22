package com.company.player;

import com.company.controller.Collider;
import com.company.controller.CollisionManager;
import com.company.controller.ControllerManager;
import com.company.graphics.Animation;
import com.company.utils.GameObject;
import com.company.utils.GameRect;
import com.company.utils.SpriteRender;
import com.company.utils.Utils;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by trongphuong1011 on 10/22/2017.
 */
public class EnemyController extends GameObject implements Collider {
    protected int dx;
    protected int dy;
    private MoveBehavior moveBehavior;
    private boolean isLeft=false;
    private boolean shootEnable;
    private int cooldown = 200;
    protected int initPosX;
    private int damage = 1;
    private Animation animationLeft;
    private Animation animationRight;

    public EnemyController(GameRect gameRect, SpriteRender spriteRenderer) {
        super(gameRect, spriteRenderer);
        dx = 0;
        dy = 0;
        moveBehavior = new MoveBehavior();
        initPosX = gameRect.getX();
        CollisionManager.instance.add(this);
        ControllerManager.instance.add(this);

        ArrayList<Image> imagesLeft = new ArrayList<>();
        imagesLeft.add(Utils.loadImage("res/walkEnemy/walkEnemy_left_1.png"));
        imagesLeft.add(Utils.loadImage("res/walkEnemy/walkEnemy_left_2.png"));
        imagesLeft.add(Utils.loadImage("res/walkEnemy/walkEnemy_left_3.png"));
        imagesLeft.add(Utils.loadImage("res/walkEnemy/walkEnemy_left_4.png"));
        imagesLeft.add(Utils.loadImage("res/walkEnemy/walkEnemy_left_5.png"));
        imagesLeft.add(Utils.loadImage("res/walkEnemy/walkEnemy_left_6.png"));
        imagesLeft.add(Utils.loadImage("res/walkEnemy/walkEnemy_left_7.png"));
        imagesLeft.add(Utils.loadImage("res/walkEnemy/walkEnemy_left_8.png"));
        animationLeft = new Animation(imagesLeft,10,false);

        ArrayList<Image> imagesRight = new ArrayList<>();
        imagesRight.add(Utils.loadImage("res/walkEnemy/walkEnemy_right_1.png"));
        imagesRight.add(Utils.loadImage("res/walkEnemy/walkEnemy_right_2.png"));
        imagesRight.add(Utils.loadImage("res/walkEnemy/walkEnemy_right_3.png"));
        imagesRight.add(Utils.loadImage("res/walkEnemy/walkEnemy_right_4.png"));
        imagesRight.add(Utils.loadImage("res/walkEnemy/walkEnemy_right_5.png"));
        imagesRight.add(Utils.loadImage("res/walkEnemy/walkEnemy_right_6.png"));
        imagesRight.add(Utils.loadImage("res/walkEnemy/walkEnemy_right_7.png"));
        imagesRight.add(Utils.loadImage("res/walkEnemy/walkEnemy_right_8.png"));
        animationRight = new Animation(imagesRight,10,false);
    }

    public void setShootEnable(boolean shootEnable) {
        this.shootEnable = shootEnable;
    }

    public void getHit(int damage) {
        gameRect.setDead(true);
        CollisionManager.instance.remove(this);
        GameObject.remove(this);
    }

    @Override
    public void draw(Graphics graphics) {
        if(isLeft){
            animationLeft.draw(graphics,gameRect);
        } else {
            animationRight.draw(graphics,gameRect);
        }
    }

    public int getDamage() {
        return damage;
    }

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    public void shooting() {
        EnemyBullet enemyBullet = new EnemyBullet(new GameRect(this.gameRect.getX(), this.gameRect.getY(), 30, 10),
                new SpriteRender("res/bullet-left.png"));
        enemyBullet.setMoveBehavior(new MoveBehavior());
    }

    @Override
    public void update() {
        if(shootEnable){
            cooldown--;
            if (cooldown <= 0) {
                shooting();
                cooldown = 100;
            }
        }
        if (gameRect.getX() <= initPosX) {
            dx = 1;
            isLeft = false;
        } else if (gameRect.getX() >= initPosX + 700) {
            dx = -1;
            isLeft= true;
        }
        gameRect.move(dx, dy);
    }

    @Override
    public void onCollide(Collider other) {
        if (other instanceof Player) {
            ((Player) other).getHit(damage);
        }
    }
}
