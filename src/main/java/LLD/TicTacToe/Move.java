package LLD.TicTacToe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Move {

    private Integer row, col;
    private Player player;
}
