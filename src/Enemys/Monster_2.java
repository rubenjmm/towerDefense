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
 * Created by Ricardo on 10/05/2015.
 */
public class Monster_2  extends Zombies_1{

    private int posx,posy;
    private boolean inGame = false;
    private char[][] board = Main.getMap().getMapa();
    private int posx_b,posy_b;
    private Timer timer;

    private boolean pausa=true;

    //ANIMACOES
    private int animation_state = 0;
    /*
       0 -> reborn
       1 -> Walking
       2 -> Atack
       3 -> Death
     */


    private ArrayList<BufferedImage> Listwalking;
    Animator ani_walking;
    private ArrayList<BufferedImage> Listatack;
    Animator ani_atack;
    private ArrayList<BufferedImage> List_death;
    Animator ani_death;
    private ArrayList<BufferedImage> Listreborn;
    Animator ani_reborn;



    public Monster_2() {
        inic();
    }

    public void inic() {

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
        if(inGame){
            if(animation_state==0) {
                pausa=false;
                g.drawImage(ani_reborn.getSprite(), posx, posy-5, 43,43, null);
                ani_reborn.update(System.currentTimeMillis());
                if(ani_reborn.isdeu_reset())
                    animation_state=1;
            }
            else if(animation_state==1){
                pausa=true;
                g.drawImage(ani_walking.getSprite(), posx, posy-15, 43, 43, null);
                ani_walking.update(System.currentTimeMillis());
                //se morrer animation_state=3
            }
            else if(animation_state==2) {
                pausa=false;
                g.drawImage(ani_atack.getSprite(), posx, posy-15,  43, 43, null);
                ani_atack.update(System.currentTimeMillis());
            }
            else if(animation_state==3) {
                pausa = false;
                g.drawImage(ani_death.getSprite(), posx, posy-15, 43, 43, null);
                ani_death.update(System.currentTimeMillis());
                if (ani_reborn.isdeu_reset()) {
                    animation_state = 5;
                    ani_death.stop();
                }
            }
        }
    }


    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            if(Main.getState()== Main.STATE.GAME && pausa){
                update_pos();
            }
        }
    };

    public void update_pos() {


        if (board[posx_b][posy_b] == 'r') {
            if (posx_b == Main.getMap().getlinhas() - 2) { //verificar se a próxima posição de baixo o fim do mapa
                posx++;
            } else {
                if (board[posx_b + 1][posy_b] != 'g') {//verificar se posso andar para a direita
                    posx++;
                    posy++;
                } else {
                    posy++;
                }
            }
        } else if (board[posx_b][posy_b] == 'k') {
            posx++;
        }

        else if( board[posx_b][posy_b]=='c' ) {
            if(board[posx_b][posy_b+1]!='g') {//verificar se posso andar para a direita
                posx++;
                posy--;
            }
            else {
                posx--;
                posy++;
            }
        }

        else if (board[posx_b][posy_b] == 'f') { //zombies chegaram à porta
            animation_state=2;
        }
        update_boardpos();
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
        inGame =  true;

        timer = new Timer(70, actionListener);
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

    //////////////////////////////// GETTER's ////////////////////////////////

    public boolean isInGame() {
        return inGame;
    }

}
