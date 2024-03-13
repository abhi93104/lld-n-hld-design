package designPattern.structural.facade.videoLibrary;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BitRateReader {
    public static VideoFile read(VideoFile file, Codec codec) {
        System.out.println("BitrateReader: reading file...");
        return file;
    }

    public static VideoFile convert(VideoFile buffer, Codec codec) {
        System.out.println("BitrateReader: writing file...");
        buffer.setFilename(buffer.getFilename().split("\\.")[0] + "." +codec.getCodecType());
        return buffer;
    }
}
