package Enemys;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class contentor para os sprites correspondentes aos monstros tipo 3
 */
public abstract class GunaSprites
{
    private static ArrayList<BufferedImage> listAttack = new ArrayList<BufferedImage>();
    private static ArrayList<BufferedImage> listWalking = new ArrayList<BufferedImage>();

    public GunaSprites(){

    }

    /**
     * Carregamento das imagens no programa
     */
    static {
        String temp;

        try
        {
            for (int i = 55; i <= 86; i = i +4)
            {
                temp = "Textures/Mobs/_guna/run/jared00" + (i) + ".png";
                listWalking.add(ImageIO.read(new File(temp)));
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            for (int i = 0; i <= 15; i = i +2)
            {
                temp = "Textures/Mobs/_guna/Attack/jared02" + (String.format("%02d", i)) + ".png";
                listAttack.add(ImageIO.read(new File(temp)));
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * @return -> Lista de imagens correspondentes ao ataque do monstro
     */
    public static ArrayList<BufferedImage> getSpriteAttack()
    {
        return listAttack;
    }

    /**
     * @return -> Lista de imagens correspondentes ao movimento do monstro
     */
    public static ArrayList<BufferedImage> getSpriteWalking()
    {
        return listWalking;
    }
}
