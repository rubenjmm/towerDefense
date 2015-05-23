package Buildings;

import Enemys.Monster1_sprites;
import Graphic.Jogo.Animator;
import com.company.Main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Ricardo on 23/05/2015.
 */
public class Base_atack  {


    public int pos_building_x,pos_building_y;
    public int mob_x,mob_y;
    public int mob_index;
    public ArrayList<BufferedImage> Listatack;
    public boolean mob_hited = false;
    public Animator ani_atack;

    public int posx;
    public int posy;

    public Base_atack() {

    }

    public Base_atack(ArrayList<BufferedImage> Lista,int x, int y,int speed) {

        this.pos_building_x = x;
        this.pos_building_y = y;
        this.Listatack = Lista;

        ////////////////
        this.posx=x+30;////
        this.posy=y+30;////
        ////////////////

        ani_atack = new Animator(Listatack);
        ani_atack.setSpeed(speed);//150ms
    }

    public void shot_fired  (int mob_index ) {

        this.mob_index = mob_index;

        posx =pos_building_x+30;
        posy =pos_building_y+30;

        mob_x = Main.getGame_logic().getMobs()[mob_index].getPosx();
        mob_y = Main.getGame_logic().getMobs()[mob_index].getPosy();

        mob_hited = false;
    }

    public void draw(Graphics g) {

        if(!mob_hited) {
            g.drawImage(ani_atack.getSprite(), posx, posy, 5, 5, null); //width & height
            ani_atack.update(System.currentTimeMillis());
            check_mob_hited();
            update_pos();
        }
    }

    public void update_pos(){

        //    X
        if( posx > mob_x) { //mob está à esquerda
            posx-= 15;
        }
        else if ( posx < mob_x) {
            posx+=15;
        }


        //    Y
        if( posy > mob_y) {
            posy-=15;
        }
        else if ( posy < mob_y) {
            posy+=15;
        }

    }

    public void check_mob_hited() {

        if( posx == mob_x && posy==mob_y) {
            mob_hited = true;
        }
    }

}
