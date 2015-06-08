package Enemys;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class contentor para os sprites correspondentes aos monstros tipo 4
 */
public abstract class GoblinSprites
{
    private static ArrayList<BufferedImage> listAttack = new ArrayList<BufferedImage>();
    private static ArrayList<BufferedImage> listWalking = new ArrayList<BufferedImage>();

    public GoblinSprites(){

    }

    /**
     * Carregamento das imagens no programa
     */
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
