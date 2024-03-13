package designPattern.structural.facade;

import designPattern.structural.facade.videoLibrary.*;

import java.io.File;

public class VideoConvertorFacade implements VideoConvertor{

    /**
     * Convert the videoFile to the given codec and returns the converted file.
     *  @param videoFileName Name of the videoFile.
     *  @param newCodec codec in which file needs to be converted
     */
    @Override
    public File convertVideoFile(String videoFileName, String newCodec) {
        VideoFile videoFile = new VideoFile(videoFileName, newCodec);
        Codec sourceCodec = CodecFactory.getCodec(videoFile);
        Codec destinationCodec ;
        if(newCodec.equals("mp4")){
            destinationCodec = new MPEG4Codec();
        }else{
            destinationCodec = new OggCodec();
        }
        VideoFile buffer = BitRateReader.read(videoFile, sourceCodec);
        VideoFile intermediateResult = BitRateReader.convert(buffer, destinationCodec);
        File result = AudioMixer.mixVideoFile(intermediateResult);
        System.out.println("Video Conversion completed");
        return result;
    }
}
