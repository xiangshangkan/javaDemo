package thinkSome.缓存;

/**
 * 将经常性创建的对象进行缓存，减少系统创建对象的消耗，但不适合不常使用的对象
 * java.lang.Integer采用了类似的处理策略
 * */
public class CacheImmutale {
    //设置最大缓存
    private static  int MAX_SIZE = 10;
    //设置存储指针
    private static int pos = 0;
    //缓存数组
    private static CacheImmutale[] cache = new CacheImmutale[MAX_SIZE];

    private CacheImmutale(String name){
        this.name = name;
    }

    private String name;
    public String getName(){
        return this.name;
    }

    public static  CacheImmutale valueOf(String name){
        //遍历已缓存对象
        for(int i = 0;i<MAX_SIZE;i++){
            //如果已有相同实例，则直接返回该缓存的实例
            if(cache[i] !=null && cache[i].getName().equals(name)){
                return cache[i];
            }
        }
        //如果缓存迟已满
        if(pos == MAX_SIZE){
            cache[0] = new CacheImmutale(name);
            pos = 1;
        }else {
            //将新对象添加到缓存中
            cache[pos++] = new CacheImmutale(name);
        }
        return cache[pos-1];

    }

    public boolean equals(Object object){
        if(this == object){
            return true;
        }else if(null != object && this.getClass() == object.getClass()){
            return this.getName() == ((CacheImmutale) object).getName();
        }
        return  false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public static void main(String[] args){
        CacheImmutale c1 = CacheImmutale.valueOf("Hello");
        CacheImmutale c2 = CacheImmutale.valueOf("Hello");
        System.out.println(c1 == c2);
    }

}
