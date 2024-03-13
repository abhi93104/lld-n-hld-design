package LLD.SnakeAndLadder;

import java.util.Random;

public class Dice {

    private Integer minNumber;
    private Integer maxNumber;

    public Dice(Integer minNumber, Integer maxNumber){
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    public Integer roll(){
        Random rand = new Random();
        return rand.nextInt(minNumber, maxNumber+1);
    }

}
