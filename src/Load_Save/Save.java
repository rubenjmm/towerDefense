package Load_Save;



import com.company.Main;

import java.util.Formatter;

/**
 * Created by Ricardo on 11/04/2015.
 */
public class Save {

    public Save() {
    }

    private Formatter x;


    public void openFile() {


        try {
            x =  new Formatter("Saves/save.txt");
        } catch (Exception e) {
            System.out.println("Erro ao criar ficheiro de save: " + e);
        }

    }

    public void writeFile() {


        x.format("lvl = %d\r\n", Main.getLevel());
        x.format("Gold left in Store = %d\r\n",Main.getLoja().getCoins());
        x.format("Life of Player = %d\r\n\r\n",Main.getLoja().getLife());

        x.format("//////////////////////////////////Mobs//////////////////////////////////////\r\n");
        x.format("Total Numver of mobs = %d\r\n",Main.getGame_logic().getTotal_number_mobs());
        x.format("//////////////////////////////////Type_one:\r\n");
        x.format("Total Number of mobs  = %d\r\n", Main.getOptions().getNumber_mobs_t1() );
        x.format("Number of mobs spawned = %d\r\n",Main.getGame_logic().get_spawned_mobs_t1() );
        x.format("Life = %d\r\n", Main.getOptions().getLife_mobs_t1() );
        x.format("atack = %d\r\n", Main.getOptions().getAtack_mobs_t1());
        x.format("Coin value = %d\r\n", Main.getOptions().getCoin_mobs_t1() );

        for(int i =0;i< Main.getGame_logic().getTotal_number_mobs();i++) {
            if(Main.getGame_logic().getMobs()[i].mob_type==1  &&  Main.getGame_logic().getMobs()[i].isInGame() ) {
                x.format("\r\n");
                x.format("Posx = %d         Posy = %d\r\n", Main.getGame_logic().getMobs()[i].getPosx(), Main.getGame_logic().getMobs()[i].getPosy());
                x.format("Current life = %d\r\n", Main.getGame_logic().getMobs()[i].life);
                x.format("Animation State = %d\r\n", Main.getGame_logic().getMobs()[i].animation_state);
                if(Main.getGame_logic().getMobs()[i].is_dead)
                    x.format("Is dead = 1\r\n");
                else
                    x.format("Is dead = 0\r\n");

            }
        }

        x.format("//////////////////////////////////Type_two:\r\n");
        x.format("Total Number of mobs  = %d\r\n", Main.getOptions().getNumber_mobs_t2() );
        x.format("Number of mobs spawned = %d\r\n",Main.getGame_logic().get_spawned_mobs_t2() );
        x.format("Life = %d\r\n", Main.getOptions().getLife_mobs_t2() );
        x.format("atack = %d\r\n", Main.getOptions().getAtack_mobs_t2());
        x.format("Coin value = %d\r\n", Main.getOptions().getCoin_mobs_t2() );


        for(int i =0;i< Main.getGame_logic().getTotal_number_mobs();i++) {
            if(Main.getGame_logic().getMobs()[i].mob_type==2 && Main.getGame_logic().getMobs()[i].isInGame()) {
                x.format("\r\n");
                x.format("Posx = %d         Posy = %d\r\n", Main.getGame_logic().getMobs()[i].getPosx(), Main.getGame_logic().getMobs()[i].getPosy());
                x.format("Current life = %d\r\n", Main.getGame_logic().getMobs()[i].life);
                x.format("Animation State = %d\r\n", Main.getGame_logic().getMobs()[i].animation_state);
                if(Main.getGame_logic().getMobs()[i].is_dead)
                    x.format("Is dead = 1\r\n");
                else
                    x.format("Is dead = 0\r\n");


            }
        }

        x.format("//////////////////////////////////Buildings//////////////////////////////////////\r\n");
        x.format("//////////////////////////////////Type_one:\r\n");
        x.format("Total Number of buildings  = %d\r\n", Main.getGame_logic().getBuildings().size() );
        x.format("atack = %d\r\n", Main.getOptions().getAtack_b1());
        x.format("atack_delay = %d\r\n", Main.getOptions().getAtack_speed_b1() );
        x.format("Raio = %d\r\n",Main.getOptions().getRaio_b1());
        for(int i =0;i<  Main.getGame_logic().getBuildings().size() ;i++) {
            x.format("\r\n");
            x.format("Posx = %d         Posy = %d\r\n", Main.getGame_logic().getBuildings().get(i).posx, Main.getGame_logic().getBuildings().get(i).posy);
            x.format("Animation State = %d", Main.getGame_logic().getBuildings().get(i).animation_actual_state );
        }


    }

    public void closeFile() {

        x.close();
    }

}
