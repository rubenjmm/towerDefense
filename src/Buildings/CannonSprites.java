package Buildings;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public abstract class CannonSprites
{
    private static ArrayList<BufferedImage> listAttack = new ArrayList<BufferedImage>();
    private  static BufferedImage bullet;

    public CannonSprites() {

    }

    static {
        String temp;

        try
        {
            for (int i = 1; i <= 16; i++)
            {
                temp = "Textures/Buildings/_cannon/can" + (i) + ".png";
                listAttack.add(ImageIO.read(new File(temp)));
            }
            bullet = ImageIO.read( new File("Textures/Buildings/Building1/Bullets/1.png"));

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static BufferedImage getBullet() {
        return bullet;
    }

    public static ArrayList<BufferedImage> getSpriteAttack()
    {
        return listAttack;
    }
}
