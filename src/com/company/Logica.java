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


    private int delay;  //milliseconds
    private Timer timer;
    private boolean mobs_inic = false;
    private Base_enemy[] mobs;

    //Depende do lvl, e vai estar num dos ficheiros
    private int number_mobs_t1;
    private int mobs_spawned_t1=0;
    private int number_mobs_t2;
    private int mobs_spawned_t2=0;
    private int total_number_mobs=0;


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

        number_mobs_t1 = Main.getOptions().getNumber_mobs_t1();
        number_mobs_t2 = Main.getOptions().getNumber_mobs_t2();
        delay = Main.getOptions().getTempo_entre_spawn_mobs();

        total_number_mobs=number_mobs_t1+number_mobs_t2;


        System.out.println("delay -> "+delay);
        System.out.println("number_mobs_t1 -> "+number_mobs_t1);

        timer = new Timer(delay, actionListener);
        buildings= new ArrayList<Base_building>();

    }

    public void new_game() {

        inicializar_mobs(); //lvl1
        eliminar_buildings();
        timer.restart();
    }

    public void inicializar_mobs(){

        mobs_spawned_t1=0;
        mobs_spawned_t2=0;

        Random r = new Random();


        mobs = new Base_enemy[number_mobs_t1 + number_mobs_t2];


        while( (mobs_spawned_t1+mobs_spawned_t2)!= mobs.length) {

            int num = r.nextInt(2);

            if (num == 0 && mobs_spawned_t1<number_mobs_t1) {
                mobs[mobs_spawned_t2+mobs_spawned_t1] = new Monster_1();
                mobs_spawned_t1 = mobs_spawned_t1+1;
            }

            if(num==1 && mobs_spawned_t2<number_mobs_t2) {

                mobs[mobs_spawned_t2+mobs_spawned_t1] = new Monster_2();
                mobs_spawned_t2 = mobs_spawned_t2+1;
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

    public int getMobs_spawned_t1() {
        return mobs_spawned_t1;
    }

    public int getMobs_spawned_t2() {
        return mobs_spawned_t2;
    }

    public int getTotal_number_mobs() {
        return total_number_mobs;
    }

    public ArrayList<Base_building> getBuildings() {
        return buildings;
    }

}