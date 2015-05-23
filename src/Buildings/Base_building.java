package Buildings;

import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * Created by Ricardo on 12/05/2015.
 */
public class Base_building {

    public int atack=0;
    public int posx_b,posy_b;
    public int posx,posy;

    public long time=0,time2=0;

    public Timer timer;

    public int atack_delay=1500; // em ms

    public boolean in_position =false;
    public boolean target_alive= false;
    public boolean atacking = false;
    public boolean first_atack= true;
    public int mob_x,mob_y;
    public int mob_index;

    public int animation_actual_state = 7;
    public int animation_next_state   = 7;
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


    public boolean last_hit=false;
    public boolean disabled = false;
    ActionListener timer_listener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            if(Main.getState()== Main.STATE.GAME && !disabled){
                atack();
            }
        }
    };

    public int raio=0; //raio de alcance

    public Base_atack atack_effect;


    public Base_building () {
        atack_effect =  new Base_atack();
        inic();
    }

    public Base_building(int x,int y,int r) {

        atack_effect =  new Base_atack();

        this.posx_b=x;
        this.posy_b=y;
        this.raio = r;

        posx = posx_b *24;
        posy = posy_b *25;

        inic() ;
    }

    public void inic() {

        timer = new Timer(atack_delay,timer_listener);
        timer.start();
        time2= System.currentTimeMillis();
        verify_pos();
    }

    public void draw(Graphics g) {

        //a cada 250ms verificar a posicao relativa do mob face à torre
        if( System.currentTimeMillis() - time2 > 250){
             verify_pos();
        }


        if (!atacking) {
            g.drawImage(img1, posx, posy, 70, 70, null);
        }
        else if ( (target_alive ) || last_hit ){
            g.drawImage(img2, posx, posy, 70, 70, null);

            if (System.currentTimeMillis() - time > 200) { //ao fim de 200ms
                time = 0;
                atacking = false;
                last_hit=false;
            }
        }

        /////////////Animacao do tiro de ataque //////////
        atack_effect.draw(g);

    }

    public boolean find_target() {


        for(int i=0;i<Main.getGame_logic().getMobs().length;i++ ) {

            if (Main.getGame_logic().getMobs()[i].isInGame() && !Main.getGame_logic().getMobs()[i].is_dead) {
                if(verify_target_range()) {

                    continue;
                }
                target_alive = true;
                mob_index=i;
                break;
            }

            if( i==Main.getGame_logic().getMobs().length -1) {
                target_alive=false;
                return false;
            }
        }

        return true;
}

    public void atack() {

        if( first_atack ){
            find_target();
            first_atack = false;
        }

        else {
            if ( verify_target_range() ) {//verifica se o inimigo está dentro da distância de ataque
                if (in_position) {  //Orientado para o zombie a atacar!
                    if (target_alive) {
                        atack_effect.shot_fired(mob_index);

                        atacking = true;
                        time = System.currentTimeMillis();
                        //Animaçao de ataque para o mob em questão
                        if (Main.getGame_logic().getMobs()[mob_index].change_life(atack)) { //mob morreu
                            target_alive = false;
                            in_position = false;
                            last_hit = true;
                        }
                    }
                }
                else if (!target_alive) {
                    target_alive = find_target();//procura novos mobs, target_alive=false se não restarem mais mobs
                }
            }
            else {  //Target is 2 far away
                target_alive = find_target();
            }
        }
    }

    public boolean verify_target_range() { //dá return a true se o target pode ser atacado

        mob_x = Main.getGame_logic().getMobs()[mob_index].getPosx();
        mob_y = Main.getGame_logic().getMobs()[mob_index].getPosy();

        if( Math.abs(posx - mob_x) <= raio   &&  Math.abs(posy-mob_y) <= raio) {
            return true;
        }
        else{
            return false;
        }
    }

    public void verify_pos() {


        mob_x = Main.getGame_logic().getMobs()[mob_index].getPosx();
        mob_y = Main.getGame_logic().getMobs()[mob_index].getPosy();

        time2 = System.currentTimeMillis();

        if( target_alive ) {
            if (posx - mob_x < 0) { //mob à direita
                if (posy - mob_y < 0) { //mob em baixo
                    animation_next_state = 6;
                }
                else if (posy - mob_y > 0) { //mob em cima
                    animation_next_state = 4;
                }
                else {
                    animation_next_state = 5;
                }
            }
            else if (posx - mob_x > 0) { //mob à esquerda
                if (posy - mob_y < 0) { //mob em baixo
                    animation_next_state = 8;
                }
                else if (posy - mob_y > 0) { //mob em cima
                    animation_next_state = 2;
                }
                else {
                    animation_next_state = 1;
                }
            }
            else {
                if (posy - mob_y < 0) { //mob em baixo
                    animation_next_state = 7;
                }
                else { //mob em cima
                    animation_next_state = 3;
                }
            }

            if (animation_next_state != animation_actual_state) {

                if (animation_actual_state++ > 8) {
                    animation_actual_state = 0;
                }
                change_animation();
                in_position = false;
            }
            else {
                in_position = true;
            }
        }

    }

    public void change_animation() {

        //altera as imagens consoante a animação
    }


}
