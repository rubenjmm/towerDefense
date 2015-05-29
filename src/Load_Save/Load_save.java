package Load_Save;


import Buildings.Base_building;
import Buildings.Type_building;
import Enemys.Base_enemy;
import Enemys.Monster_1;
import Enemys.Monster_2;
import com.company.Main;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Load_save {

    private Scanner x;
    private int posy,posx;

    private Base_enemy[] mobs;
    private int total_mobs=0;
    private ArrayList<Base_building> buildings = new ArrayList<Base_building>();
    private Type_building type_b = new Type_building();

    private int level,gold,player_life;


    public Load_save() {

    }

    public void openFile(){

        try {

            x = new Scanner(new File("Saves/save.txt"));
        }catch (Exception e){

            System.out.println("Erro ao criar ficheiro de save: " + e);
        }


    }

    public void readFile(){


        level();
        gold();
        player_life();
        mobs();
        buildings();

        Main.load__old_game(level ,  gold  ,  player_life  ,  mobs  ,   buildings);

        //Main.setLevel(level);
        //Main.getLoja().setGold(gold);
        //Main.getLoja().setLife(player_life);
        //Main.getGame_logic().set_mobs(this.mobs);
        //Main.getGame_logic().set_buildings(this.buildings);

    }

    public void closeFile(){

        x.close();
    }


    public int getint(Scanner linescanner) {

        int a=0;

        while (linescanner.hasNext()) {

            if(linescanner.hasNextInt()) {
                a = linescanner.nextInt();
            }
            else
                linescanner.next();
        }
        return a;
    }

    public void getposicao(Scanner linescanner) {

        int count=0;

        while (linescanner.hasNext()) {

            if(linescanner.hasNextInt()) {
                if(count==0) {
                    posx = linescanner.nextInt();
                    count++;
                }
                else
                    posy = linescanner.nextInt();
            }
            else
                linescanner.next();
        }
    }

    public void level() {

        level =getint( new Scanner(x.nextLine()) );
    }

    public void gold() {

        gold =getint( new Scanner(x.nextLine()) );
    }

    public void player_life() {

        player_life =getint( new Scanner(x.nextLine()) );

        x.nextLine();
    }

    public void mobs(){

        x.nextLine();
        get_total_mobs();
        get_spawn_time();
        mobs = new Base_enemy[total_mobs];
        mobs_type1();
        mobs_type2();

    }

    public void get_total_mobs() {

        total_mobs = getint( new Scanner(x.nextLine()) );
    }

    public void get_spawn_time() {

        int Spawn_time = getint( new Scanner(x.nextLine()) );
        Main.getOptions().setTempo_entre_spawn_mobs(Spawn_time);
    }

    public void mobs_type1() {


        x.nextLine();
        int n_mobs= getint( new Scanner(x.nextLine()) );
        int mobs_spawned =getint( new Scanner(x.nextLine()) );
        int life =getint( new Scanner(x.nextLine()) );
        int atack =getint( new Scanner(x.nextLine()) );
        int coin_value =getint( new Scanner(x.nextLine()) );

        Main.getOptions().setNumber_mobs_t1(n_mobs);

        Main.getOptions().setLife_mobs_t1(life);
        Main.getOptions().setAtack_mobs_t1(atack);
        Main.getOptions().setCoin_mobs_t1(coin_value);

        int i=0,j=0;
        for(i=0;i<mobs_spawned;i++) {
            x.nextLine();

            getposicao( new Scanner(x.nextLine() ) );
            int current_life = getint( new Scanner(x.nextLine()) );
            int Animation_State= getint( new Scanner(x.nextLine()) );
            int is_dead = getint( new Scanner(x.nextLine()) );

            mobs[i] = new Monster_1();
            mobs[i].inGame=true;
            if(is_dead==0)
                mobs[i].is_dead=false;
            else
                mobs[i].is_dead=true;
            mobs[i].posx=posx;
            mobs[i].posy=posy;
            mobs[i].life=current_life;
            mobs[i].animation_state=Animation_State;
        }

        for(j=0;j< n_mobs - mobs_spawned;j++) {
            mobs[i+j] = new Monster_1();
        }


    }

    public void mobs_type2() {

        x.nextLine();
        int n_mobs= getint( new Scanner(x.nextLine()) );
        int mobs_spawned =getint( new Scanner(x.nextLine()) );
        int life =getint( new Scanner(x.nextLine()) );
        int atack =getint( new Scanner(x.nextLine()) );
        int coin_value =getint( new Scanner(x.nextLine()) );


        Main.getOptions().setNumber_mobs_t2(n_mobs);

        Main.getOptions().setLife_mobs_t2(life);
        Main.getOptions().setAtack_mobs_t2(atack);
        Main.getOptions().setCoin_mobs_t2(coin_value);

        int i=0,j=0;
        for(i=0;i<mobs_spawned;i++) {
            x.nextLine();

            getposicao( new Scanner(x.nextLine() ) );
            int current_life = getint( new Scanner(x.nextLine()) );
            int Animation_State= getint( new Scanner(x.nextLine()) );
            int is_dead = getint( new Scanner(x.nextLine()) );


            mobs[i] = new Monster_2();
            mobs[i].inGame=true;
            if(is_dead==0)
                mobs[i].is_dead=false;
            else
                mobs[i].is_dead=true;
            mobs[i].posx=posx;
            mobs[i].posy=posy;
            mobs[i].life=current_life;
            mobs[i].animation_state=Animation_State;
        }

        for(j=0;j< n_mobs - mobs_spawned;j++) {
            mobs[i+j] = new Monster_2();
        }

    }

    public void buildings() {

        x.nextLine();
        x.nextLine();
        building_type1();
    }

    public void building_type1() {

        int build_id=1;

        int n_buildings= getint( new Scanner(x.nextLine()) );
        int atack =getint( new Scanner(x.nextLine()) );
        int atack_delay =getint( new Scanner(x.nextLine()) );
        int raio = getint(new Scanner(x.nextLine()));



        Main.getOptions().setAtack_b1(atack);
        Main.getOptions().setAtack_speed_b1(atack_delay);
        Main.getOptions().setRaio_b1(raio);
        if(n_buildings>0){
            x.nextLine();
        }
        for(int i=0;i<n_buildings;i++) {

            getposicao( new Scanner(x.nextLine() ) );
            int Animation_State= getint( new Scanner(x.nextLine()) );

            buildings.add( type_b.get_building(build_id, posx, posy));
            buildings.get(i).setAnimation_state(Animation_State);
        }
    }



}
