package com.company.controller.collide;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by trongphuong1011 on 9/20/2017.
 */
public class ControllerManager {
    private ArrayList<Controller> controllers;
    private boolean clear = false;

    public static final ControllerManager instance = new ControllerManager();

    private ControllerManager(){ controllers = new ArrayList<>();}

    public void add(Controller controller){ controllers.add(controller);}

    public void draw(Graphics graphics){
        for(int i=0; i < controllers.size();i++){
            Controller controller = controllers.get(i);
            controller.draw(graphics);
        }
    }
    public void remove(Controller controller){
        controllers.remove(controller);
    }

    public void update(){
        if(clear == true){
            Iterator<Controller> iterator = controllers.iterator();
            while ((iterator.hasNext())) {
                Controller controller = iterator.next();
                iterator.remove();
            }
        }
        Iterator<Controller> iterator = controllers.iterator();
        while(iterator.hasNext()){
            Controller controller = iterator.next();
            if(controller.getGameRect().isDead()){
                iterator.remove();
            }
        }
        for(int i=0;i<controllers.size();i++){
            controllers.get(i).update();
        }
    }
}
