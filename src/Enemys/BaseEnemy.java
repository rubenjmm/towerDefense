package Enemys;

import Graphic.Jogo.Animator;
import com.Main;

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
public class BaseEnemy
{
    public char[][] board = Main.getMap().getMapa();
    public boolean inGame = false;
    public int posx_b,posy_b;
    public int posx,posy;

    public Timer timer;
    public int timerDelay = 70;

    //ANIMACOES
    public boolean isWalking =true;
    public int animationState = 0;
    public int cnt = 0, attackCnt = 0;
    public int strikes = 3;
    /*
       0 -> Walking
       1 -> Attacking
     */

    public int life = 100;
    public boolean isDead = false;

    protected ArrayList<BufferedImage> listWalking;
    protected Animator animWalking;
    protected ArrayList<BufferedImage> listAttack;
    protected Animator animAttack;
    protected ArrayList<BufferedImage> listDeath;
    protected Animator animDeath;
    protected ArrayList<BufferedImage> listReborn;
    protected Animator animReborn;


    public int coinValue = 0;

    public int mobType;

    public BaseEnemy() {
        inic();
    }

    public void inic() {

    }

    public void draw (Graphics g){

    }

    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            if(Main.getState()== Main.STATE.GAME && isWalking && !isDead){
                updatePos();
            }
        }
    };

    public void updatePos() 
    {
        if (board[posx_b][posy_b] == 'r'   ) {
            if (posx_b == Main.getMap().getlinhas() - 2) { //verificar se a próxima posição de baixo o fim do mapa
                posx++;
                //randomPos(1);//x++
            } else {
                if (board[posx_b + 1][posy_b] != 'g') {//verificar se posso andar para a direita
                    posx++;
                    posy++;
                    //randomPos(1);//x++
                    //randomPos(3);//y++
                } else {
                    posy++;
                    //randomPos(3);//y--
                    //randomPos(4);//x--
                }
            }
        } else if (    (board[posx_b][posy_b] == 'k') || (board[posx_b][posy_b] == 'w') ) {
            posx++;
            //randomPos(1); //x++
        }

        else if( board[posx_b][posy_b]=='c' ) {
            if(board[posx_b][posy_b+1]!='g') {//verificar se posso andar para a direita
                posx++;
                posy--;
                //randomPos(1);//x++
                //randomPos(3);//y--
            }
            else {
                posx--;
                posy++;
                //randomPos(3);//y--
                //randomPos(4);//x--
            }
        }

        else if (board[posx_b][posy_b] == 'f') { //zombies chegaram à porta
            animationState =1;
        }
        updateBoardPos();
    }

    public void randomPos(int dir) {

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

    public void updateBoardPos() {

        if(posx%24==0){
            posy_b = posx / 24;
        }

        if(posy%25==0){
            posx_b = posy / 25;
        }

    }

    public void spawnMob(){
        //criar mobs no mapa..
        inicPos();
        startMob();
    }

    public void startMob() {
        inGame =  true;

        timer = new Timer(timerDelay, actionListener);
        timer.start();
    }

    public void inicPos(){

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

    public void attack() {
        if(animAttack.isdeu_reset())
            cnt++;

        if(cnt>4){
            attackCnt++;
            cnt=0;
        }
        //a cada 3 ataques, player perde 10% da hp
        if(attackCnt == strikes ){
            attackCnt =0;
            Main.getLoja().change_life();
        }
    }

    public boolean changeLife(int hit) {

        this.life = this.life - hit;
        if(this.life <= 0) {

            isDead = true;
            Main.getLoja().change_coin( (-1)* coinValue);
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
