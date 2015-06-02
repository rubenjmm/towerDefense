package Enemys;

import Graphic.Jogo.Animator;
import com.company.Main;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


/**
 * Created by Ricardo on 03/05/2015.
 */
public class Monster_1 extends Base_enemy{

    /*
       1 -> Walking
       2 -> Atack
     */
    public void inic() {

        mob_type=1;

        ///////Ir buscar às configurações
        strikes = Main.getOptions().getAtack_mobs_t1();
        life = Main.getOptions().getLife_mobs_t1();
        coin_value=Main.getOptions().getCoin_mobs_t1();

        Listwalking  = new ArrayList<BufferedImage>();
        Listatack    = new ArrayList<BufferedImage>();

        //Atack
        Listatack.add(Monster1_sprites.getZa1());
        Listatack.add(Monster1_sprites.getZa2());
        Listatack.add(Monster1_sprites.getZa3());
        Listatack.add(Monster1_sprites.getZa4());
        Listatack.add(Monster1_sprites.getZa5());


        //Walking
        Listwalking.add(Monster1_sprites.getZ1());
        Listwalking.add(Monster1_sprites.getZ2());
        Listwalking.add(Monster1_sprites.getZ3());
        Listwalking.add(Monster1_sprites.getZ4());
        Listwalking.add(Monster1_sprites.getZ5());
        Listwalking.add(Monster1_sprites.getZ4());
        Listwalking.add(Monster1_sprites.getZ3());
        Listwalking.add(Monster1_sprites.getZ2());



        //Atack
        ani_atack = new Animator(Listatack);
        ani_atack.setSpeed(150);
        ani_atack.play();

        //walking
        ani_walking = new Animator(Listwalking);
        ani_walking.setSpeed(180);
        ani_walking.play();


    }

    public void draw (Graphics g){
        if(inGame && !is_dead){

            if(animation_state==0) {
                g.drawImage(ani_walking.getSprite(), posx, posy, 39, 32, null); //width & height
                ani_walking.update(System.currentTimeMillis());
            }
            else if(animation_state==1){

                g.drawImage(ani_atack.getSprite(), posx, posy, 39, 32, null);
                ani_atack.update(System.currentTimeMillis());
                atack();// a cada N strikes , retira 10% da hp ao player
            }
        }
    }





}
