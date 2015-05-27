package com.company;

/**
 * Created by Ricardo on 26/04/2015.
 */
public class Opcoes {

/////////////////////////////////////////////////////////////////////////////
    private int number_mobs_t1;
    private int number_mobs_t2;

    private int life_mobs_t1;
    private int life_mobs_t2;

    private int atack_mobs_t1;//numero de swings até tirar 10%hp ao jogadors
    private int atack_mobs_t2;

    private int coin_mobs_t1;
    private int coin_mobs_t2;
///////////////////////////////////////////////////////////////////////////////
    private int raio_b1;
    private int atack_speed_b1;
    private int atack_b1;


    private int tempo_entre_spawn_mobs;


    private int difficulty_type=0;



    public Opcoes(){

    }



    public void default_options (){

        if ( Main.getLevel()==1) {

            number_mobs_t1=1;
            number_mobs_t2=2;

            life_mobs_t1=100;
            life_mobs_t2=150;

            atack_mobs_t1=3;
            atack_mobs_t2=2;

            coin_mobs_t1=5;
            coin_mobs_t2=10;

            raio_b1=220;
            atack_speed_b1=1500;
            atack_b1=15;

            tempo_entre_spawn_mobs=2500;


        }
    }


    public void  easy_difficulty() {

        difficulty_type=1;
        if ( Main.getLevel()==1) {

            number_mobs_t1=1;
            number_mobs_t2=2;

            life_mobs_t1=100;
            life_mobs_t2=150;

            atack_mobs_t1=3;
            atack_mobs_t2=2;

            coin_mobs_t1=5;
            coin_mobs_t2=10;

            raio_b1=220;
            atack_speed_b1=1500;
            atack_b1=15;

            tempo_entre_spawn_mobs=2500;


        }
    }

    public void normal_difficulty() {

        difficulty_type=2;
        if ( Main.getLevel()==1) {

            number_mobs_t1=3;
            number_mobs_t2=3;

            life_mobs_t1=120;
            life_mobs_t2=170;

            atack_mobs_t1=4;
            atack_mobs_t2=3;

            coin_mobs_t1=8;
            coin_mobs_t2=15;

            raio_b1=220;
            atack_speed_b1=1500;
            atack_b1=15;

            tempo_entre_spawn_mobs=3000;


        }
    }

    public void hard_difficulty() {

        difficulty_type=3;
        if ( Main.getLevel()==1) {

            number_mobs_t1=7;
            number_mobs_t2=6;

            life_mobs_t1=120;
            life_mobs_t2=170;

            atack_mobs_t1=3;
            atack_mobs_t2=2;

            coin_mobs_t1=5;
            coin_mobs_t2=10;

            raio_b1=220;
            atack_speed_b1=1500;
            atack_b1=15;

            tempo_entre_spawn_mobs=4500;


        }
    }


//////////////////////////// GETTER'S ////////////////////////////


    public int getTempo_entre_spawn_mobs() {
        return tempo_entre_spawn_mobs;
    }


    public int getNumber_mobs_t1() {
        return number_mobs_t1;
    }

    public int getNumber_mobs_t2() {
        return number_mobs_t2;
    }

    public int getLife_mobs_t1() {
        return life_mobs_t1;
    }

    public int getLife_mobs_t2() {
        return life_mobs_t2;
    }

    public int getAtack_mobs_t1() {
        return atack_mobs_t1;
    }

    public int getAtack_mobs_t2() {
        return atack_mobs_t2;
    }

    public int getCoin_mobs_t1() {
        return coin_mobs_t1;
    }

    public int getCoin_mobs_t2() {
        return coin_mobs_t2;
    }

    public int getRaio_b1() {
        return raio_b1;
    }

    public int getAtack_speed_b1() {
        return atack_speed_b1;
    }

    public int getAtack_b1() {
        return atack_b1;
    }

    public void setNumber_mobs_t1(int number_mobs_t1) {
        this.number_mobs_t1 = number_mobs_t1;
    }

    public void setNumber_mobs_t2(int number_mobs_t2) {
        this.number_mobs_t2 = number_mobs_t2;
    }

    public void setLife_mobs_t1(int life_mobs_t1) {
        this.life_mobs_t1 = life_mobs_t1;
    }

    public void setLife_mobs_t2(int life_mobs_t2) {
        this.life_mobs_t2 = life_mobs_t2;
    }

    public void setAtack_mobs_t1(int atack_mobs_t1) {
        this.atack_mobs_t1 = atack_mobs_t1;
    }

    public void setAtack_mobs_t2(int atack_mobs_t2) {
        this.atack_mobs_t2 = atack_mobs_t2;
    }

    public void setCoin_mobs_t1(int coin_mobs_t1) {
        this.coin_mobs_t1 = coin_mobs_t1;
    }

    public void setCoin_mobs_t2(int coin_mobs_t2) {
        this.coin_mobs_t2 = coin_mobs_t2;
    }

    public void setRaio_b1(int raio_b1) {
        this.raio_b1 = raio_b1;
    }

    public void setAtack_speed_b1(int atack_speed_b1) {
        this.atack_speed_b1 = atack_speed_b1;
    }

    public void setAtack_b1(int atack_b1) {
        this.atack_b1 = atack_b1;
    }

    public void setTempo_entre_spawn_mobs(int tempo_entre_spawn_mobs) {
        this.tempo_entre_spawn_mobs = tempo_entre_spawn_mobs;
    }

}
