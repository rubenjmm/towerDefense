package Enemys;

import Graphic.Jogo.Animator;
import com.Main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


/**
 * Monstro tipo 6
 * @see Enemys.BaseEnemy
 */
public class RedSkeleton extends BaseEnemy
{
    public boolean died = false;

    /*
       0 -> Walking
       1 -> Attack
       2 -> reborn
       3 -> Death
     */

    public void inic() {

        mobType = 6;

        ///////Ir buscar às configurações
        strikes = Main.getOptions().getAttack_mobs_t6();
        life = Main.getOptions().getLife_mobs_t6();
        coinValue =Main.getOptions().getCoin_mobs_t6();

        //Death
        listDeath = new ArrayList<BufferedImage>(RedSkeletonSprites.getSpriteDeath());
        animDeath = new Animator(listDeath);
        animDeath.setSpeed(150);
        animDeath.play();

        //Walking
        listWalking = new ArrayList<BufferedImage>(RedSkeletonSprites.getSpriteWalking());
        animWalking = new Animator(listWalking);
        animWalking.setSpeed(180);
        animWalking.play();

        //Attack
        listAttack = new ArrayList<BufferedImage>(RedSkeletonSprites.getSpriteAttack());
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