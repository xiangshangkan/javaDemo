package netty.time.upgrade;

import java.util.Date;

/**
 * @Description:
 * @Author: Zohar
 * @Date: 2020/6/15 13:38
 * @Version: 1.0
 */
public class UnixTime {

    private final long value;

    public UnixTime() {
        this(System.currentTimeMillis()/1000L + 2208988800L);
    }

    public UnixTime(long value) {
        this.value = value;
    }

    public long value(){
        return value;
    }

    @Override
    public String toString(){
        return new Date((value() -2208988800L)).toString();
    }
}
