package designPattern.structural.facade.videoLibrary;

public class CodecFactory {

    public static Codec getCodec(VideoFile videoFile){
        System.out.println("Extracting codec");
        if(videoFile.getCodecType().equals("mp4")){
            return new MPEG4Codec();
        }else{
            return new OggCodec();
        }
    }
}
