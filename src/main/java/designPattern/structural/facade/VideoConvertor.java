package designPattern.structural.facade;

import designPattern.structural.facade.videoLibrary.VideoFile;

import java.io.File;

public interface VideoConvertor {

    File convertVideoFile(String videoFileName, String codec);
}
