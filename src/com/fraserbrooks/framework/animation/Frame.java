package com.fraserbrooks.framework.animation;

import java.awt.Image;

public class Frame {
    private Image image;
    private double duration;
    
    public Frame(Image image, double dur){
        this.image = image;
        this.duration = dur;
    }
    
    public Image getImage(){
        return image;
    }
    
    public double getDuration(){
        return duration;
    }
    
}
