package Enemys;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Ricardo on 16/04/2015.
 */
public abstract class  Guna_sprites {

    //private static BufferedImage spriteSheet;

    //BufferedImage[] sprites = new BufferedImage[rows * columns];
    //            sprites[(i * columns) + j] = spriteSheet.getSubimage(i * width, j * height, width, height);

    //      //g.drawImage(sprites[1], 100, 100, null);

    /*
    private static BufferedImage up1;
    private static BufferedImage up2;

    private static BufferedImage down1;
    private static BufferedImage down2;

    private static BufferedImage left1;
    private static BufferedImage left2;

    private static BufferedImage right1;
    private static BufferedImage right2;
    */

    private  static BufferedImage z1;
    private  static BufferedImage z2;
    private  static BufferedImage z3;
    private  static BufferedImage z4;
    private  static BufferedImage z5;
    private  static BufferedImage z6;
    private  static BufferedImage z7;

    private  static BufferedImage Z_a1;
    private  static BufferedImage Z_a2;
    private  static BufferedImage Z_a3;
    private  static BufferedImage Z_a4;
    private  static BufferedImage Z_a5;


    public  Guna_sprites() {

        inic();
    }

    public static void inic(){

        try {
            z1 = ImageIO.read(new File("Textures/Mobs/Zombies/Z1.png"));//WIDTH 39          HEIGHT->32
            z2 = ImageIO.read(new File("Textures/Mobs/Zombies/Z2.png"));
            z3 = ImageIO.read(new File("Textures/Mobs/Zombies/Z3.png"));
            z4 = ImageIO.read(new File("Textures/Mobs/Zombies/Z4.png"));
            z5 = ImageIO.read(new File("Textures/Mobs/Zombies/Z5.png"));
            z6 = ImageIO.read(new File("Textures/Mobs/Zombies/Z6.png"));
            z7 = ImageIO.read(new File("Textures/Mobs/Zombies/Z7.png"));

            Z_a1 = ImageIO.read(new File("Textures/Mobs/Zombies/Z_a1.png"));//WIDTH47  HEIGHT 52
            Z_a2 = ImageIO.read(new File("Textures/Mobs/Zombies/Z_a2.png"));
            Z_a3 = ImageIO.read(new File("Textures/Mobs/Zombies/Z_a3.png"));
            Z_a4 = ImageIO.read(new File("Textures/Mobs/Zombies/Z_a4.png"));
            Z_a5 = ImageIO.read(new File("Textures/Mobs/Zombies/Z_a5.png"));

        } catch (IOException e) {

            e.printStackTrace();
        }


        //up1 = spriteSheet.getSubimage();
        //up2 = spriteSheet.getSubimage();

    }

    public  static BufferedImage getZ1() {
        return z1;
    }

    public  static BufferedImage getZ2() {
        return z2;
    }

    public  static BufferedImage getZ3() {
        return z3;
    }

    public  static BufferedImage getZ4() {
        return z4;
    }

    public  static BufferedImage getZ5() {
        return z5;
    }

    public  static BufferedImage getZ6() {
        return z6;
    }

    public  static BufferedImage getZ7() {
        return z7;
    }


    public static BufferedImage getZa1() {
        return Z_a1;
    }

    public static BufferedImage getZa2() {
        return Z_a2;
    }

    public static BufferedImage getZa3() {
        return Z_a3;
    }

    public static BufferedImage getZa4() {
        return Z_a4;
    }

    public static BufferedImage getZa5() {
        return Z_a5;
    }
}
