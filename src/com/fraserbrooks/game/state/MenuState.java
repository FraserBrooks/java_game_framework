package com.fraserbrooks.game.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.fraserbrooks.game.main.Resources;

public class MenuState extends State {

    @Override
    public void init() {
        System.out.println("Entered Menu State");
    }

    @Override
    public void update(float delta) {
        // Do Nothing

    }

    @Override
    public void render(Graphics g) {
        //Draw welcome screen
        g.drawImage(Resources.welcome, 0, 0, null);
    }

    @Override
    public void onClick(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onKeyPress(KeyEvent e) {
        // Intentionally Ignored

    }

    @Override
    public void onKeyRelease(KeyEvent e) {
        // Intentionally Ignored

    }

}
