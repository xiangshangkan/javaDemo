package netty.protobufCustom;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import netty.protobuf.protocol.MsgProtos;

import java.util.List;

/**
 * @Description: 自定义消息解码器
 * @Author: Zohar
 * @Date: 2020/7/10 20:56
 * @Version: 1.0
 */
public class ProtobufDecoder extends ByteToMessageDecoder{


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> list) throws Exception {
        // 标记一下当前的读指针 readIndex 的位置
        in.markReaderIndex();
        // 判断包头的长度
        if (in.readableBytes() < 2) {
            //不够包头
            return;
        }

        // 读取传送过来的消息的长度
        int length = in.readShort();

        //长度如果小于0
        if (length < 0) {
            //非法数据，关闭连接
            ctx.close();
        }

        if (length > in.readableBytes()) {
            //读到消息体长度如果小于传送过来的消息长度
            //重置读取位置
            in.resetReaderIndex();
            return;
        }

        //省略：读取魔数、版本号等其他的数据
        //省略：读取内容
        byte[] array;
        if (in.hasArray()) {
            //堆缓存,线程复制可读部分
            ByteBuf slice = in.slice();
            array = slice.array();
        } else {
            //直接缓存
            array = new byte[length];
            in.readBytes(array,0,length);
        }

        //字节转成 ProtoBuf 的 POJO 对象
        MsgProtos.Msg outMsg = MsgProtos.Msg.parseFrom(array);
        if (outMsg != null) {
            //获取业务消息
            list.add(outMsg);
        }


    }
}
