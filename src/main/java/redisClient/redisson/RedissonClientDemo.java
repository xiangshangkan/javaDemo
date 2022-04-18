package redisClient.redisson;

import java.util.concurrent.TimeUnit;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * @Description: Redisson 客户端链接redis服务，侧重于分布式服务
 * @Author: zhouhui2
 * @Date: 2022/4/6 4:31 PM
 */
public class RedissonClientDemo {

    public static void main(String[] args) throws InterruptedException {
        // 配置Redis-Cluster集群节点的ip和port
        Config config = new Config();
        // redis-cluster集群的ip和port
        config.useClusterServers()
                .addNodeAddress("redis://localhost:6379");
        // 通过以上配置创建Redisson的客户端
        RedissonClient redisson = Redisson.create(config);
        // 测试Redisson可重入锁的加锁，释放锁等功能
        testRedissonSimpleLock(redisson);
    }

    private static void testRedissonSimpleLock(RedissonClient redisson) throws InterruptedException {
        //1.获取key为"anyLock"的锁对象
        RLock lock = redisson.getLock("anyLock");
        //2.1：加锁
        lock.lock();
        //2.2：加锁时，设置尝试获取锁超时时间30s、锁超时⾃动释放的时间10s
        lock.tryLock(30, 10, TimeUnit.MILLISECONDS);
        Thread.sleep(10 * 1000);
        //3.释放锁
        lock.unlock();
    }
}
