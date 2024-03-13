package LLD.SnakeAndLadder;

import java.util.Map;

public class Board {

    private final Long length;
    private final Long breadth;
    private Map<Cell, Entity> entityMap;

    public Board(Long length, Long breadth){
        this.length = length;
        this.breadth = breadth;
    }

    public void addEntity(Entity entity, Cell cell){
        entityMap.put(cell, entity);
    }


}
