package Graphic.Jogo;


import com.company.Main;

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
        int cnt=0;

        if(mx>= 25&& mx<= 75) {
            if(my>= 50 && my<= 100){
                Main.getLoja().setFlag(1);
                cnt=1;
            }
        }


        if(mx>= 25&& mx<= 75) {
            if(my>= 110 && my<= 160 ){
                Main.getLoja().setFlag(2);
                cnt=1;
            }
        }

        if(mx>= 25&& mx<= 75) {
            if(my>= 170 && my<= 220){
                Main.getLoja().setFlag(3);
                cnt=1;
            }
        }

        if(mx>= 25&& mx<= 75) {
            if(my>= 230 && my<= 280){
                Main.getLoja().setFlag(4);
                cnt=1;
            }
        }

        if(mx>= 25&& mx<= 75) {
            if(my>= 290 && my<= 340){
                Main.getLoja().setFlag(5);
                cnt=1;
            }
        }

        if(cnt == 0) {
            Main.getLoja().setFlag(0);
        }

        //Main.getLoja().hightlight();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
/*
        int mx = e.getX();
        int my = e.getY();

        if(mx>= 25&& mx<= 75) {
            if( (my>= 50 && my<= 100 )  ||   (my>= 110 && my<= 160)    ||    (my>= 230 && my<= 280)      ||     (my>= 290 && my<= 340)   ){
                Main.getLoja().setFlag(0);
                System.out.println("EXITEDS");
            }
        }
*/
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        int mx = e.getX();
        int my = e.getY();
        int cnt=0;

        if(mx>= 25&& mx<= 75) {
            if(my>= 50 && my<= 100){
                Main.getLoja().setFlag(1);
                cnt=1;
            }
        }

    }


    @Override
    public void mouseDragged(MouseEvent e) {

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
