package Graphic.Jogo;

import Buildings.Building1_sprites;
import com.company.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ricardo on 29/04/2015.
 */
public class Loja extends JPanel{

    private int WIDTH = 100;
    private int HEIGHT = Main.getMap().getlinhas()*24 ;

    private int flag=0;

    public void setFlag(int Bhighlight) {
        this.flag = Bhighlight;
    }

    private Rectangle button1 = new Rectangle(  25  , 50 , 50 , 50);
    private Rectangle button2 = new Rectangle(  25  , 110 , 50 , 50);
    private Rectangle button3 = new Rectangle(  25  , 170 , 50 , 50);
    private Rectangle button4 = new Rectangle(  25 , 230 , 50 , 50);
    private Rectangle button5 = new Rectangle(  25 , 290 , 50 , 50);

    private int life=10;

    public void change_life() {
        this.life = this.life - 1;
        repaint();
    }

    private BufferedImage life_10;
    private BufferedImage life_20;
    private BufferedImage life_30;
    private BufferedImage life_40;
    private BufferedImage life_50;
    private BufferedImage life_60;
    private BufferedImage life_70;
    private BufferedImage life_80;
    private BufferedImage life_90;
    private BufferedImage life_100;
    private BufferedImage heart;

    private int coins=0;
    private BufferedImage coin1;
    private BufferedImage coin2;
    private BufferedImage coin3;
    private BufferedImage coin4;
    private BufferedImage coin5;
    private BufferedImage coin6;
    private ArrayList<BufferedImage> Listcoins;
    Animator ani_coin;

    private BufferedImage Building1 = Building1_sprites.getA11();

    private Timer timer;

    public Loja() {

        this.addMouseMotionListener(new Loja_Mouse());
        this.addMouseListener(new Loja_Mouse());

        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setBackground(Color.darkGray);

        timer = new Timer(100, actionListener);
        timer.start();

        try {
            life_10  = ImageIO.read(new File("Textures/Loja/life_bar_10.png"));
            life_20  = ImageIO.read(new File("Textures/Loja/life_bar_20.png"));
            life_30  = ImageIO.read(new File("Textures/Loja/life_bar_30.png"));
            life_40  = ImageIO.read(new File("Textures/Loja/life_bar_40.png"));
            life_50  = ImageIO.read(new File("Textures/Loja/life_bar_50.png"));
            life_60  = ImageIO.read(new File("Textures/Loja/life_bar_60.png"));
            life_70  = ImageIO.read(new File("Textures/Loja/life_bar_70.png"));
            life_80  = ImageIO.read(new File("Textures/Loja/life_bar_80.png"));
            life_90  = ImageIO.read(new File("Textures/Loja/life_bar_90.png"));
            life_100  = ImageIO.read(new File("Textures/Loja/life_bar_100.png"));
            heart =     ImageIO.read(new File("Textures/Loja/heartif.png"));


            coin1 =     ImageIO.read(new File("Textures/Loja/Coin1.png"));
            coin2 =     ImageIO.read(new File("Textures/Loja/Coin2.png"));
            coin3 =     ImageIO.read(new File("Textures/Loja/Coin3.png"));
            coin4 =     ImageIO.read(new File("Textures/Loja/Coin4.png"));
            coin5 =     ImageIO.read(new File("Textures/Loja/Coin5.png"));
            coin6 =     ImageIO.read(new File("Textures/Loja/Coin6.png"));


        } catch (IOException e) {

            e.printStackTrace();
        }

        Listcoins   = new ArrayList<BufferedImage>();
        Listcoins.add(coin1);
        Listcoins.add(coin2);
        Listcoins.add(coin3);
        Listcoins.add(coin4);
        Listcoins.add(coin5);
        Listcoins.add(coin6);
        ani_coin = new Animator(Listcoins);
        ani_coin.setSpeed(180);
        ani_coin.play();
    }

    public void newgame() {
        life = 10;
        coins = 50;
    }


    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent actionEvent) {
            if(Main.getState()== Main.STATE.GAME){
                repaint();
            }
        }
    };


    public void paint(Graphics g){

            super.paint(g);
            draw(g);
    }

    private void draw(Graphics g) {

        draw_life(g);
        draw_gold(g);
        draw_rectangles(g);
        draw_build1(g);
    }

    private void draw_life(Graphics g){

        g.drawImage(heart, 10, 400, 18, 18, null);//WIDTH->18    HEIGHT->18
        switch (life) {
            case 1:
                g.drawImage(life_10, 35, 405, 50, 7, null);
                break;
            case 2:
                g.drawImage(life_20, 35, 405, 50, 7, null);
                break;
            case 3:
                g.drawImage(life_30, 35, 405, 50, 7, null);
                break;
            case 4:
                g.drawImage(life_40, 35, 405, 50, 7, null);
                break;
            case 5:
                g.drawImage(life_50, 35, 405, 50, 7, null);
                break;
            case 6:
                g.drawImage(life_60,35, 405, 50, 7, null);
                break;
            case 7:
                g.drawImage(life_70, 35, 405, 50, 7, null);
                break;
            case 8:
                g.drawImage(life_80, 35, 405, 50, 7, null);
                break;
            case 9:
                g.drawImage(life_90, 35, 405, 50, 7, null);
                break;
            case 10:
                g.drawImage(life_100, 35, 405, 50, 7, null);
                break;
        }
    }

    private void draw_gold(Graphics g) {

        g.drawImage(ani_coin.getSprite(), 8, 421, 25, 20, null); //width & height
        ani_coin.update(System.currentTimeMillis());

        Font fnt1 = new Font("arial",Font.BOLD,15);
        g.setFont(fnt1);
        g.setColor(Color.YELLOW);
        g.drawString(String.valueOf(coins),43,435);
    }

    private void draw_rectangles(Graphics g){

        Graphics2D g2d = (Graphics2D) g;


        g2d.setColor(Color.BLACK);
        g2d.draw(button1);
        g2d.draw(button2);
        g2d.draw(button3);
        g2d.draw(button4);
        g2d.draw(button5);


        g2d.setColor(Color.LIGHT_GRAY);
        g.fillRect(25, 50, 50, 50);
        g.fillRect(25, 110, 50, 50);
        g.fillRect(25, 170, 50, 50);
        g.fillRect(25, 230, 50, 50);
        g.fillRect(25  , 290 , 50 , 50);


        if (flag>0)
            g.setColor(Color.GRAY);
        else if(flag==0)
            g.setColor(Color.LIGHT_GRAY);


        if(flag == 1) {
            g.fillRect(25  , 50 , 50 , 50);
        }
        else if(flag == 2) {
            g.fillRect(  25  , 110 , 50 , 50);
        }
        else if(flag == 3) {
            g.fillRect( 25  , 170 , 50 , 50);
        }
        else if(flag == 4) {
            g.fillRect(25 , 230 , 50 , 50);
        }
        else if(flag == 5) {
            g.fillRect(25 , 290 , 50 , 50);
        }


    }

    private void draw_build1(Graphics g) {

        //Building icon
        g.drawImage(Building1, 17, 45, 70, 70, null);

        //cost
        Font fnt1 = new Font("arial",Font.BOLD,15);
        g.setFont(fnt1);
        g.setColor(Color.YELLOW);
        g.drawString("15",60,61);
    }

    public void change_coin(int amount) {
        coins = coins - amount ;
    }

    //////////////////////////////// GETTER's ////////////////////////////////

    public int getLife() {
        return life;
    }

    public int getCoins() {
        return coins;
    }


    //////////////////////////////// SETTER's ////////////////////////////////

    public void setGold(int g) {
        this.coins = g;
    }

    public void setLife(int l) {
        this.life = l;
    }
}
