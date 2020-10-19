package openfire;

import org.jivesoftware.smack.AbstractXMPPConnection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.chat2.Chat;
import org.jivesoftware.smack.chat2.ChatManager;
import org.jivesoftware.smack.chat2.IncomingChatMessageListener;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smackx.iqregister.AccountManager;
import org.jxmpp.jid.EntityBareJid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.jid.parts.Localpart;
import org.jxmpp.stringprep.XmppStringprepException;

import java.io.IOException;
import java.util.Scanner;

/**
 * @Description: openfire 客户端
 * @Author: Zohar
 * @Date: 2020/10/13 15:33
 * @Version: 1.0
 */
public class OpenfireClient {

    private static XMPPTCPConnectionConfiguration config;
    private static AbstractXMPPConnection conn;

    static {
        //初始化连接IM服务器
        try {
            config = XMPPTCPConnectionConfiguration.builder()
                    .setXmppDomain("192.168.1.55")
                    .setHost("192.168.1.55")
                    .setPort(5222)
                    .setDebuggerEnabled(true)
                    .setSecurityMode(ConnectionConfiguration.SecurityMode.disabled)
                    .build();
            conn = new XMPPTCPConnection(config);
            conn.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void register(String userName,String password){
        try {
            AccountManager am = AccountManager.getInstance(conn);
            am.sensitiveOperationOverInsecureConnection(true);
            am.createAccount(Localpart.from(userName),password);
        } catch (SmackException.NoResponseException e) {
            e.printStackTrace();
        } catch (XMPPException.XMPPErrorException e) {
            e.printStackTrace();
        } catch (SmackException.NotConnectedException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (XmppStringprepException e) {
            e.printStackTrace();
        }
    }

    //登录IM服务器
    public static void login(String userName,String password) {
        if (conn != null) {
            try {
                conn.login(userName,password);
                System.out.println("user" + userName + "login successfully");
            } catch (XMPPException e) {
                e.printStackTrace();
            } catch (SmackException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //发送消息
    public static void sendMessage(String userName,String password) {
        //先登录
        login(userName,password);
        //再构建聊天室
        ChatManager cm = ChatManager.getInstanceFor(conn);
        cm.addListener(new IncomingChatMessageListener() {
            @Override
            public void newIncomingMessage(EntityBareJid from, Message message, Chat chat) {
                System.out.println("message from : " + from + ":" + message.getBody());
            }
        });

        try {
            EntityBareJid jid = JidCreate.entityBareFrom("zhou@192.168.1.55");
            Chat chat = cm.chatWith(jid);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                Message message = new Message();
                String msg = scanner.next();
                message.setBody(msg);
                chat.send(message);
            }

        } catch (XmppStringprepException e) {
            e.printStackTrace();
        } catch (SmackException.NotConnectedException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        sendMessage("hui","hui");
    }
}
