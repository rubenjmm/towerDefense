package Load_Save;

/**
 * Created by Ricardo on 26/04/2015.
 */

import com.Main;
import com.Mapa;

import java.io.File;
import java.util.Scanner;

public class Load_level {


    private Mapa map = Main.getMap();
    private Scanner x;
    private char[][] board;
    int linhas,colunas;
    private String level;

    public Load_level(String a) {
        this.level = a;
        openFile();
        readFile();
        closeFile();
    }

    public void openFile(){

        try {

            x = new Scanner(new File("Saves/"+level+".txt"));
        }catch (Exception e){

            System.out.println("Erro ao criar ficheiro de save: " + e);
        }


    }

    public void readFile(){
        map_size();
        lermapa();
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

    public void map_size() {

        linhas  =   getint( new Scanner(x.nextLine()) );
        colunas  =   getint( new Scanner(x.nextLine()) );
        x.nextLine();

        map.setlinhas(linhas);
        map.setcolunas(colunas);
    }

    public void lermapa() {

       board  = new char[linhas][colunas];

        for(int i=0;    i<linhas;    i++){
            String line = x.nextLine();
            for(int j=0 ;j<colunas;    j++){
                board[i][j]=line.charAt(j);
            }
        }
        map.setMapa(board);
    }

}
