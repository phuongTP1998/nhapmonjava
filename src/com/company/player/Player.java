package com.company.player;

import com.company.InputManager;
import com.company.controller.Collider;
import com.company.controller.CollisionManager;
import com.company.controller.Controller;
import com.company.controller.ControllerManager;
import com.company.gamescene.Level1Scene;
import com.company.graphics.Animation;
import com.company.utils.GameObject;
import com.company.utils.GameRect;
import com.company.utils.SpriteRender;
import com.company.utils.Utils;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by trongphuong1011 on 10/9/2017.
 */
public class Player extends GameObject implements Collider {

    private int dx, dy;

    private GameRect gameRect;
    private Animation animationLeft, animationRight, animationUp, animationDown;
    private Animation animationStayLeft, animationStayRight, animationStayUp, animationStayDown;
    private boolean isLeft, isRight, isUp, isDown;
    private boolean isMoved = false;
    private Image image = Utils.loadImage("res/Player/player_down2.png");
    private int mass;
    private Image hp1, avatar;
    boolean start = true;
    int playerHP = 10;
    private final int BorderHP = 645;

    public Player(GameRect gameRect, SpriteRender spriteRender, int mass) {
        super(gameRect, spriteRender);
        this.gameRect = gameRect;
        this.mass = mass;

        //TODO: đoạn này animation khi đang move
        ArrayList<Image> imagesLeft = new ArrayList<>();
        {
            imagesLeft.add(Utils.loadImage("res/Player/player_left1.png"));
            imagesLeft.add(Utils.loadImage("res/Player/player_left2.png"));
            imagesLeft.add(Utils.loadImage("res/Player/player_left3.png"));
        }
        animationLeft = new Animation(imagesLeft);
        ArrayList<Image> imagesRight = new ArrayList<>();
        {
            imagesRight.add(Utils.loadImage("res/Player/player_right1.png"));
            imagesRight.add(Utils.loadImage("res/Player/player_right2.png"));
            imagesRight.add(Utils.loadImage("res/Player/player_right3.png"));
        }
        animationRight = new Animation(imagesRight);
        ArrayList<Image> imagesUp = new ArrayList<>();
        {
            imagesUp.add(Utils.loadImage("res/Player/player_up1.png"));
            imagesUp.add(Utils.loadImage("res/Player/player_up2.png"));
            imagesUp.add(Utils.loadImage("res/Player/player_up3.png"));
        }
        animationUp = new Animation(imagesUp);
        ArrayList<Image> imagesDown = new ArrayList<>();
        {
            imagesDown.add(Utils.loadImage("res/Player/player_down1.png"));
            imagesDown.add(Utils.loadImage("res/Player/player_down2.png"));
            imagesDown.add(Utils.loadImage("res/Player/player_down3.png"));
        }
        animationDown = new Animation(imagesDown);

        //TODO: đoạn này sida hashcode

        ArrayList<Image> imagesStayUp = new ArrayList<>();
        {
            imagesStayUp.add(Utils.loadImage("res/Player/player_up2.png"));
        }
        animationStayUp = new Animation(imagesStayUp);

        ArrayList<Image> imagesStayLeft = new ArrayList<>();
        {
            imagesStayLeft.add(Utils.loadImage("res/Player/player_left2.png"));
        }
        animationStayLeft = new Animation(imagesStayLeft);

        ArrayList<Image> imagesStayDown = new ArrayList<>();
        {
            imagesStayDown.add(Utils.loadImage("res/Player/player_down2.png"));
        }
        animationStayDown = new Animation(imagesStayDown);

        ArrayList<Image> imagesStayRight = new ArrayList<>();
        {
            imagesStayRight.add(Utils.loadImage("res/Player/player_right2.png"));
        }
        animationStayRight = new Animation(imagesStayRight);
        CollisionManager.instance.add(this);
        ControllerManager.instance.add(this);
        hp1 = Utils.loadImage("res/hp1.png");
        avatar = Utils.loadImage("res/playerFace.png");
    }

    public GameRect getGameRect() {
        return gameRect;
    }

    public void getHit(int damage) {
        gameRect.setDead(true);
    }

    @Override
    public void draw(Graphics graphics) {
        if (start) {
            graphics.drawImage(image, 450, 490, null);
        }
        if (isMoved) {
            if (isLeft) {
                animationLeft.draw(graphics, gameRect);
                start = false;
            }
            if (isRight) {
                animationRight.draw(graphics, gameRect);
                start = false;
            }
            if (isDown) {
                animationDown.draw(graphics, gameRect);
                start = false;
            }
            if (isUp) {
                animationUp.draw(graphics, gameRect);
                start = false;
            }
        }
        if (!isMoved) {
            if (isLeft) {
                animationStayLeft.draw(graphics, gameRect);
            }
            if (isRight) {
                animationStayRight.draw(graphics, gameRect);
            }
            if (isDown) {
                animationStayDown.draw(graphics, gameRect);
            }
            if (isUp) {
                animationStayUp.draw(graphics, gameRect);
            }
        }

        graphics.drawImage(avatar, 30, 630, 50, 50, null);
        if (playerHP == 10) {
            graphics.drawImage(hp1, 80, BorderHP, 100, 20, null);
        }
        if (playerHP == 9) {
            graphics.drawImage(hp1, 80, BorderHP, 90, 20, null);
        }
        if (playerHP == 8) {
            graphics.drawImage(hp1, 80, BorderHP, 80, 20, null);
        }
        if (playerHP == 7) {
            graphics.drawImage(hp1, 80, BorderHP, 70, 20, null);
        }
        if (playerHP == 6) {
            graphics.drawImage(hp1, 80, BorderHP, 60, 20, null);
        }
        if (playerHP == 5) {
            graphics.drawImage(hp1, 80, BorderHP, 50, 20, null);
        }
        if (playerHP == 4) {
            graphics.drawImage(hp1, 80, BorderHP, 40, 20, null);
        }
        if (playerHP == 3) {
            graphics.drawImage(hp1, 80, BorderHP, 30, 20, null);
        }
        if (playerHP == 2) {
            graphics.drawImage(hp1, 80, BorderHP, 20, 20, null);
        }
        if (playerHP == 1) {
            graphics.drawImage(hp1, 80, BorderHP, 10, 20, null);
        }
    }

    boolean isLanded = false;

    @Override
    public void update() {
        dx = 0;
        if (gameRect.getY() <= Level1Scene.BORDER_DOWN) {
            if(!isLanded){
                gameRect.move(0, mass);
                ++mass;
                if(mass>4){
                    mass = 4;
                }
            }
        }

        if (!InputManager.getInstance().isRight()
                && !InputManager.getInstance().isLeft()
                && !InputManager.getInstance().isUp()
                && !InputManager.getInstance().isDown()) {
            isMoved = false;
        }
        if (InputManager.getInstance().isRight() && gameRect.getX() <= Level1Scene.BORDER_RIGHT) {
            gameRect.move(5, 0);
            isRight = true;
            isLeft = false;
            isDown = false;
            isUp = false;
            isMoved = true;
        }
        if (InputManager.getInstance().isLeft() && gameRect.getX() >= Level1Scene.BORDER_LEFT) {
            gameRect.move(-5, 0);
            isLeft = true;
            isRight = false;
            isDown = false;
            isUp = false;
            isMoved = true;
        }
//        if (InputManager.getInstance().isDown() && gameRect.getY() <= Level1Scene.BORDER_DOWN) {
//            gameRect.move(0, 3);
//            isRight = false;
//            isLeft = false;
//            isDown = true;
//            isUp = false;
//            isMoved = true;
//        }
        if (InputManager.getInstance().isUp() && gameRect.getY() >= Level1Scene.BORDER_UP) {
            gameRect.move(0, -5);
            isRight = false;
            isLeft = false;
            isDown = false;
            isUp = true;
            isMoved = true;
            mass =1;
        }
    }
    private int damage = 1;

    @Override
    public void onCollide(Collider other) {
        if (other instanceof EnemyBullet) {
            ((EnemyBullet) other).getHit(damage);
            playerHP = playerHP - 1;
        }
        if (other instanceof EnemyController) {
            ((EnemyController) other).getHit(damage);
            playerHP = playerHP - 1;
        }
    }
}
