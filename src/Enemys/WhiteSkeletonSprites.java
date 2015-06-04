package Enemys;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ricardo on 16/04/2015.
 */
public abstract class WhiteSkeletonSprites
{
    private static ArrayList<BufferedImage> listAttack = new ArrayList<BufferedImage>();
    private static ArrayList<BufferedImage> listWalking = new ArrayList<BufferedImage>();
    private static ArrayList<BufferedImage> listDeath = new ArrayList<BufferedImage>();

    public WhiteSkeletonSprites() {

    }

    static {
        String temp;

        try
        {
            for (int i = 1; i <= 6; i++)
            {
                temp = "Textures/Mobs/_skeleton/white/walk/skelBase.01-00-00_walk" + (i) + "_w.png";
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
                temp = "Textures/Mobs/_skeleton/white/attack/skelBase.01-00-00_punch" + (i) + "_w.png";
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
                temp = "Textures/Mobs/_skeleton/white/die/skelBase.01-00-00_die" + (i) + "_w.png";
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