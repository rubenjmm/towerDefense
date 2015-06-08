package Buildings;

import Graphic.Jogo.Animator;
import com.Main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


/**
 * Building attack class
 * Verifica se é possivel atacar algum monstro, se sim dispara
 *
 */
public class BaseAttack
{
    /**
     * Atributos da classe publicos por simplicidade
     * pos_building_x, pos_building_y -> posição do edificio
     * mob_x, mob_y -> posição do monstro
     * mob_index -> identificador do monstro
     * Listatack -> imagens do projectil
     * mob_hited -> flag que indica se o monstro foi atingido
     * ani_atack -> classe que anima o projectil @see Graphic.Jogo.Animator
     * posx, posy -> posição inicial do projectil
     * bullet_speed, speed_x, speed_y -> velocidade do projectil absoluta e segundo os eixos x e y
     */
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


    public BaseAttack() {

    }

    /**
     * Construtor da classe
     * @param Lista -> imagens do projectil
     * @param x -> posição do edificio em segundo x
     * @param y -> posição do edificio em segundo y
     * @param speed -> cadencia de disparo
     * @param bullet_spd -> velocidade da bala
     */
    public BaseAttack(ArrayList<BufferedImage> Lista, int x, int y, int speed, int bullet_spd) {

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

    /**
     * Handler do disparo.
     * @param index -> monstro alvo
     * @see Buildings.BaseAttack
     */
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

    /**
     * Calcula a velocidade do projectil em cada eixo
     */
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

    /**
     * Desenho do projectil durante o percurso ate ao monstro
     * @param g
     */
    public void draw(Graphics g) {

        if(!mob_hited) {
            g.drawImage(ani_atack.getSprite(), posx, posy, 5, 5, null); //width & height
            ani_atack.update(System.currentTimeMillis());
            check_mob_hited();
            update_pos();
        }
    }

    /**
     * Actualiza a posição do projectil ao longo do tempo
     */
    public void update_pos(){

        posx+=speed_x;
        posy+=speed_y;
    }

    /**
     * Verifica se o monstro já foi atingido
     */
    public void check_mob_hited() {

        if(    Math.abs(posx -Main.getGame_logic().getMobs()[mob_index].getPosx())<=speed_x*4+5  && Math.abs(posy -Main.getGame_logic().getMobs()[mob_index].getPosy())<=speed_y*4+5) {
            mob_hited = true;
            ani_atack.stop();
            posx=0;
            posy=0;
        }
    }
}
