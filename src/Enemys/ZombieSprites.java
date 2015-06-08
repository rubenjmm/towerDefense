package Enemys;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class contentor para os sprites correspondentes aos monstros tipo 7
 */
public abstract class ZombieSprites
{
    private static ArrayList<BufferedImage> listAttack = new ArrayList<BufferedImage>();
    private static ArrayList<BufferedImage> listWalking = new ArrayList<BufferedImage>();
    private static ArrayList<BufferedImage> listDeath = new ArrayList<BufferedImage>();

    public ZombieSprites() {

    }

    /**
     * Carregamento das imagens no programa
     */
    static {
        String temp;

        try
        {
            for (int i = 33; i <= 73; i = i +4)
            {
                temp = "Textures/Mobs/_realZombie/walk_hFlip/jared01" + (i) + ".png";
                listWalking.add(ImageIO.read(new File(temp)));
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            for (int i = 74; i <= 98; i = i +4)
            {
                temp = "Textures/Mobs/_realZombie/Attack_hFlip/jared01" + (i) + ".png";
                listAttack.add(ImageIO.read(new File(temp)));
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            for (int i = 90; i <= 121; i = i +4)
            {
                temp = "Textures/Mobs/_realZombie/Dead_hFlip/jared0" + (String.format("%03d", i)) + ".png";
                listDeath.add(ImageIO.read(new File(temp)));
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

    /**
     * @return -> Lista de imagens correspondentes a morte do monstro
     */
    public static ArrayList<BufferedImage> getSpriteDeath()
    {
        return listDeath;
    }
}