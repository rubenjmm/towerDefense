package Buildings;

import com.Main;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Edificio tipo 4
 * @see Buildings.BaseBuilding
 */
public class Cannon extends BaseBuilding
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

    /**
     * Construtor
     * @see Buildings.BaseBuilding
     */
    public Cannon(int x, int y) {

        type_building = 4;

        ///////Ir buscar às configurações
        atack_delay = Main.getOptions().getAttack_speed_b4();//ms
        atack = Main.getOptions().getAttack_b4(); //Damage

        inic();

        this.posx_b=x;
        this.posy_b=y;
        this.raio = Main.getOptions().getRaio_b4();

        posx=posx_b*24;
        posy=posy_b*25;

        // Default image
        img1 = CannonSprites.getSpriteAttack().get(0);
        img1 = CannonSprites.getSpriteAttack().get(1);

        ////////////////////////////////////////////////////////////////////////
        ArrayList<BufferedImage> listAttack = new ArrayList<BufferedImage>();
        listAttack.add(CannonSprites.getBullet());
        atack_effect =  new BaseAttack(listAttack,posx,posy,150,20);

    }

    /**
     * @see Buildings.BaseBuilding
     */
    @Override
    public void change_animation()
    {
        if(animation_actual_state==1)
        {
            img1 = CannonSprites.getSpriteAttack().get(0);
            img2 = CannonSprites.getSpriteAttack().get(1);
        }
        else if(animation_actual_state==2)
        {
            img1 = CannonSprites.getSpriteAttack().get(2);
            img2 = CannonSprites.getSpriteAttack().get(3);
        }
        else if(animation_actual_state==3)
        {
            img1 = CannonSprites.getSpriteAttack().get(4);
            img2 = CannonSprites.getSpriteAttack().get(5);
        }
        else if(animation_actual_state==4)
        {
            img1 = CannonSprites.getSpriteAttack().get(6);
            img2 = CannonSprites.getSpriteAttack().get(7);
        }
        else if(animation_actual_state==5)
        {
            img1 = CannonSprites.getSpriteAttack().get(8);
            img2 = CannonSprites.getSpriteAttack().get(9);
        }
        else if(animation_actual_state==6)
        {
            img1 = CannonSprites.getSpriteAttack().get(10);
            img2 = CannonSprites.getSpriteAttack().get(11);
        }
        else if(animation_actual_state==7) {
            img1 = CannonSprites.getSpriteAttack().get(12);
            img2 = CannonSprites.getSpriteAttack().get(13);
        }
        else if(animation_actual_state==8)
        {
            img1 = CannonSprites.getSpriteAttack().get(14);
            img2 = CannonSprites.getSpriteAttack().get(15);
        }
    }
}