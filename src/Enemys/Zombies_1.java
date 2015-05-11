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
 * Created by Ricardo on 03/05/2015.
 */
public class Zombies_1 {

    private int posx,posy;
    private boolean inGame = false;
    private char[][] board = Main.getMap().getMapa();
    private int posx_b,posy_b;
    private Timer timer;


    //ANIMACOES
    private int animation_state = 0;
    private int cnt=0,atack_cnt=0;
    /*
       0 -> walking
       1 -> Atacking
     */


    private ArrayList<BufferedImage> Listwalking;
    Animator ani_walking;
    private ArrayList<BufferedImage> Listatack;
    Animator ani_atack;



    public Zombies_1() {
        inic();
    }

    public void inic() {

        Listwalking   = new ArrayList<BufferedImage>();
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
        //Listwalking.add(Monster1_sprites.getZ6());
        //Listwalking.add(Monster1_sprites.getZ7());


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
        if(inGame){
            if(animation_state==0) {
                g.drawImage(ani_walking.getSprite(), posx, posy, 39, 32, null); //width & height
                ani_walking.update(System.currentTimeMillis());
            }
            else if(animation_state==1){
                g.drawImage(ani_atack.getSprite(), posx, posy, 39, 32, null);
                ani_atack.update(System.currentTimeMillis());
                if(ani_atack.isdeu_reset())
                    cnt++;

                if(cnt>4){
                    atack_cnt++;
                    cnt=0;
                }
                //a cada 3 ataques, player perde 10% da hp
                if(atack_cnt==3){
                    atack_cnt=0;
                    Main.getLoja().change_life();
                }
            }
        }
    }

    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            if(Main.getState()== Main.STATE.GAME){
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
