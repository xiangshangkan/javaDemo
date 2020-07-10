package netty.protobuf;

import netty.protobuf.protocol.MsgProtos;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @Description: ProtoBuf 协议通信数据转换的三种方式
 * @Author: Zohar
 * @Date: 2020/7/10 16:16
 * @Version: 1.0
 */
public class ProtobufDemo {

    /**
     * Protobuf 为每个mesage消息结构体生成的Java类中，包含了一个POJO类，一个Builder类。构造POJO消息，首先需要使用POJO类的newBuilder静态方法获得一个Builder
     * 构造者。每一个 POJO 字段的值，需要通过Builder构造者的setter方法去设置。
     * @return
     */
    public static MsgProtos.Msg buildMsg(){
        MsgProtos.Msg.Builder personBuilder = MsgProtos.Msg.newBuilder();
        personBuilder.setId(1000);
        personBuilder.setContent("疯狂创客圈：高性能学习社群");
        MsgProtos.Msg message = personBuilder.build();
        return message;
    }

    /**
     * 第一种方式：这种方式通过 POJO 对象的 toByteArray() 方法将 POJO 对象序列化成字节数组。通过调用 parseFrom(byte[] data) 方法，
     *             Protobuf 也可以从字节数组中重新反序列化得到POJO新的实例，适用于很多将 Protobuf 的 POJO 序列化到内存或者外存的应用场景
     * @throws IOException
     */
    @Test
    public void serAndDesr1() throws IOException {
        MsgProtos.Msg message = buildMsg();
        //将Protobuf 对象序列化成二进制字节数组
        byte[] data = message.toByteArray();
        //可以用于网络传输，保存到内存或外存
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(data);
        data = outputStream.toByteArray();
        //二进制字节数组反序列化成ProtoBuf对象
        MsgProtos.Msg inMsg = MsgProtos.Msg.parseFrom(data);
        Logger.getGlobal().info("id:=" + inMsg.getId());
        Logger.getGlobal().info("content:" + inMsg.getContent());

    }

    /**
     * 第二种方式 ： 这种方式通过调用 POJO 对象的 writeTo(OutputStream) 方法将 POJO 对象的二进制字节写出到输出流。
     * 通过调用parseFrom(InputStream) 方法，Protobuf 从输入流中读取二进制码流重新反序列化，得到POJO新的实例
     * 在阻塞式的二进制码流传输应用场景中，这种序列化和反序列化是没有问题的，但是这种方式在异步操作的NIO场景中，存在着
     * 粘包/半包的问题
     * @throws IOException
     */
    @Test
    public void serAndDesr2() throws IOException {

        MsgProtos.Msg message = buildMsg();
        //序列化到二进制码流
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        message.writeTo(outputStream);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

        //从二进制码流反序列化成Protobuf对象
        MsgProtos.Msg inMsg = MsgProtos.Msg.parseFrom(inputStream);
        Logger.getGlobal().info("id:=" +inMsg.getId());
        Logger.getGlobal().info("content:=" + inMsg.getContent());

    }

    /**
     * 第三种方式： 这种方式通过调用 POJO 对象的writeDelimitedTo(OutputStream) 方法在序列化的字节码之前添加了字节数组的长度，
     *              这一点类似于前面介绍的 Head-Content 协议，只不过 Protobuf 做了优化，长度的类型不是固定的int 类型，而是可变长度varint32
     *              反序列化时，Protobuf从输入流中先读取 varint32 类型的长度值，然后根据长度值读取此消息的二进制字节，再反序列化得到POJO新的实例
     *              这种方式可以用于异步操作的NIO应用场景中，解决了粘包/半包问题。
     * @throws IOException
     */
    @Test
    public void serAndDesr3() throws IOException {
        MsgProtos.Msg message = buildMsg();
        //序列化到二进制码流
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        message.writeDelimitedTo(outputStream);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

        //从二进制码流
        MsgProtos.Msg inMsg = MsgProtos.Msg.parseDelimitedFrom(inputStream);
        Logger.getGlobal().info("id:=" +  inMsg.getId());
        Logger.getGlobal().info("content" + inMsg.getContent());
    }


}
