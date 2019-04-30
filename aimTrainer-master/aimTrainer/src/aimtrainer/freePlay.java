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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class freePlay extends JFrame {
    static List<Target> targets = new ArrayList<>();
    static JLabel lives;// = new JLabel("x "+(LIVES-missed), SwingConstants.CENTER);
    private static Timer T = new Timer();
    final static int LIVES = 3;
    static int score;
    static int missed;
    static int targetsCreated = 0;
    static String heartPath = "heart.png"; 
   
    public freePlay() {
        targets.clear();
        T = new Timer();
        missed = 0;
        lives = new JLabel("x "+(LIVES-missed), SwingConstants.CENTER);
        score = 0;
        targetsCreated = 0;
    }
 
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
    
    private void updateLives() throws InterruptedException {
        if (missed <= 3) {
            //System.out.println("Lives: " + (LIVES-missed));
            lives.setText("x "+(LIVES-missed));
        }
        if (missed == 3) {
            //System.out.println("YOU LOSE!");
            T.cancel();
            
            JLabel loseLabel = new JLabel("You lost! Score: " + score, SwingConstants.CENTER);
            String loseText = "You Lost! Score: " + score;
            loseLabel.setSize(200,100);
            loseLabel.setText("You Lost! Score: " + score + "    Closing... please wait");
            
            int stringWidth = loseLabel.getFontMetrics(loseLabel.getFont()).stringWidth(loseText);
            int componentWidth = loseLabel.getWidth();
            
            double widthRatio = (double)componentWidth / (double)stringWidth;
            int newFontSize = (int)(loseLabel.getFont().getSize() * widthRatio);
            int componentHeight = loseLabel.getHeight();
            int fontSizeToUse = Math.min(newFontSize, componentHeight);
            
            loseLabel.setFont(new Font(loseLabel.getFont().getName(), Font.PLAIN, fontSizeToUse));      
            add(loseLabel);
            
            revalidate();
            repaint();
            
            Thread.sleep(5 * 1000);
            dispose();
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
    public static void main(String args[]) throws InterruptedException {
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
        
        Image img = ((new ImageIcon(heartPath)).getImage()).getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        lives.setIcon(new ImageIcon(img));
        lives.setBounds(365, 5, 70, 20);
        freeplay.add(lives, BorderLayout.NORTH);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                freeplay.add(scoreLabel, BorderLayout.NORTH);
                scoreLabel.setSize(50,15);
                freeplay.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                freeplay.setSize(800,600);
                freeplay.setLocationRelativeTo(null);
                freeplay.setResizable(false);
                freeplay.setVisible(true);
            }
        });
        List<Target> toAdd = new ArrayList<>();
        
        class createTarget extends TimerTask {
            @Override
            public void run() {
                targetsCreated++;
                Target target = new Target();
                toAdd.add(target);
                freeplay.add(target);
                freeplay.revalidate();
                freeplay.repaint();
                //System.out.printf("Y: %d X: %d", target.getYValue(), target.getXValue());
                
                //System.out.println(targetsCreated);
                if (targetsCreated < 10) {
                    T.schedule(new createTarget(), 1200);
                } else if (targetsCreated < 20) {
                    T.schedule(new createTarget(), 1100);
                } else if (targetsCreated < 30) {
                    T.schedule(new createTarget(), 1000);
                } else if (targetsCreated < 40) {
                    T.schedule(new createTarget(), 900);
                } else if (targetsCreated < 50) {
                    T.schedule(new createTarget(), 800);
                } else if (targetsCreated < 60) {
                    T.schedule(new createTarget(), 700);
                } else if (targetsCreated < 70) {
                    T.schedule(new createTarget(), 600);
                } else if (targetsCreated < 80) {
                    T.schedule(new createTarget(), 500);
                } else if (targetsCreated < 90) {
                    T.schedule(new createTarget(), 400);
                }
            }
        }
        
        class loop extends Thread {
            public void run() {
                T = new Timer();
                createTarget timerTask = new createTarget();
                T.schedule(timerTask, 0);
                boolean lose = false;
                while (!lose) {
                    targets.addAll(toAdd);
                    toAdd.clear();
                    Iterator<Target> iter = targets.iterator();
                    List<Target> toRemove = new ArrayList<Target>();
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
                            try {
                                freeplay.updateLives();
                            } catch (InterruptedException ex) {
                                Logger.getLogger(freePlay.class.getName()).log(Level.SEVERE, null, ex);
                            }
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
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(freePlay.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        
        targets.clear();
        loop thread = new loop();
        thread.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}