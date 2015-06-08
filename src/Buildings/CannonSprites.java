package Buildings;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class contentor para os sprites correspondentes aos edificios tipo 4
 */
public abstract class CannonSprites
{
    private static ArrayList<BufferedImage> listAttack = new ArrayList<BufferedImage>();
    private  static BufferedImage bullet;

    public CannonSprites() {

    }

    /**
     * Carregamento das imagens no programa
     */
    static {
        String temp;

        try
        {
            for (int i = 1; i <= 16; i++)
            {
                temp = "Textures/Buildings/_cannon/can" + (i) + ".png";
                listAttack.add(ImageIO.read(new File(temp)));
            }
            bullet = ImageIO.read( new File("Textures/Buildings/BuildingOne/Bullets/1.png"));

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * @return -> Lista de imagens correspondentes ao movimento do projectil
     */
    public static BufferedImage getBullet() {
        return bullet;
    }

    /**
     * @return -> Lista de imagens correspondentes ao movimento da torre
     */
    public static ArrayList<BufferedImage> getSpriteAttack()
    {
        return listAttack;
    }
}
