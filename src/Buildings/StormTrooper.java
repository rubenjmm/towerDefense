package Buildings;

import com.Main;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Edificio tipo 2
 * @see Buildings.BaseBuilding
 */
public class StormTrooper extends BaseBuilding
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
    public StormTrooper(int x, int y)
    {

        type_building = 2;

        ///////Ir buscar às configurações
        atack_delay = Main.getOptions().getAttack_speed_b2();//ms
        atack = Main.getOptions().getAttack_b2(); //Damage

        inic();

        this.posx_b = x;
        this.posy_b = y;
        this.raio = Main.getOptions().getRaio_b2();

        posx = posx_b * 24;
        posy = posy_b * 25;

        // Default image
        img1 = StormTrooperSprites.getSpriteAttack().get(0);
        img2 = StormTrooperSprites.getSpriteAttack().get(1);

        ////////////////////////////////////////////////////////////////////////
        ArrayList<BufferedImage> listAttack = new ArrayList<BufferedImage>();
        listAttack.add(StormTrooperSprites.getBullet());
        atack_effect = new BaseAttack(listAttack, posx, posy, 150, 20);
    }

    /**
     * @see Buildings.BaseBuilding
     */
    @Override
    public void change_animation()
    {

    }
}