package designPattern.creationPattern.builderPattern;

/**
* @Description:    创建一个表示食物条目的接口
* @Author:         zhouhui
* @CreateDate:
* @Version:        1.0
*/
public interface Item {
    public String name();
    public Packing packing();
    public float price();
}

