package Load_Save;

import com.Main;
import com.Mapa;

import java.io.File;
import java.util.Scanner;

/**
 * Class que carrega niveis previamente guardados
 */
public class Load_level {

    private Mapa map = Main.getMap();
    private Scanner x;
    private char[][] board;
    int linhas,colunas;
    private String level;

    /**
     * Abre ficheiros de jogos guardados
     * @param a uri do ficheiro
     */
    public Load_level(String a) {
        this.level = a;
        openFile();
        readFile();
        closeFile();
    }

    /**
     *  Abre o jogo definido anteriormente
     *  @see Load_Save.Load_level
     */
    public void openFile(){

        try {

            x = new Scanner(new File("Saves/"+level+".txt"));
        }catch (Exception e){

            System.out.println("Erro ao criar ficheiro de save: " + e);
        }

    }

    /**
     * le os dados do ficheiro de jogo guardado
     */
    public void readFile(){
        map_size();
        lermapa();
    }

    /**
     * fecha o ficheiro de jogo aberto
     * @see Load_Save.Load_level
     */
    public void closeFile(){
        x.close();
    }

    /**
     * Le o primeiro inteiro disponivel
     * @param linescanner
     * @return Primeiro inteiro disponivel
     */
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

    /**
     * define o tamanho do mapa de acordo com o indicado no ficheiro de jogo
     * @see Load_Save.Load_level
     */
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
