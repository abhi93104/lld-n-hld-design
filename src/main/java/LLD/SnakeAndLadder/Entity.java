package LLD.SnakeAndLadder;

public class Entity {

    private String entityName;
    private Cell destinationCell;
    private String afterEffects;

    public Entity(String entityName, Cell destinationCell){
        this.entityName = entityName;
        this.destinationCell = destinationCell;
    }

}
