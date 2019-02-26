package test.javazh.mathzh;

import javazh.mathzh.BigDecimalDemo;
import org.junit.*;

/**
 * @auther: Administrator
 * @date: 2018/10/15 15:50
 */
public class testBigDecimalDemo{

    private BigDecimalDemo demo = new BigDecimalDemo();

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

    @Test
    public void testBigDecimalDemo1(){
        this.demo.bigDecimalDemo1();
    }
}
