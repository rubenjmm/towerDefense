package Buildings;


import com.Main;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by Ricardo on 17/05/2015.
 */
public class BuildingOne extends BaseBuilding
{
    //ANIMACOES
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

    public BuildingOne(int x, int y) {

        type_building = 1;

        ///////Ir buscar às configurações
        atack_delay = Main.getOptions().getAttack_speed_b1();//ms
        atack = Main.getOptions().getAttack_b1(); //Damage

        inic();

        this.posx_b=x;
        this.posy_b=y;
        this.raio = Main.getOptions().getRaio_b1();

        posx=posx_b*24;
        posy=posy_b*25;

        // Default image
        img1 = BuildingOneSprites.getA11();
        img2 = BuildingOneSprites.getA21();

        ////////////////////////////////////////////////////////////////////////
        ArrayList<BufferedImage> listAttack = new ArrayList<BufferedImage>();
        listAttack.add(BuildingOneSprites.getBullet());
        atack_effect =  new Base_atack(listAttack,posx,posy,150,20);

    }

    @Override
    public void change_animation() {

        if(animation_actual_state==1){
            img1= BuildingOneSprites.getA15();
            img2= BuildingOneSprites.getA25();

        }
        else if(animation_actual_state==2) {

            img1= BuildingOneSprites.getA13();
            img2= BuildingOneSprites.getA23();

        }
        else if(animation_actual_state==3) {

            img1= BuildingOneSprites.getA12();
            img2= BuildingOneSprites.getA22();
        }
        else if(animation_actual_state==4) {

            img1= BuildingOneSprites.getA14();
            img2= BuildingOneSprites.getA24();
        }
        else if(animation_actual_state==5) {

            img1= BuildingOneSprites.getA16();
            img2= BuildingOneSprites.getA26();
        }
        else if(animation_actual_state==6) {

            img1= BuildingOneSprites.getA18();
            img2= BuildingOneSprites.getA28();

        }
        else if(animation_actual_state==7) {

            img1= BuildingOneSprites.getA11();
            img2= BuildingOneSprites.getA21();
        }
        else  {

            img1= BuildingOneSprites.getA17();
            img2= BuildingOneSprites.getA27();
        }

    }

}
