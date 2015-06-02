package com.company;

import Buildings.Base_building;
import Buildings.Type_building;
import Enemys.Base_enemy;
import Enemys.Monster_2;
import Enemys.Monster_1;
import Graphic.Menus.Game_Over;

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

    private int number_mobs_t1;
    private int mobs_spawned_t1=0;
    private int number_mobs_t2;
    private int mobs_spawned_t2=0;
    private int total_number_mobs=0;

    private int ingame_mobs_t1=0;
    private int ingame_mobs_t2=0;


    private boolean building_inic=false;

    private ArrayList<Base_building> buildings;
    private Type_building type_b = new Type_building();

    private boolean inicializacao=false;


    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            if(Main.getState()== Main.STATE.GAME){
                mobSpawner();
                check_life();
                check_end_game();//verifica de todos os inimigos já morreram.
            }
        }
    };


    public Logica() {

        number_mobs_t1 = Main.getOptions().getNumber_mobs_t1();
        number_mobs_t2 = Main.getOptions().getNumber_mobs_t2();
        delay = Main.getOptions().getTempo_entre_spawn_mobs();

        total_number_mobs=number_mobs_t1+number_mobs_t2;


        timer = new Timer(delay, actionListener);
        buildings= new ArrayList<Base_building>();

    }

    public void new_game() {

        number_mobs_t1 = Main.getOptions().getNumber_mobs_t1();
        number_mobs_t2 = Main.getOptions().getNumber_mobs_t2();
        delay = Main.getOptions().getTempo_entre_spawn_mobs();
        total_number_mobs=number_mobs_t1+number_mobs_t2;
        timer = new Timer(delay, actionListener);

        inicializar_mobs(); //lvl1
        eliminar_buildings();
        timer.restart();
        inicializacao=true;
    }


    public void load_old_game(Base_enemy[]  m, ArrayList<Base_building> b) {


        number_mobs_t1 = Main.getOptions().getNumber_mobs_t1();
        number_mobs_t2 = Main.getOptions().getNumber_mobs_t2();
        delay = Main.getOptions().getTempo_entre_spawn_mobs();
        timer = new Timer(delay, actionListener);
        buildings= new ArrayList<Base_building>();

        mobs = m;
        buildings = b;

        mobs_inic=true;
        building_inic=true;
        timer.restart();
        inicializacao=true;


    }

    public void check_end_game() {

        int contador=0;

        for(int i =0; i< total_number_mobs; i++){

            if( mobs[i].is_dead && mobs[i].isInGame()  ) {
                contador++;
            }
        }

        if(contador == total_number_mobs) { //Game over
            Game_Over end = new Game_Over(1); //tipo 1-> Ganhou o Jogo!
        }
    }

    public void inicializar_mobs(){

        ingame_mobs_t1=0;
        ingame_mobs_t2=0;

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

        if ( inicializacao ) {
            if (mobs_inic) {
                for (int i = 0; i < mobs.length; i++)
                    mobs[i].draw(g);
            }

            if (building_inic) {
                for (int i = 0; i < buildings.size(); i++) {
                    buildings.get(i).draw(g);
                }

            }
        }

    }

    private void check_life() {
        if( Main.getLoja().getLife()  <= 0){
            Game_Over end = new Game_Over(0); //tipo 0-> Perdeu o Jogo
        }
    }

    private void mobSpawner() {

        for (int i = 0; i < mobs.length; i++) {
            if (!mobs[i].isInGame()) {
                mobs[i].Spawnmob();
                if(mobs[i].mob_type==1) {
                    ingame_mobs_t1++;
                }
                else if(mobs[i].mob_type==2){
                    ingame_mobs_t2++;
                }
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

    public int get_spawned_mobs_t1() {
        return ingame_mobs_t1;
    }

    public int get_spawned_mobs_t2() {
        return ingame_mobs_t2;
    }

    public int getTotal_number_mobs() {
        return total_number_mobs;
    }

    public ArrayList<Base_building> getBuildings() {
        return buildings;
    }

    public boolean isInicializacao() {
        return inicializacao;
    }

    //////////////////////////////// SETTER's ////////////////////////////////


    public void set_spawned_mobs_t1(int a) {
         ingame_mobs_t1= a;
    }

    public void set_spawned_mobs_t2(int a) {
         ingame_mobs_t2=a;
    }

}