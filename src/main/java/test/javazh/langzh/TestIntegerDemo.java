package test.javazh.langzh;

import javazh.langzh.IntegerDemo;
import org.junit.*;

/**
 * Created by Administrator on 2018/9/11.
 */
public class TestIntegerDemo {

    private IntegerDemo integerDemo = new IntegerDemo();

    @BeforeClass //注意，这里必须是static ...因为方法将在类被加载的时候就被调用（那时候还没创建实例）
    public static void before(){
        System.out.println("global");
    }

    @AfterClass
    public static void after(){
        System.out.println("global destroy");
    }

    @Before
    public void setUp() throws Exception{
        System.out.println("一个测试开始");
    }

    @After
    public void tearDown()throws Exception{
        System.out.println("一个测试结束");
    }


}
