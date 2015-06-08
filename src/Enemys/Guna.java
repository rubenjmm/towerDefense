package Enemys;

import Graphic.Jogo.Animator;
import com.Main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


/**
 * Monstro tipo 3
 * @see Enemys.BaseEnemy
 */
public class Guna extends BaseEnemy
{

    /*
       1 -> Walking
       2 -> Atack
     */
    public void inic() {

        mobType =3;

        ///////Ir buscar às configurações
        strikes = Main.getOptions().getAttack_mobs_t3();
        life = Main.getOptions().getLife_mobs_t3();
        coinValue =Main.getOptions().getCoin_mobs_t3();

        //Atack
        listAttack = GunaSprites.getSpriteAttack();

        animAttack = new Animator(listAttack);
        animAttack.setSpeed(150);
        animAttack.play();

        //walking
        listWalking = GunaSprites.getSpriteWalking();

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
