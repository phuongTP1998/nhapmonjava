package com.company;

import com.company.controller.ControllerManager;
import com.company.gamescene.GameScene;
import com.company.gamescene.Level1Scene;
import com.company.utils.GameObject;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

/**
 * Created by trongphuong1011 on 9/20/2017.
 */
public class GameWindow extends Frame {
    BufferedImage bufferedImage;
    Graphics bufferedGraphics;

    InputManager inputManager;
    GameScene currentScene;
    public static GameWindow instance;

    public void setCurrentScene(GameScene currentScene){ this.currentScene = currentScene; }

    public GameWindow() {
        setVisible(true);
        setSize(1000, 700);
        inputManager = new InputManager();
        instance = this;
        currentScene = new Level1Scene();

        bufferedImage = new BufferedImage(1000, 700, BufferedImage.TYPE_INT_ARGB);
        bufferedGraphics = bufferedImage.getGraphics();

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                currentScene.KeyPressed(e);
                inputManager.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                currentScene.KeyReleased(e);
                inputManager.keyReleased(e);
            }
        });

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(17);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    GameObject.updateAll();
                    currentScene.update();
                    ControllerManager.instance.update();
                    repaint();
                }
            }
        });
        thread.start();
    }

    @Override
    public void update(Graphics g) {
        currentScene.draw(bufferedGraphics);
//        GameObject.drawAll(bufferedGraphics);
        ControllerManager.instance.draw(bufferedGraphics);
        g.drawImage(bufferedImage,0,0,null);
    }
}