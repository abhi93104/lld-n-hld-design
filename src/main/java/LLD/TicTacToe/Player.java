package LLD.TicTacToe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.UUID;

@Data
public class Player {

    private String playerId;
    private String name;
    private Symbol symbol;

    public Player(String name, Symbol symbol){
        this.playerId = UUID.randomUUID().toString();
        this.name = name;
        this.symbol = symbol;
    }



}
