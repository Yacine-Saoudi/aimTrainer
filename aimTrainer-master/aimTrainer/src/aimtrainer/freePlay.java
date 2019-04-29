/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aimtrainer;

import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.util.Iterator;
import java.util.TimerTask;
import java.util.Timer;
import java.util.logging.Handler;
import javax.swing.*;


public class freePlay extends JFrame {
    static List<Target> targets = new ArrayList<>();
    private final static Timer t = new Timer();
    final static int LIVES = 3;
    static int score = 0;
    static int missed = 0;
    static int targetsCreated = 0;
   
    public freePlay() {
        //initComponents();
    }
 
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
    
    private void updateLives() {
        if (missed <= 3) {
            System.out.println("Lives: " + (LIVES-missed));
        }
        if (missed == 3) {
            System.out.println("YOU LOSE!");
            t.cancel();
            
            JLabel loseLabel = new JLabel("You lost! Score: " + score, SwingConstants.CENTER);
            add(loseLabel, BorderLayout.CENTER);
            loseLabel.setSize(50,15);
            revalidate();
            repaint();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException{
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(freePlay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(freePlay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(freePlay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(freePlay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        freePlay freeplay = new freePlay();
        JLabel scoreLabel = new JLabel();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                freeplay.add(scoreLabel, BorderLayout.NORTH);
                scoreLabel.setSize(50,15);
                freeplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                freeplay.setSize(800,600);
                freeplay.setLocationRelativeTo(null);
                freeplay.setResizable(false);
                freeplay.setVisible(true);
            }
        });
        List<Target> toAdd = new ArrayList<>();
        
        class createTarget extends TimerTask {
            //int targetsCreated = 0;
            @Override
            public void run() {
                targetsCreated++;
                Target target = new Target();
                toAdd.add(target);
                freeplay.add(target);
                freeplay.revalidate();
                freeplay.repaint();
                System.out.printf("X: %d Y: %d", target.getXValue(), target.getYValue());
                
                System.out.println(targetsCreated);
                if (targetsCreated < 10) {
                    t.schedule(new createTarget(), 1200);
                } else if (targetsCreated < 20) {
                    t.schedule(new createTarget(), 1100);
                } else if (targetsCreated < 30) {
                    t.schedule(new createTarget(), 1000);
                } else if (targetsCreated < 40) {
                    t.schedule(new createTarget(), 900);
                } else if (targetsCreated < 50) {
                    t.schedule(new createTarget(), 800);
                } else if (targetsCreated < 60) {
                    t.schedule(new createTarget(), 700);
                } else {
                    t.schedule(new createTarget(), 600);
                }
            }
        }
        
        t.schedule(new createTarget(), 0);
        
        boolean lose = false;
        while (!lose) {
            targets.addAll(toAdd);
            toAdd.clear();
            //System.out.println(targets);
            Iterator<Target> iter = targets.iterator();
            while(iter.hasNext() && !lose) {
                Target target = iter.next();
                if (target == null) {continue;}
                if (target.deleteNow) {
                    freeplay.remove(target);
                    iter.remove();
                    freeplay.revalidate();
                    freeplay.repaint();
                } else if (target.getRadius() == 1) {
                    missed++;
                    if (missed == 3) {lose = true;}
                    freeplay.updateLives();
                    freeplay.remove(target);
                    iter.remove();
                    freeplay.revalidate();
                    freeplay.repaint();
                } 
                scoreLabel.setText("Score: "+ score);
            }
            
            for (Target target : targets) {
                target.changeRad();
            }
            freeplay.validate();
            freeplay.repaint();
            Thread.sleep(20);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}