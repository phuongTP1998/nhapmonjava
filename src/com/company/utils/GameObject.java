package com.company.utils;

import com.company.controller.Collider;
import com.company.controller.Controller;

import java.awt.*;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * Created by trongphuong1011 on 9/20/2017.
 */
public class GameObject extends Controller implements Collider {
    protected GameRect gameRect;
    protected SpriteRender spriteRender;
    static boolean clear = false;

    private static List<GameObject> gameObjects;

    static{
        gameObjects = new Vector<>();
    }

    public static void setClear(boolean clear){
        GameObject.clear = clear;
    }

    public boolean contains(int x, int y){
        return this.gameRect.contains(x,y);
    }

    public GameObject(GameRect gameRect,SpriteRender spriteRender){
        this.gameRect = gameRect;
        this.spriteRender = spriteRender;
        gameObjects.add(this);
    }

    public static void updateAll(){
        if(clear == true){
            Iterator<GameObject> iterator = gameObjects.iterator();
            while(iterator.hasNext()){
                GameObject gameObject = iterator.next();
                iterator.remove();
            }
        }

        for(int i=0;i < gameObjects.size();i++){
            gameObjects.get(i).update();
        }

        for(GameObject gameObject : gameObjects){
            gameObject.lateUpdate();
        }
    }

    public static void remove(GameObject gameObject){
            if(gameObject.getGameRect().isDead()){
                gameObjects.remove(gameObject);
            }
        }

    public static void drawAll(Graphics graphics){
        for(int i=0; i<gameObjects.size();i++){
            gameObjects.get(i).draw(graphics);
        }
    }

    public static GameObject objectAt(int x, int y) {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.contains(x, y)) {
                return gameObject;
            }
        }
        return null;
    }

    public void draw(Graphics graphics){spriteRender.render(graphics,gameRect);}

    public void update(){}

    public void lateUpdate(){

    }

    public GameRect getGameRect(){
        return gameRect;
    }

    @Override
    public void onCollide(Collider other) {

    }
}
