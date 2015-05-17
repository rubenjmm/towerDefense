package Buildings;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Ricardo on 17/05/2015.
 */
public class Building1_sprites {

    private  static BufferedImage A1_1;
    private  static BufferedImage A1_2;
    private  static BufferedImage A1_3;
    private  static BufferedImage A1_4;
    private  static BufferedImage A1_5;
    private  static BufferedImage A1_6;
    private  static BufferedImage A1_7;
    private  static BufferedImage A1_8;


    private  static BufferedImage A2_1;
    private  static BufferedImage A2_2;
    private  static BufferedImage A2_3;
    private  static BufferedImage A2_4;
    private  static BufferedImage A2_5;
    private  static BufferedImage A2_6;
    private  static BufferedImage A2_7;
    private  static BufferedImage A2_8;


    public  Building1_sprites() {

        inic();
    }


    public static void inic(){

        try {
            A1_1 = ImageIO.read(new File("Textures/Buildings/1/A1_1.png"));
            A2_1 = ImageIO.read(new File("Textures/Buildings/1/A2_1.png"));

            A1_2 = ImageIO.read(new File("Textures/Buildings/2/A1_2.png"));
            A2_2 = ImageIO.read(new File("Textures/Buildings/2/A2_2.png"));

            A1_3 = ImageIO.read(new File("Textures/Buildings/3/A1_3.png"));
            A2_3 = ImageIO.read(new File("Textures/Buildings/3/A2_3.png"));

            A1_4 = ImageIO.read(new File("Textures/Buildings/4/A1_4.png"));
            A2_4 = ImageIO.read(new File("Textures/Buildings/4/A2_4.png"));

            A1_5 = ImageIO.read(new File("Textures/Buildings/5/A1_5.png"));
            A2_5 = ImageIO.read(new File("Textures/Buildings/5/A2_5.png"));

            A1_6 = ImageIO.read(new File("Textures/Buildings/6/A1_6.png"));
            A2_6 = ImageIO.read(new File("Textures/Buildings/6/A2_6.png"));

            A1_7 = ImageIO.read(new File("Textures/Buildings/7/A1_7.png"));
            A2_7 = ImageIO.read(new File("Textures/Buildings/7/A2_7.png"));

            A1_8 = ImageIO.read(new File("Textures/Buildings/8/A1_8.png"));
            A2_8 = ImageIO.read(new File("Textures/Buildings/8/A2_8.png"));

        } catch (IOException e) {

            e.printStackTrace();
        }


    }


    public static BufferedImage getA11() {
        return A1_1;
    }

    public static BufferedImage getA12() {
        return A1_2;
    }

    public static BufferedImage getA13() {
        return A1_3;
    }

    public static BufferedImage getA14() {
        return A1_4;
    }

    public static BufferedImage getA15() {
        return A1_5;
    }

    public static BufferedImage getA16() {
        return A1_6;
    }

    public static BufferedImage getA17() {
        return A1_7;
    }

    public static BufferedImage getA18() {
        return A1_8;
    }

    public static BufferedImage getA21() {
        return A2_1;
    }

    public static BufferedImage getA22() {
        return A2_2;
    }

    public static BufferedImage getA23() {
        return A2_3;
    }

    public static BufferedImage getA24() {
        return A2_4;
    }

    public static BufferedImage getA25() {
        return A2_5;
    }

    public static BufferedImage getA26() {
        return A2_6;
    }

    public static BufferedImage getA27() {
        return A2_7;
    }

    public static BufferedImage getA28() {
        return A2_8;
    }

}
