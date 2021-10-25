package concurrency_in_practice.tools;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description: ${description}
 * @Author: zhouhui2
 * @Date: 2021/8/24 9:53 PM
 */
public class LockSupportDemo {

    public void testPark() {
        LockSupport.park();
    }

    public static void main(String[] args) {

        LockSupportDemo demo = new LockSupportDemo();
        demo.testPark();
    }
}
