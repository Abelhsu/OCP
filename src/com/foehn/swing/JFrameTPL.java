/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foehn.swing;

import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 *
 * @author FOEHN
 */
public class JFrameTPL extends JFrame {

    public JFrameTPL(){
        this.setSize(800,640);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JFrameTPL(String string) {
        this();
        this.setTitle("CNC 小幫手");
    }
}
