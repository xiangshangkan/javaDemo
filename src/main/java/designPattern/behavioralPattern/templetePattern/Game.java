package designPattern.behavioralPattern.templetePattern;

/**
 * @ClassName Game
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/8 09:15
 * @Version 1.0
 */
public abstract class Game {

    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //模板
    public final void play(){
        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
