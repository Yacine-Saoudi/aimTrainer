/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aimtrainer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import javax.swing.*;

public class Target extends JButton {
    private final int xt;
    private final int yt;
    public static String path = "target.png";
    private final int finalR = 50;
    private int currentR = 30;
    private boolean max = false;
    boolean deleteNow = false;
    
    public Target() {
        Random rand = new Random();
        xt = (rand.nextInt(741) + finalR);
        yt = (rand.nextInt(521) + 50);
        
        
        setBackground(Color.lightGray);
        setFocusable(false);
        
        setPreferredSize(new Dimension(currentR, currentR));
        setContentAreaFilled(false);
        
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteNow = true;
                freePlay.score++;
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
        g.fillOval(xt-currentR/2, yt-currentR/2, currentR, currentR);

        super.paintComponent(g);
    }
    
    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(Color.darkGray);
        g.drawOval(xt-currentR/2, yt-currentR/2, currentR, currentR);
    }
    
    Shape shape;
    @Override
    public boolean contains(int x, int y) {
      // If the button has changed size,  make a new shape object.
      if (shape == null || !shape.getBounds().equals(getBounds())) {
        shape = new Ellipse2D.Float(xt-currentR/2, yt-currentR/2, currentR, currentR);
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
        return currentR;
    }
    
    public void changeRad() {
        if (currentR < finalR && !max) {
            currentR++;
        } else {
            max = true;
        }
        
        if (max && currentR > 1) {
            currentR--;
        }
        setIcon(new ImageIcon(((new ImageIcon("target.png").getImage().getScaledInstance(currentR,currentR,java.awt.Image.SCALE_SMOOTH)))));
    }

}