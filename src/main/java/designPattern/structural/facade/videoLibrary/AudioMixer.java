package designPattern.structural.facade.videoLibrary;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;

@Data
@AllArgsConstructor
public class AudioMixer {

    public static File mixVideoFile(VideoFile videoFile){
        System.out.printf("Running AudioMixer on file %s\n" ,videoFile.getFilename());
        return new File(videoFile.getFilename());
    }
}
