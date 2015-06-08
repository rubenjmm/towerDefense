package Load_Save;



import com.Main;

import java.util.Formatter;

/**
 * Created by Ricardo on 11/04/2015.
 */
public class Save
{

    public Save()
    {
    }

    private Formatter x;


    public void openFile()
    {

        try
        {
            x = new Formatter("Saves/save.txt");
        } catch (Exception e)
        {
            System.out.println("Erro ao criar ficheiro de save: " + e);
        }

    }

    public void writeFile()
    {

        x.format("lvl = %d\r\n", Main.getLevel());
        x.format("Gold left in Store = %d\r\n", Main.getLoja().getCoins());
        x.format("Life of Player = %d\r\n\r\n", Main.getLoja().getLife());

        x.format("//////////////////////////////////Mobs//////////////////////////////////////\r\n");
        x.format("Total Number of mobs = %d\r\n", Main.getGame_logic().getTotal_number_mobs());
        x.format("Spawn time between mobs = %d\r\n", Main.getOptions().getTempo_entre_spawn_mobs());
        x.format("//////////////////////////////////Type_one:\r\n");
        x.format("Total Number of mobs  = %d\r\n", Main.getOptions().getNumber_mobs_t1());
        x.format("Number of mobs spawned = %d\r\n", Main.getGame_logic().getIngame_mobs_t1());
        x.format("Life = %d\r\n", Main.getOptions().getLife_mobs_t1());
        x.format("attack = %d\r\n", Main.getOptions().getAttack_mobs_t1());
        x.format("Coin value = %d\r\n", Main.getOptions().getCoin_mobs_t1());

        for (int i = 0; i < Main.getGame_logic().getTotal_number_mobs(); i++)
        {
            if (Main.getGame_logic().getMobs()[i].mobType == 1 && Main.getGame_logic().getMobs()[i].isInGame())
            {
                x.format("\r\n");
                x.format("Posx = %d         Posy = %d\r\n", Main.getGame_logic().getMobs()[i].getPosx(), Main.getGame_logic().getMobs()[i].getPosy());
                x.format("Current life = %d\r\n", Main.getGame_logic().getMobs()[i].life);
                x.format("Animation State = %d\r\n", Main.getGame_logic().getMobs()[i].animationState);
                if (Main.getGame_logic().getMobs()[i].isDead) x.format("Is dead = 1\r\n");
                else x.format("Is dead = 0\r\n");

            }
        }

        x.format("//////////////////////////////////Type_two:\r\n");
        x.format("Total Number of mobs  = %d\r\n", Main.getOptions().getNumber_mobs_t2());
        x.format("Number of mobs spawned = %d\r\n", Main.getGame_logic().getIngame_mobs_t2());
        x.format("Life = %d\r\n", Main.getOptions().getLife_mobs_t2());
        x.format("attack = %d\r\n", Main.getOptions().getAttack_mobs_t2());
        x.format("Coin value = %d\r\n", Main.getOptions().getCoin_mobs_t2());

        for (int i = 0; i < Main.getGame_logic().getTotal_number_mobs(); i++)
        {
            if (Main.getGame_logic().getMobs()[i].mobType == 2 && Main.getGame_logic().getMobs()[i].isInGame())
            {
                x.format("\r\n");
                x.format("Posx = %d         Posy = %d\r\n", Main.getGame_logic().getMobs()[i].getPosx(), Main.getGame_logic().getMobs()[i].getPosy());
                x.format("Current life = %d\r\n", Main.getGame_logic().getMobs()[i].life);
                x.format("Animation State = %d\r\n", Main.getGame_logic().getMobs()[i].animationState);
                if (Main.getGame_logic().getMobs()[i].isDead) x.format("Is dead = 1\r\n");
                else x.format("Is dead = 0\r\n");


            }
        }

        x.format("//////////////////////////////////Type_three:\r\n");
        x.format("Total Number of mobs  = %d\r\n", Main.getOptions().getNumber_mobs_t3());
        x.format("Number of mobs spawned = %d\r\n", Main.getGame_logic().getIngame_mobs_t3());
        x.format("Life = %d\r\n", Main.getOptions().getLife_mobs_t3());
        x.format("attack = %d\r\n", Main.getOptions().getAttack_mobs_t3());
        x.format("Coin value = %d\r\n", Main.getOptions().getCoin_mobs_t3());

        for (int i = 0; i < Main.getGame_logic().getTotal_number_mobs(); i++)
        {
            if (Main.getGame_logic().getMobs()[i].mobType == 3 && Main.getGame_logic().getMobs()[i].isInGame())
            {
                x.format("\r\n");
                x.format("Posx = %d         Posy = %d\r\n", Main.getGame_logic().getMobs()[i].getPosx(), Main.getGame_logic().getMobs()[i].getPosy());
                x.format("Current life = %d\r\n", Main.getGame_logic().getMobs()[i].life);
                x.format("Animation State = %d\r\n", Main.getGame_logic().getMobs()[i].animationState);
                if (Main.getGame_logic().getMobs()[i].isDead) x.format("Is dead = 1\r\n");
                else x.format("Is dead = 0\r\n");
            }
        }

        x.format("//////////////////////////////////Type_four:\r\n");
        x.format("Total Number of mobs  = %d\r\n", Main.getOptions().getNumber_mobs_t4());
        x.format("Number of mobs spawned = %d\r\n", Main.getGame_logic().getIngame_mobs_t4());
        x.format("Life = %d\r\n", Main.getOptions().getLife_mobs_t4());
        x.format("attack = %d\r\n", Main.getOptions().getAttack_mobs_t4());
        x.format("Coin value = %d\r\n", Main.getOptions().getCoin_mobs_t4());

        for (int i = 0; i < Main.getGame_logic().getTotal_number_mobs(); i++)
        {
            if (Main.getGame_logic().getMobs()[i].mobType == 4 && Main.getGame_logic().getMobs()[i].isInGame())
            {
                x.format("\r\n");
                x.format("Posx = %d         Posy = %d\r\n", Main.getGame_logic().getMobs()[i].getPosx(), Main.getGame_logic().getMobs()[i].getPosy());
                x.format("Current life = %d\r\n", Main.getGame_logic().getMobs()[i].life);
                x.format("Animation State = %d\r\n", Main.getGame_logic().getMobs()[i].animationState);
                if (Main.getGame_logic().getMobs()[i].isDead) x.format("Is dead = 1\r\n");
                else x.format("Is dead = 0\r\n");
            }
        }

        x.format("//////////////////////////////////Type_five:\r\n");
        x.format("Total Number of mobs  = %d\r\n", Main.getOptions().getNumber_mobs_t5());
        x.format("Number of mobs spawned = %d\r\n", Main.getGame_logic().getIngame_mobs_t5());
        x.format("Life = %d\r\n", Main.getOptions().getLife_mobs_t5());
        x.format("attack = %d\r\n", Main.getOptions().getAttack_mobs_t5());
        x.format("Coin value = %d\r\n", Main.getOptions().getCoin_mobs_t5());

        for (int i = 0; i < Main.getGame_logic().getTotal_number_mobs(); i++)
        {
            if (Main.getGame_logic().getMobs()[i].mobType == 5 && Main.getGame_logic().getMobs()[i].isInGame())
            {
                x.format("\r\n");
                x.format("Posx = %d         Posy = %d\r\n", Main.getGame_logic().getMobs()[i].getPosx(), Main.getGame_logic().getMobs()[i].getPosy());
                x.format("Current life = %d\r\n", Main.getGame_logic().getMobs()[i].life);
                x.format("Animation State = %d\r\n", Main.getGame_logic().getMobs()[i].animationState);
                if (Main.getGame_logic().getMobs()[i].isDead) x.format("Is dead = 1\r\n");
                else x.format("Is dead = 0\r\n");
            }
        }

        x.format("//////////////////////////////////Type_six:\r\n");
        x.format("Total Number of mobs  = %d\r\n", Main.getOptions().getNumber_mobs_t6());
        x.format("Number of mobs spawned = %d\r\n", Main.getGame_logic().getIngame_mobs_t6());
        x.format("Life = %d\r\n", Main.getOptions().getLife_mobs_t6());
        x.format("attack = %d\r\n", Main.getOptions().getAttack_mobs_t6());
        x.format("Coin value = %d\r\n", Main.getOptions().getCoin_mobs_t6());

        for (int i = 0; i < Main.getGame_logic().getTotal_number_mobs(); i++)
        {
            if (Main.getGame_logic().getMobs()[i].mobType == 6 && Main.getGame_logic().getMobs()[i].isInGame())
            {
                x.format("\r\n");
                x.format("Posx = %d         Posy = %d\r\n", Main.getGame_logic().getMobs()[i].getPosx(), Main.getGame_logic().getMobs()[i].getPosy());
                x.format("Current life = %d\r\n", Main.getGame_logic().getMobs()[i].life);
                x.format("Animation State = %d\r\n", Main.getGame_logic().getMobs()[i].animationState);
                if (Main.getGame_logic().getMobs()[i].isDead) x.format("Is dead = 1\r\n");
                else x.format("Is dead = 0\r\n");
            }
        }

        x.format("//////////////////////////////////Type_seven:\r\n");
        x.format("Total Number of mobs  = %d\r\n", Main.getOptions().getNumber_mobs_t7());
        x.format("Number of mobs spawned = %d\r\n", Main.getGame_logic().getIngame_mobs_t7());
        x.format("Life = %d\r\n", Main.getOptions().getLife_mobs_t7());
        x.format("attack = %d\r\n", Main.getOptions().getAttack_mobs_t7());
        x.format("Coin value = %d\r\n", Main.getOptions().getCoin_mobs_t7());

        for (int i = 0; i < Main.getGame_logic().getTotal_number_mobs(); i++)
        {
            if (Main.getGame_logic().getMobs()[i].mobType == 7 && Main.getGame_logic().getMobs()[i].isInGame())
            {
                x.format("\r\n");
                x.format("Posx = %d         Posy = %d\r\n", Main.getGame_logic().getMobs()[i].getPosx(), Main.getGame_logic().getMobs()[i].getPosy());
                x.format("Current life = %d\r\n", Main.getGame_logic().getMobs()[i].life);
                x.format("Animation State = %d\r\n", Main.getGame_logic().getMobs()[i].animationState);
                if (Main.getGame_logic().getMobs()[i].isDead) x.format("Is dead = 1\r\n");
                else x.format("Is dead = 0\r\n");
            }
        }

        x.format("//////////////////////////////////Buildings//////////////////////////////////////\r\n");
        x.format("//////////////////////////////////Type_one:\r\n");
        x.format("Total Number of buildings  = %d\r\n", Main.getGame_logic().getBuildings().size());
        x.format("attack = %d\r\n", Main.getOptions().getAttack_b1());
        x.format("atack_delay = %d\r\n", Main.getOptions().getAttack_speed_b1());
        x.format("Raio = %d\r\n", Main.getOptions().getRaio_b1());
        x.format("Preço = %d\r\n", Main.getOptions().getBuilding1Price());
        for (int i = 0; i < Main.getGame_logic().getBuildings().size(); i++)
        {
            x.format("\r\n");
            x.format("Posx = %d         Posy = %d\r\n", Main.getGame_logic().getBuildings().get(i).posx_b, Main.getGame_logic().getBuildings().get(i).posy_b);
            //////ALTEREI AQUI PQPQPQPQ
            x.format("Animation State = %d\r\n", Main.getGame_logic().getBuildings().get(i).animation_actual_state);
        }

        x.format("//////////////////////////////////Type_two:\r\n");
        x.format("Total Number of buildings  = %d\r\n", Main.getGame_logic().getBuildings().size());
        x.format("attack = %d\r\n", Main.getOptions().getAttack_b2());
        x.format("atack_delay = %d\r\n", Main.getOptions().getAttack_speed_b2());
        x.format("Raio = %d\r\n", Main.getOptions().getRaio_b2());
        x.format("Preço = %d\r\n", Main.getOptions().getBuilding2Price());
        for (int i = 0; i < Main.getGame_logic().getBuildings().size(); i++)
        {
            x.format("\r\n");
            x.format("Posx = %d         Posy = %d\r\n", Main.getGame_logic().getBuildings().get(i).posx_b, Main.getGame_logic().getBuildings().get(i).posy_b);
            //////ALTEREI AQUI PQPQPQPQ
            x.format("Animation State = %d\r\n", Main.getGame_logic().getBuildings().get(i).animation_actual_state);
        }

        x.format("//////////////////////////////////Type_three:\r\n");
        x.format("Total Number of buildings  = %d\r\n", Main.getGame_logic().getBuildings().size());
        x.format("attack = %d\r\n", Main.getOptions().getAttack_b3());
        x.format("atack_delay = %d\r\n", Main.getOptions().getAttack_speed_b3());
        x.format("Raio = %d\r\n", Main.getOptions().getRaio_b3());
        x.format("Preço = %d\r\n", Main.getOptions().getBuilding3Price());
        for (int i = 0; i < Main.getGame_logic().getBuildings().size(); i++)
        {
            x.format("\r\n");
            x.format("Posx = %d         Posy = %d\r\n", Main.getGame_logic().getBuildings().get(i).posx_b, Main.getGame_logic().getBuildings().get(i).posy_b);
            //////ALTEREI AQUI PQPQPQPQ
            x.format("Animation State = %d\r\n", Main.getGame_logic().getBuildings().get(i).animation_actual_state);
        }

        x.format("//////////////////////////////////Type_four:\r\n");
        x.format("Total Number of buildings  = %d\r\n", Main.getGame_logic().getBuildings().size());
        x.format("attack = %d\r\n", Main.getOptions().getAttack_b4());
        x.format("atack_delay = %d\r\n", Main.getOptions().getAttack_speed_b4());
        x.format("Raio = %d\r\n", Main.getOptions().getRaio_b4());
        x.format("Preço = %d\r\n", Main.getOptions().getBuilding4Price());
        for (int i = 0; i < Main.getGame_logic().getBuildings().size(); i++)
        {
            x.format("\r\n");
            x.format("Posx = %d         Posy = %d\r\n", Main.getGame_logic().getBuildings().get(i).posx_b, Main.getGame_logic().getBuildings().get(i).posy_b);
            //////ALTEREI AQUI PQPQPQPQ
            x.format("Animation State = %d\r\n", Main.getGame_logic().getBuildings().get(i).animation_actual_state);
        }
    }

    public void closeFile()
    {

        x.close();
    }
}
