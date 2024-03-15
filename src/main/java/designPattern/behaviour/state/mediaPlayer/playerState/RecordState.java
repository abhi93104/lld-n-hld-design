package designPattern.behaviour.state.mediaPlayer.playerState;

import designPattern.behaviour.state.mediaPlayer.player.Player;

public class RecordState extends PlayerState {
    public RecordState(Player player) {
        super(player);
    }

    @Override
    public void record(){
        System.out.println("Stop recording...");
        getPlayer().changeState(new ReadyState(getPlayer()));
    }

}
