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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    boolean deleteNow = false;
    
    public Target() {
        Random rand = new Random();
        xt = rand.nextInt(701) + 50;
        yt = rand.nextInt(501) + 50;
        
        setBackground(Color.lightGray);
        setFocusable(false);
        
        setPreferredSize(new Dimension(radius, radius));
        setContentAreaFilled(false);
        
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteNow = true;
            }
        });
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

}
