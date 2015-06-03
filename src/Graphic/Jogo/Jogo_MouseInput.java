package Graphic.Jogo;

import com.Main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Ricardo on 27/04/2015.
 */
public class Jogo_MouseInput implements MouseListener,MouseMotionListener {

    @Override
    public void mouseMoved(MouseEvent e) {


        if( Main.isHelditem() ) {
            Main.setMouse_x(e.getX());
            Main.setMouse_y(e.getY());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {


        if (  Main.isHelditem() ) {
            //was dragging an item

            Main.getGame_logic().place_building(e.getX()-30,e.getY()-20, Main.getHeld_id() );

            Main.setHelditem(false);
            Main.setHeld_id(0);

            Main.setMouse_x(-5);
            Main.setMouse_y(-5);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {


    }


    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

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
