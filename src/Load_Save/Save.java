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


        x.format("lvl = %d\r\n\r\n", Main.getLevel());

        x.format("//////////////////////////////////Mobs//////////////////////////////////////\r\n");
        x.format("//////////////////////////////////Type_one:\r\n");
        x.format("Total Number of mobs  = %d\r\n", Main.getOptions().getAtack_mobs_t1() );
        x.format("Number of mobs spawned = %d\r\n",Main.getGame_logic().getMobs_spawned_t1() );
        x.format("Life = %d\r\n", Main.getOptions().getLife_mobs_t1() );
        x.format("atack = %d\r\n", Main.getOptions().getLife_mobs_t1());
        x.format("Coin value = %d\r\n", Main.getOptions().getCoin_mobs_t1() );
        int numero_mobs_a_guardar = Main.getOptions().getNumber_mobs_t1()   -   Main.getGame_logic().getMobs_spawned_t1();
        int contador_mobs=0;
        for(int i =0;i< Main.getGame_logic().getTotal_number_mobs();i++) {
            if(Main.getGame_logic().getMobs()[i].mob_type==1) {
                contador_mobs++;
                x.format("Posx = %d         Posy = %d\r\n", Main.getGame_logic().getMobs()[i].getPosx(), Main.getGame_logic().getMobs()[i].getPosy());
                x.format("Current life = %d\r\n", Main.getGame_logic().getMobs()[i].life);
                x.format("Animation State = %d\r\n", Main.getGame_logic().getMobs()[i].animation_state);
                x.format("Is dead = %d", Main.getGame_logic().getMobs()[i].is_dead);
                if(contador_mobs == numero_mobs_a_guardar - 1) {
                    break;
                }
            }
        }


        x.format("//////////////////////////////////Type_two:\r\n");
        x.format("//////////////////////////////////Type_one:\r\n");
        x.format("Total Number of mobs  = %d\r\n", Main.getOptions().getAtack_mobs_t2() );
        x.format("Number of mobs spawned = %d\r\n",Main.getGame_logic().getMobs_spawned_t2() );
        x.format("Life = %d\r\n", Main.getOptions().getLife_mobs_t2() );
        x.format("atack = %d\r\n", Main.getOptions().getLife_mobs_t2());
        x.format("Coin value = %d\r\n", Main.getOptions().getCoin_mobs_t2() );
        numero_mobs_a_guardar = Main.getOptions().getNumber_mobs_t2()   -   Main.getGame_logic().getMobs_spawned_t2();
        contador_mobs=0;
        for(int i =0;i< Main.getGame_logic().getTotal_number_mobs();i++) {
            if(Main.getGame_logic().getMobs()[i].mob_type==2) {
                contador_mobs++;
                x.format("Posx = %d         Posy = %d\r\n", Main.getGame_logic().getMobs()[i].getPosx(), Main.getGame_logic().getMobs()[i].getPosy());
                x.format("Current life = %d\r\n", Main.getGame_logic().getMobs()[i].life);
                x.format("Animation State = %d\r\n", Main.getGame_logic().getMobs()[i].animation_state);
                x.format("Is dead = %d", Main.getGame_logic().getMobs()[i].is_dead);
                if(contador_mobs == numero_mobs_a_guardar - 1) {
                    break;
                }
            }
        }

        x.format("//////////////////////////////////Buildings//////////////////////////////////////\r\n");
        x.format("//////////////////////////////////Type_one:\r\n");
        x.format("Total Number of buildings  = %d\r\n", Main.getGame_logic().getBuildings().size() );
        x.format("atack = %d\r\n", Main.getOptions().getAtack_b1());
        x.format("atack_delay = %d\r\n", Main.getOptions().getAtack_speed_b1() );
        for(int i =0;i<  Main.getGame_logic().getBuildings().size() ;i++) {
            x.format("Posx = %d         Posy = %d\r\n", Main.getGame_logic().getBuildings().get(i).posx, Main.getGame_logic().getBuildings().get(i).posy);
            x.format("Current life = %d\r\n", Main.getGame_logic().getMobs()[i].life);
            x.format("Animation State = %d\r\n", Main.getGame_logic().getMobs()[i].animation_state);
        }



/*
        for(i= 0;i<Opcoes.getN_x_();i++){
            for(j= 0;j<Opcoes.getN_x_n();j++){
                x.format( "%c",Main.getLabirinto().getMatrizlabirinto()[i][j] );
            }
            x.format("\r\n");
        }

        /*
        x.format("//////////////////////////////////Dragões//////////////////////////////////////\r\n");
        x.format("Numero de dragões = %d\r\n", Estrategia.getN_dragoes());
        x.format("Modo do dragão = %c\r\n\r\n", Estrategia.getModo_dragao());
        for(i= 0;i<Estrategia.getN_dragoes();i++){
            x.format("Posicão   x= %d y= %d\r\nestado= %d\r\n\r\n",
                    Main.getLabirinto().getDragoes().get(i).getPos_x(),
                    Main.getLabirinto().getDragoes().get(i).getPos_y(),
                    Main.getLabirinto().getDragoes().get(i).getEstado());
        }


        x.format("//////////////////////////////////Dardos//////////////////////////////////////\r\n");
        x.format("Numero de dardos = %d\r\n\r\n", Main.getLabirinto().getDardos().size());
        for(i= 0;i<Main.getLabirinto().getDardos().size();i++){
            x.format("Posicão   x= %d y= %d\r\nestado= %d\r\n\r\n",
                    Main.getLabirinto().getDardos().get(i).getPos_x(),
                    Main.getLabirinto().getDardos().get(i).getPos_y(),
                    Main.getLabirinto().getDardos().get(i).getEstado());
        }

        x.format("//////////////////////////////////Espada//////////////////////////////////////\r\n\r\n");
        x.format("Posicão   x= %d y= %d\r\nestado= %d\r\n\r\n",
                Main.getLabirinto().getSword().getPos_x(),
                Main.getLabirinto().getSword().getPos_y(),
                Main.getLabirinto().getSword().getEstado());


        x.format("//////////////////////////////////Escudo//////////////////////////////////////\r\n\r\n");
//0->foi apanhado pelo heroi
        x.format("Posicão   x= %d y= %d\r\nestado= %d\r\n\r\n",
                Main.getLabirinto().getShield().getPos_x(),
                Main.getLabirinto().getShield().getPos_y(),
                Main.getLabirinto().getShield().getEstado());

        x.format("//////////////////////////////////Saida//////////////////////////////////////\r\n\r\n");
//aberta= 1
        x.format("Posicão   x= %d y= %d\r\nestado= %d\r\n\r\n",
                Main.getLabirinto().getexit().getPos_x(),
                Main.getLabirinto().getexit().getPos_y(),
                Main.getLabirinto().getexit().getEstado());

        x.format("//////////////////////////////////Heroi//////////////////////////////////////\r\n\r\n");
        if(Main.getLabirinto().getHeroi().isTem_shield())
            i= 1;
        else
            i= 0;
        x.format("Posicão   x= %d y= %d\r\nestado= %d\r\nn_dardos= %d\r\ntem_shield= %d\r\n\r\n",
                Main.getLabirinto().getHeroi().getPos_x(),
                Main.getLabirinto().getHeroi().getPos_y(),
                Main.getLabirinto().getHeroi().getEstado(),
                Main.getLabirinto().getHeroi().getTem_n_dardos()
                ,i);

*/
    }

    public void closeFile() {

        x.close();
    }

}
