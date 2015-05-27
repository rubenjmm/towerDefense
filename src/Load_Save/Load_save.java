package Load_Save;


import com.company.Main;
import com.company.Mapa;

import java.io.File;
import java.util.Scanner;

public class Load_save {

    private Mapa map = Main.getMap();
    private Scanner x;
    private int posy,posx;

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

        int level =getint( new Scanner(x.nextLine()) );
    }

    public void gold() {

        int gold =getint( new Scanner(x.nextLine()) );
    }

    public void player_life() {

        int player_life =getint( new Scanner(x.nextLine()) );
        x.nextLine();
    }

    public void mobs(){

        x.nextLine();
        mobs_type1();
        mobs_type2();

    }

    public void mobs_type1() {


        x.nextLine();
        int n_mobs= getint( new Scanner(x.nextLine()) );
        int mobs_spawned =getint( new Scanner(x.nextLine()) );
        int life =getint( new Scanner(x.nextLine()) );
        int atack =getint( new Scanner(x.nextLine()) );
        int coin_value =getint( new Scanner(x.nextLine()) );


        for(int i=0;i<mobs_spawned;i++) {
            x.nextLine();

            getposicao( new Scanner(x.nextLine() ) );
            int current_life = getint( new Scanner(x.nextLine()) );
            int Animation_State= getint( new Scanner(x.nextLine()) );
            int is_dead = getint( new Scanner(x.nextLine()) );

        }
    }

    public void mobs_type2() {

        x.nextLine();
        int n_mobs= getint( new Scanner(x.nextLine()) );
        int mobs_spawned =getint( new Scanner(x.nextLine()) );
        int life =getint( new Scanner(x.nextLine()) );
        int atack =getint( new Scanner(x.nextLine()) );
        int coin_value =getint( new Scanner(x.nextLine()) );

        for(int i=0;i<mobs_spawned;i++) {
            x.nextLine();

            getposicao( new Scanner(x.nextLine() ) );
            int current_life = getint( new Scanner(x.nextLine()) );
            int Animation_State= getint( new Scanner(x.nextLine()) );
            int is_dead = getint( new Scanner(x.nextLine()) );
        }

    }

    public void buildings() {

        x.nextLine();
        x.nextLine();
        building_type1();
    }

    public void building_type1() {

        int n_buildings= getint( new Scanner(x.nextLine()) );
        int atack =getint( new Scanner(x.nextLine()) );
        int atack_delay =getint( new Scanner(x.nextLine()) );
        int raio = getint(new Scanner(x.nextLine()));

        x.nextLine();


        for(int i=0;i<n_buildings;i++) {

            getposicao( new Scanner(x.nextLine() ) );
            int Animation_State= getint( new Scanner(x.nextLine()) );


        }
    }



}
