package Enemys;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ricardo on 16/04/2015.
 */
public abstract class ZombieSprites
{
    private static ArrayList<BufferedImage> listAttack = new ArrayList<BufferedImage>();
    private static ArrayList<BufferedImage> listWalking = new ArrayList<BufferedImage>();
    private static ArrayList<BufferedImage> listDeath = new ArrayList<BufferedImage>();

    public ZombieSprites() {

    }

    static {
        String temp;

        try
        {
            for (int i = 33; i <= 73; i++)
            {
                temp = "Textures/Mobs/_realZombie/walk/jared01" + (i) + ".png";
                listWalking.add(ImageIO.read(new File(temp)));
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            for (int i = 74; i <= 98; i++)
            {
                temp = "Textures/Mobs/_realZombie/Attack/jared01" + (i) + ".png";
                listAttack.add(ImageIO.read(new File(temp)));
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            for (int i = 90; i <= 121; i++)
            {
                temp = "Textures/Mobs/_realZombie/Dead/jared0" + (String.format("%03d", i)) + ".png";
                listDeath.add(ImageIO.read(new File(temp)));
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static ArrayList<BufferedImage> getSpriteAttack()
    {
        return listAttack;
    }

    public static ArrayList<BufferedImage> getSpriteWalking()
    {
        return listWalking;
    }

    public static ArrayList<BufferedImage> getSpriteDeath()
    {
        return listDeath;
    }
}