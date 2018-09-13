package designPattern.StructurePattern.adapterPattern;

/**
 * @Description: Vlc格式播放器
 * @Auther: Administrator
 * @Date: 2018/9/12 18:28
 */
public class VlcPlayer implements AdvicedmmediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. name:" + fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
