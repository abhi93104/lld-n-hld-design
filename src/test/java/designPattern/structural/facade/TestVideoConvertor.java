package designPattern.structural.facade;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

public class TestVideoConvertor {

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
        VideoConvertor tesConvertor = new VideoConvertorFacade();
        File result = tesConvertor.convertVideoFile("test.mp4", "ogg");
        Assertions.assertEquals(result.getName(), "test.ogg");
    }

    @Test
    public void Test2(){
        VideoConvertor tesConvertor = new VideoConvertorFacade();
        File result = tesConvertor.convertVideoFile("test.mp4", "mp4");
        Assertions.assertEquals(result.getName(), "test.mp4");
    }

}
