package Enemys;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ricardo on 09/05/2015.
 */
public abstract class MonsterRedSprites
{
    private static ArrayList<BufferedImage> listAttack = new ArrayList<BufferedImage>();
    private static ArrayList<BufferedImage> listWalking = new ArrayList<BufferedImage>();
    private static ArrayList<BufferedImage> listDeath = new ArrayList<BufferedImage>();
    private static ArrayList<BufferedImage> listReborn = new ArrayList<BufferedImage>();

    public MonsterRedSprites() {

    }

    static {
        String temp;

        try
        {
            for (int i = 1; i <= 8; i++)
            {
                temp = "Textures/Mobs/Monster2/A_" + (i) + ".png";
                listWalking.add(ImageIO.read(new File(temp)));
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            for (int i = 1; i <= 6; i++)
            {
                temp = "Textures/Mobs/Monster2/atack_" + (i) + ".png";
                listAttack.add(ImageIO.read(new File(temp)));
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            for (int i = 1; i <= 6; i++)
            {
                temp = "Textures/Mobs/Monster2/N_" + (i) + ".png";
                listDeath.add(ImageIO.read(new File(temp)));
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            for (int i = 1; i <= 8; i++)
            {
                temp = "Textures/Mobs/Monster2/D_" + (i) + ".png";
                listReborn.add(ImageIO.read(new File(temp)));
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

    public static ArrayList<BufferedImage> getSpriteReborn()
    {
        return listReborn;
    }
}