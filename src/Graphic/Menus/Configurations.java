//package Graphic.Menus;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//
///**
// * Created by Ricardo on 26/04/2015.
// */
//
//public class Configurations {
//
//    private static char type_maze;
//    private static int n_x_n=10;
//    private static char modo_dragao;
//    private static int  n_dragoes=1;
//
//    private static JFrame frame2;
//    private static JPanel Config_panel;
//
//    public  void  gui_tipomaze() throws IllegalArgumentException {
//
///*
//        String s  = JOptionPane.showInputDialog("Introduza o tipo o labirinto que pretende:\n" +"0->Random Maze\n" +"1->Static Maze");
//        type_maze = s.charAt(0);
//
//        if( type_maze!='0' && type_maze!='1' )
//            throw new IllegalArgumentException("Argumento inválido");
//        else if(type_maze=='0'){
//            s  = JOptionPane.showInputDialog("Introduza o tamanho do labirinto");
//            n_x_n = Integer.parseInt(s);
//        }
//
//        Estrategia.setType_maze(type_maze);
//        Estrategia.setN_x_n(n_x_n);
//*/
//    }
//
//    public  void gui_movimentacao() throws IllegalArgumentException{
///*
//        String s  = JOptionPane.showInputDialog("Tipo de movimentação do Dragao ?:\n1->Dragão Parado\n2->Dragão com movimentação aleatória\n3->Dragão com movimentação aleatória intercalada com dormir");
//        modo_dragao= s.charAt(0);
//        if(modo_dragao !='1' && modo_dragao!='2' && modo_dragao!='3' )  {
//            throw new IllegalArgumentException("Argumento inválido");
//        }
//
//        Estrategia.setModo_dragao(modo_dragao);
//
//*/
//    }
//
//    public  void gui_ndragon() throws IllegalArgumentException {
//
//    }
//
//    public  void gui_teclas(){
//
//
//    }
//
//    public int key_events(char a) {
//
//        switch (a) {
//
//            case 'a': return KeyEvent.VK_A;
//            case 'b': return KeyEvent.VK_B;
//            case 'c': return KeyEvent.VK_C;
//            case 'd': return KeyEvent.VK_D;
//            case 'e': return KeyEvent.VK_E;
//            case 'f': return KeyEvent.VK_F;
//            case 'g': return KeyEvent.VK_G;
//            case 'h': return KeyEvent.VK_H;
//            case 'i': return KeyEvent.VK_I;
//            case 'j': return KeyEvent.VK_J;
//            case 'k': return KeyEvent.VK_K;
//            case 'l': return KeyEvent.VK_L;
//            case 'm': return KeyEvent.VK_M;
//            case 'n': return KeyEvent.VK_N;
//            case 'o': return KeyEvent.VK_O;
//            case 'p': return KeyEvent.VK_P;
//            case 'q': return KeyEvent.VK_Q;
//            case 'r': return KeyEvent.VK_R;
//            case 's': return KeyEvent.VK_S;
//            case 't': return KeyEvent.VK_T;
//            case 'u': return KeyEvent.VK_U;
//            case 'v': return KeyEvent.VK_V;
//            case 'w': return KeyEvent.VK_W;
//            case 'x': return KeyEvent.VK_X;
//            case 'y': return KeyEvent.VK_Y;
//            case 'z': return KeyEvent.VK_Z;
//            case 'A': return KeyEvent.VK_A;
//            case 'B': return KeyEvent.VK_B;
//            case 'C': return KeyEvent.VK_C;
//            case 'D': return KeyEvent.VK_D;
//            case 'E': return KeyEvent.VK_E;
//            case 'F': return KeyEvent.VK_F;
//            case 'G': return KeyEvent.VK_G;
//            case 'H': return KeyEvent.VK_H;
//            case 'I': return KeyEvent.VK_I;
//            case 'J': return KeyEvent.VK_J;
//            case 'K': return KeyEvent.VK_K;
//            case 'L': return KeyEvent.VK_L;
//            case 'M': return KeyEvent.VK_M;
//            case 'N': return KeyEvent.VK_N;
//            case 'O': return KeyEvent.VK_O;
//            case 'P': return KeyEvent.VK_P;
//            case 'Q': return KeyEvent.VK_Q;
//            case 'R': return KeyEvent.VK_R;
//            case 'S': return KeyEvent.VK_S;
//            case 'T': return KeyEvent.VK_T;
//            case 'U': return KeyEvent.VK_U;
//            case 'V': return KeyEvent.VK_V;
//            case 'W': return KeyEvent.VK_W;
//            case 'X': return KeyEvent.VK_X;
//            case 'Y': return KeyEvent.VK_Y;
//            case 'Z': return KeyEvent.VK_Z;
//            case '`': return KeyEvent.VK_BACK_QUOTE;
//            case '0': return KeyEvent.VK_0;
//            case '1': return KeyEvent.VK_1;
//            case '2': return KeyEvent.VK_2;
//            case '3': return KeyEvent.VK_3;
//            case '4': return KeyEvent.VK_4;
//            case '5': return KeyEvent.VK_5;
//            case '6': return KeyEvent.VK_6;
//            case '7': return KeyEvent.VK_7;
//            case '8': return KeyEvent.VK_8;
//            case '9': return KeyEvent.VK_9;
//            case '-': return KeyEvent.VK_MINUS;
//            case '=': return KeyEvent.VK_EQUALS;
//            case '!': return KeyEvent.VK_EXCLAMATION_MARK;
//            case '@': return KeyEvent.VK_AT;
//            case '#': return KeyEvent.VK_NUMBER_SIGN;
//            case '$': return KeyEvent.VK_DOLLAR;
//            case '^': return KeyEvent.VK_CIRCUMFLEX;
//            case '&': return KeyEvent.VK_AMPERSAND;
//            case '*': return KeyEvent.VK_ASTERISK;
//            case '(': return KeyEvent.VK_LEFT_PARENTHESIS;
//            case ')': return KeyEvent.VK_RIGHT_PARENTHESIS;
//            case '_': return KeyEvent.VK_UNDERSCORE;
//            case '+':  return KeyEvent.VK_PLUS;
//            case '\t': return KeyEvent.VK_TAB;
//            case '\n': return KeyEvent.VK_ENTER;
//            case '[': return KeyEvent.VK_OPEN_BRACKET;
//            case ']': return KeyEvent.VK_CLOSE_BRACKET;
//            case '\\': return KeyEvent.VK_BACK_SLASH;
//            case ';': return KeyEvent.VK_SEMICOLON;
//            case ':': return KeyEvent.VK_COLON;
//            case '\'': return KeyEvent.VK_QUOTE;
//            case '"': return KeyEvent.VK_QUOTEDBL;
//            case ',': return KeyEvent.VK_COMMA;
//            case '.': return KeyEvent.VK_PERIOD;
//            case '/':return KeyEvent.VK_SLASH;
//            case ' ': return KeyEvent.VK_SPACE;
//            default:
//                throw new IllegalArgumentException("Cannot type character " + a);
//        }
//    }
//
//
//    public Configurations() {
//
//
//        frame2 = new JFrame("Configurations");
//        frame2.setLocationRelativeTo(null);
//        frame2.setVisible(true);
//        frame2.setSize(250, 250);
//        Config_panel = new JPanel();
//        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//
//        Config_panel.setLayout(new BoxLayout(Config_panel, BoxLayout.Y_AXIS));
//
//        JButton b_maze = new JButton("Tipo de Labirinto");
//        JButton b_mov = new JButton("Movimentação do Dragão");
//        JButton b_close = new JButton("Close");
//        JButton b_ndra = new JButton("Número de Dragões");
//        JButton b_teclas = new JButton("Trocar teclas");
//
//        Config_panel.add(b_maze);
//        b_maze.setPreferredSize(new Dimension(80, 0));
//        Config_panel.add(Box.createVerticalStrut(25));
//
//        Config_panel.add(b_mov);
//        b_mov.setPreferredSize(new Dimension(80, 0));
//        Config_panel.add(Box.createVerticalStrut(25));
//
//        Config_panel.add(b_ndra);
//        b_ndra.setPreferredSize(new Dimension(80, 0));
//        Config_panel.add(Box.createVerticalStrut(25));
//
//        Config_panel.add(b_teclas);
//        b_teclas.setPreferredSize(new Dimension(80, 0));
//        Config_panel.add(Box.createVerticalStrut(25));
//
//        Config_panel.add(b_close);
//        b_close.setPreferredSize(new Dimension(80, 0));
//
//
//        b_maze.addActionListener(new maze());
//        b_mov.addActionListener(new movimentacao());
//        b_ndra.addActionListener(new dragoes());
//        b_teclas.addActionListener(new teclas());
//        b_close.addActionListener(new close());
//
//
//        frame2.add(Config_panel);
//    }
//
//    class maze implements ActionListener {
//
//        public void actionPerformed(ActionEvent e) {
//
//            gui_tipomaze();
//        }
//    }
//
//    class movimentacao implements ActionListener {
//
//        public void actionPerformed(ActionEvent e) {
//
//            gui_movimentacao();
//        }
//    }
//
//    class dragoes implements ActionListener {
//
//        public void actionPerformed(ActionEvent e) {
//
//            gui_ndragon();
//        }
//    }
//
//    class teclas implements ActionListener {
//
//        public void actionPerformed(ActionEvent e) {
//
//            gui_teclas();
//        }
//    }
//
//    class close implements ActionListener {
//
//        public void actionPerformed(ActionEvent e) {
//
//            frame2.setVisible(false);
//            frame2.dispose();
//        }
//    }
//
//}
