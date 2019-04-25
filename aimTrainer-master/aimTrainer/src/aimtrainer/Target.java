/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aimtrainer;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Target {
    private final int x;
    private final int y;
    public static String path = "target.png";
    private int radius = 0;
    JLabel label = new JLabel();
    
    public Target() {
        Random rand = new Random();
        x = rand.nextInt(761) + 20;
        y = rand.nextInt(561) + 20;
        label.setBounds(x,y,radius,radius);
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
    
    public void incRad() {
        radius++;
    }
    
    public JLabel getLabel() throws IOException{
        label.setBounds(x-radius,y-radius,radius,radius);
        BufferedImage img = null;
        img = ImageIO.read(new File(path));
       
        Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(),
            Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(dimg);
        
        label.setIcon(image);
        
        return label;
    }
    
}
