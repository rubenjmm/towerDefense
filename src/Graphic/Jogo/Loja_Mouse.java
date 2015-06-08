package Graphic.Jogo;


import com.Main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Ricardo on 29/04/2015.
 */
public class Loja_Mouse implements MouseListener,MouseMotionListener{

    @Override
    public void mouseMoved(MouseEvent e) {

        int mx = e.getX();
        int my = e.getY();

        if(mx>= 25&& mx<= 75) {

            if (my >= 50 && my <= 100) {
                Main.getLoja().setFlag(1);
            } else if (my >= 110 && my <= 160) {
                Main.getLoja().setFlag(2);
            } else if (my >= 170 && my <= 220) {
                Main.getLoja().setFlag(3);
            } else if (my >= 230 && my <= 280) {
                Main.getLoja().setFlag(4);
            } //else if (my >= 290 && my <= 340) {
              //  Main.getLoja().setFlag(5);
            //}
            else {
                Main.getLoja().setFlag(0);
            }
        }
        else {
            Main.getLoja().setFlag(0);
        }

    }


    @Override
    public void mouseClicked(MouseEvent e) {

        int mx = e.getX();
        int my = e.getY();
        int coins = Main.getLoja().getCoins();

        if(mx>= 25&& mx<= 75) {

            if (my >= 50 && my <= 100 && coins>= Main.getOptions().getBuilding1Price()) {
                Main.setHelditem(true);
                Main.setHeld_id(1);
            } else if (my >= 110 && my <= 160 && coins>= Main.getOptions().getBuilding2Price()) {
                Main.setHelditem(true);
                Main.setHeld_id(2);
            } else if (my >= 170 && my <= 220 && coins>= Main.getOptions().getBuilding3Price()) {
                Main.setHelditem(true);
                Main.setHeld_id(3);
            } else if (my >= 230 && my <= 280 && coins>= Main.getOptions().getBuilding4Price()){
                Main.setHelditem(true);
                Main.setHeld_id(4);
            } //else if (my >= 290 && my <= 340) {
                //Main.setHelditem(true);
                //Main.setHeld_id(5);
            //}
            else {
                Main.setHelditem(false);
                Main.setHeld_id(0);
            }
        }
        else {
            Main.setHelditem(false);
            Main.setHeld_id(0);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        //mouseClicked(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //mouseClicked(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {


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