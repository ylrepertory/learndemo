import com.leo.rpc.client.RPCClient;
import com.leo.rpc.server.ServiceCenter;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: learndemo
 * @description:
 * @author: leo
 * @create: 2019-01-24 16:20
 **/
public class RPCTest {

    public static void main(String[] args) throws IOException {

        new Thread(new Runnable() {
            public void run() {
                try {
                    ServiceCenter serviceServer = new ServiceCenter(8088);
                    serviceServer.register(HelloService.class, HelloServiceImpl.class);
                    serviceServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        HelloService service = RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("localhost", 8088));
        System.out.println(service.sayHi("test"));
    }
}