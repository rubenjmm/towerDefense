package Graphic.Menus;

import com.company.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ricardo on 27/05/2015.
 */
public class Game_Over  {

    private JFrame f;
    private JPanel End_panel;
    private JLabel label;

    public Game_Over(int type ) {

        Main.setState('M');//Mudar animation STATE

        f = new JFrame("Game Over");
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setSize(190, 200);
        End_panel = new JPanel();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if( type==1)
            label = new JLabel("Congratulations!!\nYou Won the Game");
        else
            label = new JLabel("Zombies ganharam, Game over!!");

        f.add(label);

        End_panel = new JPanel();

        End_panel.setLayout(new BoxLayout(End_panel, BoxLayout.X_AXIS));

        JButton b_newgame = new JButton("New Game");
        JButton b_closegame = new JButton("Close");

        End_panel.add(b_newgame);
        b_newgame.setPreferredSize(new Dimension(105, 0));
        End_panel.add(Box.createVerticalStrut(25));


        End_panel.add(b_closegame);
        b_closegame.setPreferredSize(new Dimension(70, 0));
        End_panel.add(Box.createVerticalStrut(25));

        f.add(End_panel);

        b_newgame.addActionListener(new reset());
        b_closegame.addActionListener(new close());
    }

    class reset implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            int value = JOptionPane.showConfirmDialog(null,"Tem a certeza que pretende começar um novo jogo?");
            if(value==0) {
                Main.setState('G');
                Main.getFrame1().close();
                Main.new_game();
                f.setVisible(false);
                f.dispose();
            }
        }
    }

    class close implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int value = JOptionPane.showConfirmDialog(null,"Tem a certeza que pretende desligar o jogo?");
            if(value==0) {
                System.exit(0);
            }
        }
    }

}
