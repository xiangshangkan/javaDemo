package designPattern.StructurePattern.adapterPattern;

/**
 * @Description:  创建实现媒体播放器接口的适配器类
 * @Auther: Administrator
 * @Date: 2018/9/12 18:34
 */
public class MediaAdapter implements MediaPalyer {

    AdvicedmmediaPlayer advicedmmediaPlayer;

    public MediaAdapter(String audioType){
        if("vlc".equalsIgnoreCase(audioType)){
            advicedmmediaPlayer = new VlcPlayer();
        }else if("mp4".equalsIgnoreCase(audioType)){
            advicedmmediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
       if("vlc".equalsIgnoreCase(audioType)){
           advicedmmediaPlayer.playVlc(fileName);
       }else if("mp4".equalsIgnoreCase(audioType)){
           advicedmmediaPlayer.playMp4(fileName);
       }
    }
}
