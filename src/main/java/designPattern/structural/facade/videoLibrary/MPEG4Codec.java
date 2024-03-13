package designPattern.structural.facade.videoLibrary;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class MPEG4Codec implements Codec {

    private String codec;

    public MPEG4Codec(){
        this.codec = "mp4";
    }
    @Override
    public Codec setCodec() {
        System.out.println("Setting MPEG4 codec");
        return new MPEG4Codec() ;
    }

    @Override
    public String getCodecType() {
        return this.codec;
    }
}
