package com.company;

import Buildings.Base_building;
import Buildings.Type_building;
import Enemys.Base_enemy;
import Enemys.Monster_2;
import Enemys.Monster_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    private Base_enemy[] mobs_tipo1;
    private Base_enemy[]  mobs_tipo2;

    //Depende do lvl, e vai estar num dos ficheiros
    private int number_mobs_t1=1;
    private int number_mobs_t2=1;

    private boolean building_inic=false;
    private ArrayList<Base_building> buildings;
    private Type_building type_b = new Type_building();

    public Logica() {

        timer = new Timer(delay, actionListener);
    }

    public void new_game() {

        inicializar_mobs(); //lvl1
        timer.start();
    }

    public void inicializar_mobs(){

        //é preciso alterar... para Base_enemy
        mobs_tipo1 = new Monster_1[number_mobs_t1];
        for(int i=0;i<mobs_tipo1.length;i++)
            mobs_tipo1[i] = new Monster_1();

        mobs_tipo2 = new Monster_2[number_mobs_t2];
        for(int i=0;i<mobs_tipo2.length;i++)
            mobs_tipo2[i] = new Monster_2();


        mobs_inic = true;
    }

    public void draw(Graphics g){

        if ( mobs_inic ) {
            for (int i = 0; i < mobs_tipo1.length; i++)
                mobs_tipo1[i].draw(g);
            for (int i = 0; i < mobs_tipo2.length; i++)
                mobs_tipo2[i].draw(g);
        }

        if ( building_inic ) {
            for(int i = 0;i <buildings.size();i++ ){
                buildings.get(i).draw(g);
            }

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

    public void place_building(int x, int y, int build_id) {

        int posx_b= x/24;
        int posy_b= y/25;

        if (Main.getMap().getMapa()[posx_b][posy_b] == 'g') {
            buildings.add( type_b.get_building(build_id, posx_b, posy_b));
            building_inic = true;
        }

        Main.setHeld_id(0);
    }


    //////////////////////// GETTER AND SETTER ////////////////////////

}