package Enemys;

import Graphic.Jogo.Animator;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Ricardo on 10/05/2015.
 */
public class Monster_2  extends Base_enemy{


    public boolean died = false;

    /*
       0 -> Walking
       1 -> Atack
       2 -> reborn
       3 -> Death
     */

    private ArrayList<BufferedImage> List_death;
    private Animator ani_death;
    private ArrayList<BufferedImage> Listreborn;
    private Animator ani_reborn;


    public void inic() {

        life = 150;

        strikes = 1;
        animation_state=2;
        is_walking=false;

        Listwalking   = new ArrayList<BufferedImage>();
        Listatack    = new ArrayList<BufferedImage>();
        List_death    = new ArrayList<BufferedImage>();
        Listreborn    = new ArrayList<BufferedImage>();


        Listwalking.add(Monster2_sprites.getA1());
        Listwalking.add(Monster2_sprites.getA2());
        Listwalking.add(Monster2_sprites.getA3());
        Listwalking.add(Monster2_sprites.getA4());
        Listwalking.add(Monster2_sprites.getA5());
        Listwalking.add(Monster2_sprites.getA6());
        Listwalking.add(Monster2_sprites.getA7());
        Listwalking.add(Monster2_sprites.getA8());

        List_death.add(Monster2_sprites.getN1());
        List_death.add(Monster2_sprites.getN2());
        List_death.add(Monster2_sprites.getN3());
        List_death.add(Monster2_sprites.getN4());
        List_death.add(Monster2_sprites.getN5());
        List_death.add(Monster2_sprites.getN6());

        Listreborn.add(Monster2_sprites.getD0());
        Listreborn.add(Monster2_sprites.getD1());
        Listreborn.add(Monster2_sprites.getD2());
        Listreborn.add(Monster2_sprites.getD4());
        Listreborn.add(Monster2_sprites.getD5());
        Listreborn.add(Monster2_sprites.getD6());
        Listreborn.add(Monster2_sprites.getD7());
        Listreborn.add(Monster2_sprites.getD8());

        Listatack.add(Monster2_sprites.getAtack_1());
        Listatack.add(Monster2_sprites.getAtack_2());
        Listatack.add(Monster2_sprites.getAtack_3());
        Listatack.add(Monster2_sprites.getAtack_4());
        Listatack.add(Monster2_sprites.getAtack_5());
        Listatack.add(Monster2_sprites.getAtack_6());

        //Reborn
        ani_reborn = new Animator(Listreborn);
        ani_reborn.setSpeed(150);
        ani_reborn.play();

        //Death
        ani_death = new Animator(List_death);
        ani_death.setSpeed(150);
        ani_death.play();

        //walking
        ani_walking = new Animator(Listwalking);
        ani_walking.setSpeed(180);
        ani_walking.play();

        //walking
        ani_atack = new Animator(Listatack);
        ani_atack.setSpeed(180);
        ani_atack.play();

    }

    public void draw (Graphics g){

        if(inGame && !is_dead){

            if(animation_state==0){
                is_walking=true;
                g.drawImage(ani_walking.getSprite(), posx, posy-15, 43, 43, null);
                ani_walking.update(System.currentTimeMillis());
            }
            else if(animation_state==1) {
                is_walking=false;
                g.drawImage(ani_atack.getSprite(), posx, posy-15,  43, 43, null);
                ani_atack.update(System.currentTimeMillis());
                atack();
            }
            else if(animation_state==2) {
                is_walking=false;
                g.drawImage(ani_reborn.getSprite(), posx, posy-5, 43,43, null);
                ani_reborn.update(System.currentTimeMillis());
                if(ani_reborn.isdeu_reset())
                    animation_state=0;//começa andar
            }
        }
        else if( inGame && is_dead && !died ) {

                is_walking = false;
                g.drawImage(ani_death.getSprite(), posx, posy-15, 43, 43, null);
                ani_death.update(System.currentTimeMillis());
                if (ani_death.isdeu_reset()) {
                    ani_death.stop();
                    died = true;
                }
        }
    }

}

