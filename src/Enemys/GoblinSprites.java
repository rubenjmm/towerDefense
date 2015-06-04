package Enemys;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ricardo on 16/04/2015.
 */
public abstract class GoblinSprites
{
    private static ArrayList<BufferedImage> listAttack = new ArrayList<BufferedImage>();
    private static ArrayList<BufferedImage> listWalking = new ArrayList<BufferedImage>();

    public GoblinSprites(){

    }


    static {
        String temp;

        try
        {
            for (int i = 12; i <= 18; i++)
            {
                temp = "Textures/Mobs/_goblin/goblin" + (i) + ".png";
                listWalking.add(ImageIO.read(new File(temp)));
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            for (int i = 18; i <= 22; i++)
            {
                temp = "Textures/Mobs/_goblin/goblin" + (String.format("%02d", i)) + ".png";
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
