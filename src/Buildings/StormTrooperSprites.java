package Buildings;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class contentor para os sprites correspondentes aos edificios tipo 2
 */
public abstract class StormTrooperSprites
{
    private static ArrayList<BufferedImage> listAttack = new ArrayList<BufferedImage>();
    private  static BufferedImage bullet;

    public StormTrooperSprites() {

    }

    /**
     * Carregamento das imagens no programa
     */
    static {
        String temp;

        try
        {
            listAttack.add(ImageIO.read(new File("Textures/Buildings/_storm/storm6.png")));
            listAttack.add(ImageIO.read(new File("Textures/Buildings/_storm/storm7.png")));

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
