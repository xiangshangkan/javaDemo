package redisClient.lettuce;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;


/**
 * @Description:  lettuce 客户端连接Redis服务
 * @Author: Zohar
 * @Date: 2020/6/16 20:04
 * @Version: 1.0
 */
public class RedisClientDemo {

    public static void main(String[] args) {
        RedisClient redisClient = RedisClient.create("redis://@192.168.1.77:6379/0");
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String,String> syncCommands = connection.sync();
        syncCommands.set("key","Hello, Redis!");
        connection.close();
        redisClient.shutdown();

    }
}
