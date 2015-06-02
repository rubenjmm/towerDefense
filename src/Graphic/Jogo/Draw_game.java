package Graphic.Jogo;

import Buildings.Building1_sprites;
import Graphic.Menus.Main_Menu;
import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Ricardo on 18/04/2015.
 */
public class Draw_game extends JPanel implements ActionListener {

    private Timer timer;

    private int WIDTH = Main.getMap().getcolunas() * 24 -10;
    private int HEIGHT = Main.getMap().getlinhas()*25   - 30;

    private BufferedImage Building1 = Building1_sprites.getA11();

    public Draw_game(){

        this.addMouseMotionListener(new Jogo_MouseInput() );
        this.addMouseListener(new Jogo_MouseInput());

        this.timer = new Timer(25, this);
        this.timer.start();

        setPreferredSize(new Dimension(WIDTH,HEIGHT));


        addKeyListener(new Action_listener());
        setFocusable(true);

    }

    public void actionPerformed(ActionEvent e) {

        repaint();
    }

    public void paint(Graphics g){

        super.paint(g);
        setBackground(Color.darkGray);
        Main.getMap().draw_board(g);
        Main.getGame_logic().draw(g);
        draw_build_drag(g);
    }


    private void draw_build_drag(Graphics g)  {


        if( Main.isHelditem() ){
            int id =  Main.getHeld_id();
            int posx =Main.getMouse_x();
            int posy =Main.getMouse_y();

            if( id == 1) {
                int r = Main.getOptions().getRaio_b1(); //raio de alcance
                g.drawImage(Building1,posx-35 , posy-33, 70, 70, null);
                r=r*2;
                g.drawOval(posx-r/2, posy -r/2, r, r);
            }
        }
    }

    public class Action_listener extends KeyAdapter {

        public Action_listener() { }

        public void keyPressed(KeyEvent e) {

            int keycode = e.getKeyCode();
            if(Main.getState()== Main.STATE.GAME) {
                if (keycode == KeyEvent.VK_ESCAPE || keycode == KeyEvent.VK_BACK_SLASH) {
                    Main.setState('M');
                    Main_Menu n = new Main_Menu();
                    n.menu();
                }
            }
        }
    }

}

