package Graphic.Jogo;

import com.company.Main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Ricardo on 27/04/2015.
 */
public class Jogo_MouseInput implements MouseListener {

    @Override
    public void mousePressed(MouseEvent e) {

        int mx = e.getX();
        int my = e.getY();

        if(Main.getState() == Main.STATE.GAME) {

            //Playbutton
            if (mx >= 150 && mx <= 250) {
                if (my >= 200 && my <= 250) {
                    Main.setState('G');
                    //f.setVisible(false);
                    //f.dispose();
                }
            }

            //helpButton
            if (mx >= 400 && mx <= 500) {
                if (my >= 200 && my <= 250) {

                }
            }
            //closeButton
            if (mx >= 650 && mx <= 750) {
                if (my >= 200 && my <= 250) {
                    //System.exit(0);
                }
            }

            //loadButton
            if (mx >= 280 && mx <= 380) {
                if (my >= 300 && my <= 350) {

                }
            }
            //saveButton
            if (mx >= 530 && mx <= 630) {
                if (my >= 300 && my <= 350) {

                }
            }


            //optionsButton
            if (mx >= 400 && mx <= 530) {
                if (my >= 400 && my <= 450) {

                }
            }
        }

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
