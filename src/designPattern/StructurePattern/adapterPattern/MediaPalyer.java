package designPattern.StructurePattern.adapterPattern;

/**
 * @Description:  为媒体播放器和更高级的播放器创建接口
 * @Auther: Administrator
 * @Date: 2018/9/12 18:22
 */
public interface MediaPalyer {

    public void play(String audioType,String fileName);
}
