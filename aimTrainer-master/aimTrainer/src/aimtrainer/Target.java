/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aimtrainer;

import java.util.Random;
import javax.swing.*;

public class Target {
    private final int x;
    private final int y;
    public static String path = "target.png";
    private int radius = 0;
    
    public Target() {
        Random rand = new Random();
        x = rand.nextInt(761) + 20;
        y = rand.nextInt(361) + 20;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getRadius() {
        return radius++;
    }
    
    //public JLabel returnLabel(){
        
    //}
    
}
