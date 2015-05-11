package Graphic.Menus;


import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Ricardo on 26/04/2015.
 */
public class Main_Menu extends JFrame {

    private Rectangle NewButton =    new Rectangle(150,200,100,50);
    private Rectangle helpButton =    new Rectangle(400,200,100,50);
    private Rectangle closeButton =   new Rectangle(650,200,100,50);

    private Rectangle loadButton =    new Rectangle(280,300,100,50);
    private Rectangle saveButton =    new Rectangle(530,300,100,50);

    private Rectangle optionsButton = new Rectangle(390,400,130,50);

    public Main_Menu() {
    }

    public void menu() {

        //pops up on escape
        Draw_menu teste= new Draw_menu(this);
        setTitle("Defend feup");

        add(teste);
        setSize(950, 550);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public class Draw_menu extends JPanel implements ActionListener {

        private ImageIcon img2;

        public Draw_menu(JFrame j) {
            this.addMouseListener(new Main_Mouse(j));
            setFocusable(true);
            addKeyListener(new Action_listener());
            img2 = new ImageIcon("Textures/background.jpg");

        }

        public void actionPerformed(ActionEvent e) {
            repaint();
        }

        public void paint(Graphics g) {

            super.paint(g);
            render(g);
        }

        public void render(Graphics g ){

            g.drawImage(img2.getImage(),0,0,null);

            Graphics2D g2d = (Graphics2D) g;

            Font fnt0 = new Font("arial",Font.BOLD,50);//titulo
            g.setFont(fnt0);
            g.setColor(Color.white);
            g.drawString("Tower Defense",290,100);

            Font fnt1 = new Font("arial",Font.BOLD,30);
            g.setFont(fnt1);
            g.drawString("New",NewButton.x+19,NewButton.y+35);
            g2d.draw(NewButton);
            g.drawString("Help",helpButton.x+19,helpButton.y+35);
            g2d.draw(helpButton);
            g.drawString(" Quit", closeButton.x+12,closeButton.y+35);
            g2d.draw(closeButton);

            g.drawString("Load", loadButton.x+17,loadButton.y + 35);
            g2d.draw(loadButton);
            g.drawString("Save", saveButton.x+16,saveButton.y+ 35);
            g2d.draw(saveButton);

            g.drawString("Options",optionsButton.x+12,optionsButton.y+35);
            g2d.draw(optionsButton);

        }

    }

    public class Action_listener extends KeyAdapter {

        public Action_listener() { }

        public void keyPressed(KeyEvent e) {

            int keycode = e.getKeyCode();

            if(Main.getState()== Main.STATE.Main_menu) {
                if (keycode == KeyEvent.VK_ESCAPE || keycode == KeyEvent.VK_BACK_SLASH) {
                    Main.setState('G');
                    setVisible(false);
                    dispose();
                }
            }
        }
    }

}
