/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disperindag.widget;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

/**
 *
 * @author Alvin
 */
public class Button extends JButton{
    
    private boolean over;
    private boolean press;
    
    public Button() {
        super();
        setFont(new Font("tahoma", Font.PLAIN, 14));
        setForeground(Color.BLACK);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        
        setOver(false);
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                setOver(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setOver(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setPress(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setPress(false);
            }
        });
    }
    
    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
        repaint();
    }

    public boolean isPress() {
        return press;
    }

    public void setPress(boolean press) {
        this.press = press;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Color light = new Color(117, 128, 44, 127);
        Color dark  = new Color(255, 255, 255, 255);

        GradientPaint paint = null;

        if (over) {
            if (press) {
                paint = new GradientPaint(0, 0, light, 0, getHeight(), light);
            } else {
                paint = new GradientPaint(0, 0, dark, 0, getHeight(), light);
            }
        } else {
            paint = new GradientPaint(0, 0, light, 0, getHeight(), dark);
        }

        RoundRectangle2D.Double kotak = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(paint);
        g2.fill(kotak);
        
        super.paintComponent(g);
    }
}
