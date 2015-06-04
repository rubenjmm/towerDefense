package Buildings;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;



public abstract class StormTrooperSprites
{
    private static ArrayList<BufferedImage> listAttack = new ArrayList<BufferedImage>();
    private  static BufferedImage bullet;

    public StormTrooperSprites() {

    }

    static {
        String temp;

        try
        {
            listAttack.add(ImageIO.read(new File("Textures/Buildings/_storm/storm6.png")));
            listAttack.add(ImageIO.read(new File("Textures/Buildings/_storm/storm7.png")));

            bullet = ImageIO.read( new File("Textures/Buildings/BuildingOne/Bullets/1.png"));

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
