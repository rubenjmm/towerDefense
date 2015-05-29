package Enemys;

import Graphic.Jogo.Animator;
import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ricardo on 12/05/2015.
 */
public class Base_enemy {

    public char[][] board = Main.getMap().getMapa();
    public boolean inGame = false;
    public int posx_b,posy_b;
    public int posx,posy;

    public Timer timer;
    public int timer_delay=70;


    //ANIMACOES
    public boolean is_walking=true;
    public int animation_state = 0;
    public int cnt=0,atack_cnt=0;
    public int strikes=3;
    /*
       0 -> walking
       1 -> Atacking
     */

    public int life = 100;
    public boolean is_dead = false;

    public ArrayList<BufferedImage> Listwalking;
    Animator ani_walking;
    public ArrayList<BufferedImage> Listatack;
    Animator ani_atack;

    public int coin_value=0;

    public int mob_type;


    public Base_enemy() {
        inic();
    }

    public void inic() {

        /*
        Inicializar ArrayList de imagens
        Inicializar class de animação
         */

    }

    public void draw (Graphics g){

    }

    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            if(Main.getState()== Main.STATE.GAME && is_walking && !is_dead){
                update_pos();
            }
        }
    };

    public void update_pos() {


        if (board[posx_b][posy_b] == 'r') {
            if (posx_b == Main.getMap().getlinhas() - 2) { //verificar se a próxima posição de baixo o fim do mapa
                posx++;
                //random_pos(1);//x++
            } else {
                if (board[posx_b + 1][posy_b] != 'g') {//verificar se posso andar para a direita
                    posx++;
                    posy++;
                    //random_pos(1);//x++
                    //random_pos(3);//y++
                } else {
                    posy++;
                    //random_pos(3);//y--
                    //random_pos(4);//x--
                }
            }
        } else if (board[posx_b][posy_b] == 'k') {
            posx++;
            //random_pos(1); //x++
        }

        else if( board[posx_b][posy_b]=='c' ) {
            if(board[posx_b][posy_b+1]!='g') {//verificar se posso andar para a direita
                posx++;
                posy--;
                //random_pos(1);//x++
                //random_pos(3);//y--
            }
            else {
                posx--;
                posy++;
                //random_pos(3);//y--
                //random_pos(4);//x--
            }
        }

        else if (board[posx_b][posy_b] == 'f') { //zombies chegaram à porta
            animation_state=1;
        }
        update_boardpos();
    }

    public void random_pos(int dir) {

        Random r = new Random();
        int num = r.nextInt(2);
        if(dir == 1) { //x++
            if(num==1)
                posx++;
        }
        else if(dir == 2) {//y++
            if(num==1)
                posy++;
        }
        else if(dir==3){ //y--
            if(num==1)
                posy--;
        }
        else { //x--
            if(num==1)
                posx--;
        }
    }

    public void update_boardpos() {

        if(posx%24==0){
            posy_b = posx / 24;
        }

        if(posy%25==0){
            posx_b = posy / 25;
        }

    }

    public void Spawnmob(){

        //criar mobs no mapa..
        inic_pos();
        start_mob();


    }

    public void start_mob() {
        inGame =  true;

        timer = new Timer(timer_delay, actionListener);
        timer.start();
    }

    public void inic_pos(){

        Random r = new Random();
        int num = r.nextInt(6);
        posy_b = 0;
        if(num==1) {
            posx_b = 11;
        }
        else if(num==2) {
            posx_b = 12;
        }
        else if(num==3){
            posx_b = 13;
        }
        else  if(num==4) {
            posx_b = 14;
        }
        else
            posx_b = 10;

        //Normalizar para o mapa em questão
        posx = posy_b * 24;
        posy = posx_b * 25;
    }

    public void atack() {


        if(ani_atack.isdeu_reset())
            cnt++;

        if(cnt>4){
            atack_cnt++;
            cnt=0;
        }
        //a cada 3 ataques, player perde 10% da hp
        if(atack_cnt== strikes ){
            atack_cnt=0;
            Main.getLoja().change_life();
        }
    }

    public boolean change_life(int hit) {

        this.life = this.life - hit;
        if(this.life <= 0) {

            is_dead = true;
            Main.getLoja().change_coin( (-1)*coin_value );
            return true; //mob morreu
        }
        else {
            return false; //mob continua vivo
        }
    }

    public void disable_e() {
        timer.stop();
    }

    //////////////////////////////// GETTER's ////////////////////////////////

    public boolean isInGame() {
        return inGame;
    }

    public int getPosx() {
        return posx;
    }

    public int getPosy() {
        return posy;
    }

//////////////////////////////// SETTER's ////////////////////////////////


}
