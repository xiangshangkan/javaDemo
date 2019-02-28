package javazh.langzh;

import org.junit.*;


/**
 * @Description:
 * @Auther: Administrator
 * @Date: 2018/9/15 18:02
 */
public class TestStringBuilderDemo {

    private StringBuilderDemo stringBuilderDemo = new StringBuilderDemo();

    @BeforeClass   //注意：必须是static   因为方法将在类被加载时调用（那时类还没有创建实例）
    public static void before(){System.out.println("global");}

    @AfterClass
    public static  void after(){System.out.println("global destroy");}

    @Before     //每个测试开始都会执行一次
    public void setup(){System.out.println("一个测试开始！");}

    @After
    public void tearDown(){System.out.println("一个测试结束");}

    @Test
    public void testStringBuilderDemo1(){
        stringBuilderDemo.StringBuilderDemo1();
    }
}
