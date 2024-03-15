package designPattern.behaviour.state.mediaPlayer.playerState;

import designPattern.behaviour.state.mediaPlayer.player.Player;

public class ReadyState extends PlayerState {
    public ReadyState(Player player) {
        super(player);
    }

    @Override
    public void playNPause(){
        getPlayer().setCurrentSongIndex(0);
        getPlayer().playCurrentSong();
        getPlayer().changeState(new PlayState(getPlayer()));
    }

}
