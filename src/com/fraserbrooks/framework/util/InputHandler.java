package com.fraserbrooks.framework.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.fraserbrooks.game.state.State;

public class InputHandler implements KeyListener, MouseListener {
    
    private State currentState;
    
    public void setCurrentState(State s){
        this.currentState = s;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        currentState.onClick(e);
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // Nothing
        
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // Nothing
        
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // Nothing
        
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // Nothing
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        currentState.onKeyPress(e);
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        currentState.onKeyRelease(e);
        
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // Nothing
        
    }

}
