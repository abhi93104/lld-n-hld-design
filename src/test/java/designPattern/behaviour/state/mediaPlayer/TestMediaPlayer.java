package designPattern.behaviour.state.mediaPlayer;

import designPattern.behaviour.state.mediaPlayer.player.Player;
import designPattern.behaviour.state.mediaPlayer.playerState.OffState;
import designPattern.structural.facade.VideoConvertor;
import designPattern.structural.facade.VideoConvertorFacade;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

public class TestMediaPlayer {

    @BeforeEach
    public void setup(){
        System.out.println("Setup runs before each teat");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("TearDown runs after completion of each test to clear everything.");
    }

    @Test
    public void Test1(){
        Player player = new Player();
        player.clickOnNOff();
        player.clickPlayNPause();
        Assertions.assertEquals(0, player.getCurrentSongIndex());

        player.clickNext();
        player.clickPlayNPause();
        player.clickPlayNPause();
        Assertions.assertEquals(1, player.getCurrentSongIndex());

        player.clickNext();
        player.clickPrev();
        Assertions.assertEquals(1, player.getCurrentSongIndex());

        player.clickRecord();
        player.clickRecord();
        player.clickOnNOff();
        Assertions.assertEquals(OffState.class, player.getState().getClass());
    }

    @Test
    public void Test2(){
        Player player = new Player();
        Assertions.assertThrows(IllegalArgumentException.class, player::clickPlayNPause);
        player.clickOnNOff();
        Assertions.assertThrows(IllegalArgumentException.class, player::clickNext);
    }
}
