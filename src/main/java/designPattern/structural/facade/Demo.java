package designPattern.structural.facade;

import java.io.File;

public class Demo {

    public static void main(String... args){
        VideoConvertor videoConvertor = new VideoConvertorFacade();
        File convertedFile = videoConvertor.convertVideoFile("video.ogg", "mp4");
        System.out.println(convertedFile.getName());
    }
}
