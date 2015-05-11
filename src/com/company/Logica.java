package com.company;

import Enemys.Monster_2;
import Enemys.Zombies_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

/**
 * Created by Ricardo on 04/05/2015.
 */


public class Logica {

    private int n_mobs_t1=0;
    private int n_mobs_t2=0;
    private int delay = 2000; //milliseconds
    private Timer timer;
    private boolean mobs_inic = false;
    private Zombies_1[] mobs_tipo1;
    private Monster_2[]  mobs_tipo2;

    private int number_mobs_t1=10;
    private int number_mobs_t2=2;

    public Logica() {

        timer = new Timer(delay, actionListener);
    }

    public void new_game() {

        inicializar_mobs(); //lvl1
        timer.start();
    }

    public void inicializar_mobs(){

        mobs_tipo1 = new Zombies_1[number_mobs_t1];
        for(int i=0;i<mobs_tipo1.length;i++)
            mobs_tipo1[i] = new Zombies_1();

        mobs_tipo2 = new Monster_2[number_mobs_t2];
        for(int i=0;i<mobs_tipo2.length;i++)
            mobs_tipo2[i] = new Monster_2();


        mobs_inic = true;
    }

    public void draw_mobs(Graphics g){

        if ( mobs_inic ) {
            for (int i = 0; i < mobs_tipo1.length; i++)
                mobs_tipo1[i].draw(g);
            for (int i = 0; i < mobs_tipo2.length; i++)
                mobs_tipo2[i].draw(g);
        }
    }

    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            if(Main.getState()== Main.STATE.GAME){
                mobSpawner();
                check_life();
            }
        }
    };

    private void check_life() {
        if( Main.getLoja().getLife()  <= 0){
            //gameover
        }
    }

    private void mobSpawner() {

        Random r = new Random();
        int num = r.nextInt(2);

        if(num==1) {
            for (int i = 0; i < mobs_tipo1.length; i++) {
                if (!mobs_tipo1[i].isInGame()) {
                    mobs_tipo1[i].Spawnmob();
                    n_mobs_t1++;
                    break;
                }
            }
        }
        else {
            for (int i = 0; i < mobs_tipo2.length; i++) {
                if (!mobs_tipo2[i].isInGame()) {
                    mobs_tipo2[i].Spawnmob();
                    n_mobs_t2++;
                    break;
                }
            }
        }
    }

    public Zombies_1[] getMobs() {
        return mobs_tipo1;
    }
}