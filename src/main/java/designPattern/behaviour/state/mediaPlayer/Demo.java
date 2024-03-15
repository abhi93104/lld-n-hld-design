package designPattern.behaviour.state.mediaPlayer;

import designPattern.behaviour.state.mediaPlayer.player.Player;

public class Demo {


    public static void main(String... args){
        Player player = new Player();
        player.clickOnNOff();
        player.clickPlayNPause();
        player.clickNext();
        player.clickPlayNPause();
        player.clickPlayNPause();
        player.clickNext();
        player.clickPrev();
        player.clickRecord();
        player.clickRecord();
        player.clickOnNOff();
    }
}
