package Enemys;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ricardo on 16/04/2015.
 */
public abstract class GunaSprites
{
    private static ArrayList<BufferedImage> listAttack = new ArrayList<BufferedImage>();
    private static ArrayList<BufferedImage> listWalking = new ArrayList<BufferedImage>();

    public GunaSprites(){

    }

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

    public static ArrayList<BufferedImage> getSpriteAttack()
    {
        return listAttack;
    }

    public static ArrayList<BufferedImage> getSpriteWalking()
    {
        return listWalking;
    }
}
