package designPattern.behaviour.state.mediaPlayer.playerState;

import designPattern.behaviour.state.mediaPlayer.player.Player;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class PlayerState {
    private final Player player;

    public void record(){
        System.out.println("Start recording...");
        getPlayer().changeState(new RecordState(getPlayer()));
    }

    public void next(){
        throw new IllegalArgumentException("Next is not allowed here.");
    }

    public void prev(){
        throw new IllegalArgumentException("Prev is not allowed here.");
    }

    public void onNOff(){
        System.out.println("Switching off the player...");
        player.changeState(new OffState(player));
    }

    public void playNPause(){
        throw new IllegalArgumentException("PlayNPause is not allowed here.");
    }

}
