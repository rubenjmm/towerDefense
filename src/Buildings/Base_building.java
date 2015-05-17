package Buildings;

import com.company.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

/**
 * Created by Ricardo on 12/05/2015.
 */
public class Base_building {

    public int atack;
    public int posx_b,posy_b;
    public int posx,posy;

    public Time timer;
    public int atack_delay;
    public boolean first_atack= true;
    public int mob_x,mob_y;

    public Base_building () {

    }

    public Base_building(int x,int y) {

        this.posx_b=x;
        this.posy_b=y;

    }

    public void draw(Graphics g) {


    }

    public void find_target() {

        //encontrar um mob vivo

    }


    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            if(Main.getState()== Main.STATE.GAME){
                atack();
            }
        }
    };

    public void atack() {

        if( first_atack ){

            find_target();
            first_atack = false;
        }
        else {
            //atacar
            //verificar se mob continua vivo
        }

    }

    public void change_pos() {

    }




}
