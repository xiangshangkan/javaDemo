package jvm;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 将堆的最小值-Xms参数与最大值-Xmx参数设置为一样即可避免堆自动扩展，通过参数-XX:+HeapDumpOnOutOfMemoryError
 * 可以让虚拟机在出现内存溢出异常时Dump出当前的内存堆转储快照以便事后进行分析
 */
public class HeapOOm {

    static class OOMObject {

    }
    public static void main(String[] args) throws ParseException {

        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }

    }
}
