package designPattern.structural.facade.videoLibrary;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class OggCodec implements Codec {
    private String codec;

    public OggCodec(){
        this.codec = "ogg";
    }
    @Override
    public Codec setCodec() {
        System.out.println("Setting Ogg codec");
        return new OggCodec() ;
    }
    public String getCodecType() {
        return this.codec;
    }
}
