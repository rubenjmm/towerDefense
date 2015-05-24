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

    //////////////////////////////////////
    public int declivex,declivey;/////////
    //////////////////////////////////////
    public int bullet_speed;

    public Base_atack() {

    }

    public Base_atack(ArrayList<BufferedImage> Lista,int x, int y,int speed,int  bullet_spd) {

        this.pos_building_x = x;
        this.pos_building_y = y;
        this.Listatack = Lista;
        this.bullet_speed=bullet_spd;

        ////////////////
        this.posx=x+30;////
        this.posy=y+30;////
        ////////////////

        ani_atack = new Animator(Listatack);
        ani_atack.setSpeed(speed);//150ms
    }

    public void shot_fired  (int index ) {

        this.mob_index = index;

        posx =pos_building_x+30;
        posy =pos_building_y+30;

        mob_x = Main.getGame_logic().getMobs()[mob_index].getPosx();
        mob_y = Main.getGame_logic().getMobs()[mob_index].getPosy();

        mob_hited = false;
        ani_atack.play();
    }

    public void draw(Graphics g) {

        if(!mob_hited) {
            System.out.println("entrei..");

            g.drawImage(ani_atack.getSprite(), posx, posy, 5, 5, null); //width & height
            ani_atack.update(System.currentTimeMillis());
            check_mob_hited();
            update_pos();
        }
    }

    public void update_pos(){

        //    X
        if( posx > mob_x) { //mob está à esquerda
            posx-= bullet_speed;
        }
        else if ( posx < mob_x) {
            posx+=bullet_speed;
        }


        //    Y
        if( posy > mob_y) {
            posy-=bullet_speed;
        }
        else if ( posy < mob_y) {
            posy+=bullet_speed;
        }

    }

    public void check_mob_hited() {

        if(    Math.abs(posx -mob_x)<=bullet_speed  && Math.abs(posy -mob_y)<=bullet_speed ) {
            mob_hited = true;
            ani_atack.stop();
            posx=0;
            posy=0;
            System.out.println("entrei..");
        }
    }

}
