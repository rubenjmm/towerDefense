package Load_Save;


import com.company.Main;
import com.company.Mapa;

import java.io.File;
import java.util.Scanner;

public class Load_save {

    private Mapa map = Main.getMap();
    private Scanner x;

    public Load_save() {
    }

    public void openFile(){

        try {

            x = new Scanner(new File("Saves/save.txt"));
        }catch (Exception e){

            System.out.println("Erro ao criar ficheiro de save: " + e);
        }


    }
/*
    public void readFile(){


        maze_size();
        dragoes();
        armas();
        saida();
        jogador();
        mapa();
        Main.setLabirinto(labirinto);
    }

    public void closeFile(){

        x.close();
    }


    public int getint(Scanner linescanner) {

        int a=0;

        while (linescanner.hasNext()) {

            if(linescanner.hasNextInt()) {
                a = linescanner.nextInt();
            }
            else
                linescanner.next();
        }
        return a;
    }

    public void getposicao(Scanner linescanner,Elementos pos) {

        int count=0;

        while (linescanner.hasNext()) {

            if(linescanner.hasNextInt()) {
                if(count==0) {
                    pos.setPos_x(linescanner.nextInt());
                    count++;
                }
                else
                    pos.setPos_y(linescanner.nextInt());
            }
            else
                linescanner.next();
        }
    }

    public void maze_size() {

        int maze_size=getint( new Scanner(x.nextLine()) );
        Estrategia.setN_x_n(maze_size);
        labirinto.setColunas(maze_size);
        labirinto.setLinhas(maze_size);
        x.nextLine();
    }

    public void dragoes(){

        int n_dragoes=0,modo_dragao=0,estado=0;

        x.nextLine();

        n_dragoes = getint( new Scanner(x.nextLine()) );
        Estrategia.setN_dragoes(n_dragoes);
        //System.out.println(n_dragoes);


        modo_dragao = getint( new Scanner(x.nextLine()) ) + 48;
        Estrategia.setModo_dragao( (char) modo_dragao);
        //System.out.println((char)modo_dragao);

        x.nextLine();

        Elementos posicao = new Elementos(0,0);
        Dragon[] n_dragon = new Dragon[n_dragoes];
        char img=' ';

        for(int i=0;i<n_dragoes;i++) {

            getposicao(new Scanner(x.nextLine()),posicao);
            estado = getint( new Scanner(x.nextLine()) );
            x.nextLine();
            if(estado==0)
                img=' ';
            else if(estado==1)
                img='D';
            else if(estado==2)
                img='d';

            n_dragon[i] = new Dragon( posicao.getPos_x(), posicao.getPos_y(),img,estado);
            labirinto.getDragoes().add(n_dragon[i]);
        }
    }

    public void armas() {

        dardos();
        espada();
        shield();

    }

    public void saida() {

        int estado=0;
        Elementos posicao = new Elementos(0,0);
        char img=' ';

        x.nextLine();
        x.nextLine();

        getposicao(new Scanner(x.nextLine()), posicao);
        estado = getint(new Scanner(x.nextLine()));
        x.nextLine();
        if (estado == 0)
            img = 'X';
        else if (estado == 1)
            img = ' ';

        labirinto.getexit().setPos_x(posicao.getPos_x());
        labirinto.getexit().setPos_y(posicao.getPos_y());
        labirinto.getexit().setEstado(estado);
        labirinto.getexit().setImg(img);
    }

    public void jogador() {

        int estado=0,temshield=0,n_dardos=0;
        boolean shield=false;
        Elementos posicao = new Elementos(0,0);
        char img=' ';

        x.nextLine();
        x.nextLine();

        getposicao(new Scanner(x.nextLine()), posicao);
        estado = getint(new Scanner(x.nextLine()));
        n_dardos = getint(new Scanner(x.nextLine()));
        temshield = getint(new Scanner(x.nextLine()));
        x.nextLine();

        if (estado == 0)
            img = ' ';
        else if (estado == 1)
            img = 'H';
        else if(estado==2)
            img='A';

        if(temshield==0)
            shield=false;
        else if(temshield==1)
            shield=true;

        labirinto.getHeroi().setPos_x(posicao.getPos_x());
        labirinto.getHeroi().setPos_y(posicao.getPos_y());
        labirinto.getHeroi().setEstado(estado);
        labirinto.getHeroi().setImg(img);
        labirinto.getHeroi().setTem_n_dardos(n_dardos);
        labirinto.getHeroi().setTem_shield(shield);

    }

    public void mapa() {

        char lab[][] = new char[Estrategia.getN_x_n()][Estrategia.getN_x_n()];

        for(int i=0;i<Estrategia.getN_x_n();i++){ //percorre todas as linhas

            String line = x.nextLine();
            for(int j=0;j<Estrategia.getN_x_n();j++){
                lab[i][j]=line.charAt(j);
            }
        }

        labirinto.setMatrizlabirinto(lab);

    }

    public void dardos() {


        int n_dardos=0,estado=0;

        x.nextLine();

        n_dardos = getint( new Scanner(x.nextLine()) );
        //System.out.println(n_dardos);

        x.nextLine();

        Elementos posicao = new Elementos(0,0);
        Armas[] dardos = new Armas[n_dardos];
        char img=' ';

        for(int i=0;i<n_dardos;i++) {

            getposicao(new Scanner(x.nextLine()), posicao);
            estado = getint(new Scanner(x.nextLine()));
            x.nextLine();
            if (estado == 0)
                img = ' ';
            else if (estado == 1)
                img = (char) 36;

            dardos[i] = new Armas(posicao.getPos_x(), posicao.getPos_y(), img);
            labirinto.getDardos().add(dardos[i]);
        }
    }

    public void espada() {

        int estado=0;
        Elementos posicao = new Elementos(0,0);
        char img=' ';

        x.nextLine();
        x.nextLine();

        getposicao(new Scanner(x.nextLine()), posicao);
        estado = getint(new Scanner(x.nextLine()));
        x.nextLine();
        if (estado == 0)
            img = ' ';
        else if (estado == 1)
            img = 'E';

        labirinto.getSword().setPos_x(posicao.getPos_x());
        labirinto.getSword().setPos_y(posicao.getPos_y());
        labirinto.getSword().setEstado(estado);
        labirinto.getSword().setImg(img);
    }

    public void shield() {

        int estado=0;
        Elementos posicao = new Elementos(0,0);
        char img=' ';

        x.nextLine();
        x.nextLine();

        getposicao(new Scanner(x.nextLine()), posicao);
        estado = getint(new Scanner(x.nextLine()));
        x.nextLine();
        if (estado == 0)
            img = ' ';
        else if (estado == 1)
            img = (char) 174;

        labirinto.getShield().setPos_x(posicao.getPos_x());
        labirinto.getShield().setPos_y(posicao.getPos_y());
        labirinto.getShield().setEstado(estado);
        labirinto.getShield().setImg(img);
    }
    */

}
