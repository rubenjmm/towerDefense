package Graphic.Menus;

import com.company.Main;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Ricardo on 27/04/2015.
 */
public class Main_Mouse implements MouseListener,MouseMotionListener {

    private JFrame f;

    public Main_Mouse(JFrame frame) {

        this.f = frame;
    }

    @Override
    public void mousePressed(MouseEvent e) {

        int mx = e.getX();
        int my = e.getY();

            //NewButton
            if (mx >= 150 && mx <= 250) {
                if (my >= 200 && my <= 250) {
                    newButton();
                }
            }

            //helpButton
            if (mx >= 400 && mx <= 500) {
                if (my >= 200 && my <= 250) {
                    helpButton();
                }
            }
            //closeButton
            if (mx >= 650 && mx <= 750) {
                if (my >= 200 && my <= 250) {
                    closebutton();
                }
            }

            //loadButton
            if (mx >= 280 && mx <= 380) {
                if (my >= 300 && my <= 350) {
                    loadButton();
                }
            }
            //saveButton
            if (mx >= 530 && mx <= 630) {
                if (my >= 300 && my <= 350) {
                    saveButton();
                }
            }


            //optionsButton
            if (mx >= 400 && mx <= 530) {
                if (my >= 400 && my <= 450) {
                    optionsButton();
                }
            }

    }

    public void newButton() {

        Main.getFrame1().close();
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

    }

    public void saveButton() {

    }

    public void loadButton() {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    public JFrame getF() {
        return f;
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void setF(JFrame f) {
        this.f = f;
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
