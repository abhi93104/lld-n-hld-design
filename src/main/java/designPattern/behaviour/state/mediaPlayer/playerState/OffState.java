package designPattern.behaviour.state.mediaPlayer.playerState;

import designPattern.behaviour.state.mediaPlayer.player.Player;

public class OffState extends PlayerState {


    public OffState(Player player) {
        super(player);
    }

    @Override
    public void onNOff(){
        System.out.println("Switching On the player...");
        getPlayer().changeState(new ReadyState(getPlayer()));
    }

    @Override
    public void record(){
        throw new IllegalArgumentException("Device is off");
    }

    @Override
    public void next(){
        throw new IllegalArgumentException("Device is off");
    }

    @Override
    public void prev(){
        throw new IllegalArgumentException("Device is off");
    }

    @Override
    public void playNPause(){
        throw new IllegalArgumentException("Device is off");
    }


}
