package Graphic.Jogo;

import com.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Definições custom
 */
public class Config_custom {

    private static JFrame frame2;
    private static JPanel Config_panel;

    /**
     * Construtor da class
     * Define botões para interação
     */
    public Config_custom() {


        frame2 = new JFrame("Configurations");
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
        frame2.setSize(250, 250);
        Config_panel = new JPanel();
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Config_panel.setLayout(new BoxLayout(Config_panel, BoxLayout.Y_AXIS));

        JButton mobs_t1 = new JButton("Mobs type 1");
        JButton mobs_t2= new JButton("Mobs type 2");
        JButton buildings = new JButton("Buildings ");
        JButton spawn = new JButton("Spawn Time");
        JButton b_close = new JButton("Close");

        Config_panel.add(mobs_t1);
        mobs_t1.setPreferredSize(new Dimension(80, 0));
        Config_panel.add(Box.createVerticalStrut(25));

        Config_panel.add(mobs_t2);
        mobs_t2.setPreferredSize(new Dimension(80, 0));
        Config_panel.add(Box.createVerticalStrut(25));

        Config_panel.add(buildings);
        buildings.setPreferredSize(new Dimension(80, 0));
        Config_panel.add(Box.createVerticalStrut(25));

        Config_panel.add(spawn);
        spawn.setPreferredSize(new Dimension(80, 0));
        Config_panel.add(Box.createVerticalStrut(25));

        Config_panel.add(b_close);
        b_close.setPreferredSize(new Dimension(80, 0));


        mobs_t1.addActionListener(new mobs_t1());
        mobs_t2.addActionListener(new mobs_t2());
        buildings.addActionListener(new buildings());
        spawn.addActionListener(new spawn());
        b_close.addActionListener(new close());

        frame2.add(Config_panel);
    }

    class mobs_t1 implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            gui_mobs_t1();
        }
    }

    class mobs_t2 implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            gui_mobs_t2();
        }
    }

    class buildings implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            gui_buildings();
        }
    }

    class spawn implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            gui_spawn();
        }
    }

    class close implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            frame2.setVisible(false);
            frame2.dispose();
        }
    }


    /**
     * define opções para monstros tipo 1
     */
    public void gui_mobs_t1() {


        String s  = JOptionPane.showInputDialog("Introduza o numero de mobs do tipo 1 ?:\nDefault = 1");
        int number_mobs_t1 = Integer.parseInt(s);
        Main.getOptions().setNumber_mobs_t1(number_mobs_t1);

        s = JOptionPane.showInputDialog("Introduza a vida dos mobs do tipo 1 ?:\nDefault = 100");
        int life_mobs_t1 = Integer.parseInt(s);
        Main.getOptions().setLife_mobs_t1(life_mobs_t1);


        s = JOptionPane.showInputDialog("Introduza o dano de ataque dos mobs do tipo 1 ?:\nDefault = 3");
        int atack_mobs_t1 = Integer.parseInt(s);
        Main.getOptions().setAttack_mobs_t1(atack_mobs_t1);

        s = JOptionPane.showInputDialog("Introduza o valor em gold de cada mob do tipo 1 ?:\nDefault = 5");
        int coin_mobs_t1 = Integer.parseInt(s);
        Main.getOptions().setCoin_mobs_t1(coin_mobs_t1);

    }

    /**
     * define opções para monstros tipo 2
     */
    public void gui_mobs_t2() {


        String s  = JOptionPane.showInputDialog("Introduza o numero de mobs do tipo 2 ?:\nDefault = 2");
        int number_mobs_t2 = Integer.parseInt(s);
        Main.getOptions().setNumber_mobs_t2(number_mobs_t2);

        s = JOptionPane.showInputDialog("Introduza a vida dos mobs do tipo 2 ?:\nDefault = 150");
        int life_mobs_t2 = Integer.parseInt(s);
        Main.getOptions().setLife_mobs_t2(life_mobs_t2);


        s = JOptionPane.showInputDialog("Introduza o dano de ataque dos mobs do tipo 2 ?:\nDefault = 2");
        int atack_mobs_t2 = Integer.parseInt(s);
        Main.getOptions().setAttack_mobs_t2(atack_mobs_t2);

        s = JOptionPane.showInputDialog("Introduza o valor em gold de cada mob do tipo 2 ?:\nDefault = 10");
        int coin_mobs_t2 = Integer.parseInt(s);
        Main.getOptions().setCoin_mobs_t2(coin_mobs_t2);
    }

    /**
     * define opções para edificios do tipo 1
     */
    public void gui_buildings() {


        String s  = JOptionPane.showInputDialog("Introduza o raio de ataque do edifício 1 ?:\nDefault = 220");
        int raio = Integer.parseInt(s);
        Main.getOptions().setRaio_b1(raio);

        s = JOptionPane.showInputDialog("Introduza o tempo de de ataque do edifício 1 ?:\nDefault = 1500");
        int atack_speed_b1 = Integer.parseInt(s);
        Main.getOptions().setRaio_b1(atack_speed_b1);


        s = JOptionPane.showInputDialog("Introduza o dano de ataque do edifício 1 ?:\nDefault = 15");
        int atack_b1 = Integer.parseInt(s);
        Main.getOptions().setRaio_b1(atack_b1);


    }

    /**
     * define tempo entre o spawn de monstros
     */
    public void gui_spawn() {

        String s  = JOptionPane.showInputDialog("Introduza o tempo de Spawn entre mobs ?:\nDefault = 2500");
        int spawn_time = Integer.parseInt(s);

        Main.getOptions().setTempo_entre_spawn_mobs(spawn_time);

        frame2.setVisible(false);
        frame2.dispose();
    }
}
