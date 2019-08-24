package designPattern.behavioralPattern.templetePattern;

/**
 * @ClassName TemplatePatternDemo
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/3/8 09:26
 * @Version 1.0
 */
public class TemplatePatternDemo {

    public static void main(String[] args){
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}
