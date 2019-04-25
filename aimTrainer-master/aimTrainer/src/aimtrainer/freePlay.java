/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aimtrainer;

import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.*;


public class freePlay extends JPanel {
    static List<Target> targets = new ArrayList<>();
   
    public freePlay() {
        initComponents();
        Target b = new Target();
        /*b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerfomed(java.awt.event.ActionEvent e) {
                
            }
        });*/
        
        add(b);
    }

    public void createTarget() {
        targets.add(new Target());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame freeplay = new JFrame();
                //freeplay.createTarget();
                //Target b = new Target();
                        
                //freeplay.add(b);
                freeplay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                freeplay.setSize(800,600);
                freeplay.add(new freePlay());
                freeplay.setResizable(false);
                freeplay.setVisible(true);
            }
        });
        /*while(true) {
            Timer t = new Timer();
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                   // add new target on screen every 5 seconds
                }
            }, 0, 5000);
        }*/
        //freeplay.createTarget();
        //freeplay.add(targets.get(0));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
