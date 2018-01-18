package com.fraserbrooks.framework.util;

import java.util.Random;

public class RandomNG {
    
    private static Random rand = new Random();
    
    public  static int randR(int lowerBound, int upperBound){
        return rand.nextInt(upperBound - lowerBound) + lowerBound;
    }
    
    public static int getRandInt(int upperBound){
        return rand.nextInt(upperBound);
    }
    
}
