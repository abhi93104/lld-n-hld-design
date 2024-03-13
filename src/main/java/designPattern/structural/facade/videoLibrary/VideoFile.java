package designPattern.structural.facade.videoLibrary;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VideoFile {

    private String filename;
    private String codecType;
}
