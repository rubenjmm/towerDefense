package Enemys;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ricardo on 16/04/2015.
 */
public abstract class RedSkeletonSprites
{
    private static ArrayList<BufferedImage> listAttack = new ArrayList<BufferedImage>();
    private static ArrayList<BufferedImage> listWalking = new ArrayList<BufferedImage>();
    private static ArrayList<BufferedImage> listDeath = new ArrayList<BufferedImage>();

    public RedSkeletonSprites() {

    }

    static {
        String temp;

        try
        {
            for (int i = 0; i <= 6; i++)
            {
                temp = "Textures/Mobs/_skeleton/red/walk/skelBase.01-00-00_walk" + (i) + "_r.png";
                listWalking.add(ImageIO.read(new File(temp)));
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            for (int i = 0; i <= 20; i++)
            {
                temp = "Textures/Mobs/_skeleton/red/attack/skelBase.01-00-00_punch" + (i) + "_r.png";
                listAttack.add(ImageIO.read(new File(temp)));
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            for (int i = 0; i <= 3; i++)
            {
                temp = "Textures/Mobs/_skeleton/red/die/skelBase.01-00-00_die" + (i) + "_r.png";
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