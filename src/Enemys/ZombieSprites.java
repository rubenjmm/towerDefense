package Enemys;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
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

    private static Image flipHorizontal(Image img, ImageObserver obs) {
        PixelGrabber pg;
        int[] pix;
        int[] newPix;
        int rows = img.getHeight(obs);
        int cols = img.getWidth(obs);

        pix = new int[rows*cols];
        newPix = new int[rows*cols];

        pg = new PixelGrabber(img, 0, 0, cols, rows, pix, 0, cols);

        try {
            pg.grabPixels();
        }
        catch (InterruptedException e) {
            System.out.println("interupted");
        }

        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                newPix[row*cols + (cols-col-1)] = pix[row*cols + col];

        img = null;

        Canvas imageCreator = new Canvas();
        img = imageCreator.createImage(new MemoryImageSource(cols, rows, newPix,
                0, cols));
        return img;

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