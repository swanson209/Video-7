/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JavaGame extends JFrame {

    int x, y;
    private Image dbImage;
    private Graphics dbg;
    Image face;
    Font font = new Font("Arial", Font.BOLD | Font.ITALIC, 30);

    public class AL extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == e.VK_LEFT) {
                if (x <= 0) {
                    x = 0;
                } else {
                    x -= 5;
                }
            }
            if (keyCode == e.VK_RIGHT) {
                if (x >= 230) {
                    x = 230;
                } else {
                    x += 5;
                }
            }
            if (keyCode == e.VK_UP) {
                if (y <= 20) {
                    y = 20;
                } else {
                    y -= 5;
                }
            }
            if (keyCode == e.VK_DOWN) {
                if (y >= 230) {
                    y = 230;
                } else {
                    y += 5;
                }
            }
        }

        public void keyReleased(KeyEvent e) {

        }
    }

    public JavaGame() {
        // load images
        ImageIcon i = new ImageIcon("C:/Users/DaSammich/Desktop/snowball.jpg");
        face = i.getImage();
        // game properties
        addKeyListener(new AL());
        setTitle("Java Game");
        setSize(250, 250);
        setResizable(false);
        setVisible(true);
        setBackground(Color.CYAN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        x = 150;
        y = 150;
    }

    public void paint(Graphics g) {
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage, 0, 0, this);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.red);
        g.drawImage(face, x, y, this);
        repaint();
    }

    public static void main(String[] args) {
        new JavaGame();
    }

}
