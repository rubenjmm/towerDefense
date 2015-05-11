package Graphic.Menus;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


/**
 * Created by Ricardo on 28/04/2015.
 */
public class Inic_Menu extends JFrame{

    //private static JFrame f = this;

    private Rectangle NewButton =    new Rectangle(150,220,100,50);
    private Rectangle helpButton =    new Rectangle(400,220,100,50);
    private Rectangle closeButton =   new Rectangle(650,220,100,50);

    private Rectangle loadButton =    new Rectangle(280,350,100,50);

    private Rectangle optionsButton = new Rectangle(510,350,130,50);

    public Inic_Menu() {
    }

    public void begin() {

        //pops up on escape
        Draw_Inic_Menu teste = new Draw_Inic_Menu(this);
        //f = new JFrame();
        setTitle("Defend feup");


        add(teste);
        setSize(950, 550);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    public class Draw_Inic_Menu extends JPanel {

        private ImageIcon img2;

        public Draw_Inic_Menu(JFrame j) {
            this.addMouseListener(new Inic_Mouse(j));
            setFocusable(true);
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

            g.drawString("Options",optionsButton.x+12,optionsButton.y+35);
            g2d.draw(optionsButton);

        }

    }

}
