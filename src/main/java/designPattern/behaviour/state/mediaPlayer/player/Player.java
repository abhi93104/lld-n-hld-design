package designPattern.behaviour.state.mediaPlayer.player;

import designPattern.behaviour.state.mediaPlayer.playerState.OffState;
import designPattern.behaviour.state.mediaPlayer.playerState.PlayState;
import designPattern.behaviour.state.mediaPlayer.playerState.PlayerState;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Player {

    private PlayerState state;
    private List<String> preLoadedSongList = new ArrayList<>();
    private int currentSongIndex;

    public Player(){
        state = new OffState(this);
        currentSongIndex = -1;
        for(int i = 0;i<10;i++){
            preLoadedSongList.add("Song"+i);
        }
    }

    public void clickOnNOff(){
        state.onNOff();
    }

    public void clickPlayNPause(){
        state.playNPause();
    }

    public void clickPrev(){
        state.prev();
    }

    public void clickNext(){
        state.next();
    }
    public void clickRecord(){
        state.record();
    }

    public void changeState(PlayerState newState){
        this.state = newState;
    }

    public void playCurrentSong(){
        int songIndex = playSong(currentSongIndex);
        System.out.printf("Continue playing Song: %s\n", preLoadedSongList.get(songIndex));
    }

    public void pauseCurrentSong(){
        System.out.printf("Pausing Song: %s\n", preLoadedSongList.get(currentSongIndex));
    }

    public void playNextSong(){
        int songIndex = playSong(currentSongIndex + 1);
        System.out.printf("Start playing Song: %s\n", preLoadedSongList.get(songIndex));

    }

    public void playPrevSong(){
        int songIndex = playSong(currentSongIndex - 1);
        System.out.printf("Start playing Song: %s\n", preLoadedSongList.get(songIndex));
    }

    private int playSong(int songIndex){
        if(songIndex >= preLoadedSongList.size()){
            songIndex = 0;
        }
        if(songIndex < 0){
            songIndex = preLoadedSongList.size()-1;
        }
        currentSongIndex = songIndex;
        return songIndex;
    }


}
