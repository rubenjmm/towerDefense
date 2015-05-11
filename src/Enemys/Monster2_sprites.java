package Enemys;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Ricardo on 09/05/2015.
 */
public abstract class Monster2_sprites {

    private static BufferedImage N_1;
    private static BufferedImage N_2;
    private static BufferedImage N_3;
    private static BufferedImage N_4;
    private static BufferedImage N_5;
    private static BufferedImage N_6;

    private static BufferedImage D_0;
    private static BufferedImage D_1;
    private static BufferedImage D_2;
    private static BufferedImage D_4;
    private static BufferedImage D_5;
    private static BufferedImage D_6;
    private static BufferedImage D_7;
    private static BufferedImage D_8;

    private static BufferedImage A_1;
    private static BufferedImage A_2;
    private static BufferedImage A_3;
    private static BufferedImage A_4;
    private static BufferedImage A_5;
    private static BufferedImage A_6;
    private static BufferedImage A_7;
    private static BufferedImage A_8;

    private static BufferedImage atack_1;
    private static BufferedImage atack_2;
    private static BufferedImage atack_3;
    private static BufferedImage atack_4;
    private static BufferedImage atack_5;
    private static BufferedImage atack_6;


    public Monster2_sprites() {
        inic();
    }


    public static void inic() {

        try {

            //80 por 70 dont forget

            A_1 = ImageIO.read(new File("Textures/Mobs/Monster2/A_1.png"));
            A_2 = ImageIO.read(new File("Textures/Mobs/Monster2/A_2.png"));
            A_3 = ImageIO.read(new File("Textures/Mobs/Monster2/A_3.png"));
            A_4 = ImageIO.read(new File("Textures/Mobs/Monster2/A_4.png"));
            A_5 = ImageIO.read(new File("Textures/Mobs/Monster2/A_5.png"));
            A_6 = ImageIO.read(new File("Textures/Mobs/Monster2/A_6.png"));
            A_7 = ImageIO.read(new File("Textures/Mobs/Monster2/A_7.png"));
            A_8 = ImageIO.read(new File("Textures/Mobs/Monster2/A_8.png"));

            D_0 = ImageIO.read(new File("Textures/Mobs/Monster2/D_0.png"));
            D_1 = ImageIO.read(new File("Textures/Mobs/Monster2/D_1.png"));
            D_2 = ImageIO.read(new File("Textures/Mobs/Monster2/D_2.png"));
            D_4 = ImageIO.read(new File("Textures/Mobs/Monster2/D_4.png"));
            D_5 = ImageIO.read(new File("Textures/Mobs/Monster2/D_5.png"));
            D_6 = ImageIO.read(new File("Textures/Mobs/Monster2/D_6.png"));
            D_7 = ImageIO.read(new File("Textures/Mobs/Monster2/D_7.png"));
            D_8 = ImageIO.read(new File("Textures/Mobs/Monster2/D_8.png"));

            N_1 = ImageIO.read(new File("Textures/Mobs/Monster2/N_1.png"));
            N_2 = ImageIO.read(new File("Textures/Mobs/Monster2/N_2.png"));
            N_3 = ImageIO.read(new File("Textures/Mobs/Monster2/N_3.png"));
            N_4 = ImageIO.read(new File("Textures/Mobs/Monster2/N_4.png"));
            N_5 = ImageIO.read(new File("Textures/Mobs/Monster2/N_5.png"));
            N_6 = ImageIO.read(new File("Textures/Mobs/Monster2/N_6.png"));


            atack_1 = ImageIO.read(new File("Textures/Mobs/Monster2/atack_1.png"));
            atack_2 = ImageIO.read(new File("Textures/Mobs/Monster2/atack_2.png"));
            atack_3 = ImageIO.read(new File("Textures/Mobs/Monster2/atack_3.png"));
            atack_4 = ImageIO.read(new File("Textures/Mobs/Monster2/atack_4.png"));
            atack_5 = ImageIO.read(new File("Textures/Mobs/Monster2/atack_5.png"));
            atack_6 = ImageIO.read(new File("Textures/Mobs/Monster2/atack_6.png"));


        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static BufferedImage getN1() {
        return N_1;
    }

    public static BufferedImage getN2() {
        return N_2;
    }

    public static BufferedImage getN3() {
        return N_3;
    }

    public static BufferedImage getN4() {
        return N_4;
    }

    public static BufferedImage getN5() {
        return N_5;
    }

    public static BufferedImage getN6() {
        return N_6;
    }

    public static BufferedImage getD0() {
        return D_0;
    }

    public static BufferedImage getD1() {
        return D_1;
    }

    public static BufferedImage getD2() {
        return D_2;
    }


    public static BufferedImage getD4() {
        return D_4;
    }

    public static BufferedImage getD5() {
        return D_5;
    }

    public static BufferedImage getD6() {
        return D_6;
    }

    public static BufferedImage getD7() {
        return D_7;
    }

    public static BufferedImage getD8() {
        return D_8;
    }

    public static BufferedImage getA1() {
        return A_1;
    }

    public static BufferedImage getA2() {
        return A_2;
    }

    public static BufferedImage getA3() {
        return A_3;
    }

    public static BufferedImage getA4() {
        return A_4;
    }

    public static BufferedImage getA5() {
        return A_5;
    }

    public static BufferedImage getA6() {
        return A_6;
    }

    public static BufferedImage getA7() {
        return A_7;
    }

    public static BufferedImage getA8() {
        return A_8;
    }


    public static BufferedImage getAtack_1() {
        return atack_1;
    }

    public static BufferedImage getAtack_2() {
        return atack_2;
    }

    public static BufferedImage getAtack_3() {
        return atack_3;
    }

    public static BufferedImage getAtack_4() {
        return atack_4;
    }

    public static BufferedImage getAtack_5() {
        return atack_5;
    }

    public static BufferedImage getAtack_6() {
        return atack_6;
    }

}