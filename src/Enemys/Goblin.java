package Enemys;

import Graphic.Jogo.Animator;
import com.Main;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


/**
 * Created by Ricardo on 03/05/2015.
 */
public class Goblin extends BaseEnemy
{

    /*
       1 -> Walking
       2 -> Atack
     */
    public void inic() {

        mobType =1;

        ///////Ir buscar às configurações
        strikes = Main.getOptions().getAtack_mobs_t1();
        life = Main.getOptions().getLife_mobs_t1();
        coinValue =Main.getOptions().getCoin_mobs_t1();

        listWalking = new ArrayList<BufferedImage>();
        listAttack = new ArrayList<BufferedImage>();

        //Atack
        //listAttack.add(MonsterBlueSprites.getZa1());


        //Walking
        //listWalking.add(MonsterBlueSprites.getZ1());


        //Atack
        animAttack = new Animator(listAttack);
        animAttack.setSpeed(150);
        animAttack.play();

        //walking
        animWalking = new Animator(listWalking);
        animWalking.setSpeed(180);
        animWalking.play();


    }

    public void draw (Graphics g){
        if(inGame && !isDead){

            if(animationState ==0) {
                g.drawImage(animWalking.getSprite(), posx, posy, 39, 32, null); //width & height
                animWalking.update(System.currentTimeMillis());
            }
            else if(animationState ==1){

                g.drawImage(animAttack.getSprite(), posx, posy, 39, 32, null);
                animAttack.update(System.currentTimeMillis());
                attack();// a cada N strikes , retira 10% da hp ao player
            }
        }
    }





}
