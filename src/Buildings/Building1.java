package Buildings;


import java.awt.image.BufferedImage;
import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by Ricardo on 17/05/2015.
 */
public class Building1 extends Base_building {



    //ANIMACOES
    private int animation_state = 7;
    /*
       1 -> left
       2 -> left/up
       3 -> up
       4 -> right/up
       5 -> right
       6 -> right/down
       7 -> down
       8 -> left/down
     */

    private ArrayList<BufferedImage> List_1;
    private ArrayList<BufferedImage> List_2;
    private ArrayList<BufferedImage> List_3;
    private ArrayList<BufferedImage> List_4;
    private ArrayList<BufferedImage> List_5;
    private ArrayList<BufferedImage> List_6;
    private ArrayList<BufferedImage> List_7;
    private ArrayList<BufferedImage> List_8;


    public Building1 (int x,int y) {

        atack_delay = 500;//ms

        inic();

        this.posx_b=x;
        this.posy_b=y;

        atack_delay = 500; //ms

        List_1.add(Building1_sprites.getA15());
        List_1.add(Building1_sprites.getA25());

        List_2.add(Building1_sprites.getA13());
        List_2.add(Building1_sprites.getA23());

        List_3.add(Building1_sprites.getA12());
        List_3.add(Building1_sprites.getA22());

        List_4.add(Building1_sprites.getA14());
        List_4.add(Building1_sprites.getA24());

        List_5.add(Building1_sprites.getA16());
        List_5.add(Building1_sprites.getA26());

        List_6.add(Building1_sprites.getA18());
        List_6.add(Building1_sprites.getA28());

        List_7.add(Building1_sprites.getA11());
        List_7.add(Building1_sprites.getA21());

        List_8.add(Building1_sprites.getA17());
        List_8.add(Building1_sprites.getA27());


    }




}
