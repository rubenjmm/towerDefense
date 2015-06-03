package Enemys;

import Graphic.Jogo.Animator;
import com.Main;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Ricardo on 10/05/2015.
 */
public class MonsterRed extends BaseEnemy
{
    public boolean died = false;

    /*
       0 -> Walking
       1 -> Attack
       2 -> reborn
       3 -> Death
     */

    public void inic() {

        mobType =2;

        ///////Ir buscar às configurações
        strikes = Main.getOptions().getAtack_mobs_t2();
        life = Main.getOptions().getLife_mobs_t2();
        coinValue =Main.getOptions().getCoin_mobs_t2();

        animationState =2;
        isWalking =false;


        //Reborn
        listReborn = new ArrayList<BufferedImage>(MonsterRedSprites.getSpriteReborn());
        animReborn = new Animator(listReborn);
        animReborn.setSpeed(150);
        animReborn.play();

        //Death
        listDeath = new ArrayList<BufferedImage>(MonsterRedSprites.getSpriteDeath());
        animDeath = new Animator(listDeath);
        animDeath.setSpeed(150);
        animDeath.play();

        //Walking
        listWalking = new ArrayList<BufferedImage>(MonsterRedSprites.getSpriteWalking());
        animWalking = new Animator(listWalking);
        animWalking.setSpeed(180);
        animWalking.play();

        //Attack
        listAttack = new ArrayList<BufferedImage>(MonsterRedSprites.getSpriteAttack());
        animAttack = new Animator(listAttack);
        animAttack.setSpeed(180);
        animAttack.play();

    }

    public void draw (Graphics g)
    {
        if(inGame && !isDead){

            if(animationState ==0){
                isWalking =true;
                g.drawImage(animWalking.getSprite(), posx, posy-15, 43, 43, null);
                animWalking.update(System.currentTimeMillis());
            }
            else if(animationState ==1) {
                isWalking =false;
                g.drawImage(animAttack.getSprite(), posx, posy-15,  43, 43, null);
                animAttack.update(System.currentTimeMillis());
                attack();
            }
            else if(animationState ==2) {
                isWalking =false;
                g.drawImage(animReborn.getSprite(), posx, posy-5, 43,43, null);
                animReborn.update(System.currentTimeMillis());
                if(animReborn.isdeu_reset())
                    animationState =0;//começa andar
            }
        }
        else if( inGame && isDead && !died ) {

                isWalking = false;
                g.drawImage(animDeath.getSprite(), posx, posy-15, 43, 43, null);
                animDeath.update(System.currentTimeMillis());
                if (animDeath.isdeu_reset()) {
                    animDeath.stop();
                    died = true;
                }
        }
    }

}

