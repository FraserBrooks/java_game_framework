package com.fraserbrooks.game.main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Resources {
    
    public static BufferedImage welcome, iconimage;
    
    public static void load() {
        welcome = loadImage("welcome.png");
        iconimage = loadImage("iconimage.png");
    }

    public static AudioClip loadSound(String filename) {
        URL fileURL = Resources.class.getResource("/resources/" + filename);
        return Applet.newAudioClip(fileURL);
    }

    public static BufferedImage loadImage(String filename) {
        BufferedImage img = null;

        try {
            img = ImageIO.read(Resources.class.getResourceAsStream("/resources/" + filename));
        } catch (IOException e) {
            System.err.println("Error while reading image file: /resources/" + filename);
            e.printStackTrace();
        }

        return img;
    }
    
    

}
