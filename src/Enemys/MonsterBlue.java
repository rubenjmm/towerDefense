package Enemys;

import Graphic.Jogo.Animator;
import com.Main;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


/**
 * Monstro tipo 1
 * @see Enemys.BaseEnemy
 */
public class MonsterBlue extends BaseEnemy
{
    /*
       1 -> Walking
       2 -> Atack
     */
    public void inic() {

        this.mobType =1;

        ///////Ir buscar às configurações
        this.strikes = Main.getOptions().getAttack_mobs_t1();
        this.life = Main.getOptions().getLife_mobs_t1();
        this.coinValue =Main.getOptions().getCoin_mobs_t1();

        //listWalking  = new ArrayList<BufferedImage>();
        //listAttack = new ArrayList<BufferedImage>();

        //Attack
        this.listAttack = new ArrayList<BufferedImage>(MonsterBlueSprites.getSpriteAttack());

        this.animAttack = new Animator(this.listAttack);
        this.animAttack.setSpeed(150);
        this.animAttack.play();

        //walking
        this.listWalking = new ArrayList<BufferedImage>(MonsterBlueSprites.getSpriteWalking());

        this.animWalking = new Animator(this.listWalking);
        this.animWalking.setSpeed(180);
        this.animWalking.play();
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