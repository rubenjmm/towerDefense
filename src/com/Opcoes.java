package com;

/**
 * Class contentor das opções de jogo relativas a monstros, edificios, etc.
 */
public class Opcoes {

/////////////////////////////////////////////////////////////////////////////
    private int number_mobs_t1;
    private int number_mobs_t2;
    private int number_mobs_t3;
    private int number_mobs_t4;
    private int number_mobs_t5;
    private int number_mobs_t6;
    private int number_mobs_t7;

    private int life_mobs_t1;
    private int life_mobs_t2;
    private int life_mobs_t3;
    private int life_mobs_t4;
    private int life_mobs_t5;
    private int life_mobs_t6;
    private int life_mobs_t7;

    private int attack_mobs_t1;//numero de swings até tirar 10%hp ao jogadors
    private int attack_mobs_t2;
    private int attack_mobs_t3;
    private int attack_mobs_t4;
    private int attack_mobs_t5;
    private int attack_mobs_t6;
    private int attack_mobs_t7;

    private int coin_mobs_t1;
    private int coin_mobs_t2;
    private int coin_mobs_t3;
    private int coin_mobs_t4;
    private int coin_mobs_t5;
    private int coin_mobs_t6;
    private int coin_mobs_t7;

///////////////////////////////////////////////////////////////////////////////
    private int raio_b1;
    private int attack_speed_b1;
    private int attack_b1;

    private int raio_b2;
    private int attack_speed_b2;
    private int attack_b2;

    private int raio_b3;
    private int attack_speed_b3;
    private int attack_b3;

    private int raio_b4;
    private int attack_speed_b4;
    private int attack_b4;

    private int tempo_entre_spawn_mobs;

    private int difficulty_type=0;

    private int building1Price = 15;
    private int building2Price = 1;
    private int building3Price = 50;
    private int building4Price = 100;

    public Opcoes(){

    }

    public void default_options (){
        if ( Main.getLevel()==1) {

            number_mobs_t1 = 1;
            number_mobs_t2 = 2;
            number_mobs_t3 = 3;
            number_mobs_t4 = 4;
            number_mobs_t5 = 5;
            number_mobs_t6 = 6;
            number_mobs_t7 = 7;

            life_mobs_t1=100;
            life_mobs_t2=150;
            life_mobs_t3 = 100;
            life_mobs_t4 = 100;
            life_mobs_t5 = 100;
            life_mobs_t6 = 100;
            life_mobs_t7 = 100;

            attack_mobs_t1 =3;
            attack_mobs_t2 =2;
            attack_mobs_t3 =2;
            attack_mobs_t4 =2;
            attack_mobs_t5 =2;
            attack_mobs_t6 =2;
            attack_mobs_t7 =2;

            coin_mobs_t1 = 5;
            coin_mobs_t2 = 10;
            coin_mobs_t3 = 10;
            coin_mobs_t4 = 10;
            coin_mobs_t5 = 10;
            coin_mobs_t6 = 10;
            coin_mobs_t7 = 10;

            raio_b1 = 220;
            attack_speed_b1 = 1500;
            attack_b1 = 15;

            raio_b2 = 220;
            attack_speed_b2 = 1500;
            attack_b2 = 15;

            raio_b3 = 220;
            attack_speed_b3 = 1500;
            attack_b3 = 15;

            raio_b4= 220;
            attack_speed_b4 = 1500;
            attack_b4 = 15;

            tempo_entre_spawn_mobs = 2500;

            building1Price = 15;
            building2Price = 1;
            building3Price = 50;
            building4Price = 100;
        }
    }

    public void  easy_difficulty() {

        difficulty_type=1;
        if ( Main.getLevel()==1) {
            number_mobs_t1 = 1;
            number_mobs_t2 = 2;
            number_mobs_t3 = 3;
            number_mobs_t4 = 4;
            number_mobs_t5 = 5;
            number_mobs_t6 = 6;
            number_mobs_t7 = 7;

            life_mobs_t1=100;
            life_mobs_t2=150;
            life_mobs_t3 = 100;
            life_mobs_t4 = 100;
            life_mobs_t5 = 100;
            life_mobs_t6 = 100;
            life_mobs_t7 = 100;

            attack_mobs_t1 =3;
            attack_mobs_t2 =2;
            attack_mobs_t3 =2;
            attack_mobs_t4 =2;
            attack_mobs_t5 =2;
            attack_mobs_t6 =2;
            attack_mobs_t7 =2;

            coin_mobs_t1 = 5;
            coin_mobs_t2 = 10;
            coin_mobs_t3 = 10;
            coin_mobs_t4 = 10;
            coin_mobs_t5 = 10;
            coin_mobs_t6 = 10;
            coin_mobs_t7 = 10;

            raio_b1 = 220;
            attack_speed_b1 = 1500;
            attack_b1 = 15;

            raio_b2 = 220;
            attack_speed_b2 = 1500;
            attack_b2 = 15;

            raio_b3 = 220;
            attack_speed_b3 = 1500;
            attack_b3 = 15;

            raio_b4= 220;
            attack_speed_b4 = 1500;
            attack_b4 = 15;

            tempo_entre_spawn_mobs = 2500;

            building1Price = 15;
            building2Price = 1;
            building3Price = 50;
            building4Price = 100;
        }
    }

    public void normal_difficulty() {

        difficulty_type=2;
        if ( Main.getLevel()==1) {
            number_mobs_t1 = 1;
            number_mobs_t2 = 2;
            number_mobs_t3 = 3;
            number_mobs_t4 = 4;
            number_mobs_t5 = 5;
            number_mobs_t6 = 6;
            number_mobs_t7 = 7;

            life_mobs_t1=100;
            life_mobs_t2=150;
            life_mobs_t3 = 100;
            life_mobs_t4 = 100;
            life_mobs_t5 = 100;
            life_mobs_t6 = 100;
            life_mobs_t7 = 100;

            attack_mobs_t1 =3;
            attack_mobs_t2 =2;
            attack_mobs_t3 =2;
            attack_mobs_t4 =2;
            attack_mobs_t5 =2;
            attack_mobs_t6 =2;
            attack_mobs_t7 =2;

            coin_mobs_t1 = 5;
            coin_mobs_t2 = 10;
            coin_mobs_t3 = 10;
            coin_mobs_t4 = 10;
            coin_mobs_t5 = 10;
            coin_mobs_t6 = 10;
            coin_mobs_t7 = 10;

            raio_b1 = 220;
            attack_speed_b1 = 1500;
            attack_b1 = 15;

            raio_b2 = 220;
            attack_speed_b2 = 1500;
            attack_b2 = 15;

            raio_b3 = 220;
            attack_speed_b3 = 1500;
            attack_b3 = 15;

            raio_b4= 220;
            attack_speed_b4 = 1500;
            attack_b4 = 15;

            tempo_entre_spawn_mobs = 2500;

            building1Price = 15;
            building2Price = 1;
            building3Price = 50;
            building4Price = 100;
        }
    }

    public void hard_difficulty() {
        difficulty_type=3;
        if ( Main.getLevel()==1) {
            number_mobs_t1 = 1;
            number_mobs_t2 = 2;
            number_mobs_t3 = 3;
            number_mobs_t4 = 4;
            number_mobs_t5 = 5;
            number_mobs_t6 = 6;
            number_mobs_t7 = 7;

            life_mobs_t1=100;
            life_mobs_t2=150;
            life_mobs_t3 = 100;
            life_mobs_t4 = 100;
            life_mobs_t5 = 100;
            life_mobs_t6 = 100;
            life_mobs_t7 = 100;

            attack_mobs_t1 =3;
            attack_mobs_t2 =2;
            attack_mobs_t3 =2;
            attack_mobs_t4 =2;
            attack_mobs_t5 =2;
            attack_mobs_t6 =2;
            attack_mobs_t7 =2;

            coin_mobs_t1 = 5;
            coin_mobs_t2 = 10;
            coin_mobs_t3 = 10;
            coin_mobs_t4 = 10;
            coin_mobs_t5 = 10;
            coin_mobs_t6 = 10;
            coin_mobs_t7 = 10;

            raio_b1 = 220;
            attack_speed_b1 = 1500;
            attack_b1 = 15;

            raio_b2 = 220;
            attack_speed_b2 = 1500;
            attack_b2 = 15;

            raio_b3 = 220;
            attack_speed_b3 = 1500;
            attack_b3 = 15;

            raio_b4= 220;
            attack_speed_b4 = 1500;
            attack_b4 = 15;

            tempo_entre_spawn_mobs = 2500;

            building1Price = 15;
            building2Price = 1;
            building3Price = 50;
            building4Price = 100;
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

    public int getAttack_mobs_t1() {
        return attack_mobs_t1;
    }

    public int getAttack_mobs_t2() {
        return attack_mobs_t2;
    }

    public int getCoin_mobs_t1() {
        return coin_mobs_t1;
    }

    public int getCoin_mobs_t2() {
        return coin_mobs_t2;
    }

    public int getNumber_mobs_t3()
    {
        return number_mobs_t3;
    }

    public int getNumber_mobs_t4()
    {
        return number_mobs_t4;
    }

    public int getNumber_mobs_t5()
    {
        return number_mobs_t5;
    }

    public int getNumber_mobs_t6()
    {
        return number_mobs_t6;
    }

    public int getNumber_mobs_t7()
    {
        return number_mobs_t7;
    }

    public int getLife_mobs_t3()
    {
        return life_mobs_t3;
    }

    public int getLife_mobs_t4()
    {
        return life_mobs_t4;
    }

    public int getLife_mobs_t5()
    {
        return life_mobs_t5;
    }

    public int getLife_mobs_t6()
    {
        return life_mobs_t6;
    }

    public int getLife_mobs_t7()
    {
        return life_mobs_t7;
    }

    public int getAttack_mobs_t3()
    {
        return attack_mobs_t3;
    }

    public int getAttack_mobs_t4()
    {
        return attack_mobs_t4;
    }

    public int getAttack_mobs_t5()
    {
        return attack_mobs_t5;
    }

    public int getAttack_mobs_t6()
    {
        return attack_mobs_t6;
    }

    public int getAttack_mobs_t7()
    {
        return attack_mobs_t7;
    }

    public int getCoin_mobs_t3()
    {
        return coin_mobs_t3;
    }

    public int getCoin_mobs_t4()
    {
        return coin_mobs_t4;
    }

    public int getCoin_mobs_t5()
    {
        return coin_mobs_t5;
    }

    public int getCoin_mobs_t6()
    {
        return coin_mobs_t6;
    }

    public int getCoin_mobs_t7()
    {
        return coin_mobs_t7;
    }

    public int getRaio_b1() {
        return raio_b1;
    }

    public int getAttack_speed_b1() {
        return attack_speed_b1;
    }

    public int getAttack_b1() {
        return attack_b1;
    }

    public int getRaio_b2() { return raio_b2;}

    public int getAttack_speed_b2()
    {
        return attack_speed_b2;
    }

    public int getAttack_b2()
    {
        return attack_b2;
    }

    public int getRaio_b3()
    {
        return raio_b3;
    }

    public int getAttack_speed_b3()
    {
        return attack_speed_b3;
    }

    public int getAttack_b3()
    {
        return attack_b3;
    }

    public int getRaio_b4()
    {
        return raio_b4;
    }

    public int getAttack_speed_b4()
    {
        return attack_speed_b4;
    }

    public int getAttack_b4()
    {
        return attack_b4;
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

    public void setAttack_mobs_t1(int attack_mobs_t1) {
        this.attack_mobs_t1 = attack_mobs_t1;
    }

    public void setAttack_mobs_t2(int attack_mobs_t2) {
        this.attack_mobs_t2 = attack_mobs_t2;
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

    public void setAttack_speed_b1(int atack_speed_b1) {
        this.attack_speed_b1 = atack_speed_b1;
    }

    public void setAttack_b1(int atack_b1) {
        this.attack_b1 = atack_b1;
    }

    public void setNumber_mobs_t3(int number_mobs_t3)
    {
        this.number_mobs_t3 = number_mobs_t3;
    }

    public void setNumber_mobs_t4(int number_mobs_t4)
    {
        this.number_mobs_t4 = number_mobs_t4;
    }

    public void setNumber_mobs_t5(int number_mobs_t5)
    {
        this.number_mobs_t5 = number_mobs_t5;
    }

    public void setNumber_mobs_t6(int number_mobs_t6)
    {
        this.number_mobs_t6 = number_mobs_t6;
    }

    public void setNumber_mobs_t7(int number_mobs_t7)
    {
        this.number_mobs_t7 = number_mobs_t7;
    }

    public void setLife_mobs_t3(int life_mobs_t3)
    {
        this.life_mobs_t3 = life_mobs_t3;
    }

    public void setLife_mobs_t4(int life_mobs_t4)
    {
        this.life_mobs_t4 = life_mobs_t4;
    }

    public void setLife_mobs_t5(int life_mobs_t5)
    {
        this.life_mobs_t5 = life_mobs_t5;
    }

    public void setLife_mobs_t6(int life_mobs_t6)
    {
        this.life_mobs_t6 = life_mobs_t6;
    }

    public void setLife_mobs_t7(int life_mobs_t7)
    {
        this.life_mobs_t7 = life_mobs_t7;
    }

    public void setAttack_mobs_t3(int attack_mobs_t3)
    {
        this.attack_mobs_t3 = attack_mobs_t3;
    }

    public void setAttack_mobs_t4(int attack_mobs_t4)
    {
        this.attack_mobs_t4 = attack_mobs_t4;
    }

    public void setAttack_mobs_t5(int attack_mobs_t5)
    {
        this.attack_mobs_t5 = attack_mobs_t5;
    }

    public void setAttack_mobs_t6(int attack_mobs_t6)
    {
        this.attack_mobs_t6 = attack_mobs_t6;
    }

    public void setAttack_mobs_t7(int attack_mobs_t7)
    {
        this.attack_mobs_t7 = attack_mobs_t7;
    }

    public void setCoin_mobs_t3(int coin_mobs_t3)
    {
        this.coin_mobs_t3 = coin_mobs_t3;
    }

    public void setCoin_mobs_t4(int coin_mobs_t4)
    {
        this.coin_mobs_t4 = coin_mobs_t4;
    }

    public void setCoin_mobs_t5(int coin_mobs_t5)
    {
        this.coin_mobs_t5 = coin_mobs_t5;
    }

    public void setCoin_mobs_t6(int coin_mobs_t6)
    {
        this.coin_mobs_t6 = coin_mobs_t6;
    }

    public void setCoin_mobs_t7(int coin_mobs_t7)
    {
        this.coin_mobs_t7 = coin_mobs_t7;
    }

    public void setRaio_b4(int raio_b4)
    {
        this.raio_b4 = raio_b4;
    }

    public void setAttack_speed_b4(int attack_speed_b4)
    {
        this.attack_speed_b4 = attack_speed_b4;
    }

    public void setAttack_b4(int attack_b4)
    {
        this.attack_b4 = attack_b4;
    }

    public void setRaio_b2(int raio_b2)
    {
        this.raio_b2 = raio_b2;
    }

    public void setAttack_speed_b2(int attack_speed_b2)
    {
        this.attack_speed_b2 = attack_speed_b2;
    }

    public void setAttack_b2(int attack_b2)
    {
        this.attack_b2 = attack_b2;
    }

    public void setRaio_b3(int raio_b3)
    {
        this.raio_b3 = raio_b3;
    }

    public void setAttack_speed_b3(int attack_speed_b3)
    {
        this.attack_speed_b3 = attack_speed_b3;
    }

    public void setAttack_b3(int attack_b3)
    {
        this.attack_b3 = attack_b3;
    }

    public void setTempo_entre_spawn_mobs(int tempo_entre_spawn_mobs) {
        this.tempo_entre_spawn_mobs = tempo_entre_spawn_mobs;
    }

    public int getBuilding1Price()
    {
        return building1Price;
    }

    public int getBuilding2Price()
    {
        return building2Price;
    }

    public int getBuilding3Price()
    {
        return building3Price;
    }

    public int getBuilding4Price()
    {
        return building4Price;
    }

    public void setBuilding1Price(int building1Price)
    {
        this.building1Price = building1Price;
    }

    public void setBuilding2Price(int building2Price)
    {
        this.building2Price = building2Price;
    }

    public void setBuilding3Price(int building3Price)
    {
        this.building3Price = building3Price;
    }

    public void setBuilding4Price(int building4Price)
    {
        this.building4Price = building4Price;
    }
}
