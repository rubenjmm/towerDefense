package Graphic.Menus;

import Graphic.Jogo.Config;
import Load_Save.Load_save;
import com.Main;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Class que gere acções do rato no ecra principal
 */
public class Inic_Mouse implements MouseListener,MouseMotionListener {

    private JFrame f;

    public Inic_Mouse(JFrame frame) {

        this.f = frame;
    }

    @Override
    public void mousePressed(MouseEvent e) {

        int mx = e.getX();
        int my = e.getY();

        if(Main.getState() == Main.STATE.Inic_menu) {

            //Newbutton
            if (mx >= 150 && mx <= 250) {
                if (my >= 200 && my <= 250) {
                    newButton();
                }
            }

            //helpButton
            if (mx >= 400 && mx <= 500) {
                if (my >= 220 && my <= 270) {
                    helpButton();
                }
            }
            //closeButton
            if (mx >= 650 && mx <= 750) {
                if (my >= 220 && my <= 270) {
                    closebutton();
                }
            }

            //loadButton
            if (mx >= 280 && mx <= 380) {
                if (my >= 350 && my <= 400) {
                    loadButton();
                }
            }

            //optionsButton
            if (mx >= 510 && mx <= 640) {
                if (my >= 350 && my <= 400) {
                    optionsButton();
                }
            }

        }

    }

    public void newButton() {
        Main.new_game();
        f.setVisible(false);
        f.dispose();
    }

    public void helpButton() {

    }

    public void closebutton() {
        System.exit(0);
    }

    public void optionsButton() {

        Config configurations = new Config();
    }

    public void loadButton() {

        Load_save load_g = new Load_save();

        load_g.openFile();
        load_g.readFile();
        load_g.closeFile();
        f.dispose();
    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    public void setF(JFrame f) {
        this.f = f;
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public JFrame getF() {
        return f;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }






}
