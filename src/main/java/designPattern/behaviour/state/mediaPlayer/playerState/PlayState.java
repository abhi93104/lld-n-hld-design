package designPattern.behaviour.state.mediaPlayer.playerState;

import designPattern.behaviour.state.mediaPlayer.player.Player;

public class PlayState extends PlayerState {
    public PlayState(Player player) {
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
        getPlayer().pauseCurrentSong();
        getPlayer().changeState(new PauseState(getPlayer()));
    }

}
