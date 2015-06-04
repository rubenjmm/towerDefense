package com;

import Buildings.BaseBuilding;
import Buildings.TypeBuilding;
import Enemys.*;
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
    private BaseEnemy[] mobs;

    private int number_mobs_t1;
    private int mobs_spawned_t1 = 0;
    private int number_mobs_t2;
    private int mobs_spawned_t2 = 0;
    private int number_mobs_t3;
    private int mobs_spawned_t3 = 0;
    private int number_mobs_t4;
    private int mobs_spawned_t4 = 0;
    private int number_mobs_t5;
    private int mobs_spawned_t5 = 0;
    private int number_mobs_t6;
    private int mobs_spawned_t6 = 0;
    private int number_mobs_t7;
    private int mobs_spawned_t7 = 0;

    private int total_number_mobs=0;

    private int ingame_mobs_t1 = 0;
    private int ingame_mobs_t2 = 0;
    private int ingame_mobs_t3 = 0;
    private int ingame_mobs_t4 = 0;
    private int ingame_mobs_t5 = 0;
    private int ingame_mobs_t6 = 0;
    private int ingame_mobs_t7 = 0;

    private boolean building_inic=false;

    private ArrayList<BaseBuilding> buildings;
    private TypeBuilding type_b = new TypeBuilding();

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
        number_mobs_t3 = Main.getOptions().getNumber_mobs_t3();
        number_mobs_t4 = Main.getOptions().getNumber_mobs_t4();
        number_mobs_t5 = Main.getOptions().getNumber_mobs_t5();
        number_mobs_t6 = Main.getOptions().getNumber_mobs_t6();
        number_mobs_t7 = Main.getOptions().getNumber_mobs_t7();

        delay = Main.getOptions().getTempo_entre_spawn_mobs();

        total_number_mobs=number_mobs_t1 + number_mobs_t2 + number_mobs_t3 + number_mobs_t4 + number_mobs_t5 + number_mobs_t6 + number_mobs_t7;

        timer = new Timer(delay, actionListener);
        buildings= new ArrayList<BaseBuilding>();

    }

    public void new_game() {

        number_mobs_t1 = Main.getOptions().getNumber_mobs_t1();
        number_mobs_t2 = Main.getOptions().getNumber_mobs_t2();
        number_mobs_t3 = Main.getOptions().getNumber_mobs_t3();
        number_mobs_t4 = Main.getOptions().getNumber_mobs_t4();
        number_mobs_t5 = Main.getOptions().getNumber_mobs_t5();
        number_mobs_t6 = Main.getOptions().getNumber_mobs_t6();
        number_mobs_t7 = Main.getOptions().getNumber_mobs_t7();

        delay = Main.getOptions().getTempo_entre_spawn_mobs();
        total_number_mobs = number_mobs_t1 + number_mobs_t2 + number_mobs_t3 + number_mobs_t4 + number_mobs_t5 + number_mobs_t6 + number_mobs_t7;

        timer = new Timer(delay, actionListener);

        inicializar_mobs(); //lvl1
        eliminar_buildings();
        timer.restart();
        inicializacao=true;
    }


    public void load_old_game(BaseEnemy[]  m, ArrayList<BaseBuilding> b) {

        number_mobs_t1 = Main.getOptions().getNumber_mobs_t1();
        number_mobs_t2 = Main.getOptions().getNumber_mobs_t2();
        number_mobs_t3 = Main.getOptions().getNumber_mobs_t3();
        number_mobs_t4 = Main.getOptions().getNumber_mobs_t4();
        number_mobs_t5 = Main.getOptions().getNumber_mobs_t5();
        number_mobs_t6 = Main.getOptions().getNumber_mobs_t6();
        number_mobs_t7 = Main.getOptions().getNumber_mobs_t7();

        delay = Main.getOptions().getTempo_entre_spawn_mobs();
        timer = new Timer(delay, actionListener);
        buildings= new ArrayList<BaseBuilding>();

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

            if( mobs[i].isDead && mobs[i].isInGame()  ) {
                contador++;
            }
        }

        if(contador == total_number_mobs) { //Game over
            Game_Over end = new Game_Over(1); //tipo 1-> Ganhou o Jogo!
        }
    }

    public void inicializar_mobs(){

        ingame_mobs_t1 = 0;
        ingame_mobs_t2 = 0;
        ingame_mobs_t3 = 0;
        ingame_mobs_t4 = 0;
        ingame_mobs_t5 = 0;
        ingame_mobs_t6 = 0;
        ingame_mobs_t7 = 0;

        mobs_spawned_t1 = 0;
        mobs_spawned_t2 = 0;
        mobs_spawned_t3 = 0;
        mobs_spawned_t4 = 0;
        mobs_spawned_t5 = 0;
        mobs_spawned_t6 = 0;
        mobs_spawned_t7 = 0;

        Random r = new Random();

        mobs = new BaseEnemy[number_mobs_t1 + number_mobs_t2 + number_mobs_t3 + number_mobs_t4 + number_mobs_t5 + number_mobs_t6 + number_mobs_t7];

        while( (mobs_spawned_t1 + mobs_spawned_t2 + mobs_spawned_t3 + mobs_spawned_t4 + mobs_spawned_t5 + mobs_spawned_t6 + mobs_spawned_t7)!= mobs.length) {

            int num = r.nextInt(2);

            if (num == 0 && mobs_spawned_t1<number_mobs_t1) {
                mobs[mobs_spawned_t1 + mobs_spawned_t2 + mobs_spawned_t3 + mobs_spawned_t4 + mobs_spawned_t5 + mobs_spawned_t6 + mobs_spawned_t7] = new MonsterBlue();
                mobs_spawned_t1 = mobs_spawned_t1+1;
            }
            if(num == 1 && mobs_spawned_t2<number_mobs_t2) {
                mobs[mobs_spawned_t1 + mobs_spawned_t2 + mobs_spawned_t3 + mobs_spawned_t4 + mobs_spawned_t5 + mobs_spawned_t6 + mobs_spawned_t7] = new MonsterRed();
                mobs_spawned_t2 = mobs_spawned_t2+1;
            }
            if(num == 2 && mobs_spawned_t3<number_mobs_t3) {
                mobs[mobs_spawned_t1 + mobs_spawned_t2 + mobs_spawned_t3 + mobs_spawned_t4 + mobs_spawned_t5 + mobs_spawned_t6 + mobs_spawned_t7] = new Guna();
                mobs_spawned_t3 = mobs_spawned_t3+1;
            }
            if(num == 3 && mobs_spawned_t4<number_mobs_t4) {
                mobs[mobs_spawned_t1 + mobs_spawned_t2 + mobs_spawned_t3 + mobs_spawned_t4 + mobs_spawned_t5 + mobs_spawned_t6 + mobs_spawned_t7] = new Goblin();
                mobs_spawned_t4 = mobs_spawned_t4+1;
            }
            if(num == 4 && mobs_spawned_t5<number_mobs_t5) {
                mobs[mobs_spawned_t1 + mobs_spawned_t2 + mobs_spawned_t3 + mobs_spawned_t4 + mobs_spawned_t5 + mobs_spawned_t6 + mobs_spawned_t7] = new WhiteSkeleton();
                mobs_spawned_t5 = mobs_spawned_t5+1;
            }
            if(num == 5 && mobs_spawned_t6<number_mobs_t6) {
                mobs[mobs_spawned_t1 + mobs_spawned_t2 + mobs_spawned_t3 + mobs_spawned_t4 + mobs_spawned_t5 + mobs_spawned_t6 + mobs_spawned_t7] = new RedSkeleton();
                mobs_spawned_t6 = mobs_spawned_t6+1;
            }
            if(num == 6 && mobs_spawned_t7<number_mobs_t7) {
                mobs[mobs_spawned_t1 + mobs_spawned_t2 + mobs_spawned_t3 + mobs_spawned_t4 + mobs_spawned_t5 + mobs_spawned_t6 + mobs_spawned_t7] = new Zombie();
                mobs_spawned_t7 = mobs_spawned_t7+1;
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
                mobs[i].spawnMob();
                if(mobs[i].mobType ==1) {
                    ingame_mobs_t1++;
                }
                else if(mobs[i].mobType ==2){
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

            buildings.add( type_b.getBuilding(build_id, posx_b, posy_b));
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
        else if( id== 3 ) {
            Main.getLoja().change_coin(25);
        }
        else if( id== 2 ) {
            Main.getLoja().change_coin(5);
        }
        else if( id== 4 ) {
            Main.getLoja().change_coin(50);
        }
    }

    //////////////////////////////// GETTER's ////////////////////////////////

    public BaseEnemy[] getMobs() {
        return mobs;
    }

    public int getIngame_mobs_t1() {
        return ingame_mobs_t1;
    }

    public int getIngame_mobs_t2() {
        return ingame_mobs_t2;
    }

    public int getIngame_mobs_t3()
    {
        return ingame_mobs_t3;
    }

    public int getIngame_mobs_t4()
    {
        return ingame_mobs_t4;
    }

    public int getIngame_mobs_t5()
    {
        return ingame_mobs_t5;
    }

    public int getIngame_mobs_t6()
    {
        return ingame_mobs_t6;
    }

    public int getIngame_mobs_t7()
    {
        return ingame_mobs_t7;
    }

    public int getTotal_number_mobs() {
        return total_number_mobs;
    }

    public ArrayList<BaseBuilding> getBuildings() {
        return buildings;
    }

    public boolean isInicializacao() {
        return inicializacao;
    }

    //////////////////////////////// SETTER's ////////////////////////////////

    public void setIngame_mobs_t1(int ingame_mobs_t1) {
         this.ingame_mobs_t1 = ingame_mobs_t1;
    }

    public void setIngame_mobs_t2(int ingame_mobs_t2) {
         this.ingame_mobs_t2 = ingame_mobs_t2;
    }

    public void setIngame_mobs_t3(int ingame_mobs_t3)
    {
        this.ingame_mobs_t3 = ingame_mobs_t3;
    }

    public void setIngame_mobs_t4(int ingame_mobs_t4)
    {
        this.ingame_mobs_t4 = ingame_mobs_t4;
    }

    public void setIngame_mobs_t5(int ingame_mobs_t5)
    {
        this.ingame_mobs_t5 = ingame_mobs_t5;
    }

    public void setIngame_mobs_t6(int ingame_mobs_t6)
    {
        this.ingame_mobs_t6 = ingame_mobs_t6;
    }

    public void setIngame_mobs_t7(int ingame_mobs_t7)
    {
        this.ingame_mobs_t7 = ingame_mobs_t7;
    }
}