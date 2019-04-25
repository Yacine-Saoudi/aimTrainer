/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aimtrainer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Target extends JButton {
    private final int xt;
    private final int yt;
    public static String path = "target.png";
    private int radius = 50;
    JLabel label = new JLabel();
    
    public Target() {
        Random rand = new Random();
        xt = rand.nextInt(701) + 50;
        yt = rand.nextInt(501) + 50;
        label.setBounds(xt,yt,radius,radius);
        
        setBackground(Color.lightGray);
        setFocusable(false);
        
        setPreferredSize(new Dimension(radius, radius));
        setContentAreaFilled(false);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
          g.setColor(Color.gray);
        } else {
          g.setColor(getBackground());
        }
        g.fillOval(xt, yt, radius, radius);

        super.paintComponent(g);
    }
    
    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(Color.darkGray);
        g.drawOval(xt, yt, radius, radius);
    }
    
    Shape shape;
    @Override
    public boolean contains(int x, int y) {
      // If the button has changed size,  make a new shape object.
      if (shape == null || !shape.getBounds().equals(getBounds())) {
        shape = new Ellipse2D.Float(xt, yt, radius, radius);
      }
      return shape.contains(x, y);
    }
    
    public int getXValue() {
        return xt;
    }
    
    public int getYValue() {
        return yt;
    }
    
    public int getRadius() {
        return radius;
    }
    
    public void incRad() {
        radius++;
    }
    
    public JLabel getLabel1() throws IOException{
        label.setBounds(xt-radius,yt-radius,radius,radius);
        BufferedImage img = null;
        img = ImageIO.read(new File(path));
       
        Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(),
            Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(dimg);
        
        label.setIcon(image);
        
        return label;
    }
    
}
