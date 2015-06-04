package com;

import Buildings.BaseBuilding;
import Buildings.Building1Sprites;
import Enemys.BaseEnemy;
import Graphic.Jogo.Frame;
import Graphic.Jogo.Loja;
import Graphic.Menus.Inic_Menu;
import Load_Save.Load_level;

import java.util.ArrayList;

public class Main {

    private static Mapa map;
    private static Opcoes options;
    private static Frame frame1;
    private static int level=0;
    private static  Loja loja;
    private static Logica game_logic;

    public enum STATE {
        Main_menu,
        Inic_menu,
        GAME
    }

    private static boolean helditem = false;
    private static int held_id = 0;
    private static int mouse_x,mouse_y;

    private static STATE state = STATE.Main_menu;

    private static boolean first_game=false;

    public static void main(String[] args) {
        //Inicializar as texturas
        //MonsterBlueSprites.inic();
        //MonsterRedSprites.inic();
        //Building1Sprites.inic();

        level=1;
        options = new Opcoes();
        options.default_options();
        game_logic = new Logica();
        inic_menu();
    }

    public static void inic_menu() {
        state = STATE.Inic_menu;

        Inic_Menu n = new Inic_Menu();
        map = new Mapa();
        loja = new Loja();
        n.begin();
    }

    public static void new_game() {

        first_game=true;
        state = STATE.GAME;
        level = 1 ;
        Load_level load = new Load_level("lvl1"); //Inicializa a class Mapa com o nível 1, que está no ficheiro lvl1
        frame1 = new Frame();
        game_logic.new_game();
        loja.newgame();
    }

    public static void load__old_game(int lvl ,int gold  ,int player_life  , BaseEnemy[]  mobs, ArrayList<BaseBuilding> buildings  ) {

        loja.setGold(gold);
        loja.setLife(player_life);
        level = lvl;
        Load_level load = new Load_level("lvl"+Integer.toString(level));

        if ( !first_game) {
            frame1 = new Frame();
        }

        game_logic.load_old_game(mobs,buildings);
        state = STATE.GAME;

    }

/////////////////////////////// GETTER /////////////////////////////// SETTER ///////////////////////////////
    public static Loja getLoja() {
    return loja;
}

    public static int getLevel() {
        return level;
    }

    public static Logica getGame_logic() {
        return game_logic;
    }

    public static Mapa getMap() {
        return map;
    }

    public static Opcoes getOptions() {
        return options;
    }

    public static STATE getState() {
        return state;
    }

    public static void setState(char op) {

        if(op=='M')
            state = STATE.Main_menu;
        else if(op=='G')
            state = STATE.GAME;
        else if(op=='i')
            state = STATE.Inic_menu;
    }

    public static Frame getFrame1() {
        return frame1;
    }


    public static void setHelditem(boolean held) {
        helditem = held;
    }

    public static void setHeld_id(int id) {
        held_id = id;
    }

    public static boolean isHelditem() {
        return helditem;
    }

    public static int getHeld_id() {
        return held_id;
    }


    public static int getMouse_x() {
        return mouse_x;
    }

    public static void setMouse_x(int mouse_x) {
        Main.mouse_x = mouse_x;
    }

    public static int getMouse_y() {
        return mouse_y;
    }

    public static void setMouse_y(int mouse_y) {
        Main.mouse_y = mouse_y;
    }

}