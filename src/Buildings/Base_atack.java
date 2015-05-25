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


    public int bullet_speed;
    //////////////////////////////////////
    public float speed_x,speed_y;/////////
    //////////////////////////////////////


    public Base_atack() {

    }

    public Base_atack(ArrayList<BufferedImage> Lista,int x, int y,int speed,int  bullet_spd) {

        this.pos_building_x = x;
        this.pos_building_y = y;
        this.Listatack = Lista;
        this.bullet_speed=bullet_spd;

        ////////////////
        this.posx=x+15;////
        this.posy=y+30;////
        ////////////////

        ani_atack = new Animator(Listatack);
        ani_atack.setSpeed(speed);//150ms
    }

    public void shot_fired  (int index ) {

        this.mob_index = index;

        posx =pos_building_x+15;
        posy =pos_building_y+30;

        mob_x = Main.getGame_logic().getMobs()[mob_index].getPosx();
        mob_y = Main.getGame_logic().getMobs()[mob_index].getPosy();

        calcular_declive();

        mob_hited = false;
        ani_atack.play();


    }

    public void calcular_declive() {

        int distancia_x,distancia_y;

        distancia_x =  (pos_building_x - mob_x)  ;
        distancia_y =  (pos_building_y - mob_y)  ;


        if( Math.abs(distancia_x) > Math.abs(distancia_y)+bullet_speed) {
            speed_x = bullet_speed;

            //o mais pequeno a dividir pelo maior, para ser sempre menor do que 1
            speed_y = bullet_speed*distancia_y/Math.abs(distancia_x);


            if( distancia_y < 0) {
                speed_y = speed_y*(-1);
            }

            if(distancia_y<0 && distancia_x>0) {
                speed_x=(-1)*speed_x;
            }

            else if(distancia_y>0 && distancia_x>0) {
                speed_y=(-1)*speed_y;
                speed_x=(-1)*speed_x;
            }


        }
        else if( Math.abs(distancia_x) < Math.abs(distancia_y)+ bullet_speed) {
            speed_y = bullet_speed;
            speed_x = bullet_speed*distancia_x/Math.abs(distancia_y);


            if( distancia_x > 0) {
                speed_x = speed_x*(-1);
            }

            if(distancia_y<0 && distancia_x<0) {
                speed_x=(-1)*speed_x;
            }

            else if(distancia_y>0 && distancia_x>0) {
                speed_y=(-1)*speed_y;

            }
            else if(distancia_y>0 && distancia_x<0) {
                speed_y=(-1)*speed_y;
                speed_x=(-1)*speed_x;
            }
        }
        else {
            speed_x=bullet_speed;
            speed_y=bullet_speed;
        }

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

        posx+=speed_x;
        posy+=speed_y;
    }

    public void check_mob_hited() {

        if(    Math.abs(posx -Main.getGame_logic().getMobs()[mob_index].getPosx())<=speed_x*4+5  && Math.abs(posy -Main.getGame_logic().getMobs()[mob_index].getPosy())<=speed_y*4+5) {
            mob_hited = true;
            ani_atack.stop();
            posx=0;
            posy=0;
        }
    }

}
