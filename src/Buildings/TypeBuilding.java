package Buildings;

/**
 * Class construtora de edificios dado o tipo segundo padrão builder
 */
public class TypeBuilding
{
    /**
     *
     * @param id -> tipo de edificio a ser gerado
     * @param x -> posição em x
     * @param y -> posição em y
     * @return -> new building do tipo pretendido na posição definida
     */
    public BaseBuilding getBuilding(int id, int x, int y) {

        if(id == 1){
            return  new BuildingOne(x, y);
        }
        if(id == 2){
            return new StormTrooper(x, y);
        }
        if(id == 3){
            return new Turret(x, y);
        }
        if(id == 4)
        {
            return new Cannon(x, y);
        }
        else
            return new BaseBuilding(x,y,5);
    }

}
