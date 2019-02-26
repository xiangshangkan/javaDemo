package designPattern.StructurePattern.adapterPattern;

/**
 * @Description:  创建了一个实现MediaPaler接口的实现类
 * @Auther: Administrator
 * @Date: 2018/9/12 18:45
 */
public class AudioPlayer implements MediaPalyer {

    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if("mp3".equalsIgnoreCase(audioType)){
            System.out.println("Playing mp3 file. name:" + fileName);
        }else if("vlc".equalsIgnoreCase(audioType) || "mp4".equalsIgnoreCase(audioType)){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType,fileName);
        }else{
            System.out.println("Invalid media." + audioType + " format not supported");
        }

    }
}
