package com.fraserbrooks.game.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import com.fraserbrooks.game.state.State;
import com.fraserbrooks.game.state.LoadState;
import com.fraserbrooks.framework.util.InputHandler;

@SuppressWarnings("serial")
public class Game extends JPanel implements Runnable{
    
    private int gameWidth;
    private int gameHeight;
    private Image gameImage;
    
    private volatile State currentState;
    
    private InputHandler inputHandler;
    
    private Thread gameThread;
    private volatile boolean running;
    
    
    
    public Game(int gameWidth, int gameHeight){
        this.gameWidth = gameWidth;
        this.gameHeight = gameHeight;
        setPreferredSize(new Dimension(gameWidth, gameHeight));
        setBackground(Color.BLACK);
        setFocusable(true);
        requestFocus();
        
    }
    
    public void setCurrentState(State newState){
        System.gc();
        newState.init();
        currentState = newState;
        inputHandler.setCurrentState(newState);
    }
    
    @Override
    public void addNotify(){
        super.addNotify();
        initInput();
        setCurrentState(new LoadState());
        initGame();
    }
    
    private void initGame(){
        running = true;
        gameThread = new Thread(this, "Game Thread");
        gameThread.start();
    }

    @Override
    public void run() {
        
        long updateDuration = 0; // measures both update and render
        long sleepDuration = 0; // this and update should sum to 17 on each iteration
        
        while (running){
            long beforeUpdate = System.nanoTime();
            long deltaMillis = updateDuration + sleepDuration;
            
            updateAndRender(deltaMillis);
            
            updateDuration = (System.nanoTime() - beforeUpdate) / 1000000L;
            sleepDuration = Math.max(2, 17 - updateDuration);
            
            try {
                Thread.sleep(sleepDuration);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            
        }
        
        //End game when running is False
        System.exit(0);
    }

    private void updateAndRender(long deltaMillis) {
        // convert to seconds to allow denotion in pixels per second
        currentState.update(deltaMillis / 1000f); 
        //Double Buffering (reduce tearing)
        prepareGameImage();
        currentState.render(gameImage.getGraphics());
        renderGameImage(getGraphics());
    }
    
    public void exit(){
        running = false;
    }

    private void prepareGameImage() {
        if (gameImage == null){
            gameImage = createImage(gameWidth, gameHeight);
        }
        Graphics g = gameImage.getGraphics();
        //clear previous frame
        g.clearRect(0, 0, gameWidth, gameHeight);
    }
    
    
    private void renderGameImage(Graphics g){
        if (gameImage != null){
            g.drawImage(gameImage, 0, 0, null);
        }
        g.dispose();
    }
    
    private void initInput() {
        inputHandler = new InputHandler();
        addKeyListener(inputHandler);
        addMouseListener(inputHandler);
    }
    
    
}
