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


    private int delay = 2500; //milliseconds
    private Timer timer;
    private boolean mobs_inic = false;
    private Base_enemy[] mobs;

    //Depende do lvl, e vai estar num dos ficheiros
    private int number_mobs_t1=1;
    private int number_mobs_t2=2;

    private boolean building_inic=false;
    private ArrayList<Base_building> buildings;
    private Type_building type_b = new Type_building();


    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            if(Main.getState()== Main.STATE.GAME){
                mobSpawner();
                check_life();
            }
        }
    };

    public Logica() {

        timer = new Timer(delay, actionListener);
        buildings= new ArrayList<Base_building>();

    }

    public void new_game() {

        inicializar_mobs(); //lvl1
        eliminar_buildings();
        timer.restart();
    }

    public void inicializar_mobs(){

        int mobs_criados_t1=0;
        int mobs_criados_t2=0;

        Random r = new Random();


        mobs = new Base_enemy[number_mobs_t1 + number_mobs_t2];


        while( (mobs_criados_t1+mobs_criados_t2)!= mobs.length) {

            int num = r.nextInt(2);

            if (num == 0 && mobs_criados_t1<number_mobs_t1) {
                mobs[mobs_criados_t2+mobs_criados_t1] = new Monster_1();
                mobs_criados_t1 = mobs_criados_t1+1;
            }

            if(num==1 && mobs_criados_t2<number_mobs_t2) {

                mobs[mobs_criados_t2+mobs_criados_t1] = new Monster_2();
                mobs_criados_t2 = mobs_criados_t2+1;
            }
        }
        mobs_inic = true;
    }

    public void draw(Graphics g){

        if ( mobs_inic ) {
            for (int i = 0; i < mobs.length; i++)
                mobs[i].draw(g);
        }

        if ( building_inic ) {
            for(int i = 0;i <buildings.size();i++ ){
                buildings.get(i).draw(g);
            }

        }

    }

    private void check_life() {
        if( Main.getLoja().getLife()  <= 0){
            //gameover
        }
    }

    private void mobSpawner() {

        for (int i = 0; i < mobs.length; i++) {
            if (!mobs[i].isInGame()) {
                mobs[i].Spawnmob();
                break;
            }
        }
    }

    public void place_building(int x, int y, int build_id) {

        int posx_b= x/24;
        int posy_b= y/25;

        if ( Main.getMap().getMapa()[posy_b][posx_b] == 'g') {

            atualizar_gold(build_id);

            buildings.add( type_b.get_building(build_id, posx_b, posy_b));
            building_inic = true;
        }


        Main.setHeld_id(0);
    }

    public void eliminar_buildings() {


        buildings.clear();
        building_inic=false;
    }

    public void atualizar_gold(int id) {

        if (id==1) {
            //15g
            Main.getLoja().change_coin(15);
        }
        else if( id==2 ) {

        }
    }

    //////////////////////////////// GETTER's ////////////////////////////////

    public Base_enemy[] getMobs() {
        return mobs;
    }

}