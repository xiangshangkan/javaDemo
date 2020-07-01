package redisClient.jedis;

import redis.clients.jedis.Jedis;

import java.util.logging.Logger;

/**
 * @Description: Jedis 客户daunt连接redis
 * @Author: Zohar
 * @Date: 2020/6/22 15:33
 * @Version: 1.0
 */
public class RedisClientDemo {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.1.77",6379);
        //如果返回pong 代表连接成功
        Logger.getGlobal().info("jedis.ping()" + jedis.ping());

    }

}
