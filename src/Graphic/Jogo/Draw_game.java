package Graphic.Jogo;

import Enemys.Zombies_1;
import Graphic.Menus.Main_Menu;
import Graphic.Menus.Main_Mouse;
import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Ricardo on 18/04/2015.
 */
public class Draw_game extends JPanel implements ActionListener {

    private Timer timer;
    private Zombies_1[] mobs = Main.getGame_logic().getMobs();

    private int WIDTH = Main.getMap().getcolunas() * 24 -10;
    private int HEIGHT = Main.getMap().getlinhas()*25   - 30;

    public Draw_game(){

        this.addMouseListener(new Main_Mouse(  Main.getFrame1()    ));
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
        Main.getGame_logic().draw_mobs(g);
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

