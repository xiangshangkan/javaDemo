package javazh.utilzh;

import org.junit.*;

/**
 * @Description:
 * @Auther: Administrator
 * @Date: 2018/9/17 09:18
 */
public class TestArrayListDemo {

    private ArrayListDemo arrayListDemo = new ArrayListDemo();

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
    public void testArrayListDemo1(){
        arrayListDemo.arrayListDemo1();
    }
    @Test
    public void testArrayListDemo2(){
        arrayListDemo.arrayListDemo2();
    }
    @Test
    public void testArrayListDemo3(){
        arrayListDemo.arrayListDemo3();
    }
    @Test
    public void testArrayListDemo4(){
        arrayListDemo.arrayListDemo4();
    }
}
