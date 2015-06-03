package Load_Save;


import Buildings.Base_building;
import Buildings.Type_building;
import Enemys.BaseEnemy;
import Enemys.MonsterBlue;
import Enemys.MonsterRed;
import com.company.Main;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Load_save {

    private Scanner x;
    private int posy,posx;

    private BaseEnemy[] mobs;
    private int total_mobs=0;
    private ArrayList<Base_building> buildings = new ArrayList<Base_building>();
    private Type_building type_b = new Type_building();

    private int level,gold,player_life;

    private int mobs_created=0;

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


        //fazer pause ao draw
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
        Load_level load = new Load_level("lvl"+Integer.toString(level));
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
        mobs = new BaseEnemy[total_mobs];
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
        Main.getGame_logic().set_spawned_mobs_t1(mobs_spawned);
        Main.getOptions().setLife_mobs_t1(life);
        Main.getOptions().setAtack_mobs_t1(atack);
        Main.getOptions().setCoin_mobs_t1(coin_value);

        int i;
        int j = 0;
        for(i=0;i<mobs_spawned;i++) {
            x.nextLine();

            getposicao( new Scanner(x.nextLine() ) );
            int current_life = getint( new Scanner(x.nextLine()) );
            int Animation_State= getint( new Scanner(x.nextLine()) );
            int is_dead = getint( new Scanner(x.nextLine()) );

            mobs[mobs_created] = new MonsterBlue();
            mobs[mobs_created].inGame=true;
            if(is_dead==0)
                mobs[mobs_created].isDead =false;
            else
                mobs[mobs_created].isDead =true;
            mobs[mobs_created].posx=posx;
            mobs[mobs_created].posy=posy;
            mobs[mobs_created].life=current_life;
            mobs[mobs_created].animationState =Animation_State;

            mobs[mobs_created].posy_b = posx / 24;
            mobs[mobs_created].posx_b = posy / 24;

            mobs[mobs_created].startMob();

            mobs_created++;
        }

        for(j=0;j< n_mobs - mobs_spawned;j++) {
            mobs[mobs_created] = new MonsterBlue();

            mobs_created++;
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
        Main.getGame_logic().set_spawned_mobs_t2(mobs_spawned);
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


            mobs[mobs_created] = new MonsterRed();
            mobs[mobs_created].inGame=true;
            if(is_dead==0)
                mobs[mobs_created].isDead =false;
            else
                mobs[mobs_created].isDead =true;
            mobs[mobs_created].posx=posx;
            mobs[mobs_created].posy=posy;
            mobs[mobs_created].life=current_life;
            mobs[mobs_created].animationState =Animation_State;

            mobs[mobs_created].posy_b = posx / 24;
            mobs[mobs_created].posx_b = posy / 24;

            mobs[mobs_created].startMob();


            mobs_created++;
        }


        for(j=0;j< n_mobs - mobs_spawned;j++) {
            mobs[mobs_created] = new MonsterRed();

            mobs_created++;
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
