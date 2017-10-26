package com.company.view.graphics;

import java.awt.*;

/**
 * Created by trongphuong1011 on 9/20/2017.
 */
public class SpriteRender {
        private Image image;

        public Image getImage(){
            return image;
        }

        public SpriteRender(Image image){
            this.image = image;
        }

        public SpriteRender(String path){
            this(Utils.loadImage(path));
        }

        public void render(Graphics graphics, GameRect gameRect){
                graphics.drawImage(image, gameRect.getX(),gameRect.getY(),gameRect.getWidth(),gameRect.getHeight(),null);
        }
}
