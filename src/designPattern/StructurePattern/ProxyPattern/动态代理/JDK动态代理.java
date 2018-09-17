package designPattern.StructurePattern.ProxyPattern.动态代理;

import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
测试类
代理对象不需要实现接口，但是目标对象一定要实现接口，否则不能用动态代理
*/
public class JDK动态代理
{
    public static void main(String[] args)
    {
        //目标对象
        IUserDao target=new UserDao();
        //【原始的类型 class.cn.itcast.b_dynamic.UserDao】
        System.out.println(target.getClass());
        //给目标对象，创建代理对象
        IUserDao proxy=(IUserDao)new ProxyFactory(target).getProxyInstance();
        //class $Proxy0  内存中动态生成的代理对象
        System.out.println(proxy.getClass());

        //执行方法【代理对象】
        proxy.save();
    }
}


/**
 *接口
 */
interface IUserDao
{
    void save();
}

/**
 目标对象接口实现
 */
class UserDao implements IUserDao
{
    public void save()
    {
        System.out.println("-----已经保存数据------------");
    }
}


/*
创建动态代理对象
动态代理不需要实现接口，但是需要指定接口类型
*/
class ProxyFactory
{
    //维护一个目标对象
    private Object target;
    public ProxyFactory(Object target)
    {
        this.target=target;
    }

    //给目标对象生成代理对象
    public Object getProxyInstance()
    {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler(){
                    public Object invoke(Object proxy,Method method,Object[] args)throws Throwable
                    {
                        System.out.println("开始事务2");
                        //执行目标对象方法
                        Object returnValue=method.invoke(target,args);
                        System.out.println("提交事务2");
                        return returnValue;
                    }
                });
    }
}
