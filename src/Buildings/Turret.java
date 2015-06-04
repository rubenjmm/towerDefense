package Buildings;

import com.Main;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Turret extends BaseBuilding
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

    public Turret (int x,int y ) {

        type_building = 3;

        ///////Ir buscar às configurações
        atack_delay = Main.getOptions().getAttack_speed_b3();//ms
        atack = Main.getOptions().getAttack_b3(); //Damage

        inic();

        this.posx_b=x;
        this.posy_b=y;
        this.raio = Main.getOptions().getRaio_b3();

        posx=posx_b*24;
        posy=posy_b*25;

        // Default image
        img1 = TurretSprites.getSpriteAttack().get(1);
        img1 = TurretSprites.getSpriteAttack().get(2);

        ////////////////////////////////////////////////////////////////////////
        ArrayList<BufferedImage> listAttack = new ArrayList<BufferedImage>();
        listAttack.add(TurretSprites.getBullet());
        atack_effect =  new Base_atack(listAttack,posx,posy,150,20);

    }

    @Override
    public void change_animation()
    {
        if(animation_actual_state==1)
        {
            img1 = TurretSprites.getSpriteAttack().get(0);
            img2 = TurretSprites.getSpriteAttack().get(1);
        }
        else if(animation_actual_state==2)
        {
            img1 = TurretSprites.getSpriteAttack().get(2);
            img2 = TurretSprites.getSpriteAttack().get(3);
        }
        else if(animation_actual_state==3)
        {
            img1 = TurretSprites.getSpriteAttack().get(4);
            img2 = TurretSprites.getSpriteAttack().get(5);
        }
        else if(animation_actual_state==4)
        {
            img1 = TurretSprites.getSpriteAttack().get(6);
            img2 = TurretSprites.getSpriteAttack().get(7);
        }
        else if(animation_actual_state==5)
        {
            img1 = TurretSprites.getSpriteAttack().get(8);
            img2 = TurretSprites.getSpriteAttack().get(9);
        }
        else if(animation_actual_state==6)
        {
            img1 = TurretSprites.getSpriteAttack().get(10);
            img2 = TurretSprites.getSpriteAttack().get(11);
        }
        else if(animation_actual_state==7) {
            img1 = TurretSprites.getSpriteAttack().get(12);
            img2 = TurretSprites.getSpriteAttack().get(13);
        }
        else if(animation_actual_state==8)
        {
            img1 = TurretSprites.getSpriteAttack().get(14);
            img2 = TurretSprites.getSpriteAttack().get(15);
        }
    }
}
