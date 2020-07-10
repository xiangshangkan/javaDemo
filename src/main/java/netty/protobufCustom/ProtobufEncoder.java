package netty.protobufCustom;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import netty.protobuf.protocol.MsgProtos;

/**
 * @Description: 自定义 protoBuf 编码：
 *                1、 写入ProtoBuf 的 POJO 的字节码长
 *                2、写入其他的字段， 如魔数， 版本号
 *                3、写入ProtoBuf 的 POJO 的字节码内容
 * @Author: Zohar
 * @Date: 2020/7/10 20:44
 * @Version: 1.0
 */
public class ProtobufEncoder extends MessageToByteEncoder<MsgProtos.Msg>{

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MsgProtos.Msg msg, ByteBuf out) throws Exception {
        // 将对象转换为字节
        byte[] bytes = msg.toByteArray();
        // 读取消息的长度
        int length = bytes.length;

        //将消息长度写入，也就是消息头，这里只用两个字节，最大为32769
        out.writeShort(length);
        //魔术
        out.writeShort(1);
        //版本号
        out.writeShort(2);
        //消息体中包含我们要发送的数据
        out.writeBytes(msg.toByteArray());
    }


}
