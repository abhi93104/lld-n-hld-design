package LLD.TicTacToe;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ScoreBoard {

    private Map<String, Integer> scoreBoard;

    public ScoreBoard(){
        this.scoreBoard = new HashMap<>();
    }

    public void updateScoreBoard(Player p){
        if(scoreBoard.containsKey(p.getPlayerId())){
            scoreBoard.put(p.getPlayerId(), scoreBoard.get(p.getPlayerId()) + 1);
        }else{
            scoreBoard.put(p.getPlayerId(), 1);
        }
    }
}
