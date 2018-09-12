package designPattern.creationPattern.builderPattern;

/**
* @Description:    创建一个包装器类并实现食物包装接口
* @Author:         zhouhui
* @CreateDate:
* @Version:        1.0
*/
public class Wrapper implements Packing {
    @Override
    public String pack() {
        return "pack:Wrapper";
    }
}
