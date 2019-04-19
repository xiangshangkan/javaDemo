package demo;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName CacheUtils
 * @Description TODO
 * @Author zhouhui
 * @Date 2019/4/19 11:28
 * @Version 1.0
 */
public class CacheUtils {

    private static Map<String,Object> concurrentHashMap = new ConcurrentHashMap<>();

    private static Map<String,Object> hashTable = new Hashtable<>();

    private static Map<String,Object> hashMap = new HashMap<>();

    public static Object get1(String key) {
      return concurrentHashMap.get(key);
    }

    public static void put1(String key, Object value) {
        concurrentHashMap.put(key,value);
    }

    public static Object get2(String key) {
        return hashTable.get(key);
    }

    public static void put2(String key, Object value) {
        hashTable.put(key,value);
    }

    public static Object get3(String key) {
        return hashMap.get(key);
    }

    public static void put3(String key, Object value) {
        hashMap.put(key,value);
    }


}
