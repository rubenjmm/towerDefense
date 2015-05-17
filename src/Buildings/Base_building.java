package Buildings;

import com.company.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.Time;
import java.util.Random;
import java.util.Timer;

/**
 * Created by Ricardo on 12/05/2015.
 */
public class Base_building {

    public int atack=0;
    public int posx_b,posy_b;
    public int posx,posy;

    public  int contador=0;
    public long time=0;

    public Time timer;
    public int atack_delay; // em ms
    public boolean atacking = false;
    public boolean first_atack= true;
    public int mob_x,mob_y;
    public int mob_index,mob_type;

    public Base_building () {

    }

    public BufferedImage img1;
    public BufferedImage img2;

    public Base_building(int x,int y) {

        this.posx_b=x;
        this.posy_b=y;

        posx = posx_b *24;
        posy = posy_b *25;

        inic() ;
    }

    public void inic() {

        //timer = new Timer( atack_delay ,actionListener);
        //timer.start();
    }

    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            if(Main.getState()== Main.STATE.GAME){
                atack();
            }
        }
    };

    public void draw(Graphics g) {

        //a cada 8 iterações verificar a posicao relativa do mob face à torre
        if( contador++ > 8){
            contador=0;
            verify_pos();
        }

        if(!atacking) {
            g.drawImage(img1,posx,posy,70,70,null );
        }
        else {
            g.drawImage(img2,posx,posy,70,70,null );
            if( System.currentTimeMillis() - time > 150){ //ao fim de 150ms
                time = 0;
                atacking=false;
            }
        }
    }

    public void find_target() {

        Random r = new Random();
        int num = r.nextInt(2);


        //ALTERAR AS VARIRÁVEIS   index E type
        if(num==1) {
            for (int i = 0; i < Main.getGame_logic().getMobs_tipo1().length ; i++) {
                if (  Main.getGame_logic().getMobs_tipo1()[i].isInGame() &&  !Main.getGame_logic().getMobs_tipo1()[i].is_dead            ) {
                    mob_index = i;
                    mob_type = num;
                    break;
                }
            }
        }
        else {
            for (int i = 0; i < Main.getGame_logic().getMobs_tipo2().length ; i++) {
                if (  Main.getGame_logic().getMobs_tipo2()[i].isInGame() &&  !Main.getGame_logic().getMobs_tipo2()[i].is_dead            ) {
                    mob_index = i;
                    mob_type = num;
                    break;
                }
            }
        }



    }

    public void atack() {

        if( first_atack ){
            find_target();
            first_atack = false;
        }
        else {
            atacking = true;
            time = System.currentTimeMillis();
            if(mob_type==1) {
                if( Main.getGame_logic().getMobs_tipo1()[mob_index].change_life( atack )) { //mob morreu
                    find_target();
                }
            }
            else {
                if( Main.getGame_logic().getMobs_tipo1()[mob_index].change_life( atack )) { //mob morreu
                    find_target();
                }
            }

        }

    }

    public void verify_pos() {

        //if( )
        change_pos();
    }

    public void change_pos() {

        //verificar posição relativa
    }


}
