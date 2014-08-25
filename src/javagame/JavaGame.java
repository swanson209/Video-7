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

public class JavaGame extends JFrame implements Runnable {

    int x, y, xDirection, yDirection;
    private Image dbImage;
    private Graphics dbg;
    Image face;

    public void run() {
        try {
            while (true) {
                move();
                Thread.sleep(5);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public void move() {
        x += xDirection;
        y += yDirection;
        if (x <= 0) {
            x = 0;
        }
        if (x >= 200) {
            x = 200;
        }
        if (y <= 50) {
            y = 50;
        }
        if (y >= 200) {
            y = 200;
        }

    }

    public void setXDirection(int xdir) {
        xDirection = xdir;
    }

    public void setYDirection(int ydir) {
        yDirection = ydir;
    }

    public class AL extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == e.VK_LEFT) {
                setXDirection(-1);
            }
            if (keyCode == e.VK_RIGHT) {
                setXDirection(+1);
            }
            if (keyCode == e.VK_UP) {
                setYDirection(-1);
            }
            if (keyCode == e.VK_DOWN) {
                setYDirection(+1);
            }
        }

        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == e.VK_LEFT) {
                setXDirection(0);
            }
            if (keyCode == e.VK_RIGHT) {
                setXDirection(0);
            }
            if (keyCode == e.VK_UP) {
                setYDirection(0);
            }
            if (keyCode == e.VK_DOWN) {
                setYDirection(0);
            }
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
        JavaGame jg = new JavaGame();
        Thread t1 = new Thread(jg);
        t1.start();
    }

}
