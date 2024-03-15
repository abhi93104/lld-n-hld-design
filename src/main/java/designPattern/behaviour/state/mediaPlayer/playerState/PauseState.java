package designPattern.behaviour.state.mediaPlayer.playerState;

import designPattern.behaviour.state.mediaPlayer.player.Player;

public class PauseState extends PlayerState {
    public PauseState(Player player) {
        super(player);
    }

    @Override
    public void next(){
        getPlayer().playNextSong();
    }

    @Override
    public void prev(){
        getPlayer().playPrevSong();
    }

    @Override
    public void playNPause(){
        getPlayer().playCurrentSong();
        getPlayer().changeState(new PlayState(getPlayer()));
    }

}
