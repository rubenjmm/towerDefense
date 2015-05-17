package Buildings;

import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by Ricardo on 12/05/2015.
 */
public class Base_building {

    public int atack=0;
    public int posx_b,posy_b;
    public int posx,posy;

    public  int contador=0;
    public long time=0;

    public Timer timer;

    public int atack_delay=1500; // em ms
    public boolean atacking = false;
    public boolean first_atack= true;
    public int mob_x,mob_y;
    public int mob_index,mob_type;

    private int animation_actual_state = 7;
    private int animation_next_state   = 7;
    /*
       1 -> left
       2 -> left/up
       3 -> up
       4 -> right/up
       5 -> right
       6 -> right/down
       7 -> down
       8 -> left/down
     */

    public BufferedImage img1;
    public BufferedImage img2;

    ActionListener timer_listener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            if(Main.getState()== Main.STATE.GAME){
                atack();
            }
        }
    };

    public Base_building () {
        inic();
    }

    public Base_building(int x,int y) {

        this.posx_b=x;
        this.posy_b=y;

        posx = posx_b *24;
        posy = posy_b *25;

        inic() ;
    }

    public void inic() {

        timer = new Timer(atack_delay,timer_listener);
        timer.start();
    }

    public void draw(Graphics g) {

        //a cada 8 iterações verificar a posicao relativa do mob face à torre
        if( contador++ > 8){
            contador=0;
            verify_pos();
        }

        if(!atacking) {
            g.drawImage(img1,posx,posy,70,70,null );
        }
        else {
            g.drawImage(img2,posx,posy,70,70,null );
            if( System.currentTimeMillis() - time > 150){ //ao fim de 150ms
                time = 0;
                atacking=false;
            }
        }
    }

    public void find_target() {

        Random r = new Random();
        int num = r.nextInt(2);


        //ALTERAR AS VARIRÁVEIS   index E type
        if(num==1) {
            for (int i = 0; i < Main.getGame_logic().getMobs_tipo1().length ; i++) {
                if (  Main.getGame_logic().getMobs_tipo1()[i].isInGame() &&  !Main.getGame_logic().getMobs_tipo1()[i].is_dead            ) {
                    mob_index = i;
                    mob_type = num;
                    break;
                }
            }
        }
        else {
            for (int i = 0; i < Main.getGame_logic().getMobs_tipo2().length ; i++) {
                if (  Main.getGame_logic().getMobs_tipo2()[i].isInGame() &&  !Main.getGame_logic().getMobs_tipo2()[i].is_dead            ) {
                    mob_index = i;
                    mob_type = num;
                    break;
                }
            }
        }



    }

    public void atack() {

        System.out.println("KJKKE");

        if( first_atack ){
            find_target();
            first_atack = false;
        }
        else {
            atacking = true;
            time = System.currentTimeMillis();
            if(mob_type==1) {
                if( Main.getGame_logic().getMobs_tipo1()[mob_index].change_life( atack )) { //mob morreu
                    find_target();
                }
            }
            else {
                if( Main.getGame_logic().getMobs_tipo2()[mob_index].change_life( atack )) { //mob morreu
                    find_target();
                }
            }
        }

    }

    public void verify_pos() {


        if(mob_type==1) {
            mob_x = Main.getGame_logic().getMobs_tipo1()[mob_index].getPosx();
            mob_y = Main.getGame_logic().getMobs_tipo1()[mob_index].getPosy();
        }
        else {
            mob_x = Main.getGame_logic().getMobs_tipo2()[mob_index].getPosx();
            mob_y = Main.getGame_logic().getMobs_tipo2()[mob_index].getPosy();
        }

        if( posx - mob_x < 0) { //mob à esquerda
            if( posy - mob_y < 0) { //mob em baixo
                animation_next_state = 8;
            }
            else if( posy - mob_y >0) { //mob em cima
                animation_next_state = 2;
            }
            else {
                animation_next_state = 1;
            }
        }
        else if ( posx - mob_x > 0) { //mob à direita
            if( posy - mob_y < 0) { //mob em baixo
                animation_next_state = 6;
            }
            else if( posy - mob_y >0) { //mob em cima
                animation_next_state = 4;
            }
            else {
                animation_next_state = 5;
            }
        }
        else  {
            if( posy - mob_y < 0) { //mob em baixo
                animation_next_state = 7;
            }
            else { //mob em cima
                animation_next_state = 3;
            }
        }

        if(animation_next_state != animation_actual_state) {

            if ( animation_actual_state++ > 8 ) {
                animation_actual_state=0;
                change_animation();
            }
        }
    }

    public void change_animation() {

        //altera as imagens consoante a animação
    }

    //falta o efeito..


}
