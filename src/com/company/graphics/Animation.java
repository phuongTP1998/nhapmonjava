package com.company.graphics;

import com.company.utils.GameRect;

import java.awt.*;
import java.awt.List;
import java.util.*;

/**
 * Created by trongphuong1011 on 10/13/2017.
 */
public class Animation {
    private java.util.List<Image> images;
    private int imageIndex = 0;
    private int interval=10;
    private int time;

    private boolean isOneTime;
    private boolean hasEnded;

    public Animation(java.util.List<Image> images, int interval, boolean isOneTime) {
        this.images = images;
        this.interval=interval;
        this.isOneTime=isOneTime;
    }
    public Animation(java.util.List<Image> images) {
        this(images,5,false);
    }

    public Animation(java.util.List<Image> images, boolean isOneTime) {
        this(images,5, isOneTime);
    }

    public void draw(Graphics graphics, GameRect gameRect) {
        time++;
        if(time>=interval){
             time=0;
            imageIndex++;
            if(imageIndex >= images.size()){
                 if(isOneTime){
                    hasEnded=true;
                }
                imageIndex=0;
            }
        }
        if(isOneTime&&hasEnded){
            return;
        }
        graphics.drawImage(images.get(imageIndex),gameRect.getX(),gameRect.getY(),null);
    }
}
