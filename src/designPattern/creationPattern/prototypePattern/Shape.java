package designPattern.creationPattern.prototypePattern;

/**
 * @Description:  创建一个实现Cloneable的shape 重写父类Object的clone()方法
 * @Auther: Administrator
 * @Date: 2018/9/12 14:09
 */
public abstract class Shape implements Cloneable{

    private String id;

    protected  String type;

    abstract  void draw();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Object clone(){
        Object shape = null;
        try {
            //必须调用Object的Clone方法
            shape = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return shape;
    }
}
