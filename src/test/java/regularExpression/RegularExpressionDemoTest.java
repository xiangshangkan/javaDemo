package regularExpression;

import RegularExpression.RegularExpressionDemo;
import org.junit.*;

/**
 * 正则表达式测试
 * @auther: Administrator
 * @date: 2018/9/26 14:35
 */
public class RegularExpressionDemoTest {

    private RegularExpressionDemo regularExpressionDemo = new RegularExpressionDemo();

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
    public void testRegularExpressionDemo1(){
        regularExpressionDemo.RegularExpressionDemo1();
    }

}
