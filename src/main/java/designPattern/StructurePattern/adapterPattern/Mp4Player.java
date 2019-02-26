package designPattern.StructurePattern.adapterPattern;

/**
 * @Description: Mp4格式播放器
 * @Auther: Administrator
 * @Date: 2018/9/12 18:31
 */
public class Mp4Player implements AdvicedmmediaPlayer {
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. name:" + fileName);
    }
}
